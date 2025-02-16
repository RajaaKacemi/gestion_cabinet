package ma.enset.gestionconsultations.service;

import ma.enset.gestionconsultations.dao.ConsultationDao;
import ma.enset.gestionconsultations.dao.PatientDoa;
import ma.enset.gestionconsultations.entities.Consultation;
import ma.enset.gestionconsultations.entities.Patient;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ServiceTest {
    public static void main(String[] args) throws ParseException {
        IPatientService service = new PatientService(new PatientDoa());
        IConsultationService serviceConsultation = new ConsultationService(new ConsultationDao());

        /*Patient patient = new Patient();

        patient.setNom("Kacemi");
        patient.setPrenom("Majda");
        patient.setTel("0628117312");

        service.addPatient(patient);*/
        List<Patient> patients = service.getPatients();
        patients.forEach(patient -> System.out.println(patient));
        System.out.println(patients.get(0));
        Consultation consultation = new Consultation();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date utilDate = dateFormat.parse("20/02/2025"); // Convertir la chaîne en java.util.Date
        Date sqlDate = new Date(utilDate.getTime()); // Convertir en java.sql.Date
        consultation.setDateConsultation(sqlDate);
        consultation.setPatient(patients.get(0));
        consultation.setDescription("Consultation");
        serviceConsultation.addConsultation(consultation);
    }
}
