package br.com.sms.servico.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.sms.servico.models.FuncionarioPO;

public class FuncionarioDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
	private EntityManager em = emf.createEntityManager();

	public void inserir(FuncionarioPO po) {
		em.getTransaction().begin();
		em.persist(po);
		em.getTransaction().commit();
	}

	public List<FuncionarioPO> select() {
		System.out.println("chamei");
		return em.createQuery("select f from Funcionario f", FuncionarioPO.class).getResultList();
	}

	public FuncionarioPO selectById(Long id) {
		Query query = em.createQuery("select f from Funcionario f where f.id = :pId");
		query.setParameter("pId", id);
		return (FuncionarioPO) query.getSingleResult();

	}
}
