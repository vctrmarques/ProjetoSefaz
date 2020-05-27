package com.joao.controller;

import com.joao.model.Telefone;
import com.joao.model.Usuario;

public interface Controller {

	public boolean salvarUsuario(Usuario usuario) throws Exception;
	
	public boolean excluirUsuario(Integer id) throws Exception;
	
	public Usuario alterarUsuario(Usuario usuario) throws Exception;
	
	public Usuario findUserById(Integer id) throws Exception;
	
	
	public boolean salvarTelefone(Telefone telefone) throws Exception;
	
	public boolean excluirTelefone(Integer id) throws Exception;

	public Telefone alterarTelefone(Telefone telefone) throws Exception;
}
