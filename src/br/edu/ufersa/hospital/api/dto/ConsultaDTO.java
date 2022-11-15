package br.edu.ufersa.hospital.api.dto;

import java.time.LocalDate;

import br.edu.ufersa.hospital.model.entity.Medico;
import br.edu.ufersa.hospital.model.entity.Paciente;
import br.edu.ufersa.hospital.model.entity.Prontuario;

public class ConsultaDTO{
	private int id;
    private Paciente paciente;
    private Medico medico;
    private LocalDate data;
    private Prontuario prontuario;
    
    public int getId(){
        return this.id;
    }

    public void setId(int id){
        if(id < 0){
            System.out.println("Id inválido");
        } else this.id = id;
    }

    public void setPaciente(Paciente temp){
        this.paciente.setNome(temp.getNome());
        this.paciente.setEndereco(temp.getEndereco());
        this.paciente.setCpf(temp.getCpf());
        this.paciente.setProntuarios(temp.getProntuarios());

    }
    public Paciente getPaciente(){
        return this.paciente;

    }
    
    public void setMedico(Medico temp){
        this.medico.setNome(temp.getNome());
        this.medico.setCodigoDoConselho(temp.getCodigoDoConselho());
        this.medico.setCpf(temp.getCpf());
        this.medico.setEndereco(temp.getEndereco());
        this.medico.setValorDaConsulta(temp.getValorDaConsulta());
    }
    public Medico getMedico(){
        return this.medico;
    }
    
    public void setData(LocalDate temp){
        LocalDate agora = LocalDate.now();
        LocalDate limiteMinimo = agora.minusYears(150);
        LocalDate limiteMaximo = agora.plusYears(2);
        if(temp.isAfter(limiteMinimo) && temp.isBefore(limiteMaximo)){
            this.data = temp;
        }
        else this.data = agora.plusMonths(2);
    }
    public LocalDate getData(){
        return this.data;
    }
    
    public void setProntuario(Prontuario prontuario){
        if(prontuario != null){
            this.prontuario = prontuario;
        }
    }
    public Prontuario getProntuario(){ 
        return this.prontuario;
    }
}