package service;
 
import java.util.List;
 
import model.People;
 
public interface PeopleService {
	
    public void addPeople(People people);
    
    public Boolean existsPassport(People people);
 
    public List<People> getAllPeople();
 
    public void deletePeople(Integer peopleId);
 
    public People getPeople(int peopleId);
    
    public List<People> updatePeople(People people);
}