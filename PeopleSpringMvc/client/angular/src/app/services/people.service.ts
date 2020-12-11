import {Injectable} from '@angular/core';
import {Http, Response, Headers, RequestOptions, URLSearchParams} from '@angular/http';
import "rxjs/add/operator/map";
import {Observable} from 'rxjs/Observable';
import {GLOBAL} from './global';

export interface People {
    id?;
    passport?;
    firstname?;
    lastname?;
}

@Injectable()
export class PeopleService{
	public url: string;
	
	constructor(private _http: Http){
		this.url = GLOBAL.url;
	}
	
	listPeople(){
		
		let headers = new Headers({'Content-Type':'application/x-www-form-urlencoded'});
		
		let options = new RequestOptions({ headers: headers });
					
		let people = this._http.get(this.url, options)
                    .toPromise()
					.then(res => <People[]> res.json())
					.then(data => { return data; });
		
		return people;
		
	}
	
	updatePeople(people){
		let params = new URLSearchParams();
		
		people = JSON.stringify(people);
		params.append('people', people);
		
		let headers = new Headers({'Content-Type':'application/x-www-form-urlencoded'});
		let options = new RequestOptions({ headers: headers });
		
		return this._http.post(this.url+'edit', params, options)
				   .map(res => res.json());
		
		
	}
	
	addPeople(people){
		
		let params = new URLSearchParams();
		
		people = JSON.stringify(people);
		params.append('people', people);
		
		let headers = new Headers({'Content-Type':'application/x-www-form-urlencoded'});
		let options = new RequestOptions({ headers: headers });
		
		return this._http.post(this.url+'add', params, options)
				   .map(res => res.json());
		
	}
	
	deletePeople(people){
		
		let params = new URLSearchParams();
		
		people = JSON.stringify(people);
		params.append('people', people);
		
		let headers = new Headers({'Content-Type':'application/x-www-form-urlencoded'});
		let options = new RequestOptions({ headers: headers });
		
		return this._http.post(this.url+'delete', params, options)
				   .map(res => res.json());
		
	}
	
}