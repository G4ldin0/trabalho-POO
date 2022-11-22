package br.edu.ufersa.hospital.model.entity;

import br.edu.ufersa.hospital.api.dto.UsuarioDTO;

public class Usuario {
	private String username;
	private String senha;
	private String confirmSenha;
	public Usuario(Usuario user) {
		this.username = user.getUsername();
		this.senha = user.getSenha();
	}
	public Usuario() {
		this.username = null;
		this.senha = null;
	}
	public Usuario(String username, String senha) {
		setUsername(username);
		setSenha(senha);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	 public static Usuario converter(UsuarioDTO dto) {
	        Usuario user = new Usuario();
	        user.setUsername(dto.getUsername());
	        user.setSenha(dto.getSenha());
	        user.setConfirmSenha(dto.getConfirmSenha());
	        return user;
	    }
	public String getConfirmSenha() {
		return confirmSenha;
	}
	public void setConfirmSenha(String confirmSenha) {
		this.confirmSenha = confirmSenha;
	}
}
