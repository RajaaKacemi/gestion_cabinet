package ma.enset.gestionconsultations.service;

import ma.enset.gestionconsultations.dao.PatientDoa;
import ma.enset.gestionconsultations.entities.Patient;

public class ServiceTest {
    public static void main(String[] args) {
        IPatientService service = new PatientService(new PatientDoa());

        Patient patient = new Patient();

        patient.setNom("Kacemi");
        patient.setPrenom("Rajaa");
        patient.setTel("0628117312");

        service.addPatient(patient);

    }
}
