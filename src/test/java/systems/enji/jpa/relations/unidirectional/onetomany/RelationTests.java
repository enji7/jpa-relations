package systems.enji.jpa.relations.unidirectional.onetomany;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import jakarta.persistence.EntityManager;

@DataJpaTest(showSql = false)
class RelationTests {

  @Autowired
  EntityManager em;

  @Test
  void persistAndFind() {
	  
	  // prepare objects and their relations
	  A a = new A();
	  B b1 = new B();
	  B b2 = new B();
	  a.bs = List.of(b1, b2);
	  
	  // persist to DB
	  em.persist(b1);
	  em.persist(b2);
	  em.persist(a);
	  em.flush();
	  
	  // detach them, so they can't be reused by the following find operations
	  em.detach(b1);
	  em.detach(b2);
	  em.detach(a);

	  // make sure that the persisted entities (and their relations) can be found
	  Assertions.assertEquals(em.find(A.class, a.id).bs
			  .stream()
			  .map(b -> b.id)
			  .collect(Collectors.toSet()), 
			  Set.of(b1.id, b2.id));
	  
  }

}
