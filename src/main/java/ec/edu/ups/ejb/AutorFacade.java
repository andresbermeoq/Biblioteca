package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.model.Autor;

@Stateless
public class AutorFacade extends AbstractFacade<Autor> {
	
	@PersistenceContext(unitName = "Biblioteca")
	private EntityManager entityManager;
	
	public AutorFacade() {
		super(Autor.class);
	}
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	

}
