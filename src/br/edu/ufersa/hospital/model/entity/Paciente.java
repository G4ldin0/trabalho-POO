package br.edu.ufersa.hospital.model.entity;
import java.time.LocalDate;
import java.util.Vector;

public class Paciente extends Pessoa{
   
   private Vector<Prontuario> prontuarios;

   public Paciente(){}

   public Paciente(String nome, String endereco, String cpf, Vector<Prontuario> prontuarios){
      setNome(nome);
      setEndereco(endereco);
      setCpf(cpf);
      setProntuarios(prontuarios);
   }

   
   /*
    * GETTERS E SETTERS
   */

   public void setProntuarios(Vector<Prontuario> Prontuarios){ 
      this.prontuarios = new Vector<Prontuario>(Prontuarios);
      if (!Prontuarios.isEmpty()){
      } else { 
         prontuarios.add(new Prontuario(LocalDate.now(), null));
      }
   }

   public Vector<Prontuario> getProntuarios(){ return prontuarios; }

}
