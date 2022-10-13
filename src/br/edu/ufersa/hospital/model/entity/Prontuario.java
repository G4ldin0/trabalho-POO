package br.edu.ufersa.hospital.model.entity;
import java.time.LocalDate;

public class Prontuario{
   private LocalDate data;
   private String obs;
   private int ID;

   public Prontuario(String obs){
      data = LocalDate.now();
      alterar(obs);
   }

   public Prontuario(LocalDate data, String obs){
      LocalDate limiteMinimo = LocalDate.now().minusYears(150);
      LocalDate limiteMaximo = LocalDate.now();
      if(data.isAfter(limiteMinimo)){
         if(data.isBefore(limiteMaximo)){
            this.data = data;
         } 
         else this.data = limiteMaximo;
      }
      else this.data = limiteMinimo;
      
      alterar(obs);
   }

   public LocalDate getData(){
      return data;
   }

   public String getObs(){
      return obs;
   }
}