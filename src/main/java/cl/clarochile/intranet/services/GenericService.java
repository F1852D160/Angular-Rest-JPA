package cl.clarochile.intranet.services;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public abstract class GenericService<T, PK extends Serializable>  {

	
	@PersistenceContext(unitName="claroPU")
	protected EntityManager em;
	private Class<T> clazz;

	public GenericService(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public T create(T t) {
		em.persist(t);
		
		return t;
	}

	public T update(T t) {
		em.merge(t);
		
		return t;
	}

	public T find(PK pk) {
		return em.find(clazz, pk);
	}


	public T remove(T t) {
		em.remove(em.contains(t) ? t : em.merge(t));
		return t;
	}

}
