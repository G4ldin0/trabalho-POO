package br.edu.ufersa.hospital.model.entity;
import java.time.LocalDate;
import br.edu.ufersa.hospital.api.dto.ProntuarioDTO;

public class Prontuario{

   private int id;
   private LocalDate data;
   private String obs;
   private Paciente paciente;
   
   public Prontuario(String obs){
      data = LocalDate.now();
      setObs(obs);
   }

   public Prontuario(LocalDate data, String obs){
      setData(data);
      setObs(obs);
   }

   public Prontuario() {
	// TODO Auto-generated constructor stub
}
public int getId(){
      return this.id;
   }

   public void setId(int id){
      if(id < 0){
          System.out.println("Id inválido");
      } else this.id = id;
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

   public Paciente getPaciente() {
       return paciente;
   }

   public void setPaciente(Paciente paciente) {
       this.paciente = paciente;    // melhorar a segurança disso aqui
   }

   public static Prontuario converter(ProntuarioDTO dto) {
       Prontuario pront = new Prontuario();
       pront.setPaciente(dto.getPaciente());
       pront.setObs(dto.getObs());
       pront.setId(dto.getId());
       pront.setData(dto.getData());
       return pront;
   }

}