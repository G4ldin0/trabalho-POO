package br.edu.ufersa.hospital.api.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import br.edu.ufersa.hospital.api.dto.MedicoDTO;
import br.edu.ufersa.hospital.model.service.MedicoBO;

public class CadastrarMedicoController {
    
    @FXML private TextField login;
    @FXML private TextField senha;
    private MedicoBO bo = new MedicoBO();
    
    public void cadastrar() {
        MedicoDTO dto = new MedicoDTO();
        dto.setNome(login.getText());
        dto.setCpf(senha.getText());
        bo.adicionar(dto);
        // Telas.listarMedicos();   método ainda não implementado
    }
    
}