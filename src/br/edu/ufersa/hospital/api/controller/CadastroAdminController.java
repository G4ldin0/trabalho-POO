package br.edu.ufersa.hospital.api.controller;

import br.edu.ufersa.hospital.Exception.PasswordErrorException;
import br.edu.ufersa.hospital.api.dto.AdmDTO;
import br.edu.ufersa.hospital.model.entity.Adm;
import br.edu.ufersa.hospital.model.service.AdmBO;
import br.edu.ufersa.hospital.model.service.ContaBO;
import br.edu.ufersa.hospital.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CadastroAdminController {
	
		@FXML private TextField username;
	    @FXML private PasswordField senha;
	    @FXML private PasswordField confirmSenha;
	    @FXML private TextField email;
	    @FXML private Label erroAutent;
	    @FXML private Button botaoFechar;
	    AdmBO bo = new AdmBO();
	    ContaBO bo2 = new ContaBO();
	    public void cadastrar(ActionEvent action){
	      AdmDTO admin = new AdmDTO();
	      if(senha.getText().equals(confirmSenha.getText())) {
	    	  
	      admin.setSenha(senha.getText());
	      admin.setUsername(username.getText());
	      try {
	           Adm cadastrado = bo.adicionar(admin);
	           bo2.adicionar(admin);
	           Telas.login();
	           }
	       catch(PasswordErrorException e){
	       erroAutent.setText("username ou senha não encontrados!");
	       erroAutent.setVisible(true);
	       botaoFechar.setVisible(true);
	      botaoFechar.setDisable(false);
	       }            
	         }
	      else {
	    	  erroAutent.setText("Preencha corretamente!");
		      erroAutent.setVisible(true);
		      botaoFechar.setVisible(true);
		      botaoFechar.setDisable(false);
	      }
	    }
	    
	    public void voltarTelaLogin() {
	    	Telas.login();
	    }
	    
	    public void fecharError(ActionEvent action) {
	    	erroAutent.setVisible(false);
	    	botaoFechar.setVisible(false);
	    	botaoFechar.setDisable(true);
	    }
	    public void IrTelaCadastroAdmin(ActionEvent action) {
	    	Telas.CadastroAdmin();
	    }
	}
