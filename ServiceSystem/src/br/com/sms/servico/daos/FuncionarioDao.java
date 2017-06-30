package br.com.sms.servico.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sms.servico.models.FuncionarioPO;
import br.com.sms.servico.util.JPAUtil;

public class FuncionarioDao {

	EntityManager em = new JPAUtil().getEntityManager();

	public void inserir(FuncionarioPO po) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(po);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	public void alterar(FuncionarioPO po) throws Exception {
		try {
			em.getTransaction().begin();
			FuncionarioPO funcionarioPO = em.find(FuncionarioPO.class, po.getId());
			em.remove(funcionarioPO);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	public void excluir(FuncionarioPO po) throws Exception {
		try {
			em.getTransaction().begin();
			FuncionarioPO funcionarioPO = em.find(FuncionarioPO.class, po.getId());
			em.remove(funcionarioPO);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<FuncionarioPO> select() throws Exception {
		try {
			String jpql = "select f from FuncionarioPO f";
			Query query = em.createQuery(jpql);
			return query.getResultList();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	public FuncionarioPO selectById(Long id) throws Exception {
		try {
			Query query = em.createQuery("select f from FuncionarioPO f where f.id = :pId");
			query.setParameter("pId", id);
			return (FuncionarioPO) query.getSingleResult();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}
}
