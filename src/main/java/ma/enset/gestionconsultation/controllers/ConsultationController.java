package ma.enset.gestionconsultation.controllers;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import ma.enset.gestionconsultation.dao.ConsultationDao;
import ma.enset.gestionconsultation.dao.PatientDao;
import ma.enset.gestionconsultation.entities.Consultation;
import ma.enset.gestionconsultation.entities.Patient;
import ma.enset.gestionconsultation.service.CabinetService;
import ma.enset.gestionconsultation.service.ICabinetService;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class ConsultationController implements Initializable {
    @FXML private DatePicker dateConsultation;
    @FXML private ComboBox<Patient> comboPatient;
    @FXML private TextArea textAreaDescription;
    private ICabinetService cabinetService;
    private Consultation selectedConsultation;
    private ObservableList<Patient> patients = FXCollections.observableArrayList();
//
    @FXML private TableView<Consultation> tableConsultation;
    @FXML private TableColumn<Consultation, Long> columnId;
    @FXML private TableColumn<Consultation, Date> columnDateConsultation;
    @FXML private TableColumn<Consultation, String> columnDescription;
    @FXML private TableColumn<Consultation, String> columnPatient;
    @FXML private Label labelSuccess;
    private ObservableList<Consultation> consultations = FXCollections.observableArrayList();
//

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cabinetService = new CabinetService(new PatientDao(), new ConsultationDao());
        comboPatient.setItems(patients);
        patients.setAll(cabinetService.getAllPatients());

        //
        tableConsultation.setItems(consultations);
        columnId.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));
        columnDateConsultation.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDateConsultation()));
        columnPatient.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPatient().getNom()));
        columnDescription.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescription()));
        //
        loadConsultation();
        tableConsultation.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectConsultation(newSelection);
            }
        });

    }
    private void selectConsultation(Consultation consultation) {
        selectedConsultation = consultation;
        dateConsultation.setValue(consultation.getDateConsultation().toLocalDate());
        comboPatient.setValue(consultation.getPatient());
//        comboPatient.getSelectionModel().select(consultation.getPatient());
        textAreaDescription.setText(consultation.getDescription());
    }

    public void addConsultation(){
     Consultation consultation = new Consultation();
     consultation.setDateConsultation(Date.valueOf(dateConsultation.getValue()));
     consultation.setDescription(textAreaDescription.getText());
     consultation.setPatient(comboPatient.getSelectionModel().getSelectedItem());
        cabinetService.addConsultation(consultation);
        loadConsultation();

            patients.setAll(cabinetService.getAllPatients());
    }

    public void delConsultation(){
        Consultation consultation = tableConsultation.getSelectionModel().getSelectedItem();
        cabinetService.deleteConsultation(consultation);
        loadConsultation();
       labelSuccess.setText("Le consultation a été bien supprimé");
    }

    public void updateConsultation() {
        if (selectedConsultation != null) {
            selectedConsultation.setDateConsultation(Date.valueOf(dateConsultation.getValue()));
            selectedConsultation.setPatient(comboPatient.getSelectionModel().getSelectedItem());
            selectedConsultation.setDescription(textAreaDescription.getText());
            System.out.println("Mise à jour de la consultation : " + selectedConsultation);
            cabinetService.updateConsultation(selectedConsultation);

            loadConsultation();
            labelSuccess.setText("La consultation a été bien modifiée !");
        }
    }


    private void loadConsultation(){
        consultations.setAll(cabinetService.getAllConsultations());
    }

}
