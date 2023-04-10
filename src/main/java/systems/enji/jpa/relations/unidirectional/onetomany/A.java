package systems.enji.jpa.relations.unidirectional.onetomany;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity(name = "A_UNIDIRECTIONAL_ONE2MANY")
public class A {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	String id;
	
	@OneToMany
	@JoinColumn(name="A_ID")
	List<B> bs;
	
}
