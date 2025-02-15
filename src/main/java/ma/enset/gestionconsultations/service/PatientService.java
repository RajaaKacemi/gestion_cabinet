package ma.enset.gestionconsultations.service;

import ma.enset.gestionconsultations.dao.IPatientDoa;
import ma.enset.gestionconsultations.entities.Patient;

import java.sql.SQLException;
import java.util.List;

public class PatientService implements IPatientService {

    public PatientService(IPatientDoa patientDoa) {
        this.patientDoa = patientDoa;
    }

    private IPatientDoa patientDoa;
    @Override
    public void addPatient(Patient patient) {
        try {
            patientDoa.create(patient);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updatePatient(Patient patient) {
        try {
            patientDoa.update(patient);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletePatient(Patient patient) {
        try {
            patientDoa.delete(patient);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Patient> getPatients() {
        List <Patient> patients = null;
        try {
            patients = patientDoa.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patients;
    }

    @Override
    public Patient getPatient(Long id) {
        Patient patient = null;
        try {
            patient = patientDoa.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patient;

    }
}
