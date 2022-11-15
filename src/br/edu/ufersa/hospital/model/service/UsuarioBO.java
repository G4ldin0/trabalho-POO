package br.edu.ufersa.hospital.model.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.hospital.Exception.AutenticationException;
import br.edu.ufersa.hospital.api.dto.UsuarioDTO;
import br.edu.ufersa.hospital.model.dao.UsuarioDAO;
import br.edu.ufersa.hospital.model.entity.Usuario;

public class UsuarioBO {
	
	UsuarioDAO dao = new UsuarioDAO();
public boolean adicionar(UsuarioDTO userDTO) {
	    
	    Usuario user = Usuario.converter(userDTO);
      
		ResultSet rs = dao.encontrar(user);
		try {
			if(rs==null || !(rs.next())) {
				if(dao.cadastrar(user) == true)
					return true;
					else return false;
			}
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	} 
public Usuario autenticar(Usuario vo) throws AutenticationException{
	ResultSet rs =  dao.encontrarPorUsername(vo);
	try {
		if(rs.next()) {
			if(rs.getString("senha").equals(vo.getSenha()) && rs.getString("username").equals(vo.getUsername())) {
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
