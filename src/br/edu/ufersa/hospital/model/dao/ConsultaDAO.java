package br.edu.ufersa.hospital.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;

import br.edu.ufersa.hospital.model.entity.Consulta;

public class ConsultaDAO extends BaseDAO<Consulta> {
	Consulta vo;
	  public boolean cadastrar(Consulta vo) {
		  conn = getConnection();
		  String sql = "insert into Consulta (idPaciente,idMedico,dia,horario,idProntuario) values (?,?,?,?,?);";
		  PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,vo.getPaciente().getId());
			ps.setInt(2,vo.getMedico().getId());
			Date data = Date.valueOf(vo.getData());
			ps.setDate(3, data);
			Time horario = Time.valueOf(vo.getHorario());
			ps.setTime(4,horario);
			ps.setInt(5,vo.getProntuario().getId());
			  ps.execute();
			  return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	  }
	  public boolean editar(Consulta vo) {
		  String sql = "UPDATE Consulta SET idPaciente = ?, idMedico = ?, dia = ?, horario = ?, idProntuario = ?  WHERE idConsulta=? ";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setInt(1,vo.getPaciente().getId());
				ps.setInt(2,vo.getMedico().getId());
				Date data = Date.valueOf(vo.getData());
				ps.setDate(3, data);
				Time horario = Time.valueOf(vo.getHorario());
				ps.setTime(4,horario);
				ps.setInt(5,vo.getProntuario().getId());
				ps.setInt(6, vo.getId());
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
			ps.setInt(1, vo.getId());
			  ps.execute();
			  return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	  }
	  public Consulta buscarPorMomento(Consulta vo) {
		  String sql = "SELECT * FROM Consulta WHERE Momento=? ;";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				Date data = Date.valueOf(vo.getData());
				ps.setDate(1,data);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					Consulta m = new Consulta();
					m.getPaciente().setId(rs.getInt("idPaciente"));
					m.getMedico().setId(rs.getInt("idMedico"));
					LocalDate data1 = LocalDate.parse(rs.getDate("Momento").toString());
					m.setData(data1);
					m.getProntuario().setId(rs.getInt("idProntuario"));
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
				ps.setInt(1, vo.getPaciente().getId());
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					Consulta m = new Consulta();
					m.getPaciente().setId(rs.getInt("idPaciente"));
					m.getMedico().setId(rs.getInt("idMedico"));
					LocalDate data1 = LocalDate.parse(rs.getDate("Momento").toString());
					m.setData(data1);
					m.getProntuario().setId(rs.getInt("idProntuario"));
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
				ps.setInt(1, vo.getMedico().getId());
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					Consulta m = new Consulta();
					m.getPaciente().setId(rs.getInt("idPaciente"));
					m.getMedico().setId(rs.getInt("idMedico"));
					LocalDate data1 = LocalDate.parse(rs.getDate("Momento").toString());
					m.setData(data1);
					m.getProntuario().setId(rs.getInt("idProntuario"));
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
				vo.getPaciente().setId(rs.getInt("idPaciente"));
				vo.getMedico().setId(rs.getInt("idMedico"));
				LocalDate data1 = LocalDate.parse(rs.getDate("Momento").toString());
				vo.setData(data1);
				vo.getProntuario().setId(rs.getInt("idProntuario"));
				listaConsulta.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return listaConsulta;
	  }
}
