package br.edu.ufersa.hospital.model.service;

public class ProntuarioBO {
  public void alterar(String texto){
    this.obs = (!texto.isEmpty()) ? (texto) : ("Entrada de texto inválida.");
 }
 public static void Cadastrar(Prontuario prontuario){}
 public static void Excluir(Prontuario prontuario){}
}
