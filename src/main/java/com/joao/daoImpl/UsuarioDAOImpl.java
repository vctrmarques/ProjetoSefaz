package com.joao.daoImpl;

import java.util.List;

import javax.persistence.Query;

import com.joao.dao.usuarios.UsuarioDAO;
import com.joao.model.Usuario;

@SuppressWarnings("serial")
public class UsuarioDAOImpl extends UsuarioDAO {

	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarios() {
		Query q = criarQuery("SELECT u FROM Usuario u ORDER BY u.nome");
		return q.getResultList();
	}
	
	public Usuario findUserByName(String pNome) {
		Usuario user = null;
		Query q = null;
		String consulta = "SELECT u FROM Usuario u WHERE u.nome = '"+ pNome + "\'";
		
		q = criarQuery(consulta);
		if (q.getResultList().size() <= 0) {
			user = null;
		} else {
			user = (Usuario) q.getResultList().get(0);
		}
		return user;
	}
}