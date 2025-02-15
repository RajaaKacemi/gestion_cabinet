package ma.enset.gestionconsultations.service;

import ma.enset.gestionconsultations.entities.Patient;

import java.util.List;

public interface IPatientService {
    void addPatient(Patient patient);
    void updatePatient(Patient patient);
    void deletePatient(Patient patient);
    List<Patient> getPatients();
    Patient getPatient(Long id);
}
