package br.edu.ufersa.hospital.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;

public interface BaseInterDAO<entity> {
	public Connection getConnection();
	public boolean cadastrar (entity e);
	public boolean excluirPorCPF(entity e);
	public boolean excluirPorId(entity e);
	public boolean editar(entity e);
	public entity buscarPorCPF(entity e);
	public ResultSet encontrar(entity e);
  public ResultSet exibir();
}
