import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.agenda.dao.UsuarioDAO;
import br.com.agenda.model.Usuario;

public class Teste {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("agenda_app");
		EntityManager manager = factory.createEntityManager();

		
	
		
		//List<Usuario> u = manager.createQuery("select u from Usuario u",Usuario.class).getResultList();
		
		List<Usuario> u  = new UsuarioDAO().lista();
		System.out.println("lista: "+ u.get(1).getNome());
		
		for (Usuario usuario : new UsuarioDAO().lista()) {
			System.out.println(usuario.getNome());
		}
		
		
		
	/*	EntityTransaction tra = manager.getTransaction();
		
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
