package br.edu.ufersa.hospital.model.entity;
import java.time.LocalDate;
import java.util.Vector;

import br.edu.ufersa.hospital.api.dto.MedicoDTO;
import br.edu.ufersa.hospital.api.dto.PacienteDTO;

public class Paciente extends Pessoa{
   
   private int id;
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

   public int getId(){
      return this.id;
   }

   public void setId(int id){
      if(id < 0){
         System.out.println("Id inválido");
      } else this.id = id;
   }
   
   public void setProntuarios(Vector<Prontuario> Prontuarios){ 
      this.prontuarios = new Vector<Prontuario>(Prontuarios);
      if (!Prontuarios.isEmpty()){
         //Entra com todos os elementos do BD
      } else { 
         prontuarios.add(new Prontuario(LocalDate.now(), null));
      }
   }

   public Vector<Prontuario> getProntuarios(){ return prontuarios; }
   
   public static Paciente converter(PacienteDTO dto) {
       Paciente pac = new Paciente();
       pac.setCpf(dto.getCpf());
       pac.setEndereco(dto.getEndereco());
       pac.setNome(dto.getNome());
       pac.setId(dto.getId());
       return pac;
   }

}
