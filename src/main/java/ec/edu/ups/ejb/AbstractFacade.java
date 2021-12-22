package ec.edu.ups.ejb;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

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
	
	public void edit(T entity) {
		getEntityManager().merge(entity);
	}

	public void remove(T entity) {
		getEntityManager().remove(getEntityManager().merge(entity));
	}
	
	public T find(Object id) {
		return getEntityManager().find(entityClass, id);
	}
	
	public List<T> findAll() {
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return getEntityManager().createQuery(cq).getResultList();
	}
	
	public List<T> findbyName(String name) {
		TypedQuery<T> query = (TypedQuery<T>) getEntityManager().createQuery("SELECT l FROM Libro l LEFT JOIN l.capitulos c WHERE c.autor.Nombre = :name");
		query.setParameter("name", name);
		return query.getResultList();
	}
	
	public List<T> findbyTitle(String title) {
		TypedQuery<T> query = (TypedQuery<T>) getEntityManager().createQuery("SELECT l FROM Libro l LEFT JOIN l.capitulos c WHERE c.titulo = :titulo");
		query.setParameter("titulo", title);
		return query.getResultList();
		
	}
}
