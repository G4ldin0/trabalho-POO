package br.edu.ufersa.hospital.model.entity;

import br.edu.ufersa.hospital.api.dto.UsuarioDTO;

public class Usuario {
	private String username;
	private String senha;
	
	public Usuario(Usuario user) {
		this.username = user.getUsername();
		this.senha = user.getSenha();
	}
	public Usuario() {
		this.username = null;
		this.senha = null;
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
	        return user;
	    }
}
