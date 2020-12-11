package dao;
 
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import model.People;
 
@Repository
public class PeopleDAOImpl implements PeopleDAO {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public void addPeople(People people) {
    	sessionFactory.getCurrentSession().save(people);
 
    }
    
    public Boolean existsPassport(People people) {
    	
    	final Session session = sessionFactory.getCurrentSession();
    	final Criteria crit = session.createCriteria(People.class);
    	crit.add(Restrictions.eq("passport", people.getPassport()));
    	
    	if(crit.list().size() > 0) {
    		return true;
    	}else {
    		return false;
    	}
    	
    }
 
    @SuppressWarnings("unchecked")
    public List<People> getAllPeople() {
 
        return sessionFactory.getCurrentSession().createQuery("from People")
                .list();
    }
 
    @Override
    public void deletePeople(Integer peopleId) {
        People people = (People) sessionFactory.getCurrentSession().load(
                People.class, peopleId);
        if (null != people) {
            this.sessionFactory.getCurrentSession().delete(people);
        }
 
    }
 
    public People getPeople(int peopleId) {
        return (People) sessionFactory.getCurrentSession().get(
                People.class, peopleId);
    }
    
    @Override
    public List<People> updatePeople(People people) {
        sessionFactory.getCurrentSession().update(people);
        List<People> peopleList = new ArrayList<People>();
        peopleList.add(people);
        return peopleList;
    }
 
}