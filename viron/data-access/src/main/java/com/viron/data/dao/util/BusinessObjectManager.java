package com.viron.data.dao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BusinessObjectManager {

	private static final String PERSISTENCE_ENTITY_MANAGER_DATA_ACCESS = "data-access";
	/**
	 * The JPA session.
	 */

	private final EntityManager entityManager;

	/**
	 * Constructor. Stores the session.
	 * 
	 * @param entityManager
	 *            The session to store.
	 */

	public BusinessObjectManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * Get the entity manager associated with this instance.
	 */

	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Flush any data waiting to be written.
	 */

	public void flush() {
		entityManager.flush();
	}

	// -----------------------------------------------------------------------------------------------
	//
	// Pseudo singleton interface which uses ThreadLocal to store the relevant
	// BusinessObjectManager
	//
	// ------------------------------------------------------------------------------------------------

	private static ThreadLocal<BusinessObjectManager> bom = new ThreadLocal<BusinessObjectManager>();

	/**
	 * Get an instance of the business object manager, creating one if one has
	 * not been created already.
	 * 
	 * @return A usable instance of the business object manager.
	 */
	public static BusinessObjectManager getInstance() {
		BusinessObjectManager instance = bom.get();
		if (instance == null) {
			instance = createBusinessObjectManager();
			bom.set(instance);
		}
		return instance;
	}

	/**
	 * Create the business object manager if required.
	 */

	public static BusinessObjectManager createBusinessObjectManager() {
		final EntityManager newEntityManager = createOrRetrieveEntityManager();
		return new BusinessObjectManager(newEntityManager);
	}

	/**
	 * Start a new transaction
	 */

	public static void beginTransaction() {
		final BusinessObjectManager instance = bom.get();
		if (instance == null) {
			return;
		}
		EntityTransaction transaction = instance.getEntityManager()
				.getTransaction();
		transaction.begin();
	}

	/**
	 * Check to see if there is an active transaction.
	 */

	public static boolean hasActiveTransaction() {
		final BusinessObjectManager instance = bom.get();
		if (instance == null) {
			return false;
		}
		EntityTransaction transaction = instance.getEntityManager()
				.getTransaction();
		if (transaction == null) {
			return false;
		}
		return transaction.isActive();
	}

	/**
	 * Commit any transaction taking place inside the BusinessObjectManager.
	 */

	public static void commit() {
		final BusinessObjectManager instance = bom.get();
		if (instance == null) {
			return;
		}
		EntityTransaction transaction = instance.getEntityManager()
				.getTransaction();
		if (transaction != null && transaction.isActive()) {
			transaction.commit();
		}
	}

	/**
	 * Roll back any transaction taking place inside the BusinessObjectManager.
	 */

	public static void rollback() {
		final BusinessObjectManager instance = bom.get();
		if (instance == null) {
			return;
		}
		EntityTransaction transaction = instance.getEntityManager()
				.getTransaction();
		if (transaction != null && transaction.isActive()) {
			transaction.rollback();
		}
	}

	/**
	 * Close the EntityManager in use.
	 */

	public static void close() {
		if (bom == null) {
			return;
		}

		final BusinessObjectManager instance = bom.get();
		if (instance == null) {
			return;
		}

		try {
			EntityManager em = instance.getEntityManager();
			if (em != null && em.isOpen()) {
				em.close();
			}
		} finally {
			bom.remove();
		}
	}

	/**
	 * Retrieves the entity manager from the thread context or creates and
	 * returns new one.
	 * 
	 * @return The entity manager in use.
	 */
	private static EntityManager createOrRetrieveEntityManager() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(PERSISTENCE_ENTITY_MANAGER_DATA_ACCESS);
		return emf.createEntityManager();
	}
}
