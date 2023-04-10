package systems.enji.jpa.relations.unidirectional.onetomany;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "B_UNIDIRECTIONAL_ONE2MANY")
public class B {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	String id;
	
}
