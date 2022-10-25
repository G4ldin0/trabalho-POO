package br.edu.ufersa.hospital.model.entity;

public class Pessoa {

    protected String nome;
    protected String cpf;
    protected String endereco;

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        if (nome == " "){
            System.out.println("Esse nome é inválido.");
        } else this.nome = nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == " "){
            System.out.println("Cpf inválido.");
        } else this.cpf = cpf;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public void setEndereco(String endereco){
        if (endereco == " "){
            System.out.println("Endereço inválido.");
        } else this.endereco = endereco;
    }

    /*  public void setNome(String nome){ this.nome = (!nome.isEmpty()) ? (nome) : ("Null"); }
   public void setEndereco(String endereco){ this.endereco = (!endereco.isEmpty()) ? (endereco) : ("Null"); } 
   public void setCpf(Long cpf){ this.cpf = (cpf > 99_999_999_99L) ? (cpf) : (123_456_789_87L); } */

}
