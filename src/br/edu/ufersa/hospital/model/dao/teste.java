package br.edu.ufersa.hospital.model.dao;

import br.edu.ufersa.hospital.model.entity.Medico;

public class teste {
	public static void main(String args[]) {
	BaseDAO<Medico> dao = new BaseDAO<Medico>();
	System.out.println(dao.getConnection());
	
	}
}
