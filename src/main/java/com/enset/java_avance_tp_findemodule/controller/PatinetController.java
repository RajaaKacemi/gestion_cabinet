package com.enset.java_avance_tp_findemodule.controller;

import com.enset.java_avance_tp_findemodule.DAO.PatientDAO;
import com.enset.java_avance_tp_findemodule.entities.Patient;
import com.enset.java_avance_tp_findemodule.interfaces.IPatientService;
import com.enset.java_avance_tp_findemodule.service.PatientService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;


public class PatinetController implements Initializable {
    //Table
    @FXML private TableView<Patient> tabelPatient;
    @FXML private TableColumn<Patient,Long> colID;
    @FXML private TableColumn<Patient,String> colFName;
    @FXML private TableColumn<Patient,String> colLName;
    @FXML private TableColumn<Patient,String> colTel;
    //buttons
    @FXML private Button buttonAdd;
    @FXML private Button buttonDel;
    @FXML private Button buttonUp;

    //textFields
    @FXML private TextField fieldSearch;
    @FXML private TextField fieldFName;
    @FXML private TextField fieldLName;
    @FXML private TextField fieldTel;
    private IPatientService patientService;
    private ObservableList<Patient> patientList= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        patientService = new PatientService(new PatientDAO());
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
//        patientService.getAllPatients();
//        patientList.setAll(patientService.getAllPatients());
        tabelPatient.setItems(patientList);
        loadPatient();
    }
    public void addPatient() {
        Patient patient = new Patient();
        patient.setFirstName(fieldFName.getText());
        patient.setLastName(fieldLName.getText());
        patient.setTel(fieldTel.getText());
        patientService.addPatient(patient);
        loadPatient();

    }
    public void delPatient() {
        Patient patient=tabelPatient.getSelectionModel().getSelectedItem();
        patientService.deletePatient(patient);
        loadPatient();

    }
    public void upPatient() {
    Patient patient=tabelPatient.getSelectionModel().getSelectedItem();
    patientService.updatePatient(patient);
    loadPatient();
    }
    private void loadPatient() {
        patientList.setAll(patientService.getAllPatients());
    }
}
