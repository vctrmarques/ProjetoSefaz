package com.joao.daoImpl;

import java.util.List;

import javax.persistence.Query;

import com.joao.dao.usuarios.UsuarioDAO;
import com.joao.model.Usuario;

@SuppressWarnings("serial")
public class UsuarioDAOImpl extends UsuarioDAO {

	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarios() {
		Query q = criarQuery("SELECT u.nome, u.email, t.dd, t.numero, t.tipo FROM Usuario as u JOIN Telefone as t ON t.id = u.id");
		return q.getResultList();
	}
	
	public Usuario findUserByName(String nome) {
		Usuario user = null;
		Query q = null;
		String consulta = "SELECT u FROM Usuario u WHERE u.nome = '"+ nome + "\'";
		
		q = criarQuery(consulta);
		if (q.getResultList().size() <= 0) {
			user = null;
		} else {
			user = (Usuario) q.getResultList().get(0);
		}
				
		return user;
	}
	
	public Usuario findUserById(Integer id) {
		Usuario user = null;
		Query q = null;
		String consulta = "SELECT u FROM Usuario u WHERE u.id = '"+ id + "\'";
		
		q = criarQuery(consulta);
		if (q.getResultList().size() <= 0) {
			user = null;
		} else {
			user = (Usuario) q.getResultList().get(0);
		}
		
		return user;
	}
}