package br.com.sms.servico.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
			em.persist(funcionarioPO);
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

	public List<FuncionarioPO> selectDynamic(String nome, String cpf, String setor) throws Exception {
		try {
			/**
			 * CriteriaBuilder é uma fábrica auxiliar para criar expressões
			 * sobre as funções que utilizaremos na busca. A fábrica não executa
			 * a query, ela apenas ajuda a criá-la.
			 */
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<FuncionarioPO> query = criteriaBuilder.createQuery(FuncionarioPO.class);

			// aqui estou guardando a raiz da consulta "Select f FuncionarioPO
			// f"
			Root<FuncionarioPO> root = query.from(FuncionarioPO.class);

			// Os Path é usado para definir os caminhos até os atributos do
			// objeto
			Path<String> nomePath = root.<String> get("nome");
			Path<String> cpfPath = root.<String> get("cpf");
			Path<String> setorPath = root.<String> get("setor");

			// criamos uma lista de Predicate para poder usa-ló no where pois os
			// predicate so tem vida no scopo do if adicionando na lista podemos
			// usa-lo embaixo
			List<Predicate> predicates = new ArrayList<Predicate>();

			if (!nome.isEmpty()) {
				Predicate nomeIgual = criteriaBuilder.like(nomePath, nome + "%");
				predicates.add(nomeIgual);
			}

			if (!cpf.isEmpty()) {
				Predicate cpfIgual = criteriaBuilder.like(cpfPath, cpf + "%");
				predicates.add(cpfIgual);
			}

			if (!setor.isEmpty()) {
				Predicate setorIgual = criteriaBuilder.like(setorPath, setor + "%");
				predicates.add(setorIgual);
			}

			// apos verificar quais parametros foram preenchidos sera montada
			// uma clausula where com os dados da Lista de Predicates
			query.where((Predicate[]) predicates.toArray(new Predicate[0]));
			// executamos a query
			TypedQuery<FuncionarioPO> typedQuery = em.createQuery(query);
			// resultado da select dinamica
			return typedQuery.getResultList();
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
