package br.com.sms.servico.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

	public EntityManager getEntityManager() {
		EntityManager em = emf.createEntityManager();
		return em;
	}
}
