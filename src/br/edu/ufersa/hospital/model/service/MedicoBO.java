package br.edu.ufersa.hospital.model.service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.edu.ufersa.hospital.model.entity.Medico;
import br.edu.ufersa.hospital.model.dao.MedicoDAO;
import br.edu.ufersa.hospital.model.dao.BaseInterDAO;

public class MedicoBO {

    /*  IBaseInterDAO<Medico> dao = new MedicoDAO();
	public boolean adicionar(Medico med) {
		ResultSet rs = dao.funcaoPChamar
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
	} */

public void cadastrar(Medico med){ // Melhorar cadastrar() com a implementação do banco de dados
    med.setNome(med.getNome()); // Esses sets provavelmente vão pro BD
    med.setCpf(med.getCpf());
    med.setCodigoDoConselho(med.getCodigoDoConselho());
    med.setEndereco(med.getEndereco());
    med.setValorDaConsulta(med.getValorDaConsulta());
}

public void editar(Medico med){
    med.setNome(med.getNome());
    med.setCpf(med.getCpf());
    med.setCodigoDoConselho(med.getCodigoDoConselho());
    med.setEndereco(med.getEndereco());
    med.setValorDaConsulta(med.getValorDaConsulta());
}

public void excluir(Medico med){
    med = null;
}

public Medico buscarPorCodigo(Medico med){ // "Medico med" vai ter o med.buscar == codConselho ou cpf buscado
    //if (this.codigoDoConselho == med.codigoDoConselho){
    //    return Medico.this; // Retorna a própria classe
    //} else return med; // Alterar esse else?
    return med;
}

public Medico buscarPorCpf(Medico med){ // "Medico med" vai ter o med.buscar == codConselho ou cpf buscado
    //if (this.cpf == med.cpf){
    //  return Medico.this; // Retorna a própria classe
    //} else return med; // Alterar esse else
    return med;
}

}
