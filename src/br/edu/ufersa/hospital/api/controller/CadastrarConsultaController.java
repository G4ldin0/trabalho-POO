package br.edu.ufersa.hospital.api.controller;
import java.time.LocalDate;
import java.time.LocalTime;

import br.edu.ufersa.hospital.api.dto.ConsultaDTO;
import br.edu.ufersa.hospital.model.service.ConsultaBO;
import br.edu.ufersa.hospital.view.Telas;
import br.edu.ufersa.hospital.model.dao.MedicoDAO;
import br.edu.ufersa.hospital.model.dao.PacienteDAO;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
public class CadastrarConsultaController {
	@FXML private TextField cpfPaciente;
    @FXML private TextField cpfMedico;
    @FXML private TextField data;
    @FXML private TextField horario;
    @FXML private CheckBox addPront;
    	private ConsultaBO bo = new ConsultaBO();
    	private PacienteDAO dao = new PacienteDAO();
    	private MedicoDAO dao1 = new MedicoDAO();
    public void cadastrar() {
    	ConsultaDTO dto = new ConsultaDTO();
    	dto.getPaciente().setCpf(cpfPaciente.getText());
    	dto.setPaciente(dao.encontrarPorCPF(dto.getPaciente()));
		dto.setMedico(dao1.encontrarPorCpf(dto.getMedico()));
		dto.setData(LocalDate.parse(data.getText()));
		dto.setHorario(LocalTime.parse(horario.getText()));
		bo.adicionar(dto);
		Telas.listarConsultas();
    }
}