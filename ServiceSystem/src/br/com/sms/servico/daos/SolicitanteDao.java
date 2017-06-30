package br.com.sms.servico.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sms.servico.models.SolicitantePO;
import br.com.sms.servico.util.JPAUtil;

public class SolicitanteDao {

	EntityManager em = new JPAUtil().getEntityManager();

	public void inserir(SolicitantePO po) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(po);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	public void alterar(SolicitantePO po) throws Exception {
		try {
			em.getTransaction().begin();
			SolicitantePO solicitantePO = em.find(SolicitantePO.class, po.getId());
			em.persist(solicitantePO);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	public void excluir(SolicitantePO po) throws Exception {
		try {
			em.getTransaction().begin();
			SolicitantePO solicitantePO = em.find(SolicitantePO.class, po.getId());
			em.remove(solicitantePO);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SolicitantePO> select() throws Exception {
		try {
			String jpql = "select s from SolicitantePO s";
			em.getTransaction().begin();
			Query query = em.createQuery(jpql);
			List<SolicitantePO> solicitantes = query.getResultList();
			em.getTransaction().commit();

			return solicitantes;

		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	public SolicitantePO selectById(Long id) throws Exception {
		try {
			String jpql = "select s from SolicitantePO s where s.id = :Pid";
			em.getTransaction().begin();
			Query query = em.createQuery(jpql);
			query.setParameter("Pid", id);
			Object po = query.getSingleResult();
			em.getTransaction().commit();

			return (SolicitantePO) po;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}
}
