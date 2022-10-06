package entity;
import java.time.LocalDate;
import java.util.Vector;

public class Paciente {
   private String nome;
   private String endereco;
   private long cpf;
   private Vector<Prontuario> prontuarios;

   public Paciente(String nome, String endereco, Long cpf, Vector<Prontuario> prontuarios){
      setNome(nome);
      setEndereco(endereco);
      setCpf(cpf);
      setProntuarios(prontuarios);
   }

   
   /*
    * GETTERS E SETTERS
   */
   
   public void setNome(String nome){ this.nome = (!nome.isEmpty()) ? (nome) : ("Null"); }
   public void setEndereco(String endereco){ this.endereco = (!endereco.isEmpty()) ? (endereco) : ("Null"); } 
   public void setCpf(Long cpf){ this.cpf = (cpf > 99_999_999_99L) ? (cpf) : (123_456_789_87L); }
   public void setProntuarios(Vector<Prontuario> Prontuarios){ 
      this.prontuarios = new Vector<Prontuario>(Prontuarios);
      if (!Prontuarios.isEmpty()){
         //Entra com todos os elementos do BD
      } else { 
         prontuarios.add(new Prontuario(LocalDate.now(), null));
      }
   }

   public String getNome(){ return this.nome; }
   public String getEndereco(){ return this.endereco; }
   public long getCpf(){ return this.cpf; }
   public Vector<Prontuario> getProntuarios(){ return prontuarios; }

}
