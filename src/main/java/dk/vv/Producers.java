package dk.vv;

import dk.vv.facades.PersonFacade;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class Producers {

    @Produces
    PersonFacade getPersonFacade(EntityManager entityManager){
        return new PersonFacade(entityManager);
    }
}
