package dk.vv;

import dk.vv.entitties.Person;
import dk.vv.facades.PersonFacade;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.*;

import java.util.List;

@QuarkusTest
public class PersonFacadeTest {


    @Inject
    EntityManagerFactory entityManagerFactory;

    EntityManager entityManager;
    PersonFacade classUnderTest;

    @BeforeEach
    public void before() {
        flyway.migrate();
        this.entityManager = this.entityManagerFactory.createEntityManager();

        this.classUnderTest = new PersonFacade(entityManager);
    }

    @Inject
    protected Flyway flyway;

    @AfterEach
    public void restoreDatabase() {
        flyway.clean();
    }



    @Test
    void canQueryPersons(){
        List<Person> personList = classUnderTest.getAllPersons();

        Assertions.assertEquals(6,personList.size());
    }

    @Test
    void canDeletePersons(){
        classUnderTest.deletePerson(5);
        classUnderTest.deletePerson(3);

        Assertions.assertEquals(4,classUnderTest.getAllPersons().size());
    }


}
