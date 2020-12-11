package dao;
 
import java.util.List;
import model.People;
 
public interface PeopleDAO {
 
    public void addPeople(People people);
    
    public Boolean existsPassport(People people);
 
    public List<People> getAllPeople();
 
    public void deletePeople(Integer peopleId);
 
    public List<People> updatePeople(People people);
 
    public People getPeople(int peopleId);
    
}