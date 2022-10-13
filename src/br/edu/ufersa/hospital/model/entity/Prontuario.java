package br.edu.ufersa.hospital.model.entity;
import java.time.LocalDate;
import br.edu.ufersa.hospital.model.service.ProntuarioBO;

public class Prontuario{
   private LocalDate data;
   private String obs;


   public Prontuario(String obs){
      data = LocalDate.now();
      setObs(obs);
   }

   public Prontuario(LocalDate data, String obs){
      setData(data);
      setObs(obs);
   }


   public LocalDate getData(){
      return data;
   }

   public void setData(LocalDate data){
      LocalDate limiteMinimo = LocalDate.now().minusYears(150);
      LocalDate limiteMaximo = LocalDate.now();
      if(data.isAfter(limiteMinimo)){
         if(data.isBefore(limiteMaximo)){
            this.data = data;
         } 
         else this.data = limiteMaximo;
      }
      else this.data = limiteMinimo;
   }

   public void setObs(String obs){
      if (obs == " "){
         System.out.println("Esse nome é inválido.");
      } else this.obs = obs;
   }

   public String getObs(){
      return obs;
   }
}