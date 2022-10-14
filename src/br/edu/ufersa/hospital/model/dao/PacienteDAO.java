package br.edu.ufersa.hospital.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.hospital.model.entity.Paciente;

public class PacienteDAO extends BaseDAO<Paciente> {
	Paciente vo;
	  public boolean cadastrar(Paciente vo) {
		  conn = getConnection();
		  String sql = "insert into Paciente (nome,cpf,endereco) values (?,?,?);";
		  PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getNome());
			ps.setLong(2, vo.getCpf());
			ps.setString(3, vo.getEndereco());
			ps.execute();
			  return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	  }
	  public boolean editarPorID(Paciente vo) {
		  String sql = "UPDATE Paciente SET cpf=?,nome=?,endereco=? WHERE idPaciente=? ";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setLong(1, vo.getCpf());
				ps.setString(2, vo.getNome());
				ps.setString(3, vo.getEndereco());
				ps.setInt(4, vo.getIdConsulta());
				ps.executeUpdate();
				return true;		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}	
			
	  }
	  public boolean editarPorCpf(Paciente vo) {
		  String sql = "UPDATE Paciente SET cpf=?,nome=?,endereco=? WHERE cpf=? ";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setLong(1, vo.getCpf());
				ps.setString(2, vo.getNome());
				ps.setString(3, vo.getEndereco());
				ps.setLong(4, vo.getCpf());
				ps.executeUpdate();
				return true;		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}	
			
	  }
	  
	  public boolean excluirPorCPF(Paciente vo) {
		  conn = getConnection();
		  String sql = "delete from Paciente where cpf = ?;";
		  PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, vo.getCpf());
			  ps.execute();
			  return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	  }
	  public boolean excluirPorId(Paciente vo) {
		  conn = getConnection();
		  String sql = "delete from Paciente where idPaciente = ?;";
		  PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getIdPaciente());
			  ps.execute();
			  return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	  }
	  public Paciente buscarPorCPF(Paciente vo) {
		  String sql = "SELECT * FROM Paciente WHERE cpf=? ;";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setLong(1, vo.getCpf());
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					Paciente m = new Paciente();
					m.setCpf(rs.getLong("cpf"));
					m.setEndereco(rs.getString("endereco"));
					m.setNome(rs.getString("nome"));
					return m;
				}
				else return null;
			
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				return null;
			}
	  }
	  public Paciente buscarPorId(Paciente vo) {
		  String sql = "SELECT * FROM Medico WHERE idPaciente=? ;"; // 3  idPaciente = 3
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setInt(1, vo.getIdPaciente());
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					Paciente m = new Paciente();
					m.setCpf(rs.getLong("cpf"));
					m.setEndereco(rs.getString("endereco"));
					m.setNome(rs.getString("nome"));
					return m;
				}
				else return null;
			
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				return null;
			}
	  }
	  public List<Paciente> listar(){
		  conn = getConnection();
		  String sql = "select * from Paciente";
		  Statement st;
		  ResultSet rs;
		  List<Paciente> listaPaciente = new ArrayList<Paciente>();
		  try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Paciente vo = new Paciente();
				vo.setCpf(rs.getLong("cpf"));
				vo.setNome(rs.getString("nome"));
				vo.setEndereco(rs.getString("endereco"));
				vo.setProntuarios(rs.getDouble("prontuario")); //arrumar
				listaPaciente.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return listaPaciente;
	  }
}
