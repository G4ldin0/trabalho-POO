package br.edu.ufersa.hospital.api.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.hospital.api.dto.ConsultaDTO;
import br.edu.ufersa.hospital.model.service.ConsultaBO;
import br.edu.ufersa.hospital.view.Telas;
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

public class RegistroConsultasController implements Initializable {
    
    @FXML private Pane menu;
    @FXML private AnchorPane slider;
    @FXML private TableView<ConsultaDTO> tabelaConsultas;
    @FXML private TableColumn<ConsultaDTO, String> columnPaciente;
    @FXML private TableColumn<ConsultaDTO, String> columnData;
    @FXML private TableColumn<ConsultaDTO, String> columnHorario;
    @FXML private TableColumn<ConsultaDTO, String> columnMedico;
    @FXML private TableColumn<ConsultaDTO, String> columnStatus;
    @FXML private TableColumn<ConsultaDTO, String> columnEmitirProntuario;
    private ConsultaBO bo = new ConsultaBO();
    private ObservableList<ConsultaDTO> listaDeConsultas;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
        listarConsultas();
        
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
    
    public void listarConsultas() {
        List<ConsultaDTO> consultas = bo.listar();
        listaDeConsultas = FXCollections.observableArrayList(consultas);
        columnPaciente.setCellValueFactory(new PropertyValueFactory<>("idPaciente"));
        columnData.setCellValueFactory(new PropertyValueFactory<>("data"));
        columnHorario.setCellValueFactory(new PropertyValueFactory<>("horario"));
        columnMedico.setCellValueFactory(new PropertyValueFactory<>("idMedico"));
        columnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        columnEmitirProntuario.setCellValueFactory(new PropertyValueFactory<>("emitirProntuario"));
        tabelaConsultas.setItems(listaDeConsultas);
    }
    
    public void listarPacientes() {
        Telas.listarPacientes();
    }
    public void listarMedicos() { 
        Telas.listarMedicos();
    }
    
}