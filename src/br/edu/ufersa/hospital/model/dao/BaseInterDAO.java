package br.edu.ufersa.hospital.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;

public interface BaseInterDAO<entity> {
	public Connection getConnection();
	public boolean cadastrar (entity e);
	public boolean editar(entity e);
	public boolean excluirPorId(entity e);
	public ResultSet listar();
    public ResultSet exibir();
    public ResultSet encontrar(entity e);
    public entity encontrarPorId(entity e);
	public ResultSet encontrarPorCampoEspecifico(entity e, String field);
}
