package agenda.contato.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import agenda.contato.dao.DaoGeneric;
import agenda.contato.entades.Contato;
@ViewScoped
@ManagedBean(name = "contatoBean")
public class ContatoBean {

	private Contato contato = new Contato();;
	private DaoGeneric<Contato> dao = new DaoGeneric<Contato>();

	public String salvar() {	
		contato = dao.merge(contato);
		return "";
	}
	
	public String novo() {
		contato = new Contato();
		return "";
	}
	
	public String remove() {
		//contato = new Contato();
		dao.deletaPorId(contato);		
		return "";
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
}
