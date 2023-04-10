package systems.enji.jpa.relations.jointable.onetoone;

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
	  A a = new A();
	  B b = new B();
	  a.b = b;
	  
	  // persist to DB
	  em.persist(b);
	  em.persist(a);
	  em.flush();
	  
	  // detach them, so they can't be reused by the following find operations
	  em.detach(a);
	  em.detach(b);
	  
	  // make sure that the persisted entities (and their relations) can be found
	  Assertions.assertEquals(em.find(A.class, a.id).b.id, b.id);
	  Assertions.assertEquals(em.find(B.class, b.id).a.id, a.id);
	  
  }

}
