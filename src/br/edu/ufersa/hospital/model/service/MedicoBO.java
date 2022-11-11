package br.edu.ufersa.hospital.model.service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.edu.ufersa.hospital.model.entity.Medico;
import br.edu.ufersa.hospital.model.dao.MedicoDAO;
import br.edu.ufersa.hospital.model.dao.BaseInterDAO;

public class MedicoBO {

    BaseInterDAO<Medico> dao = new MedicoDAO();

	public boolean adicionar(Medico med) {
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

    public boolean atualizar(Medico med) {
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

    public boolean apagar(Medico med) {
        ResultSet rs = dao.encontrar(med);
		try {
			if(rs==null || !(rs.next())) {
				if(dao.excluirPorCPF(med) == true)
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

    public List<Medico> listar() {

        List<Medico> corpoMedico = new ArrayList<Medico>();
        ResultSet rs = dao.exibir();

        try {

            while(rs.next()) {
                Medico med = new Medico();
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