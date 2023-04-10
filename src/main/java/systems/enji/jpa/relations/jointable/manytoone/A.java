package systems.enji.jpa.relations.jointable.manytoone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;

@Entity(name = "A_JOINTABLE_MANY2ONE")
public class A {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	String id;

	@ManyToOne
	@JoinTable(
			name = "A2B_MANY2ONE", 
			joinColumns = @JoinColumn(name = "A_ID"), 
			inverseJoinColumns = @JoinColumn(name = "B_ID"))
	B b;

}
