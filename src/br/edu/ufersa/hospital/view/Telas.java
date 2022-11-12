package br.edu.ufersa.hospital.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application {

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
        arg0.setTitle("Cadastro");
    }
    
    public static void telaCadastroAdm() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/cadastro.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de Cadastro de Adminstradores do Hospital");
            stage.show();
        }
        catch(Exception e) {    // captura exception qnd qm chamar ele throws Excep.
            e.printStackTrace();
        }
    }
    
}