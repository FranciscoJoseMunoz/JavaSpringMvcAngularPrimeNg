package service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import dao.PeopleDAO;
import model.People;
 
@Service
@Transactional
public class PeopleServiceImpl implements PeopleService {
 
    @Autowired
    private PeopleDAO peopleDAO;
 
    @Override
    @Transactional
    public void addPeople(People people) {
        peopleDAO.addPeople(people);
    }
    
    @Override
    @Transactional
    public Boolean existsPassport(People people) {
        return peopleDAO.existsPassport(people);
    }
 
    @Override
    @Transactional
    public List<People> getAllPeople() {
        return peopleDAO.getAllPeople();
    }
 
    @Override
    @Transactional
    public void deletePeople(Integer peopleId) {
        peopleDAO.deletePeople(peopleId);
    }
 
    public People getPeople(int peopleId) {
        return peopleDAO.getPeople(peopleId);
    }
    
    public List<People> updatePeople(People people) {
        return peopleDAO.updatePeople(people);
    }
 
    public void setPeopleDAO(PeopleDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }
 
}