package br.edu.ufersa.hospital.model.service;
import br.edu.ufersa.hospital.model.entity.Paciente;
import br.edu.ufersa.hospital.model.dao.PacienteDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    public boolean atualizar(PacienteDTO pacDTO) {
        
        Paciente pac = Paciente.converter(pacDTO);
        
        ResultSet rs = dao.encontrar(pac);
        try {
            if(rs==null || !(rs.next())) {
                if(dao.editar(pac) == true)
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

    public boolean apagar(PacienteDTO pacDTO) {   // o apagar vai vir do DTO?
    
        Paciente pac = Paciente.converter(pacDTO);
    
        ResultSet rs = dao.encontrar(pac);
        try {
            if(rs==null || !(rs.next())) {
                if(dao.excluirPorId(pac) == true)
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
    
    public List<Paciente> listar() {

        List<Paciente> pacientes = new ArrayList<Paciente>();
        ResultSet rs = dao.exibir();

        try {

            while(rs.next()) {
                Paciente pac = new Paciente();
                pac.setId(rs.getInt("idMedico"));
                pac.setNome(rs.getString("nome"));
                pac.setCpf(rs.getString("cpf"));
                pac.setEndereco(rs.getString("endereco"));

                pacientes.add(pac);
            }
            return pacientes;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

}
