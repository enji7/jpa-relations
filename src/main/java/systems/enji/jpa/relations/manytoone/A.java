package systems.enji.jpa.relations.manytoone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "A_MANY2ONE")
public class A {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	String id;
	
	@ManyToOne
	@JoinColumn(name="B_ID")
	B b;
	
}
