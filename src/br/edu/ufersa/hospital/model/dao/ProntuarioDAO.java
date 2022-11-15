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
public class ProntuarioDAO extends BaseDAO implements BaseInterDAO<Prontuario> {

	@Override
  	public boolean cadastrar(Prontuario vo) {
	  String sql = "INSERT INTO Prontuario (momento,obs,idPaciente) VALUES (?,?,?);";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setDate(1, Date.valueOf(vo.getData()));
			ps.setString(2, vo.getObs());
			ps.setInt(3, vo.getPaciente().getId());
			
			return ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}
  	}

	@Override
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
			e.printStackTrace();

			return false;
		}	
 	}
  
	@Override
 	public boolean excluirPorId(Prontuario vo) {
		String sql = "DELETE FROM Prontuario WHERE idProntuario = ?;";

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
		String sql = "SELECT * FROM prontuario;";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);

			return ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();

			return null;
		}
	}

  public ResultSet buscarPorPaciente(Prontuario vo) {
	  String sql = "SELECT * FROM Prontuario WHERE idPaciente=? ;";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, vo.getPaciente().getId());

			return ps.executeQuery();

		} catch (SQLException ex) {
			ex.printStackTrace();

			return null;
		}
  }
}
