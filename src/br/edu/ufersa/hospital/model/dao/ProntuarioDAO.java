package br.edu.ufersa.hospital.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import br.edu.ufersa.hospital.model.entity.Paciente;
import br.edu.ufersa.hospital.model.entity.Prontuario;

@SuppressWarnings("unused")
public class ProntuarioDAO extends BaseDAO<Prontuario> {
  Prontuario vo;
  public boolean cadastrar(Prontuario vo) {
	  conn = getConnection();
	  String sql = "insert into Prontuario (momento,obs,idPaciente) values (?,?,?);";
	  PreparedStatement ps;
	try {
		ps = conn.prepareStatement(sql);
		Date.valueOf(vo.getData());
		ps.setDate(1, Date.valueOf(vo.getData()));
		ps.setString(2, vo.getObs());
		ps.setInt(3, vo.getId());
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
			ps.setDate(1, Date.valueOf(vo.getData()));
			ps.setString(2, vo.getObs());
			ps.setInt(3, vo.getPaciente().getId());
			ps.setInt(4, vo.getId());
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
		ps.setInt(1, vo.getId());
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
			ps.setInt(1, vo.getPaciente().getId());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Prontuario m = new Prontuario();
				m.setData(LocalDate.parse(rs.getDate("momento").toString()));
				m.setObs(rs.getString("obs"));
				m.getPaciente().setId(rs.getInt("idPaciente"));
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
