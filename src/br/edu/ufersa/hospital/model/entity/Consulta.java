package br.edu.ufersa.hospital.model.entity;
import java.time.LocalDate;
// import java.time.LocalTime; import feito para classe ainda não implementada

import br.edu.ufersa.hospital.api.dto.ConsultaDTO;

public class Consulta{
    
    private int id;
    private Paciente paciente;
    private Medico medico;
    private LocalDate data;
    private Prontuario prontuario;

    public Consulta(Paciente paciente,Medico medico, LocalDate data, Prontuario prontuario){
        setPaciente(paciente);
        setMedico(medico);
        setData(data);
        setProntuario(prontuario);
    }

    public Consulta() {
		// TODO Auto-generated constructor stub
	}

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
    
    public static Consulta converter(ConsultaDTO dto) {
        Consulta cons = new Consulta();
        cons.getPaciente().setId(dto.getPaciente().getId());
        cons.getMedico().setId(dto.getMedico().getId());
        cons.getProntuario().setId(dto.getProntuario().getId());
        cons.setId(dto.getId());
        cons.setData(dto.getData());
        return cons;
    }
    
}