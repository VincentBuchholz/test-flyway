package dk.vv.rest;

import dk.vv.entitties.Person;
import dk.vv.facades.PersonFacade;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
@Path("/api/person")
public class PersonResource {

    private final PersonFacade personFacade;

    @Inject
    public PersonResource(PersonFacade personFacade) {
        this.personFacade = personFacade;
    }

    @GET
    public Response getPersons(){
        List<Person> personList =personFacade.getAllPersons();

        return Response.ok(personList).build();
    }
}
