package br.com.agenda.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.agenda.JPAUtil;
import br.com.agenda.interfaces.ICrud;
import br.com.agenda.model.Contato;

public class ContatoDAO implements ICrud<Contato>, Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;
	
	public ContatoDAO() {
		//this.manager = new JPAUtil().getEntityManager();
	}

	@Override
	public void novo(Contato c) {
		System.out.println("dsadadads"+c.getId());
		System.out.println("dsadadads"+c.getNome());
		System.out.println("dsadadads"+c.getUsuario());
		this.manager.getTransaction().begin();
		this.manager.persist(c);
		this.manager.getTransaction().commit();
	}

	@Override
	public void edita(Contato u) {
		this.manager.getTransaction().begin();
		this.manager.merge(u);
		this.manager.getTransaction().commit();

	}

	@Override
	public void remove(Contato u) {
		
			this.manager.getTransaction().begin();
			this.manager.remove(u);
			this.manager.getTransaction().commit();
		
		
	}

	@Override
	public Contato obtem(Integer id) {
		return this.manager.find(Contato.class, id);
	}

	@Override
	public List<Contato> lista() {
		return this.manager.createQuery("select c from Contato c", Contato.class).getResultList();
	}
	
	public List<Contato> listaDeContatosPorId(Integer id) {
		return this.manager.createQuery("select c from Contato c where fk_usuario = :id", Contato.class)
				.setParameter("id", id)
				.getResultList();
	}

}
