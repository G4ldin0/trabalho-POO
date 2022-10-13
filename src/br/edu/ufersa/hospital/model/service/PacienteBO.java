package br.edu.ufersa.hospital.model.service;
import br.edu.ufersa.hospital.model.entity.Paciente;
import br.edu.ufersa.hospital.model.dao.PacienteDAO;
import br.edu.ufersa.hospital.model.dao.BaseInterDAO;

public class PacienteBO {
  public void Alterar(Paciente alteracao){
    setNome(alteracao.getNome());
    setEndereco(alteracao.getEndereco());
    setCpf(alteracao.getCpf());
 }
 public static void Cadastrar(){}
   public static void Excluir(){}
 
 public static Paciente buscarPorNome(Paciente busca){ return null;}
 public static Paciente buscarPorCpf(Paciente busca){ return null;}
}
