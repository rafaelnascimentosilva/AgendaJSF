package br.com.agenda.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.agenda.model.Usuario;

@Named
@RequestScoped
public class LoginController {

	@Inject
	private Usuario usuario;

	private String mensagem;

	public void VerificaLogin() {
		if (usuario.getNome().equals("ana") && usuario.getFone().equals("123")) {
			mensagem = "Seja bem vinda: " + usuario.getNome();
			System.out.println("Seja bem vinda: " + usuario.getNome());
		} else {
			mensagem = "Usuario " + usuario.getNome() + " nao encontrado";
			System.out.println("Usuario " + usuario.getNome() + " nao encontrado");
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
