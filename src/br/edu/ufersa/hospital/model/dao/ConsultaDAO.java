package br.edu.ufersa.hospital.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.hospital.model.entity.Consulta;

public class ConsultaDAO extends BaseDAO<Consulta> {
	Consulta vo;
	  public boolean cadastrar(Consulta vo) {
		  conn = getConnection();
		  String sql = "insert into Consulta (idPaciente,idMedico,momento,idProntuario) values (?,?,?,?);";
		  PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,vo.getIdPaciente());
			ps.setInt(2,vo.getIdMedico());
			ps.setDate(3, vo.getMomento()); // Nao existe setDateTime
			ps.setInt(4,vo.getIdProntuario());
			  ps.execute();
			  return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	  }
	  public boolean editar(Consulta vo) {
		  String sql = "UPDATE Consulta SET idPaciente = ?, idMedico = ?, momento = ?, idProntuario = ?  WHERE idConsulta=? ";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setInt(1,vo.getIdPaciente());
				ps.setInt(2,vo.getIdMedico());
				ps.setDate(3, vo.getMomento());
				ps.setInt(4,vo.getIdProntuario());
				ps.setInt(5, vo.getIdConsulta());
				ps.executeUpdate();
				return true;		
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}	
			
	  }
	  
	  public boolean excluirPorID(Consulta vo) {
		  conn = getConnection();
		  String sql = "delete from Consulta where idConsulta = ?;";
		  PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getIdConsulta());
			  ps.execute();
			  return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	  }
	  public Consulta buscarPorMomento(Consulta vo) {
		  String sql = "SELECT * FROM Consulta WHERE momento=? ;";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setDateTime(1, vo.getDiaEHorario()); // setDateTime não existe, depois será resolvido
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					Consulta m = new Consulta();
					m.setIdPaciente(rs.getInt("idPaciente"));
					m.setIdMedico(rs.getInt("idMedico"));
					m.setMomento(rs.getDate("Momento"));
					m.setIdProntuario(rs.getInt("idProntuario"));
					return m;
				}
				else return null;
			
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				return null;
			}
	  }
	  public Consulta buscarPorPaciente(Consulta vo) {
		  String sql = "SELECT * FROM Consulta WHERE idPaciente=? ;";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setIdPaciente(1, vo.getIdPaciente());
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					Consulta m = new Consulta();
					m.setIdPaciente(rs.getInt("idPaciente"));
					m.setIdMedico(rs.getInt("idMedico"));
					m.setMomento(rs.getDateTime("Momento"));
					m.setIdProntuario(rs.getInt("idProntuario"));
					return m;
				}
				else return null;
			
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				return null;
			}
	  }
	  public Consulta buscarPorMedico(Consulta vo) {
		  String sql = "SELECT * FROM Consulta WHERE idMedico=? ;";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setInt(1, vo.getIdMedico());
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					Consulta m = new Consulta();
					m.setIdPaciente(rs.getInt("idPaciente"));
					m.setIdMedico(rs.getInt("idMedico"));
					m.setMomento(rs.getDateTime("Momento"));
					m.setIdProntuario(rs.getInt("idProntuario"));
					return m;
				}
				else return null;
			
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				return null;
			}
	  }
	  
	  public List<Consulta> listar(){
		  conn = getConnection();
		  String sql = "select * from Consulta";
		  Statement st;
		  ResultSet rs;
		  List<Consulta> listaConsulta = new ArrayList<Consulta>();
		  try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Consulta vo = new Consulta();
				vo.setIdPaciente(rs.getInt("idPaciente"));
				vo.setIdMedico(rs.getInt("idMedico"));
				vo.setIdConsulta(rs.getInt("idConsulta"));
				vo.setMomento(rs.getDate("momento"));
				listaConsulta.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return listaConsulta;
	  }
}
