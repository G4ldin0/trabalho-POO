package br.edu.ufersa.hospital.api.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.hospital.api.dto.PacienteDTO;
import br.edu.ufersa.hospital.model.service.PacienteBO;
import br.edu.ufersa.hospital.view.Telas;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class RegistroPacientesController implements Initializable {

    @FXML private Button menu;
    @FXML private Button menuClose;
    @FXML private AnchorPane slider;
    @FXML private TextField busca;
    @FXML private TableView<PacienteDTO> tabelaPacientes;
    @FXML private TableColumn<PacienteDTO, String> columnNome;
    @FXML private TableColumn<PacienteDTO, String> columnCpf;
    @FXML private TableColumn<PacienteDTO, String> columnEndereco;
    @FXML private TableColumn<PacienteDTO, String> columnIdade;
    @FXML private TableColumn<PacienteDTO, String> columnHistorico;
    private PacienteBO bo = new PacienteBO();
    private ObservableList<PacienteDTO> listaDePacientes;
    private ObservableList<PacienteDTO> listaPacientesFiltrados;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
        listarPacientes();
        
    }
    
    public void abrirMenu() {
        // menu.setOnMouseClicked(event -> {});
           TranslateTransition slide = new TranslateTransition();
           slide.setDuration(Duration.seconds(0.4));
           slide.setNode(slider);
           slide.setToY(0);
           slide.play();
           
           slider.setTranslateY(-107);
           slide.setOnFinished((ActionEvent e) -> {
               slider.setVisible(true);
               menu.setVisible(false);
               menuClose.setVisible(true);
           });
    }
    
    public void fecharMenu() {
     // menu.setOnMouseClicked(event -> {});
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(slider);
        slide.setToY(-107);
        slide.play();
        
        slider.setTranslateY(0);
        slide.setOnFinished((ActionEvent e) -> {
            slider.setVisible(false);
            menu.setVisible(true);
            menuClose.setVisible(false);
        });
    }
    
    public void logout() {
        Telas.logout();
    }
    
    public void listarPacientes() {
        List<PacienteDTO> pacientes = bo.listar();
        listaDePacientes = FXCollections.observableArrayList(pacientes);
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        columnEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        columnIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));//ver no bd
        columnHistorico.setCellValueFactory(new PropertyValueFactory<>("historico"));//ver no bd
        tabelaPacientes.setItems(listaDePacientes);
    }
    
    public void buscar() {
    	PacienteDTO dto = new PacienteDTO();
    	dto.setCpf(busca.getText());
    	List<PacienteDTO> pacientes = bo.listarPorCpf(dto);
    	listaPacientesFiltrados = FXCollections.observableArrayList(pacientes);
    	columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        columnEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        columnIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));//ver no bd
        columnHistorico.setCellValueFactory(new PropertyValueFactory<>("historico"));//ver no bd
        tabelaPacientes.setItems(listaPacientesFiltrados);
    }
    
    
    public void telaListarPacientes() {
    	Telas.listarPacientes();
    }
    public void listarMedicos() {
        Telas.listarMedicos();
    }
    public void listarConsultas() {
        Telas.listarConsultas();
    }
    public void cadastrar() {
    	Telas.telaCadastroPaciente();
    }
    public void editar() {
    	Telas.telaEdicaoPaciente();
    }
    public void excluir() {
    	Telas.telaConfirmarExclusao();
    }
    
}