package br.edu.ufersa.hospital.model.service;
import br.edu.ufersa.hospital.model.entity.Prontuario;
import br.edu.ufersa.hospital.model.dao.ProntuarioDAO;
import br.edu.ufersa.hospital.model.dao.BaseInterDAO;

public class ProntuarioBO {
  public void alterar(Prontuario pront){
    String texto = pront.getObs();
    String auxilio = (!texto.isEmpty()) ? (texto) : ("Entrada de texto inválida.");
    pront.setObs(auxilio);
 }
 public static void Cadastrar(Prontuario prontuario){}
 public static void Excluir(Prontuario prontuario){}
}
