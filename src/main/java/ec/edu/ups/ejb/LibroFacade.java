package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import ec.edu.ups.model.Libro;

@Stateless
public class LibroFacade extends AbstractFacade<Libro> {
	
	@PersistenceContext(unitName = "Biblioteca")
	private EntityManager entityManager;
	
	public LibroFacade() {
		super(Libro.class);
	}
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
