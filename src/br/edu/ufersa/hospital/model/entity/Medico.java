package br.edu.ufersa.hospital.model.entity;

import br.edu.ufersa.hospital.api.dto.MedicoDTO;

public class Medico extends Pessoa{

    private int codigoDoConselho;
    private double valorDaConsulta;

    public Medico(){}

    public Medico(String nome, String cpf, int codConselho, String endereco, double valorConsulta){
        setNome(nome);
        setCpf(cpf);
        setCodigoDoConselho(codConselho);
        setEndereco(endereco);
        setValorDaConsulta(valorConsulta);
    }

    public Medico(String nome, String cpf, int codConselho, double valorConsulta){
        setNome(nome);
        setCpf(cpf);
        setCodigoDoConselho(codConselho);
        this.endereco = "Condomínio dos Médicos";
        setValorDaConsulta(valorConsulta);
    }

    public Medico(String nome, String cpf, int codConselho){
        setNome(nome);
        setCpf(cpf);
        setCodigoDoConselho(codConselho);
        this.endereco = "Condomínio dos Médicos";
        this.valorDaConsulta = 5499.99;
    }
    public int getCodigoDoConselho() {
        return this.codigoDoConselho;
    }

    public void setCodigoDoConselho(int codigoDoConselho) { // setCodigoDoConselho()
        if (codigoDoConselho == 0){
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
    
    public static Medico converter(MedicoDTO dto) {
        Medico med = new Medico();
        med.setCpf(dto.getCpf());
        med.setEndereco(dto.getEndereco());
        med.setNome(dto.getNome());
        med.setId(dto.getId());
        med.setCodigoDoConselho(dto.getCodigoDoConselho());
        med.setValorDaConsulta(dto.getValorDaConsulta());
        return med;
    }
    
}