package systems.enji.jpa.relations.jointable.manytoone;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "B_JOINTABLE_MANY2ONE")
public class B {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	String id;

	@OneToMany(mappedBy="b")
	List<A> as;
	
}
