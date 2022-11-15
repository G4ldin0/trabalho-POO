package br.edu.ufersa.hospital.api.dto;


public public class PacienteDTO extends PessoaDTO {
    
    private String idade;
    
    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        if (idade == " "){  // melhorar isso aqui
            System.out.println("Idade inválida.");
        } else this.idade = idade;
    }
}