package controller;
 
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import model.People;
import service.PeopleService;

@Controller
public class PeopleController {
 
    public PeopleController() {
        System.out.println("PeopleController()");
    }
 
    @Autowired
    private PeopleService peopleService;
    
    public void setResponseContentAndHeaders(HttpServletResponse response) {
    	
    	response.setContentType("application/json");
        
        //CORS
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        response.setHeader("Access-Control-Allow-Headers", "Accept-Ranges, Content-Encoding, Content-Length, Content-Range, Content-Type, Accept, Range");
        response.setHeader("Access-Control-Expose-Headers", "Accept-Ranges, Content-Encoding, Content-Length, Content-Range");
    	
    }
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public @ResponseBody String listPeople(HttpServletRequest request, HttpServletResponse response){
        
    	setResponseContentAndHeaders(response);
        
        try {
			return JSONObject.valueToString(peopleService.getAllPeople());
		} catch (JSONException e) {
			return "error";
		}
        
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public @ResponseBody String addPeople(@RequestParam(value = "people") JSONObject people, HttpServletRequest request, HttpServletResponse response) {
    
    	setResponseContentAndHeaders(response);
    	
        People person = new People();
        person.setId(0);
        person.setPassport(people.getString("passport"));
        person.setFirstname(people.getString("firstname"));
        person.setLastname(people.getString("lastname"));
        
        HashMap<String, String> result = new HashMap<String, String>();
        
        try {
        	JSONObject.valueToString(peopleService.existsPassport(person));
        	result.put("success", "true");
            result.put("response", JSONObject.valueToString(peopleService.existsPassport(person)));
            
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
        HashMap<String, String> result2 = new HashMap<String, String>();
        if(result.get("response") == "false") {
        	
        	try {
        		peopleService.addPeople(person);
                result2.put("success", "true");
                result2.put("response", "true");
                return JSONObject.valueToString(result2);
        		
        	} catch (JSONException e) {
    			throw new RuntimeException(e);
    		}
        	
        }else {
        	result2.put("success", "true");
            result2.put("response", "false");
            return JSONObject.valueToString(result2);
        }
        
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/edit")
    public @ResponseBody String editPeople(@RequestParam(value = "people") JSONObject people, HttpServletRequest request, HttpServletResponse response){
    
    	setResponseContentAndHeaders(response);
        
    	
        People person = new People();
        person.setId(people.getInt("id"));
        person.setPassport(people.getString("passport"));
        person.setFirstname(people.getString("firstname"));
        person.setLastname(people.getString("lastname"));
        
        try {
        	JSONObject.valueToString(peopleService.updatePeople(person));
        	
        	HashMap<String, String> result = new HashMap<String, String>();
            result.put("success", "true");
            result.put("response", JSONObject.valueToString(peopleService.updatePeople(person)));
            
            return JSONObject.valueToString(result);
        	
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
        
    	
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    public @ResponseBody String deletePeople(@RequestParam(value = "people") JSONObject people, HttpServletRequest request, HttpServletResponse response) {
        
    	setResponseContentAndHeaders(response);
        
        int id = people.getInt("id");
        
        HashMap<String, String> result = new HashMap<String, String>();
        
        try {
        	peopleService.deletePeople(id);
        	result.put("success", "true");
            result.put("response", "true");
            return JSONObject.valueToString(result);
            
        	
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
    	
    }
 
}