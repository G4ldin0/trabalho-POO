package br.edu.ufersa.hospital.api.controller;

import br.edu.ufersa.hospital.Exception.AutenticationException;
import br.edu.ufersa.hospital.model.entity.Usuario;
import br.edu.ufersa.hospital.model.service.UsuarioBO;
import br.edu.ufersa.hospital.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML private TextField nomeUsuario;
    @FXML private PasswordField senha;
    @FXML private Label erroAutent;
    @FXML private Button botaoFechar;
    UsuarioBO bo = new UsuarioBO();
    public void autenticar(ActionEvent action) {
            Usuario user = new Usuario();
            user.setSenha(senha.getText());
            user.setUsername(nomeUsuario.getText());            
            try {
            	 Usuario autenticado = bo.autenticar(user);
            	 Telas.listarPacientes();
            }
            catch(AutenticationException e){
            	erroAutent.setText(e.getMessage());
            	erroAutent.setVisible(true);
            	botaoFechar.setVisible(true);
            	botaoFechar.setDisable(false);
            }
    }
    public void fecharError(ActionEvent action) {
    	erroAutent.setVisible(false);
    	botaoFechar.setVisible(false);
    	botaoFechar.setDisable(true);
    }
}
