package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.model.Capitulo;

@Stateless
public class CapituloFacade extends AbstractFacade<Capitulo> {
	
	@PersistenceContext(unitName = "Biblioteca")
	private EntityManager entityManager;
	
	public CapituloFacade() {
		super(Capitulo.class);
	}
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
