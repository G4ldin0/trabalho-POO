package br.edu.ufersa.hospital.api.controller;
import br.edu.ufersa.hospital.api.dto.ConsultaDTO;
import br.edu.ufersa.hospital.model.service.ConsultaBO;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class CadastrarConsultaController {
	@FXML private TextField nomePaciente;
    @FXML private TextField nomeMedico;
    @FXML private TextField data;
    @FXML private TextField horario;
    @FXML private CheckBox addPront;
    	private ConsultaBO bo = new ConsultaBO();
    public void cadastrar() {
    	ConsultaDTO dto = new ConsultaDTO();
    	dto.setPaciente(nomePaciente.getText());
		dto.setNome(nome.getText());
		dto.setTelefone(telefone.getText());
		dto.setEndereco(endereco.getText());
    }
}
