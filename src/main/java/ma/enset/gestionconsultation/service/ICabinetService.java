package ma.enset.gestionconsultation.service;

import ma.enset.gestionconsultation.entities.Consultation;
import ma.enset.gestionconsultation.entities.Patient;

import java.sql.SQLException;
import java.util.List;

public interface ICabinetService {
    void addPatient(Patient patient)  ;
    void updatePatient(Patient patient);
    void deletePatient(Patient patient);
    List<Patient> getAllPatients();
    Patient getPatientById(Long id);
    List<Patient> searchPatientsByQuery(String search) throws SQLException;

    void addConsultation(Consultation consultation);
    void updateConsultation(Consultation consultation);
    void deleteConsultation(Consultation consultation);
    List<Consultation> getAllConsultations();
    Consultation getConsultationById(Long id);

}
