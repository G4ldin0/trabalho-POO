package br.edu.ufersa.hospital.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.edu.ufersa.hospital.model.entity.Adm;

public class AdmDAO extends BaseDAO implements BaseInterDAO<Adm> {

	@Override
	public boolean cadastrar(Adm vo) {
		String sql = "insert into adm (username,senha) values (?,?);";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1,vo.getUsername());
			ps.setString(2,vo.getSenha());
			ps.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}
	}

	@Override
	public boolean editar(Adm vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluirPorId(Adm vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ResultSet encontrar(Adm vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Adm encontrarPorId(Adm vo) {
		return null;
	}

	@Override
	public ResultSet encontrarPorCampoEspecifico(Adm vo, String field) {
		// TODO Auto-generated method stub
		return null;
	}
	public ResultSet encontrarPorUsername(Adm vo) {
		String sql = "SELECT * FROM adm WHERE username=? ;";

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

	@Override
	public ResultSet encontrarPorNome(Adm e) {
		// TODO Auto-generated method stub
		return null;
	}
}
