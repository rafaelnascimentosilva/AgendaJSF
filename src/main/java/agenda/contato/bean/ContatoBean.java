package agenda.contato.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import agenda.contato.dao.DaoGeneric;
import agenda.contato.entades.Contato;

@ViewScoped
@ManagedBean(name = "contatoBean")
public class ContatoBean {

	private Contato contato = new Contato();;
	private DaoGeneric<Contato> dao = new DaoGeneric<Contato>();
	private List<Contato> contatos = new ArrayList<Contato>();

	public String salvar() {
		contato = dao.merge(contato);
		contato = new Contato();
		carregaLista();
		return "";
	}

	public String novo() {
		contato = new Contato();
		//carregaLista();
		return "";
	}

	public String remove() {
		dao.deletaPorId(contato);
		//contato = new Contato();
		carregaLista();
		return "";
	}

	@PostConstruct
	public void carregaLista() {
		contatos = dao.getListaEntity(Contato.class);
	}

	public DaoGeneric<Contato> getDao() {
		return dao;
	}

	public void setDao(DaoGeneric<Contato> dao) {
		this.dao = dao;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Contato> getContatos() {
		return contatos;
	}
}
