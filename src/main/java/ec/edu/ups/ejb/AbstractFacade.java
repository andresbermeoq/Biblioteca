package ec.edu.ups.ejb;

import javax.persistence.EntityManager;

public abstract class AbstractFacade<T> {

	private Class<T> entityClass;

	public AbstractFacade(Class<T> entityClass) {
		super();
		this.entityClass = entityClass;
	}
	
	protected abstract EntityManager getEntityManager();
	
	
	public void create(T entity) {
		getEntityManager().persist(entity);
	}
}
