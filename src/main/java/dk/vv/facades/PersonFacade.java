package dk.vv.facades;

import dk.vv.entitties.Person;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

public class PersonFacade {

    private EntityManager entityManager;


    @Inject
    public PersonFacade(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<Person> getAllPersons(){
        return entityManager.createQuery("select p from Person p",Person.class).getResultList();
    }


    @Transactional
    public void deletePerson(int id){
        entityManager.getTransaction().begin();
        Person p = entityManager.find(Person.class,id);
        entityManager.remove(p);

        entityManager.getTransaction().commit();
    }
}
