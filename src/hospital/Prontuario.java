package hospital;
import java.time.LocalDate;

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


   public void setObs(String texto){
      this.obs = (!texto.isEmpty()) ? (texto) : ("Entrada de texto inválida.");
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

   public LocalDate getData(){
      return data;
   }

   public String getObs(){
      return obs;
   }

   //não é possível implementar os métodos no momento, pois realizam manipulações no banco de dados do hospital
   public static void Cadastrar(Prontuario prontuario){}
   public static void Excluir(Prontuario prontuario){}
}