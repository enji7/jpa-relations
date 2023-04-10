package systems.enji.jpa.relations.jointable.onetoone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "B_JOINTABLE_ONE2ONE")
public class B {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	String id;

	@OneToOne(mappedBy = "b")
	A a;
	
}
