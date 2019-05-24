package br.com.agenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Transient;

import org.primefaces.PrimeFaces;

import br.com.agenda.dao.UsuarioDAO;
import br.com.agenda.model.Usuario;

@Named("usuarioCtrl")
@SessionScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	@Inject
	private UsuarioDAO usuarioDao;

	@Produces
	private List<Usuario> usuarioLista;

	private Usuario usuarioSelecionado;

	@PostConstruct
	private void init() {

		this.usuarioLista = usuarioDao.lista();

	}

	public UsuarioController() {

	}

	public List<Usuario> Listar() {

		return this.usuarioLista = new UsuarioDAO().lista();

	}

	public void Novo() {
		if (usuario != null) {
			usuarioDao.novo(this.usuario);
			this.usuario = new Usuario();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Sucesso", "Adicionado"));
		}
	}

	public void btnDialogoEditar(Usuario u) {

		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('dlgEditar').show();");
		this.usuarioSelecionado = u;
	}

	public void btnDialogoDelete(Usuario u) {

		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('dlgDelete').show();");

	}

	public void Editar() {
		usuarioDao.edita(this.usuarioSelecionado);
		this.usuarioSelecionado = new Usuario();
	}
	
	public void Delete() {
		usuarioDao.remove(this.usuarioSelecionado);
		this.usuarioSelecionado = new Usuario();
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public List<Usuario> getUsuarioLista() {
		return usuarioLista;
	}

	public void setUsuarioLista(List<Usuario> usuarioLista) {
		this.usuarioLista = usuarioLista;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

}
