package br.edu.ufersa.hospital.model.service;
import br.edu.ufersa.hospital.model.entity.Paciente;
import br.edu.ufersa.hospital.model.dao.PacienteDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.hospital.api.dto.PacienteDTO;
import br.edu.ufersa.hospital.model.dao.BaseInterDAO;

public class PacienteBO {
    
    BaseInterDAO<Paciente> dao = new PacienteDAO();
    
    public boolean adicionar(PacienteDTO pacDTO) {
        
        Paciente pac = Paciente.converter(pacDTO);
        
        ResultSet rs = dao.encontrar(pac);
        try {
            if(rs==null || !(rs.next())) {
                if(dao.cadastrar(pac) == true)
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
    
    public void Alterar(Paciente alteracao){
    alteracao.setNome(alteracao.getNome());
    alteracao.setEndereco(alteracao.getEndereco());
    alteracao.setCpf(alteracao.getCpf());
    }
    public static void Cadastrar(){}
    public static void Excluir(){}
 
 public static Paciente buscarPorNome(Paciente busca){ return null;}
 public static Paciente buscarPorCpf(Paciente busca){ return null;}
}
