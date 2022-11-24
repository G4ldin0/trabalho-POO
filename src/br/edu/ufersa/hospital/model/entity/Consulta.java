package br.edu.ufersa.hospital.model.entity;
import java.time.LocalDate;
// import java.time.LocalTime; import feito para classe ainda não implementada
import java.time.LocalTime;

import br.edu.ufersa.hospital.api.dto.ConsultaDTO;

public class Consulta{
    
    private int id;
    private String cpfPaciente;
    private String cpfMedico;
    private LocalDate data;
    private Prontuario prontuario;
	private LocalTime horario;

    public Consulta(String cpfPaciente,String cpfMedico, LocalDate data,LocalTime horario, Prontuario prontuario){
        setCpfPaciente(cpfPaciente);
        setCpfMedico(cpfMedico);
        setData(data);
        setProntuario(prontuario);
        setHorario(horario);
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

    /*public void setPaciente(Paciente temp){
        this.paciente.setNome(temp.getNome());
        this.paciente.setEndereco(temp.getEndereco());
        this.paciente.setCpf(temp.getCpf());
        this.paciente.setProntuarios(temp.getProntuarios());

    }
    public Paciente getPaciente(){
        return this.paciente;

    }*/
    
    /*public void setMedico(Medico temp){
        this.medico.setNome(temp.getNome());
        this.medico.setCodigoDoConselho(temp.getCodigoDoConselho());
        this.medico.setCpf(temp.getCpf());
        this.medico.setEndereco(temp.getEndereco());
        this.medico.setValorDaConsulta(temp.getValorDaConsulta());
    }
    public Medico getMedico(){
        return this.medico;
    }*/
    
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
    
    public LocalTime getHorario() {
    	return this.horario;
    }
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public String getCpfPaciente() {
		return this.cpfPaciente;
	}

	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}

	public String getCpfMedico() {
		return this.cpfMedico;
	}

	public void setCpfMedico(String cpfMedico) {
		this.cpfMedico = cpfMedico;
	}
	
	public static Consulta converter(ConsultaDTO dto) {
        Consulta cons = new Consulta();
        //cons.getPaciente().setCpf(dto.getPaciente().getCpf());
        //cons.getMedico().setCpf(dto.getMedico().getCpf());
        //cons.getProntuario().setId(dto.getProntuario().getId());
        cons.setCpfMedico(dto.getCpfMedico());
        cons.setCpfPaciente(dto.getCpfPaciente());
        //cons.setId(dto.getId());
        //cons.setData(dto.getData());
        //cons.setHorario(dto.getHorario());
        return cons;
    }
   
}