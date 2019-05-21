import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.agenda.model.Contato;
import br.com.agenda.model.Usuario;

public class Teste {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("agenda_app");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tra = manager.getTransaction();
		
		tra.begin();

		Usuario u = new Usuario();
		u = manager.find(Usuario.class, 1);		
		
		//u.setNome("pedro");
		//u.setSenha("123456");		
		
		Contato c = new Contato();
		c.setNome("Aninha");
		c.setFone("8533889500");
		c.setUsuario(u);		
		
		u.getContatos().add(c);
		
		manager.persist(u);
		
		tra.commit();

		
		
		
	}
}
