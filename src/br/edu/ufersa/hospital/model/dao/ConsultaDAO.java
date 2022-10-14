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
		  String sql = "insert into Consulta (Paciente,Medico,diaEHorario,prontuario) values (?,?,?,?);";
		  PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(vo.getID());
			  ps.execute();
			  return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	  }
	  public boolean editar(Medico vo) {
		  String sql = "UPDATE Medico SET cpf=?,nome=?,codigoDoConselho=?,endereco=? WHERE cpf=? ";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setLong(1, vo.getCpf());
				ps.setString(2, vo.getNome() );
				ps.setInt(3, vo.getCodigoDoConselho());
				ps.setString(4, vo.getEndereco());
				ps.setLong(5, vo.getCpf());
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
			ps.setLong(1, vo.getCpf());
			  ps.execute();
			  return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	  }
	  public Medico buscarPorCodigo(Medico vo) {
		  String sql = "SELECT * FROM Medico WHERE id=? ;";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setInt(1, vo.getCodigoDoConselho());
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					Medico m = new Medico();
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
	  public Medico buscarPorCPF(Medico vo) {
		  String sql = "SELECT * FROM Medico WHERE id=? ;";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setLong(1, vo.getCpf());
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					Medico m = new Medico();
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
				vo.setCpf(rs.getLong("cpf"));
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
