package org.deliver.transport.jakarta.hello;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
@Path("colis")
public class ColisRessources {


    private final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    @Inject
    private colisRepository colisRepo;

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Colis findColis(@PathParam("id") Long id) {
        logger.info("Getting colis by id " + id);
        return colisRepo.findById(id)
                .orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @GET
    @Produces("application/json")
    public List<Colis> findAll() {
        logger.info("Getting all colis (Ressources)");
        return colisRepo.findAll();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Colis create(Colis c) {
        logger.info("Creating colis " + c.getId());
        try{
            colisRepo.insertHistory(c);
            return colisRepo.create(c);
        }catch (PersistenceException ex){
            logger.info("Error creating colis " + c.getId());
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        logger.info("Deleting colis by id " + id);
        try{
            colisRepo.delete(id);
        }catch (IllegalArgumentException e){
            logger.info("Error deleting colis by id " + id);
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }


    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Colis update(Colis c) {
        logger.info("Updating colis " + c.getId());
        try{
            Colis rest = colisRepo.create(c);
            colisRepo.insertHistory(c);
            return rest;
        }catch (PersistenceException ex){
            logger.info("Error updating colis " + c.getId());
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }
}
