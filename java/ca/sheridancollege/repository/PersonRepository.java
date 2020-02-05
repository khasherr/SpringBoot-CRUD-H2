package ca.sheridancollege.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.sheridancollege.bean.Person;

public interface PersonRepository extends CrudRepository <Person, Integer> {
	
	public List <Person> findByName(String name);
	public List <Person> findByEmail(String email); 
	public List <Person> findByAddress (String address); 
	public List <Person> findByPhoneNumber (int phoneNumber);
	public Person findById(int id);
	
	

}
