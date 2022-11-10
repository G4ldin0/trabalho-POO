package br.edu.ufersa.hospital.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.hospital.model.entity.Medico;

public class MedicoDAO extends BaseDAO<Medico> {
	Medico vo;
	  public boolean cadastrar(Medico vo) {
		  conn = getConnection();
		  String sql = "insert into Medico (nome,cpf,codigoDoConselho,endereco,valorDaConsulta) values (?,?,?,?,?);";
		  PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getNome());
			  ps.setString(2, vo.getCpf());
			  ps.setInt(3, vo.getCodigoDoConselho());
			  ps.setString(4, vo.getEndereco());
			  ps.setDouble(5, vo.getValorDaConsulta());
			  ps.execute();
			  return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	  }
	  public boolean editar(Medico vo) {
		  String sql = "UPDATE Medico SET cpf=?,nome=?,codigoDoConselho=?,endereco=? WHERE idMedico=? ";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, vo.getCpf());
				ps.setString(2, vo.getNome() );
				ps.setInt(3, vo.getCodigoDoConselho());
				ps.setString(4, vo.getEndereco());
				ps.setInt(5, vo.getId());
				ps.executeUpdate();
				return true;		
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}	
	  }
	  
	  public boolean excluirPorCPF(Medico vo) {
		  conn = getConnection();
		  String sql = "delete from Medico where cpf = ?;";
		  PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getCpf());
			  ps.execute();
			  return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	  }
	  public boolean excluirPorId(Medico vo) {
		  conn = getConnection();
		  String sql = "delete from Medico where idMedico = ?;";
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
	  public Medico buscarPorCodigoDoConselho(Medico vo) {
		  String sql = "SELECT * FROM Medico WHERE id=? ;";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setInt(1, vo.getCodigoDoConselho());
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					Medico m = new Medico();
					m.setCpf(rs.getString("cpf"));
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
	  public Medico buscarPorCPF(Medico vo) {
		  String sql = "SELECT * FROM Medico WHERE id=? ;";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, vo.getCpf());
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					Medico m = new Medico();
					m.setCpf(rs.getString("cpf"));
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
	  public List<Medico> listar(){
		  conn = getConnection();
		  String sql = "select * from Medico";
		  Statement st;
		  ResultSet rs;
		  List<Medico> listaMedico = new ArrayList<Medico>();
		  try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Medico vo = new Medico();
				vo.setCpf(rs.getString("cpf"));
				vo.setNome(rs.getString("nome"));
				vo.setCodigoDoConselho(rs.getInt("codigoDoConselho"));
				vo.setEndereco(rs.getString("endereco"));
				vo.setValorDaConsulta(rs.getDouble("valorDaConsulta"));
				listaMedico.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return listaMedico;
	  }
}
