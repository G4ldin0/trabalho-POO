package br.edu.ufersa.hospital.model.dao;

import java.sql.ResultSet;

public interface BaseInterDAO<entity> {
	public boolean cadastrar (entity e);
	public boolean editar(entity e);
	public boolean excluirPorId(entity e);
	public ResultSet listar();
}
