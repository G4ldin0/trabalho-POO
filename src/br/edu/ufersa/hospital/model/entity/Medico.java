package br.edu.ufersa.hospital.model.entity;

public class Medico{

    private String nome;
    private int cpf;
    private int codigoDoConselho;
    private String endereco;
    private double valorDaConsulta;

    public Medico(){}

    public Medico(String nome, int cpf, int codConselho, String endereco, double valorConsulta){
        setNome(nome);
        setCpf(cpf);
        setCodigoDoConselho(codConselho);
        setEndereco(endereco);
        setValorDaConsulta(valorConsulta);
    }

    public Medico(String nome, int cpf, int codConselho, double valorConsulta){
        setNome(nome);
        setCpf(cpf);
        setCodigoDoConselho(codConselho);
        this.endereco = "Condomínio dos Médicos";
        setValorDaConsulta(valorConsulta);
    }

    public Medico(String nome, int cpf, int codConselho){
        setNome(nome);
        setCpf(cpf);
        setCodigoDoConselho(codConselho);
        this.endereco = "Condomínio dos Médicos";
        this.valorDaConsulta = 5499.99;
    }

    public Medico(int buscar){
        setCpf(buscar);
        setCodigoDoConselho(buscar);
    }

    /* void gerarRelatorio(){
        implementar a classe gerarRelatorio() futuramente
    } */

    // Getters e Setters abaixo. Setters tem o nome de "alterar". Ex: setNome() -> alterarNome()

    public String getNome() { 
        return nome;
    }

    public void setNome(String nome) {  // setNome()
        if (nome == " "){
            System.out.println("Esse nome é inválido.");
        } else this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {   // setCpf()
        if (cpf == 0){
            System.out.println("Cpf inválido.");
        } else this.cpf = cpf;
    }

    public int getCodigoDoConselho() {
        return codigoDoConselho;
    }

    public void setCodigoDoConselho(int codigoDoConselho) { // setCodigoDoConselho()
        if (cpf == 0){
            System.out.println("Código do conselho inválido.");
        } else this.codigoDoConselho = codigoDoConselho;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {  // setEndereco()
        if (endereco == " "){
            System.out.println("Endereço inválido.");
        } else this.endereco = endereco;
    }
    
    public double getValorDaConsulta() {
        return valorDaConsulta;
    }

    public void setValorDaConsulta(double valorDaConsulta) {    // setValorDaConsulta()
        if (valorDaConsulta == 0){
            System.out.println("Valor da consulta inválido.");
        } else this.valorDaConsulta = valorDaConsulta;
    }
}