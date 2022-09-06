package hospital;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
public class Consulta{
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime diaEHorario;
    private Prontuario prontuario;

    public void setPaciente(Paciente temp){
        this.paciente.setNome(temp.getNome());
        this.paciente.setEndereco(temp.getEndereco());
        this.paciente.setCpf(temp.getCpf());
        this.paciente.setProntuario(temp.getProntuarios());
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
        if(temp.isAfter(agora.minusYears(2)) && temp.isBefore(agora.plusYears(2))){
            this.diaEHorario = temp;
        }
        else this.diaEHorario = agora.plusMonths(2); // se não colocar uma data válida, a consulta será alterada para dois meses após.
    }
     public LocalDateTime getDiaEHorario(){
        return this.diaEHorario;
    }
    public Prontuario getProntuario(){
        return this.prontuario;
    }
    public void setProntuarioUnico(Prontuario temp){
        this.prontuario.setData(temp.getData());
        this.prontuario.setObs(temp.getObs());
    }
    public void editar(Consulta temp){ // basicamente um setConsulta
        setPaciente(temp.getPaciente());
        setMedico(temp.getMedico());
        setProntuarioUnico(temp.getProntuario());
        setDiaEHorario(temp.getDiaEHorario());
    }
    public static void cadastrar(Consulta consultaCadastro){
        // tem que ser implementada com a integração com o BD
    }
    public static void excluir(Consulta consultaExcluir){
        // tem que ser implementada com a integração com o BD
    }
    public static Consulta buscarporMedico(Medico medicoBusca){
        //
    }
    public static Consulta buscarPorPaciente(Paciente pacienteBusca){
        //
    }
    public static Consulta buscarPorHorario(LocalTime horario){
        // 
    }
    Consulta(Paciente paciente,Medico medico, LocalDateTime diaEhorario,Prontuario prontuario){
        setPaciente(paciente);
        setMedico(medico);
        setDiaEHorario(diaEHorario);
        setProntuarioUnico(prontuario);
    }
    Consulta(Paciente paciente,Medico medico){
        setPaciente(paciente);
        setMedico(medico);
}