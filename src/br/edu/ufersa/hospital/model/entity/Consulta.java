package br.edu.ufersa.hospital.model.entity;
import java.time.LocalDateTime;
// import java.time.LocalTime; import feito para classe ainda não implementada

public class Consulta{
    
    private int id;
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime diaEHorario;
    private Prontuario prontuario;

    public Consulta(Paciente paciente,Medico medico, LocalDateTime diaEhorario, Prontuario prontuario){
        setPaciente(paciente);
        setMedico(medico);
        setDiaEHorario(diaEhorario);
        setProntuario(prontuario);
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
    
    public void setDiaEHorario(LocalDateTime temp){
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime limiteMinimo = agora.minusYears(150);
        LocalDateTime limiteMaximo = agora.plusYears(2);
        if(temp.isAfter(limiteMinimo) && temp.isBefore(limiteMaximo)){
            this.diaEHorario = temp;
        }
        else this.diaEHorario = agora.plusMonths(2); // se não colocar uma data válida, a consulta será alterada para dois meses após.
    }
    public LocalDateTime getDiaEHorario(){
        return this.diaEHorario;
    }
    
    public void setProntuario(Prontuario prontuario){
        if(prontuario != null){
            this.prontuario = prontuario;
        }
    }
    public Prontuario getProntuario(){ 
        return this.prontuario;
    }

    
    // public Consulta buscarporMedico(Medico medicoBusca){
    //     //
    // }
    // public Consulta buscarPorPaciente(Paciente pacienteBusca){
    //     //
    // }
    // public Consulta buscarPorHorario(LocalTime horario){
    //     // 
    // }

}