package br.edu.ufersa.hospital.api.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.hospital.api.dto.MedicoDTO;
import br.edu.ufersa.hospital.model.service.MedicoBO;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class RegistroMedicosController implements Initializable {

    @FXML private Pane menu;
    @FXML private AnchorPane slider;
    @FXML private TableView<MedicoDTO> tabelaMedicos;
    @FXML private TableColumn<MedicoDTO, String> columnNome;
    @FXML private TableColumn<MedicoDTO, String> columnCpf;
    @FXML private TableColumn<MedicoDTO, String> columnEndereco;
    @FXML private TableColumn<MedicoDTO, String> columnCodConselho;
    @FXML private TableColumn<MedicoDTO, String> columnValorConsulta;
    @FXML private TableColumn<MedicoDTO, String> columnEmitirProntuario;
    private MedicoBO bo = new MedicoBO();
    private ObservableList<MedicoDTO> listaDeMedicos;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
        listarMedicos();
        
        menu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);
            
            slide.setToX(0);
            slide.play();
            
            slider.setTranslateX(-176);
            slide.setOnFinished((ActionEvent e) -> {
                menu.setVisible(true);
                slider.setVisible(true);
            });
                
        });
        
    }
    
    public void listarMedicos() {
        List<MedicoDTO> medicos = bo.listar();
        listaDeMedicos = FXCollections.observableArrayList(medicos);
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        columnEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        columnCodConselho.setCellValueFactory(new PropertyValueFactory<>("codConselho"));//ver no bd
        columnValorConsulta.setCellValueFactory(new PropertyValueFactory<>("valorConsulta"));//bd
        columnEmitirProntuario.setCellValueFactory(new PropertyValueFactory<>("emitirProntuario"));
        tabelaMedicos.setItems(listaDeMedicos);
    }

    
}
