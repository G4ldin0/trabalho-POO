package br.edu.ufersa.hospital.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.hospital.model.entity.Medico;

public class MedicoDAO extends BaseDAO implements BaseInterDAO<Medico> {

	@Override
	public boolean cadastrar(Medico vo) {
		String sql = "insert into Medico (nome, endereco, cpf, idMedico, codConselho, valorConsulta) values (?,?,?,?,?,?);";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, vo.getNome());
			ps.setString(2, vo.getEndereco());
			ps.setString(3, vo.getCpf());
			ps.setInt(4, vo.getId());
			ps.setInt(5, vo.getCodigoDoConselho());
			ps.setDouble(6, vo.getValorDaConsulta());
			
			return ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();

			return false;

		}
	}

	@Override
	public boolean editar(Medico vo) {
		String sql = "UPDATE Medico SET nome=?,endereco=?cpf=?,codConselho=?,ValorConsulta=?, WHERE idMedico=? ";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, vo.getNome() );
			ps.setString(2, vo.getEndereco());
			ps.setString(3, vo.getCpf());
			ps.setInt(4, vo.getCodigoDoConselho());
			ps.setDouble(5, vo.getValorDaConsulta());
			ps.setInt(6, vo.getId());
			ps.executeUpdate();

			return true;		
		
		} catch (SQLException e) {
			e.printStackTrace();

			return false;

		}	
	}
	
	@Override
	public ResultSet listar() {
		String sql = "SELECT * FROM Medico;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);

			return pst.executeQuery();

		} catch (SQLException ex) {
			ex.printStackTrace();

			return null;
			
		}
	}

	@Override
	public boolean excluirPorId(Medico vo) {
		String sql = "delete from Medico where idMedico = ?;";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, vo.getId());

			return ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();

			return false;

		}
	}
	
	public boolean excluirPorCPF(Medico vo) {
		String sql = "delete from Medico where cpf = ?;";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, vo.getCpf());

			return ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();

			return false;

		}
	}

	  public Medico encontrarPorCodigoDoConselho(Medico vo) {
		  String sql = "SELECT * FROM Medico WHERE id=? ;";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setInt(1, vo.getCodigoDoConselho());
				ResultSet rs = ps.executeQuery();
				
				return new Medico(rs.getInt("idMedico"), rs.getString("nome"), rs.getString("cpf"), rs.getString("endereco"), rs.getInt("codConselho"), rs.getDouble("valorConsulta"));
	
			} catch (SQLException ex) {
				ex.printStackTrace();

				return null;

			}
	  }

	public Medico encontrarPorCPF(Medico vo){
		String sql = "SELECT * FROM Medico WHERE cpf=? ;";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, vo.getCpf());
			
			ResultSet rs = ps.executeQuery();

			return new Medico(rs.getInt("idMedico"), rs.getString("nome"), rs.getString("cpf"), rs.getString("endereco"), rs.getInt("codConselho"), rs.getDouble("valorConsulta"));

		} catch(SQLException ex) {
			ex.printStackTrace();

			return null;

		}
	}
	
	public ResultSet encontrar(Medico vo){
        String sql = "SELECT * FROM Medico WHERE cpf=? ;";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, vo.getCpf());

            ResultSet rs = ps.executeQuery();
            return rs;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
	public Medico encontrarPorId(Medico e) {
		String sql = "SELECT * FROM Medico WHERE id=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, e.getId());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Medico a = new Medico();
				a.setCpf(rs.getString("cpf"));
				a.setEndereco(rs.getString("endereco"));
				a.setNome(rs.getString("nome"));
				a.setCodigoDoConselho(rs.getInt("codigoDoConselho"));
				a.setValorDaConsulta(rs.getDouble("valorDaConsulta"));
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
    @Override
    public ResultSet exibir() {
        String sql = "SELECT * FROM Medico;";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
            return null;
        }
    }

	@Override
	public ResultSet encontrarPorCampoEspecifico(Medico e, String field) {
		// TODO Auto-generated method stub
		return null;
	}

}
