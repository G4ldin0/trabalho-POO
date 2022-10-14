package br.edu.ufersa.hospital.model.entity;

public class Medico extends Pessoa{

    private int id;
    private int codigoDoConselho;
    private double valorDaConsulta;

    public Medico(){}

    public Medico(String nome, long cpf, int codConselho, String endereco, double valorConsulta){
        setNome(nome);
        setCpf(cpf);
        setCodigoDoConselho(codConselho);
        setEndereco(endereco);
        setValorDaConsulta(valorConsulta);
    }

    public Medico(String nome, long cpf, int codConselho, double valorConsulta){
        setNome(nome);
        setCpf(cpf);
        setCodigoDoConselho(codConselho);
        this.endereco = "Condomínio dos Médicos";
        setValorDaConsulta(valorConsulta);
    }

    public Medico(String nome, long cpf, int codConselho){
        setNome(nome);
        setCpf(cpf);
        setCodigoDoConselho(codConselho);
        this.endereco = "Condomínio dos Médicos";
        this.valorDaConsulta = 5499.99;
    }
    /* void gerarRelatorio(){
        implementar a classe gerarRelatorio() futuramente
    } */

    // Getters e Setters abaixo. Setters tem o nome de "alterar". Ex: setNome() -> alterarNome()

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        if(id < 0){
            System.out.println("Id inválido");
        } else this.id = id;
    }

    public int getCodigoDoConselho() {
        return this.codigoDoConselho;
    }

    public void setCodigoDoConselho(int codigoDoConselho) { // setCodigoDoConselho()
        if (cpf == 0){
            System.out.println("Código do conselho inválido.");
        } else this.codigoDoConselho = codigoDoConselho;
    }
    
    public double getValorDaConsulta() {
        return this.valorDaConsulta;
    }

    public void setValorDaConsulta(double valorDaConsulta) {    // setValorDaConsulta()
        if (valorDaConsulta == 0){
            System.out.println("Valor da consulta inválido.");
        } else this.valorDaConsulta = valorDaConsulta;
    }
}