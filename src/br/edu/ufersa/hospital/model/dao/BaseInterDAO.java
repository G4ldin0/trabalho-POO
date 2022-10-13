package br.edu.ufersa.hospital.model.dao;

import java.sql.Connection;

public interface BaseInterDAO<entity> {
	public Connection getConnection();
	public boolean adicionar (entity e);
	public boolean excluir(entity e);
	public boolean editar(entity e);
	public entity buscarPorCpf(entity e);
}
