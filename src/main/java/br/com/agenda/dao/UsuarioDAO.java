package br.com.agenda.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.agenda.interfaces.ICrud;
import br.com.agenda.model.Usuario;

public class UsuarioDAO implements ICrud<Usuario> {
	@Inject
	private EntityManager mananer;

	@Override
	public void novo(Usuario u) {
		this.mananer.getTransaction().begin();
		this.mananer.persist(u);
		this.mananer.getTransaction().commit();
	}

	@Override
	public void edita(Usuario u) {
		this.mananer.getTransaction().begin();
		this.mananer.merge(u);
		this.mananer.getTransaction().commit();
	}

	@Override
	public void remove(Usuario u) {
		this.mananer.getTransaction().begin();
		this.mananer.remove(u);
		this.mananer.getTransaction().commit();
	}

	@Override
	public Usuario obtem(Integer id) {
		return this.mananer.find(Usuario.class, id);
	}

	@Override
	public List<Usuario> lista() {
		return mananer.createQuery("select u from Usuario u",Usuario.class).getResultList();
	}

}
