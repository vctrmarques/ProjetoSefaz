package com.joao.daoImpl;

import java.util.ArrayList;
import java.util.List;

import com.joao.dao.usuarios.UsuarioDAO;
import com.joao.model.Telefone;
import com.joao.model.Usuario;

@SuppressWarnings("serial")
public class UsuarioDAOImpl extends UsuarioDAO {

	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarios() {
		//Query q = criarQuery("SELECT u.nome, u.email, t.dd, t.numero, t.tipo FROM Usuario as u JOIN Telefone as t ON t.id = u.id");
		List<Usuario> usuario = new ArrayList<Usuario>();
		
		Usuario user1 = new Usuario();
		List<Telefone> fone = new ArrayList<Telefone>();
		Telefone telefone = new Telefone();
		telefone.setDdd(81);
		telefone.setNumero("3435-9999");
		telefone.setTipo("residencial");
		fone.add(telefone);
		
		
		user1.setId(1);
		user1.setNome("joao");
		user1.setEmail("teste@teste.com");
		user1.setSenha("123");
		user1.setTelefone(fone);

		Usuario user2 = new Usuario();
		user2.setId(2);
		user2.setNome("Victor");
		user2.setEmail("selecao@teste.com");
		user2.setSenha("teste");
		user2.setTelefone(fone);
		
		Usuario user3 = new Usuario();
		user3.setId(3);
		user3.setNome("Andre");
		user3.setEmail("prova@teste.com");
		user3.setSenha("2133");
		user3.setTelefone(fone);
		
		usuario.add(user1);
		usuario.add(user2);
		usuario.add(user3);
		
		//return q.getResultList();
		
		return usuario;
	}
	
	public Usuario findUserByName(String nome) {
		/*Usuario user = null;
		Query q = null;
		String consulta = "SELECT u FROM Usuario u WHERE u.nome = '"+ nome + "\'";
		
		q = criarQuery(consulta);
		if (q.getResultList().size() <= 0) {
			user = null;
		} else {
			user = (Usuario) q.getResultList().get(0);
		}*/
		
		Usuario user = new Usuario();
		user.setId(1);
		user.setNome("joao");
		user.setEmail("teste@teste.com");
		user.setSenha("123"); 
				
		return user;
	}
	
	public Usuario findUserById(Integer id) {
		/*Usuario user = null;
		Query q = null;
		String consulta = "SELECT u FROM Usuario u WHERE u.id = '"+ id + "\'";
		
		q = criarQuery(consulta);
		if (q.getResultList().size() <= 0) {
			user = null;
		} else {
			user = (Usuario) q.getResultList().get(0);
		}*/
		
		List<Telefone> fone = new ArrayList<Telefone>();
		Telefone telefone = new Telefone();
		telefone.setDdd(11);
		telefone.setNumero("3436-9999");
		telefone.setTipo("empresarial");
		fone.add(telefone);
		
		Usuario user = new Usuario();
		user.setId(1);
		user.setNome("joao");
		user.setEmail("teste@teste.com");
		user.setSenha("123"); 
		user.setTelefone(fone);
				
		return user;
	}
}