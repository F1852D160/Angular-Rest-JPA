package cl.clarochile.intranet.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import cl.clarochile.intranet.models.User;


@LocalBean
@Stateless
public class UserService extends GenericService<User, Long> {

	public UserService() {
		super(User.class);
	}

	public List<User> findAll() {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
		return query.getResultList();
	}
}
