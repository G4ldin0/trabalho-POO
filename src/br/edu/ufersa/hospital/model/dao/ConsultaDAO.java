package br.edu.ufersa.hospital.model.dao;

import java.sql.PreparedStatement;

import br.edu.ufersa.hospital.model.entity.Consulta;

public class ConsultaDAO extends BaseDAO {
  Consulta vo;
  public void adicionar(Consulta vo) {
	  conn = getConnection();
	  String sql = "insert into Consulta (Paciente,Medico,diaEHorario,Prontuario) values (?,?,?,?)";
	  PreparedStatement ps = conn.prepareStatement(sql);
	  ps.setString(1, vo.paciente.getNome());
	  ps.setString(2, vo.getMedico());
	  ps.setString(3, vo.getDiaEHorario());
	  ps.setString(4, vo.getProntuario());
  }
}
