package br.com.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.agenda.interfaces.ICrud;
import br.com.agenda.model.Usuario;

public class UsuarioDAO implements ICrud<Usuario> {
	
	@Inject
	private EntityManager manager;

	@Override
	public void novo(Usuario u) {
		this.manager.getTransaction().begin();
		this.manager.persist(u);
		this.manager.getTransaction().commit();
	}

	@Override
	public void edita(Usuario u) {
		this.manager.getTransaction().begin();
		this.manager.merge(u);
		this.manager.getTransaction().commit();
	}

	@Override
	public void remove(Usuario u) {
		this.manager.getTransaction().begin();
		this.manager.remove(u);
		this.manager.getTransaction().commit();
	}

	@Override
	public Usuario obtem(Integer id) {
		return this.manager.find(Usuario.class, id);
	}

	@Override
	public List<Usuario> lista() {	
		//return this.manager.createQuery("select u from Usuario u",Usuario.class).getResultList();
		List<Usuario> gfg = new ArrayList<Usuario>(); 
		  
        // Initialize an ArrayList with add() 
        gfg.add(new Usuario("ds")); 
        gfg.add(new Usuario("ds")); 
        gfg.add(new Usuario("ds")); 
		return  gfg;
	}

}
