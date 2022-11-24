package br.edu.ufersa.hospital.model.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.hospital.Exception.AutenticationException;
import br.edu.ufersa.hospital.Exception.PasswordErrorException;
import br.edu.ufersa.hospital.api.dto.AdmDTO;
import br.edu.ufersa.hospital.model.dao.AdmDAO;
import br.edu.ufersa.hospital.model.entity.Adm;

public class AdmBO {
	
	AdmDAO dao = new AdmDAO();
public Adm adicionar(AdmDTO admDTO) throws PasswordErrorException {
	    
	    Adm admin = Adm.converter(admDTO);
      
		ResultSet rs = dao.encontrarPorUsername(admin);
		try {
			if(rs==null || !(rs.next())) {
				if(dao.cadastrar(admin) == true)
					return admin;
					else throw new PasswordErrorException();
			}
			else throw new PasswordErrorException();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new PasswordErrorException();
		}	
	} 
public Adm autenticar(Adm vo) throws AutenticationException{
	ResultSet rs =  dao.encontrarPorUsername(vo);
	try {
		if(rs.next()) {
			if(rs.getString("senha").equals(vo.getSenha())) {
				return vo;
			}
			else throw new AutenticationException();
		}
		else throw new AutenticationException();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new AutenticationException();
	}
}
}
