package br.edu.ufersa.hospital.model.service;
import br.edu.ufersa.hospital.model.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.hospital.api.dto.ConsultaDTO;
import br.edu.ufersa.hospital.model.dao.*;

public class ConsultaBO {
  
    BaseInterDAO<Consulta> dao = new ConsultaDAO();

    public boolean adicionar(ConsultaDTO consDTO) {
        
        Consulta cons = Consulta.converter(consDTO);
      
        ResultSet rs = dao.encontrar(cons);
        try {
            if(rs==null || !(rs.next())) {
                if(dao.cadastrar(cons) == true)
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
    
    public boolean atualizar(ConsultaDTO consDTO) {
        
        Consulta cons = Consulta.converter(consDTO);
        
        ResultSet rs = dao.encontrar(cons);
        try {
            if(rs==null || !(rs.next())) {
                if(dao.editar(cons) == true)
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
    
    public boolean apagar(ConsultaDTO consDTO) {   // o apagar vai vir do DTO?
        
        Consulta cons = Consulta.converter(consDTO);
        
        ResultSet rs = dao.encontrar(cons);
        try {
            if(rs==null || !(rs.next())) {
                if(dao.excluirPorId(cons) == true)
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
    
    public List<ConsultaDTO> listar() {

        List<ConsultaDTO> listaConsultas = new ArrayList<ConsultaDTO>();
        ResultSet rs = dao.exibir();

        try {

            while(rs.next()) {
                ConsultaDTO cons = new ConsultaDTO();
                cons.getPaciente().setId(rs.getInt("idPaciente"));
                cons.getMedico().setId(rs.getInt("idMedico"));
                cons.getProntuario().setId(rs.getInt("idProntuario"));
                cons.setId(rs.getInt("idConsulta"));
                cons.setData(rs.getDate("momento")); // ajeitar isso aqui

                listaConsultas.add(cons);
            }
            return listaConsultas;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

}
