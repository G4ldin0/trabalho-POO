package br.edu.ufersa.hospital.api.controller;

import br.edu.ufersa.hospital.view.Telas;

import java.util.List;

import br.edu.ufersa.hospital.api.dto.ConsultaDTO;
import br.edu.ufersa.hospital.api.dto.MedicoDTO;
import br.edu.ufersa.hospital.model.service.ConsultaBO;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class CadastrarRelatorioController {

    //fields
    @FXML private Button botaoVoltar;
    @FXML private TextField busca;
    @FXML private Button menu;
    @FXML private Button menuClose;
    @FXML private AnchorPane slider;

    @FXML private TextField nomeMedico;
    @FXML private TextField horaInicial;
    @FXML private TextField dataInicial;
    @FXML private TextField horaFinal;
    @FXML private TextField dataFinal;
    @FXML private TextArea relatorioFinal;

    //configuração inicial
    public void set(MedicoDTO medico){
        String relatorio = new String();
        ConsultaBO bo = new ConsultaBO();
        List<ConsultaDTO> lista = bo.listar();

        if (!lista.isEmpty()){
            for(int i = 0; i < lista.size(); i++){
                relatorio += "consulta ao dia";
                relatorio += lista.get(i).getData().toString();
                relatorio += "\n\n";
            }
        } else
            relatorio = "nada por hoje chefia";

        nomeMedico.setText(medico.getNome());
        this.relatorioFinal.setText(relatorio);
    }

    //menu
    @FXML
    void abrirMenu(ActionEvent event) {
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
            botaoVoltar.setVisible(false);
        });
    }

    @FXML
    void fecharMenu(ActionEvent event) {
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
            botaoVoltar.setVisible(true);
        });
    }
    
    @FXML
    void buscar(ActionEvent event) {

    }




    //trocar de tela
    public void logout() {
        Telas.logout();
    }
    public void listarPacientes() {
        Telas.listarPacientesAdmin();
    }
    public void listarMedicos() { 
        Telas.listarMedicosAdmin();
    }
    public void listarConsultas() {
    	Telas.listarConsultasAdmin();
    }

}
