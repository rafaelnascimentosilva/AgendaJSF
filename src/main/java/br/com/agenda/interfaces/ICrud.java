package br.com.agenda.interfaces;

import java.util.List;

import br.com.agenda.model.Usuario;

public interface ICrud<E> {

	public void novo(E entity);

	public void edita(E entity);

	public void remove(E entity);

	public E obtem(Integer id);

	public List<Usuario> lista();

}
