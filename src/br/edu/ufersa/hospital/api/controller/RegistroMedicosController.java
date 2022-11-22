package br.edu.ufersa.hospital.api.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.hospital.api.dto.MedicoDTO;
import br.edu.ufersa.hospital.model.service.MedicoBO;
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
import javafx.util.Callback;

public class RegistroMedicosController implements Initializable {

    @FXML private Button menu;
    @FXML private Button menuClose;
    @FXML private AnchorPane slider;
    @FXML private TextField busca;
    @FXML private TableView<MedicoDTO> tabelaMedicos;
    @FXML private TableColumn<MedicoDTO, String> columnNome;
    @FXML private TableColumn<MedicoDTO, String> columnCpf;
    @FXML private TableColumn<MedicoDTO, String> columnEndereco;
    @FXML private TableColumn<MedicoDTO, String> columnCodConselho;
    @FXML private TableColumn<MedicoDTO, String> columnValorConsulta;
    @FXML private TableColumn<MedicoDTO, String> columnRelatorio;
    private MedicoBO bo = new MedicoBO();
    private ObservableList<MedicoDTO> listaDeMedicos;
    private ObservableList<MedicoDTO> listaMedicosFiltrados;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
        listarMedicos();
        
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
        slide.setOnFinished((ActionEvent e) -> {	// ao fim da transição, dá pra tirar isso
            slider.setVisible(false);
            menu.setVisible(true);
            menuClose.setVisible(false);
        });
    }
    
    public void logout() {
        Telas.logout();
    }
    
    public void listarMedicos() {
        List<MedicoDTO> medicos = bo.listar();
        listaDeMedicos = FXCollections.observableArrayList(medicos);
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        columnEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        columnCodConselho.setCellValueFactory(new PropertyValueFactory<>("codigoDoConselho"));
        columnValorConsulta.setCellValueFactory(new PropertyValueFactory<>("valorDaConsulta"));
        columnRelatorio.setCellValueFactory(new PropertyValueFactory<>("emitirRelatorio"));
        tabelaMedicos.setItems(listaDeMedicos);
    }
    
    public void buscar() {
    	MedicoDTO dto = new MedicoDTO();
    	dto.setCpf(busca.getText());
    	List<MedicoDTO> medicos = bo.listarPorCpf(dto);
    	listaMedicosFiltrados = FXCollections.observableArrayList(medicos);
    	columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        columnEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        columnCodConselho.setCellValueFactory(new PropertyValueFactory<>("codConselho"));
        columnValorConsulta.setCellValueFactory(new PropertyValueFactory<>("valorConsulta"));
        columnRelatorio.setCellValueFactory(new PropertyValueFactory<>("emitirRelatorio"));
        tabelaMedicos.setItems(listaMedicosFiltrados);
    }
    
    
    public void telaListarMedicos() {
    	Telas.listarMedicos();
    }
    public void listarPacientes() {
        Telas.listarPacientes();
    }
    public void listarConsultas() {
        Telas.listarConsultas();
    }
    public void cadastrar() {
    	Telas.telaCadastroMedico();
    }
    public void editar() {
    	Telas.telaEdicaoMedico();
    }
    public void excluir() {
    	Telas.telaConfirmarExclusao();
    }
    public void relatorio() {
    	Telas.telaRelatorios();
    }
    
}