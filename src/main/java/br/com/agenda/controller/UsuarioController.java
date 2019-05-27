package br.com.agenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.dao.UsuarioDAO;
import br.com.agenda.model.Contato;
import br.com.agenda.model.Usuario;

@Named("usuarioCtrl")
@ViewScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	
	private Contato contato;

	@Inject
	private UsuarioDAO usuarioDao;
	
	@Inject
	private ContatoDAO contatoDao;

	@Produces
	private List<Usuario> usuarioLista;
	
	@Produces
	private List<Contato> contatoLista;
	
	@Produces
	private List<Contato> contatosPorUsuario;

	private Usuario usuarioSelecionado;

	@PostConstruct
	private void init() {
		this.usuarioLista = usuarioDao.lista();
		this.contatoLista = contatoDao.lista();
		this.usuario = new Usuario();
	}

	public UsuarioController() {
	}

	public List<Usuario> lista() {
		return this.usuarioLista = new UsuarioDAO().lista();
	}

	public void btnDialogoEdita(Usuario u) {
		this.usuarioSelecionado = u;
		PrimeFaces current = PrimeFaces.current();
		current.ajax().update("formEditar");
		current.executeScript("PF('dlgEditar').show();");
	}

	public void btnDialogoNovoContato(Usuario u) {
		PrimeFaces current = PrimeFaces.current();
		this.usuarioSelecionado =  u;
		if (this.usuarioSelecionado !=null) {		
			contato = new Contato();
			contato.setUsuario(u);
			 current = PrimeFaces.current();
			current.executeScript("PF('dlgNovoContato').show();");
		}else {
			System.out.println("usuario nulo");
		}	
	}
	
	public void inseriContato() {
		if (this.contato!=null) {			
			//contato.setUsuario(this.usuarioSelecionado);
			contatoLista = new ArrayList<Contato>();
			contatoDao.novo(contato);
			contatoLista.add(contato);
			PrimeFaces current = PrimeFaces.current();
			current.ajax().update("formContatosPorUsuarios");
			
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Sucesso", "Adicionado"));
		}		
	
	
	}

	public void inseri() {
		usuarioDao.novo(this.usuario);
		usuarioLista.add(usuario);
		this.usuario = new Usuario();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Sucesso", "Adicionado"));
	}

	public void edita() {
		usuarioDao.edita(this.usuarioSelecionado);
		this.usuarioSelecionado = new Usuario();
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('dlgEditar').hide()");
	}

	public void deleta(Usuario u) {
		System.out.println("cheguei");
		this.usuarioSelecionado = u;
		usuarioDao.remove(this.usuarioSelecionado);
		usuarioLista.remove(this.usuarioSelecionado);
		PrimeFaces current = PrimeFaces.current();
		current.ajax().update("formEditar");
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

	public ContatoDAO getContatoDao() {
		return contatoDao;
	}

	public void setContatoDao(ContatoDAO contatoDao) {
		this.contatoDao = contatoDao;
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
	
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Contato> getContatoLista() {
		return contatoLista;
	}

	public void setContatoLista(List<Contato> contatoLista) {
		this.contatoLista = contatoLista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((usuarioDao == null) ? 0 : usuarioDao.hashCode());
		result = prime * result + ((usuarioLista == null) ? 0 : usuarioLista.hashCode());
		result = prime * result + ((usuarioSelecionado == null) ? 0 : usuarioSelecionado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioController other = (UsuarioController) obj;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (usuarioDao == null) {
			if (other.usuarioDao != null)
				return false;
		} else if (!usuarioDao.equals(other.usuarioDao))
			return false;
		if (usuarioLista == null) {
			if (other.usuarioLista != null)
				return false;
		} else if (!usuarioLista.equals(other.usuarioLista))
			return false;
		if (usuarioSelecionado == null) {
			if (other.usuarioSelecionado != null)
				return false;
		} else if (!usuarioSelecionado.equals(other.usuarioSelecionado))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsuarioController [usuario=" + usuario + ", usuarioDao=" + usuarioDao + ", usuarioLista=" + usuarioLista
				+ ", usuarioSelecionado=" + usuarioSelecionado + "]";
	}

	public List<Contato> getContatosPorUsuario() {
		return contatosPorUsuario;
	}

	public void setContatosPorUsuario(List<Contato> contatosPorUsuario) {
		this.contatosPorUsuario = contatosPorUsuario;
	}



}
