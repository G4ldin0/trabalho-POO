/*-paciente: Paciente 
  -medico: Medico
  -diaEHorario: localDateTime
  -prontuario: Prontuario
  
  +cadastrar(consulta:Consulta):void --- Precisa de interação com o banco de dados
  +editar(consulta:Consulta):void
  +excluir(consulta:Consulta):void
  +buscarporMedico(medico:Medico):Consulta
  +buscarPorPaciente(paciente:Paciente): Consulta
  +buscarPorHorario(horario:LocalTime): Consulta
  */

package entity;
import java.time.LocalDateTime;
// import java.time.LocalTime; import feito para classe ainda não implementada

public class Consulta{
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
        this.medico.alterarNome(temp.getNome());
        this.medico.alterarCodigoDoConselho(temp.getCodigoDoConselho());
        this.medico.alterarCpf(temp.getCpf());
        this.medico.alterarEndereco(temp.getEndereco());
        this.medico.alterarValorDaConsulta(temp.getValorDaConsulta());
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

    public void editar(Consulta temp){ // basicamente um setConsulta
        setPaciente(temp.paciente);
        setMedico(temp.medico);
        setProntuario(temp.prontuario);
        setDiaEHorario(temp.diaEHorario);
    }
    public void cadastrar(Consulta consultaCadastro){
        // tem que ser implementada com a integração com o BD
    }
    public void excluir(Consulta consultaExcluir){
        // tem que ser implementada com a integração com o BD
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