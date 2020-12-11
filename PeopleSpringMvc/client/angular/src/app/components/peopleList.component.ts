import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import {PeopleService} from '../services/people.service';
import {People} from '../services/people.service';

@Component({
	selector: 'peopleList',
	templateUrl: '../views/peopleList.html',
	providers: [PeopleService]
})
export class PeopleListComponent implements OnInit{
	
	displayDialog: boolean;

    people: People = new PrimePeople();
    
    selectedPeople: People;
    
    newPeople: boolean;

    peoples: People[];

	constructor(
		private _peopleService: PeopleService,
		private _route: ActivatedRoute,
		private _router: Router
	){
		
	}

	ngOnInit(){
		
		this._peopleService.listPeople().then(peoples => this.peoples = peoples);
		
	}
	
	showDialogToAdd() {
        this.newPeople = true;
        this.people = new PrimePeople();
        this.displayDialog = true;
    }
	
	save() {
        let peoples = [...this.peoples];
        if(this.newPeople){
			
            peoples.push(this.people);
			this._peopleService.addPeople(this.people).subscribe(
				response => {
					if(response["success"] == "true"){
						
						if(response["response"] == "true"){
							this._peopleService.listPeople().then(peoples => this.peoples = peoples);
						}else{
							alert("Error: passport repeated");
						}
					}
				},
				error => {
					alert("Error: "+error);
				}
			);
			
        }else{
            peoples[this.findSelectedPeopleIndex()] = this.people;
			
			this._peopleService.updatePeople(this.people).subscribe(
				response => {
					if(response["success"] == "true"){
						this.peoples = peoples;
					}
				},
				error => {
					alert("Error: "+error);
				}
			);
			
		}
        
        this.people = null;
        this.displayDialog = false;
    }
    
    delete() {
		
		let index = this.findSelectedPeopleIndex();
		
		this._peopleService.deletePeople(this.people).subscribe(
			response => {
				if(response["success"] == "true"){
					this.peoples = this.peoples.filter((val,i) => i!=index);
				}
			},
			error => {
				alert("Error: "+error);
			}
		);
		
		this.people = null;
        this.displayDialog = false;
		
    }    
    
    onRowSelect(event) {
        this.newPeople = false;
        this.people = this.clonePeople(event.data);
        this.displayDialog = true;
    }
    
    clonePeople(p: People): People {
        let people = new PrimePeople();
        for(let prop in p) {
            people[prop] = p[prop];
        }
        return people;
    }
    
    findSelectedPeopleIndex(): number {
        return this.peoples.indexOf(this.selectedPeople);
    }

}

class PrimePeople implements People {
    
	constructor(public id?, public passport?, public firstname?, public lastname?) {}
	
}

