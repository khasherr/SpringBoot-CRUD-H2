package ca.sheridancollege.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.bean.Person;
import ca.sheridancollege.repository.PersonRepository;

@Controller
public class HomeController {
	
	@Autowired
	private PersonRepository personrepo; 
	
	
	   @GetMapping("/") // localhost:8080 
		
		public String homePage(Model model ) { 
			model.addAttribute("person", new Person());
			
			return "addContacts.html";
		}
	
	@GetMapping("/addContacts") //add contacts
	public  String addDrinks (@ModelAttribute Person person, Model model ) { 
		personrepo.save(person);
		model.addAttribute("myperson", personrepo.findAll());

		model.addAttribute("person", new Person()); 
		return  "listContact.html";

	}
	
	@GetMapping("/listContacts") //list contacts 
	
	public String listPage(Model model ) { 
		model.addAttribute("myperson", personrepo.findAll());
	     return "listContact.html";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Person person = personrepo.findById(id);
//            .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("person", person);
        return "updateContact.html";
	}
	
	@GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") int id, Model model) {
       
        
        personrepo.deleteById(id);
       //model.addAttribute("myperson", personrepo.findAll());
       // return "listContact.html";
       return "redirect:/listContacts";
    }
	
	@GetMapping("/updateContacts")
	public  String updateContacts (@ModelAttribute Person person, Model model ) { 
		personrepo.save(person); //create and update that what save does 
		model.addAttribute("myperson", personrepo.findAll()); // pull
		return  "listContact.html";
	}
	
	@GetMapping("/search")
	public String goSearch() {
		return "search.html";
	}
	
	@GetMapping("/searchName")
	public String searchName(@RequestParam String name, Model model) {
		
		List <Person> person = personrepo.findByName(name);
		model.addAttribute("myperson",person);
		return "search.html";
	}


	
	

}

