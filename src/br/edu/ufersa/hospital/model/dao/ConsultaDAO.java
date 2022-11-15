package br.edu.ufersa.hospital.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import br.edu.ufersa.hospital.model.entity.Consulta;
import br.edu.ufersa.hospital.model.entity.Medico;
import br.edu.ufersa.hospital.model.entity.Paciente;

public class ConsultaDAO extends BaseDAO implements BaseInterDAO<Consulta>{

	@Override
	public boolean cadastrar(Consulta vo) {
		String sql = "insert into Consulta (idPaciente, idMedico, idProntuario, idConsulta) values (?,?,?,?);";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1,vo.getPaciente().getId());
			ps.setInt(2,vo.getMedico().getId());
			ps.setInt(3,vo.getProntuario().getId());
			ps.setInt(4, vo.getId());

			return ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}
	}

	@Override
	public boolean editar(Consulta vo) {
		String sql = "UPDATE Consulta SET idPaciente = ?, idMedico = ?, idProntuario = ?  WHERE idConsulta=? ";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1,vo.getPaciente().getId());
			ps.setInt(2,vo.getMedico().getId());
			ps.setInt(3,vo.getProntuario().getId());
			ps.setInt(4, vo.getId());
			ps.executeUpdate();

			return true;
		
		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}	
	}
	
	@Override
	public boolean excluirPorId(Consulta vo) {
		String sql = "delete from Consulta where idConsulta = ?;";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, vo.getId());

			return ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}
	}
	
	@Override
	public ResultSet listar(){
		String sql = "select * from Consulta";
		
		try {
			Statement st = getConnection().createStatement();

			return st.executeQuery(sql);

		} catch (SQLException e) {
			e.printStackTrace();

			return null;

		}
	}

	
	// public Consulta buscarPorMomento(Consulta vo) {
	// 	String sql = "SELECT * FROM Consulta WHERE Momento=? ;";

	// 	try {
	// 		PreparedStatement ps = getConnection().prepareStatement(sql);
	// 		Date data = Date.valueOf(vo.getData());
	// 		ps.setDate(1,data);
	// 		ResultSet rs = ps.executeQuery();
			
	// 		if(rs.next()) {
	// 			Consulta m = new Consulta();
	// 			m.getPaciente().setId(rs.getInt("idPaciente"));
	// 			m.getMedico().setId(rs.getInt("idMedico"));
	// 			LocalDate data1 = LocalDate.parse(rs.getDate("Momento").toString());
	// 			m.setData(data1);
	// 			m.getProntuario().setId(rs.getInt("idProntuario"));
	// 			return m;
	// 		}
	// 		else return null;

	// 	} catch (SQLException ex) {
	// 		// TODO Auto-generated catch block
	// 		ex.printStackTrace();
	// 		return null;
	// 	}
	// }

	public Consulta buscarPorPaciente(Paciente vo) {
		String sql = "SELECT * FROM Consulta WHERE idPaciente=? ;";
		Consulta result = new Consulta();

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, vo.getId());
			ResultSet rs = ps.executeQuery();
			
			result.setId(rs.getInt("idConsulta"));
			//TO DO

			return result;
		
		} catch (SQLException ex) {
			ex.printStackTrace();

			return null;
		}
	}

	public Consulta buscarPorMedico(Consulta vo) { //O OBJETO COMPLETO OU APENAS UM FIELD?
		String sql = "SELECT * FROM Consulta WHERE idMedico=? ;";
		Consulta result = new Consulta();

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, vo.getMedico().getId());
			ResultSet rs = ps.executeQuery();
			
			result.setId(rs.getInt("idConsulta"));
			//TODO


			return result;
		
		} catch (SQLException ex) {
			ex.printStackTrace();

			return null;
		}
	}
}
