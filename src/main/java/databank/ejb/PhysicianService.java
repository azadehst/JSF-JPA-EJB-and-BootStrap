package databank.ejb;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import databank.model.PhysicianPojo;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.OptimisticLockException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
/**
 * Stateless Session Bean - InventoryService
 */
//@Stateless
@Singleton
public class PhysicianService implements Serializable {
	/** explicitly set serialVersionUID */
	private static final long serialVersionUID = 1L;

	//Get the log4j2 logger for this class
	private static final Logger LOG = LogManager.getLogger();

	@PersistenceContext(name = "PU_DataBank")
	protected EntityManager em;
	
	/**
	 * Default constructor.
	 */
	public PhysicianService() {
	}


	public List<PhysicianPojo> findAllPhysicians() {
		LOG.debug("reading all Physicians");
		//Use the named JPQL query from the PhysicianPojo class to grab all the Physicians
		TypedQuery<PhysicianPojo> allPhysiciansQuery = em.createNamedQuery(PhysicianPojo.PHYSICIAN_FIND_ALL, PhysicianPojo.class);
		//Execute the query and return the result/s.
		return allPhysiciansQuery.getResultList();
	}


	@Transactional
	public PhysicianPojo persistPhysician(PhysicianPojo physician) {
		LOG.debug("creating a Physician = {}", physician);
		em.persist(physician);
		return physician;
	}


	public PhysicianPojo findPhysicianById(int physicianId) {
		LOG.debug("read a specific physician = {}", physicianId);
		return em.find(PhysicianPojo.class, physicianId);
	}


	@Transactional
	public PhysicianPojo mergePhysician(PhysicianPojo physicianWithUpdates) {
		LOG.debug("updating a specific physician = {}", physicianWithUpdates);
		
		try {
	        return em.merge(physicianWithUpdates);
	    } catch (OptimisticLockException e) {
	        LOG.error("Optimistic lock exception while merging physician: {}", physicianWithUpdates, e);
	        return null;
	    }
	}


	@Transactional
	public void removePhysician(int physicianId) {
		LOG.debug("deleting a specific PhysicianID = {}", physicianId);
		PhysicianPojo physician = findPhysicianById(physicianId);
		LOG.debug("deleting a specific physician = {}", physician);
		if (physician != null) {
			em.refresh(physician);
			em.remove(physician);
		}
	}
		
}