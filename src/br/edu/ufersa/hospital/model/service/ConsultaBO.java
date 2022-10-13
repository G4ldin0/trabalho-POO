package br.edu.ufersa.hospital.model.service;
import br.edu.ufersa.hospital.model.entity.*;
import br.edu.ufersa.hospital.model.dao.*;
import br.edu.ufersa.hospital.model.dao.BaseInterDAO;

public class ConsultaBO {
  public void editar(Consulta temp){ // basicamente um setConsulta
    temp.setPaciente(temp.getPaciente());
    temp.setMedico(temp.getMedico());
    temp.setProntuario(temp.getProntuario());
    temp.setDiaEHorario(temp.getDiaEHorario());
}
public void cadastrar(Consulta consultaCadastro){
    // tem que ser implementada com a integração com o BD
}
public void excluir(Consulta consultaExcluir){
    // tem que ser implementada com a integração com o BD
}
}
