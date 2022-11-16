package br.edu.ufersa.hospital.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.edu.ufersa.hospital.model.entity.Usuario;

public class UsuarioDAO extends BaseDAO implements BaseInterDAO<Usuario> {

	@Override
	public boolean cadastrar(Usuario vo) {
		String sql = "insert into conta (username,senha) values (?,?);";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1,vo.getUsername());
			ps.setString(2,vo.getSenha());
			return ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}
	}

	@Override
	public boolean editar(Usuario vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluirPorId(Usuario vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet exibir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet encontrar(Usuario vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario encontrarPorId(Usuario vo) {
		return null;
	}

	@Override
	public ResultSet encontrarPorCampoEspecifico(Usuario vo, String field) {
		// TODO Auto-generated method stub
		return null;
	}
	public ResultSet encontrarPorUsername(Usuario vo) {
		String sql = "SELECT * FROM conta WHERE username=? ;";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, vo.getUsername());

            ResultSet rs = ps.executeQuery();
            return rs;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}