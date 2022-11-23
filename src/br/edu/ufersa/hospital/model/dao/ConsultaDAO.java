package br.edu.ufersa.hospital.model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import br.edu.ufersa.hospital.model.entity.Consulta;
import br.edu.ufersa.hospital.model.entity.Medico;
import br.edu.ufersa.hospital.model.entity.Paciente;

public class ConsultaDAO extends BaseDAO implements BaseInterDAO<Consulta>{

	@Override
	public boolean cadastrar(Consulta vo) {
		String sql = "insert into Consulta (idPaciente, idMedico, idProntuario, dia, horario) values (?,?,?,?,?);";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1,vo.getPaciente().getId());
			ps.setInt(2,vo.getMedico().getId());
			ps.setInt(3,vo.getProntuario().getId());
			ps.setDate(3, Date.valueOf(vo.getData()));
			ps.setTime(4,Time.valueOf(vo.getHorario()));
			ps.execute();
			return true;

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

			ResultSet rs = st.executeQuery(sql);
			return rs;

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

	public Consulta buscarPorMedico(Medico vo) { //O OBJETO COMPLETO OU APENAS UM FIELD?
		String sql = "SELECT * FROM Consulta WHERE idMedico=? ;";
		Consulta result = new Consulta();

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, vo.getId());
			ResultSet rs = ps.executeQuery();
			
			result.setId(rs.getInt("idConsulta"));
			//TODO


			return result;
		
		} catch (SQLException ex) {
			ex.printStackTrace();

			return null;
		}
	}

	@Override
	public ResultSet encontrar(Consulta e) {
		// TODO Auto-generated method stub
		return null;
	}
	public Consulta BuscarPorId(Consulta e) {
		String sql = "SELECT * FROM Consulta WHERE id=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, e.getId());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Consulta a = new Consulta();
				MedicoDAO dao1 = new MedicoDAO();
				PacienteDAO dao2 = new PacienteDAO();
				a.setHorario(LocalTime.parse(rs.getTime("horario").toString()));
				a.setData(LocalDate.parse(rs.getDate("dia").toString()));
				a.getMedico().setId(rs.getInt("idMedico"));
				a.setMedico(dao1.encontrarPorId(a.getMedico()));
				a.getPaciente().setId(rs.getInt("idPaciente"));
				a.setPaciente(dao2.encontrarPorId(a.getPaciente()));
				a.setId(e.getId());
				return a;
			}
			else return null;
		
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return null;
		}
	}
	public ResultSet BuscarPorCampoEspecifico(Consulta e, String field) {
		String sql = "SELECT * FROM Consulta WHERE " + field +"=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "dia":
				pst.setDate(1, Date.valueOf(e.getHorario().toString()));
				break;
				
			case "horario":
				pst.setTime(1, Time.valueOf(e.getData().toString()));
				break;
				
			case "idPaciente":
				pst.setInt(1, e.getPaciente().getId());
				break;
				
			case "idMedico":
				pst.setInt(1, e.getMedico().getId());
				break;
			
			default: 
				pst.setInt(1, e.getId()); // id da consulta
			}
			
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Consulta encontrarPorId(Consulta e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet encontrarPorCampoEspecifico(Consulta e, String field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet encontrarPorNome(Consulta e) {
		// TODO Auto-generated method stub
		return null;
	}
}
