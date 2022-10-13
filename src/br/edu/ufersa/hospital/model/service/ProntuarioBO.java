package br.edu.ufersa.hospital.model.service;
import br.edu.ufersa.hospital.model.entity.Prontuario;
import br.edu.ufersa.hospital.model.dao.ProntuarioDAO;
import br.edu.ufersa.hospital.model.dao.BaseInterDAO;

public class ProntuarioBO {
  public void alterar(String texto){
    this.obs = (!texto.isEmpty()) ? (texto) : ("Entrada de texto inválida.");
 }
 public static void Cadastrar(Prontuario prontuario){}
 public static void Excluir(Prontuario prontuario){}
}
