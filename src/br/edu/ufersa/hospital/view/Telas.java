package br.edu.ufersa.hospital.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application {

    public static void main (String[] args) {
        launch();   
    }
    
    private static Stage stage;
    
 // Gets e Sets
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Telas.stage = stage;    // att
    }
    
    @Override
    public void start(Stage arg0) throws Exception {
        setStage(arg0);
        arg0.setTitle("Login");
        login();
    }
    
    public static void telaCadastroAdm() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/cadastrarMedicos.FXML"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de Cadastro de Médicos");
            stage.show();
        }
        catch(Exception e) {    // captura exception qnd qm chamar ele throws Excep.
            e.printStackTrace();
        }
    }
    
    public static void listarMedicos() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/registroMedicos.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Médicos");
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void listarPacientes() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/registroPacientes.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Pacientes");
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void listarConsultas() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/registroConsultas.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Consultas");
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void login() {
    	try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/login.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}