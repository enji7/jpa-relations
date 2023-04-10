package systems.enji.jpa.relations.manytomany;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity(name = "A_MANY2MANY")
public class A {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	String id;
	
	@ManyToMany
	@JoinTable(
	   name="A2B",
	   joinColumns=@JoinColumn(name="A_ID"),
	   inverseJoinColumns=@JoinColumn(name="B_ID"))
	List<B> bs;
	
}
