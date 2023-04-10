package systems.enji.jpa.relations.manytomany;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity(name = "B_MANY2MANY")
public class B {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	String id;

	@ManyToMany(mappedBy="bs")
	List<A> as;	
}
