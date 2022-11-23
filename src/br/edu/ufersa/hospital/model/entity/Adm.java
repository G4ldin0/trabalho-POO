package br.edu.ufersa.hospital.model.entity;

import br.edu.ufersa.hospital.api.dto.AdmDTO;

public class Adm extends Conta {
	public Adm(Adm admin) {
		this.username = admin.getUsername();
		this.senha = admin.getSenha();
	}
	public Adm() {
		this.username = null;
		this.senha = null;
	}
	public Adm(String username, String senha) {
		setUsername(username);
		setSenha(senha);
		}
	 public static Adm converter(AdmDTO dto) {
	        Adm admin = new Adm();
	        admin.setUsername(dto.getUsername());
	        admin.setSenha(dto.getSenha());
	        admin.setConfirmSenha(dto.getConfirmSenha());
	        return admin;
	    }
}
