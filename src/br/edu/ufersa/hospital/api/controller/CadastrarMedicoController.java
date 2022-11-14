package br.edu.ufersa.hospital.api.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import br.edu.ufersa.hospital.api.dto.MedicoDTO;
import br.edu.ufersa.hospital.model.service.MedicoBO;

public class CadastrarMedicoController {
    
    @FXML private TextField nome;
    @FXML private TextField cpf;
    @FXML private TextField endereco;
    @FXML private TextField codConselho;
    @FXML private TextField valorConsulta;
    private MedicoBO bo = new MedicoBO();
    
    public void cadastrar() {
        MedicoDTO dto = new MedicoDTO();
        dto.setNome(nome.getText());
        dto.setCpf(cpf.getText());
        dto.setEndereco(endereco.getText());
        //dto.setCodigoDoConselho(codConselho.getText());
        //dto.setValorDaConsulta(valorConsulta.getText());
        bo.adicionar(dto);
        // Telas.listarMedicos();   método ainda não implementado
    }
    
}