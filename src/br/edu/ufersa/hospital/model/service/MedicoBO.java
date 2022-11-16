package br.edu.ufersa.hospital.model.service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.edu.ufersa.hospital.model.entity.Medico;
import br.edu.ufersa.hospital.model.dao.MedicoDAO;
import br.edu.ufersa.hospital.api.dto.MedicoDTO;
import br.edu.ufersa.hospital.model.dao.BaseInterDAO;

public class MedicoBO {

    BaseInterDAO<Medico> dao = new MedicoDAO();

	public boolean adicionar(MedicoDTO medDTO) {
	    
	    Medico med = Medico.converter(medDTO);
      
		ResultSet rs = dao.encontrar(med);
		try {
			if(rs==null || !(rs.next())) {
				if(dao.cadastrar(med) == true)
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

    public boolean atualizar(MedicoDTO medDTO) {
        
        Medico med = Medico.converter(medDTO);
        
        ResultSet rs = dao.encontrar(med);
		try {
			if(rs==null || !(rs.next())) {
				if(dao.editar(med) == true)
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

    public boolean apagar(MedicoDTO medDTO) {   // o apagar vai vir do DTO?
        
        Medico med = Medico.converter(medDTO);
        
        ResultSet rs = dao.encontrar(med);
		try {
			if(rs==null || !(rs.next())) {
				if(dao.excluirPorId(med) == true)
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

    public List<MedicoDTO> listar() {

        List<MedicoDTO> corpoMedico = new ArrayList<MedicoDTO>();
        ResultSet rs = dao.exibir();

        try {

            while(rs.next()) {
                MedicoDTO med = new MedicoDTO();
                med.setId(rs.getInt("idMedico"));
                med.setNome(rs.getString("nome"));
                med.setCpf(rs.getString("cpf"));
                med.setCodigoDoConselho(rs.getInt("codConselho"));
                med.setEndereco(rs.getString("endereco"));
                med.setValorDaConsulta(rs.getDouble("valorConsulta"));

                corpoMedico.add(med);
            }
            return corpoMedico;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
    
    public List<MedicoDTO> listarPorCpf(MedicoDTO medDTO) {

        List<MedicoDTO> corpoMedico = new ArrayList<MedicoDTO>();
        Medico medico = Medico.converter(medDTO);
        ResultSet rs = dao.encontrar(medico);

        try {

            while(rs.next()) {
                MedicoDTO med = new MedicoDTO();
                med.setId(rs.getInt("idMedico"));
                med.setNome(rs.getString("nome"));
                med.setCpf(rs.getString("cpf"));
                med.setCodigoDoConselho(rs.getInt("codConselho"));
                med.setEndereco(rs.getString("endereco"));
                med.setValorDaConsulta(rs.getDouble("valorConsulta"));

                corpoMedico.add(med);
            }
            return corpoMedico;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }

}