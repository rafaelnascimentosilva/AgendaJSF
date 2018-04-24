package agenda.contato.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import agenda.contato.util.JPAUtil;

public class DaoGeneric<E> {

	public void salvar(E entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entitytransaction = entityManager.getTransaction();
		entitytransaction.begin();
		entityManager.persist(entidade);
		entitytransaction.commit();
		entityManager.close();
	}

	public E merge(E entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entitytransaction = entityManager.getTransaction();
		entitytransaction.begin();
		E retorno = entityManager.merge(entidade);
		entitytransaction.commit();
		entityManager.close();
		return retorno;
	}

	public void deletaPorId(E entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entitytransaction = entityManager.getTransaction();
		entitytransaction.begin();
		
		Object id = JPAUtil.getPrimaryKey(entidade);
		entityManager.createQuery("delete from" + entidade.getClass().getCanonicalName() + "where id =" + id).executeUpdate();
		
		entitytransaction.commit();
		entityManager.close();
	}

}
