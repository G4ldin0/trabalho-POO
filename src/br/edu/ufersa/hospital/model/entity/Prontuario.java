package br.edu.ufersa.hospital.model.entity;
import java.time.LocalDate;
import br.edu.ufersa.hospital.model.service.ProntuarioBO;

public class Prontuario{

   private int id;
   private LocalDate momento;
   private String obs;

   public Prontuario(String obs){
      momento = LocalDate.now();
      setObs(obs);
   }

   public Prontuario(LocalDate momento, String obs){
      setMomento(momento);
      setObs(obs);
   }

   public int getId(){
      return this.id;
   }

   public void setId(int id){
      if(id < 0){
          System.out.println("Id inválido");
      } else this.id = id;
   }

   public LocalDate getmomento(){
      return momento;
   }

   public void setMomento(LocalDate momento){
      LocalDate limiteMinimo = LocalDate.now().minusYears(150);
      LocalDate limiteMaximo = LocalDate.now();
      if(momento.isAfter(limiteMinimo)){
         if(momento.isBefore(limiteMaximo)){
            this.momento = momento;
         } 
         else this.momento = limiteMaximo;
      }
      else this.momento = limiteMinimo;
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