package com.joao.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.joao.controlleImpl.ControllerImpl;
import com.joao.daoImpl.UsuarioDAOImpl;
import com.joao.model.Telefone;
import com.joao.model.Usuario;

@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {

	private UsuarioDAOImpl usuarioDAO;

	private String nome;
	private String email;
	private String senha;
	private String confirmarSenha;
	private ArrayList<Telefone> telefone;
	private Telefone fone;
	private Usuario usuario;
	private List<Usuario> usuarios;
	private List<Usuario> listUser;
	
	public UsuarioBean() {
		usuario = new Usuario();
		fone = new Telefone();
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public ArrayList<Telefone> getTelefone() {
		return telefone;
	}
	public void setTelefone(ArrayList<Telefone> telefone) {
		this.telefone = telefone;
	}
	public String getConfirmarSenha() {
		return confirmarSenha;
	}
	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public Telefone getFone() {
		return fone;
	}
	public void setFone(Telefone fone) {
		this.fone = fone;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Usuario> getUsuarios() {
		if (usuarios == null) {
			usuarios = usuarioDAO.listarUsuarios();
		}
		return usuarios;
	}
	public List<Usuario> getListUser() {
		return listUser;
	}
	public void setListUser(List<Usuario> listUser) {
		this.listUser = listUser;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public String novo() {
		return "usuario?faces-redirect=true";
	}
	
	public void limparCampos() {
		this.usuario = null;
	}
	
	public String alterar(Integer id) {
		UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
		setUsuario(usuarioDAO.findUserById(id));
		
		return "alterar";		
	}

	public String logar() {
		FacesContext contex = FacesContext.getCurrentInstance();
		Usuario user = null;
		
		UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();

		if (nome.equals("") && senha.equals("")) {
			contex.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Login e Senha não podem ser vazios!",""));
		} else {
				user = usuarioDAO.findUserByName(nome);
				if (user != null & user.getSenha().equals(senha)) {
					listUser = usuarioDAO.listarUsuarios();
					return "sucesso";

				} else {
					contex.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Senha incorreta!",""));
				}
		}
		return "falha"; 
	}
	
	public String salvar() {
		FacesContext contex = FacesContext.getCurrentInstance();
		ControllerImpl controlador = new ControllerImpl();
			try {
				if(!this.senha.equalsIgnoreCase(this.confirmarSenha)) {
					contex.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario não cadastrado!",""));
					return "usuario";
				}else {
					telefone.add(fone);
					usuario.setTelefone(telefone);
					controlador.salvarUsuario(usuario);
					controlador.salvarTelefone(fone);
				}
			} catch (Exception e) {
				contex.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario não cadastrado!",""));
			}
		return "sucesso";
	}
	
	public String editar(Integer id) {
		FacesContext contex = FacesContext.getCurrentInstance();
		ControllerImpl controlador = new ControllerImpl();
			try {
				telefone.add(fone);
				usuario.setTelefone(telefone);
				controlador.alterarUsuario(usuario);
				controlador.alterarTelefone(fone);
			} catch (Exception e) {
				contex.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario não alterado!",""));
			}
		return "editar";
	}
	
	public String excluir(Integer id) {
		FacesContext context = FacesContext.getCurrentInstance();
		ControllerImpl controlador = new ControllerImpl();

		try {
			controlador.excluirTelefone(id);
			controlador.excluirUsuario(id);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario não excluido!",""));
		}
		return "usuario";
	}

}
