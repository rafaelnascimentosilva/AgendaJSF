import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.dao.UsuarioDAO;
import br.com.agenda.model.Contato;
import br.com.agenda.model.Usuario;

public class Teste {
	public static void main(String[] args) {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("agenda_app");
		EntityManager manager = factory.createEntityManager();

		
	
		
		List<Usuario> lu = manager.createQuery("select u from Usuario u",Usuario.class).getResultList();
		//List<Contato> lc = manager.createQuery("select c from Contato c where fk_usuario = 3", Contato.class).getResultList();
		
		//List<Contato> lc2 = manager.createQuery("select u FROM Contato c JOIN c.id u  where c.id = 21", Contato.class).getResultList();
		
		//List<Usuario> u  = new UsuarioDAO().lista();
		//System.out.println("lista: "+ lu.get(1).getNome());
		
		List<Contato> lc = new ContatoDAO().listaDeContatosPorId(3);
		
		for (Contato contato : lc) {
			System.out.println(contato.getNome());
		}
		
		
	
		/*
		
		
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

		*/
		
		
	}
}
