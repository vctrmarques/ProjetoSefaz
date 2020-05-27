package com.joao.controlleImpl;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.joao.controller.Controller;
import com.joao.model.Telefone;
import com.joao.model.Usuario;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ControllerImpl implements Controller{

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean salvarUsuario(Usuario usuario) throws Exception {
		try {
			em.persist(usuario);
			return true;
		} catch (Exception e) {
			throw(e);
		}
	}

	@Override
	public boolean excluirUsuario(Integer id) throws Exception {
		Usuario user = null;
		try {

			user = em.find(Usuario.class, id);
			em.remove(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Usuario alterarUsuario(Usuario usuario) throws Exception {
		Usuario user =  null;
		try {
			user = em.merge(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Usuario findUserById(Integer id) throws Exception {
		Usuario usuario = null;
		try {
			usuario = em.find(Usuario.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public boolean salvarTelefone(Telefone telefone) throws Exception {
		try {
			em.persist(telefone);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean excluirTelefone(Integer id) throws Exception {
		try {
			em.createQuery("delete from Telefone where id = :id").setParameter("id", id).executeUpdate();
			flushAndClear();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Telefone alterarTelefone(Telefone telefone) throws Exception {

		Telefone tel = null;
		try {
			tel = em.merge(telefone);
			return tel;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tel;
	}
	
	private void flushAndClear() {
	    em.flush();
	    em.clear();
	}

}
