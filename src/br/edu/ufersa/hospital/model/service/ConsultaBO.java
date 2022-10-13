package br.edu.ufersa.hospital.model.service;

public class ConsultaBO {
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
}
