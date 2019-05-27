package br.com.agenda.interfaces;

import java.util.List;

public interface ICrud<E> {

	public void novo(E entity);

	public void edita(E entity);

	public void remove(E entity);

	public E obtem(Integer id);

	public List<E> lista();

}
