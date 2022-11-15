package br.edu.ufersa.hospital.api.dto;


public class PacienteDTO extends PessoaDTO {
    
    private String idade;
    
    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        if (idade == " "){ 
            System.out.println("Idade inválida.");
        } else this.idade = idade;
    }
}