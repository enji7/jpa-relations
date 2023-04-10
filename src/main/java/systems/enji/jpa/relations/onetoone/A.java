package systems.enji.jpa.relations.onetoone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name = "A_ONE2ONE")
public class A {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	String id;
	
	@OneToOne
	@JoinColumn(name = "B_ID")
	B b;
	
}
