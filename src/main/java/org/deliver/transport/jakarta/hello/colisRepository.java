package org.deliver.transport.jakarta.hello;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Stateless
public class colisRepository {

    // logger pour verifier le bon déroulement
    private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    @PersistenceContext
    private EntityManager em;

    public Colis create(Colis c) {
        logger.info("Creating colis " + c.getId());
        ColisHistory history = new ColisHistory(c);
        em.persist(history);
        em.persist(c);

        return c;
    }

    public List<Colis> findAll() {
        logger.info("Getting all colis");
        return em.createQuery("SELECT c FROM Colis c", Colis.class).getResultList();
    }

    public Optional<Colis> findById(Long id) {
        logger.info("Getting colis by id " + id);
        return Optional.ofNullable(em.find(Colis.class, id));
    }

    public void delete(Long id) {
        logger.info("Deleting colis by id " + id);
        var colis = findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid colis Id:" + id));
        em.remove(colis);
    }

    public Colis update(Colis c) {
        logger.info("Updating colis " + c.getId());

        // on recup le colis d'avant
        Colis oldColis = em.find(Colis.class, c.getId());
        // on créer l'historique avec le colis
        ColisHistory ch = new ColisHistory(oldColis);
        em.persist(ch);
        return em.merge(c);
    }

    // HISTORIQUE
    public List<ColisHistory> findHistorybyId(Long idColis) {
        return em.createQuery("SELECT h FROM ColisHistory h WHERE h.colisId = :colisId", ColisHistory.class)
                .setParameter("colisId", idColis)
                .getResultList();
    }
}
