package systems.enji.jpa.relations.manytomany;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import jakarta.persistence.EntityManager;

@DataJpaTest
class RelationTests {

  @Autowired
  EntityManager em;

  @Test
  void persistAndFind() {
	  
	  // prepare objects and their relations
	  A a1 = new A();
	  A a2 = new A();
	  B b1 = new B();
	  B b2 = new B();
	  a1.bs = List.of(b1, b2);
	  a2.bs = List.of(b1, b2);
	  
	  // persist to DB
	  em.persist(b1);
	  em.persist(b2);
	  em.persist(a1);
	  em.persist(a2);
	  em.flush();
	  
	  // detach them, so they can't be reused by the following find operations
	  em.detach(a1);
	  em.detach(a2);
	  em.detach(b1);
	  em.detach(b2);

	  // make sure that the persisted entities (and their relations) can be found
	  Assertions.assertEquals(em.find(A.class, a1.id).bs
			  .stream()
			  .map(b -> b.id)
			  .collect(Collectors.toSet()), 
			  Set.of(b1.id, b2.id));
	  Assertions.assertEquals(em.find(A.class, a2.id).bs
			  .stream()
			  .map(b -> b.id)
			  .collect(Collectors.toSet()), 
			  Set.of(b1.id, b2.id));
	  Assertions.assertEquals(em.find(B.class, b1.id).as
			  .stream()
			  .map(a -> a.id)
			  .collect(Collectors.toSet()), 
			  Set.of(a1.id, a2.id));
	  Assertions.assertEquals(em.find(B.class, b2.id).as
			  .stream()
			  .map(a -> a.id)
			  .collect(Collectors.toSet()), 
			  Set.of(a1.id, a2.id));
	  
  }

}
