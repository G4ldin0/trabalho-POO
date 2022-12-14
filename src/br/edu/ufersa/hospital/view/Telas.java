package br.edu.ufersa.hospital.view;


import br.edu.ufersa.hospital.api.controller.CadastrarProntuarioController;
import br.edu.ufersa.hospital.api.controller.CadastrarRelatorioController;
import br.edu.ufersa.hospital.api.dto.ProntuarioDTO;
import br.edu.ufersa.hospital.api.dto.MedicoDTO;
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
        Telas.stage = stage; 
    }
    
    @Override
    public void start(Stage arg0) throws Exception {
        setStage(arg0);
        arg0.setTitle("Cadastro");
        login();
    }
    
    public static void telaCadastroMedico() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/cadastrarMedicos.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de cadastro de Médicos");
            stage.show();
        }
        catch(Exception e) { 
            e.printStackTrace();
        }
    }
    
    public static void telaCadastroPaciente() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/cadastrarPacientes.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de cadastro de Pacientes");
            stage.show();
        }
        catch(Exception e) { 
            e.printStackTrace();
        }
    }
    
    public static void telaCadastroConsulta() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/cadastrarConsultas.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de cadastro de Consultas");
            stage.show();
        }
        catch(Exception e) {    // captura exception qnd qm chamar ele throws Excep.
            e.printStackTrace();
        }
    }
    
    public static void telaEdicaoMedico() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/editarMedicos.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de edição de Médicos");
            stage.show();
        }
        catch(Exception e) {    // captura exception qnd qm chamar ele throws Excep.
            e.printStackTrace();
        }
    }
    
    public static void telaEdicaoPaciente() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/editarPacientes.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de edição de Pacientes");
            stage.show();
        }
        catch(Exception e) {    // captura exception qnd qm chamar ele throws Excep.
            e.printStackTrace();
        }
    }
    
    public static void telaEdicaoConsulta() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/editarConsultas.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de edição de Consultas");
            stage.show();
        }
        catch(Exception e) {    // captura exception qnd qm chamar ele throws Excep.
            e.printStackTrace();
        }
    }
    
    public static void telaConfirmarExclusao() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/confirmacaoExcluir.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de confirmação de exclusão");
            stage.show();
        }
        catch(Exception e) {    // captura exception qnd qm chamar ele throws Excep.
            e.printStackTrace();
        }
    }
    
    public static void telaRelatorios(MedicoDTO medico) {
        try {
            FXMLLoader loader = new FXMLLoader((Telas.class.getResource("resources/Relatorio.fxml")));
            Parent root = loader.load();
            Scene scene = new Scene (root);

            CadastrarRelatorioController c = loader.getController();
            c.set(medico);

            stage.setScene(scene);
            stage.setTitle("Tela de Relatórios");
            stage.show();
        }
        catch(Exception e) {    // captura exception qnd qm chamar ele throws Excep.
            e.printStackTrace();
        }
    }
    
    public static void telaProntuarios(ProntuarioDTO prontuario) {
        try {
            FXMLLoader loader = new FXMLLoader(Telas.class.getResource("resources/Prontuario.fxml"));
            Parent root = loader.load();
            
            CadastrarProntuarioController c = loader.getController();
            c.set(prontuario);

            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de Prontuários");
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
    
    public static void logout() {
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
    public static void cadastroConsulta() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/cadastrarConsultas.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Consultas");
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void cadastroUsuario() {
    	try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/cadastroConta.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Cadastro");
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
	public static void cadastroAdmin() {
		try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/cadastroContaAdm.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Cadastro Admin");
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }	
	}
	public static void listarMedicosAdmin() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/registroMedicoAdmin.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Médicos");
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void listarPacientesAdmin() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/registroPacientesAdmin.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Pacientes");
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void listarConsultasAdmin() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/registroConsultasAdmin.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Consultas");
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}