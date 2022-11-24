package br.edu.ufersa.hospital.api.controller;

import br.edu.ufersa.hospital.model.service.MedicoBO;
import br.edu.ufersa.hospital.view.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditarMedicoController {

	@FXML private TextField nome;
    @FXML private TextField cpf;
    @FXML private TextField endereco;
    @FXML private TextField codigoDoConselho;
    @FXML private TextField valorDaConsulta;
    private MedicoBO bo = new MedicoBO();
	
	public void cancelar() {
		Telas.listarMedicos();
	}
	
}
