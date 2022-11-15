package br.edu.ufersa.hospital.api.controller;

import br.edu.ufersa.hospital.Exception.AutenticationException;
import br.edu.ufersa.hospital.model.entity.Usuario;
import br.edu.ufersa.hospital.model.service.UsuarioBO;
import br.edu.ufersa.hospital.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML private TextField nomeUsuario;
    @FXML private PasswordField senha;
    @FXML private Label erroAutent;
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
            	erroAutent.setText("Username ou senha não encontrados!");
            	erroAutent.setVisible(true);
            }
    }
}
