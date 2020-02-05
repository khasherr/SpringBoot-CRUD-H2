package ca.sheridancollege.bean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;


@Builder
@Data 
@NoArgsConstructor 
@AllArgsConstructor
@Entity
public class Person {
	

	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)

	private int id; 
	
	private String name; 
	private  int phoneNumber; 
	private String address; 
	private String email;
	

}
