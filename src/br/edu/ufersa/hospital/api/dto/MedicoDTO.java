package br.edu.ufersa.hospital.api.dto;

public class MedicoDTO{
    
    private String nome;
    private String cpf;
    private String endereco;
    private int id;
    private int codigoDoConselho;
    private double valorDaConsulta;

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

    public void setCodigoDoConselho(int codigoDoConselho) { 
        if (codigoDoConselho == 0){
            System.out.println("Código do conselho inválido.");
        } else this.codigoDoConselho = codigoDoConselho;
    }
    
    public double getValorDaConsulta() {
        return this.valorDaConsulta;
    }

    public void setValorDaConsulta(double valorDaConsulta) {    
        if (valorDaConsulta == 0){
            System.out.println("Valor da consulta inválido.");
        } else this.valorDaConsulta = valorDaConsulta;
    }
    
}