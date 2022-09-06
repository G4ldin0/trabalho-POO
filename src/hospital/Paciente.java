package hospital;
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
      this.prontuarios = new Vector<Prontuario>(prontuarios);
   }

   
   /*
    * GETTERS E SETTERS
   */
   
   public void setNome(String nome){ this.nome = (!nome.isEmpty()) ? (nome) : ("Null"); }
   public void setEndereco(String endereco){ this.endereco = (!endereco.isEmpty()) ? (endereco) : ("Null"); } 
   public void setCpf(Long cpf){ this.cpf = (cpf > 99_999_999_99L) ? (cpf) : (123_456_789_87L); }


   public String getNome(){ return this.nome; }
   public String getEndereco(){ return this.endereco; }
   public long getCpf(){ return this.cpf; }
   public Vector<Prontuario> getProntuarios(){ return prontuarios; }


   // não será possível implementar estes métodos no momento, pois estes realizam manipulações com o banco de dados
   public static void Cadastrar(){}
   public static void Excluir(){}

   public void Alterar(Paciente alteracao){
      setNome(alteracao.getNome());
      setEndereco(alteracao.getEndereco());
      setCpf(alteracao.getCpf());
   }

   
   public static Paciente buscarPorNome(Paciente busca){ return null;}
   public static Paciente buscarPorCpf(Paciente busca){ return null;}
   /*
       * loop que irá passar pelos elementos do BD em busca do paciente com informação equivalente
       * 
       * return new paciente(informações do BD)
   */

}
