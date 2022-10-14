package br.edu.ufersa.hospital.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.hospital.model.entity.Paciente;
import br.edu.ufersa.hospital.model.entity.Prontuario;

public class ProntuarioDAO extends BaseDAO<Prontuario> {
  Prontuario vo;
  public boolean cadastrar(Prontuario vo) {
	  conn = getConnection();
	  String sql = "insert into Prontuario (momento,obs,idPaciente) values (?,?,?);";
	  PreparedStatement ps;
	try {
		ps = conn.prepareStatement(sql);
		ps.setDateTime(1, vo.getMomento());
		  ps.setString(2, vo.getObs());
		  ps.setInt(3, vo.getIdPaciente());
		  ps.execute();
		  return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
  }
  public boolean editar(Prontuario vo) {
	  String sql = "UPDATE Prontuario SET momento = ?, obs = ?, idPaciente = ? WHERE idProntuario=? ";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setDateTime(1, vo.getMomento());
			ps.setString(2, vo.getObs());
			ps.setInt(3, vo.getIdPaciente());
			ps.setInt(4, vo.getIdProntuario());
			ps.executeUpdate();
			return true;		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
  }
  
  public boolean excluirPorCPF(Prontuario vo) {
	  conn = getConnection();
	  String sql = "delete from Medico where idProntuario = ?;";
	  PreparedStatement ps;
	try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1, vo.getIdProntuario());
		  ps.execute();
		  return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
  }
  public Prontuario buscarPorPaciente(Prontuario vo) {
	  String sql = "SELECT * FROM Prontuario WHERE idPaciente=? ;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, vo.getIdPaciente());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Prontuario m = new Prontuario();
				m.setMomento(rs.getDateTime("momento"));
				m.setObs(rs.getString("obs"));
				m.setIdPaciente(rs.getInt("idPaciente"));
				return m;
			}
			else return null;
		
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return null;
		}
  }
}
