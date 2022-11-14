package br.edu.ufersa.hospital.api.dto;


public class PacienteDTO {
    
    private String nome;
    private String cpf;
    private String endereco;
    private String idade;
    private int id;

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

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        if (idade == " "){  // melhorar isso aqui
            System.out.println("Idade inválida.");
        } else this.idade = idade;
    }
    
    public int getId(){
        return this.id;
    }

    public void setId(int id){
        if(id < 0){
            System.out.println("Id inválido");
        } else this.id = id;
    }
    
}