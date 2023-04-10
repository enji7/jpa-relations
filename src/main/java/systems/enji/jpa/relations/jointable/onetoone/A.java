package systems.enji.jpa.relations.jointable.onetoone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;

@Entity(name = "A_JOINTABLE_ONE2ONE")
public class A {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	String id;
	
	@OneToOne
	@JoinTable(
			name = "A2B_ONE2ONE", 
			joinColumns = @JoinColumn(name = "A_ID"), 
			inverseJoinColumns = @JoinColumn(name = "B_ID"))
	B b;
	
}
