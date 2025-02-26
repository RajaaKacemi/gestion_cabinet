package ma.enset.gestionconsultations.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.gestionconsultations.dao.ConsultationDao;
import ma.enset.gestionconsultations.entities.Consultation;
import ma.enset.gestionconsultations.service.ConsultationService;
import ma.enset.gestionconsultations.service.IConsultationService;

import java.net.URL;
import java.util.ResourceBundle;

public class ConsultationController implements Initializable {

    @FXML private TextField textFielddescription;
    @FXML private TextField comboPatient;
    @FXML private TextField dateConsultation;

    @FXML private TableView<Consultation> tablePatients;
    @FXML private TableColumn<Consultation, String> columnId;
    @FXML private TableColumn<Consultation, String> columnDescription;
    @FXML private TableColumn<Consultation, String> columnPatient;
    @FXML private TableColumn<Consultation, String> columnDateConsultation;

    private IConsultationService consultationService;
    private ObservableList<Consultation> consultations = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        consultationService = new ConsultationService(new ConsultationDao());
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        columnPatient.setCellValueFactory(new PropertyValueFactory<>("Patient"));
        columnDateConsultation.setCellValueFactory(new PropertyValueFactory<>("DateConsultation"));
        consultations.setAll(consultationService.getConsultations());
        tablePatients.setItems(consultations);
    }

}
