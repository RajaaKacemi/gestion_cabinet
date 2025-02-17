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

        Patient patient = new Patient();

        patient.setNom("Kacemi");
        patient.setPrenom("Majda");
        patient.setTel("0628117312");

        List<Patient> patients = service.getPatients();
        List<Consultation> consultations = serviceConsultation.getConsultations();

        patients.forEach(pat -> System.out.println(pat));


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date utilDate = dateFormat.parse("20/02/2025"); // Convertir la chaîne en java.util.Date
        Date sqlDate = new Date(utilDate.getTime()); // Convertir en java.sql.Date
        /*consultation.setDateConsultation(sqlDate);
        consultation.setPatient(patients.get(1));
        consultation.setDescription("Consultation de Majda");*/
        consultations.get(1).setPatient(patients.get(1));
        serviceConsultation.updateConsultation(consultations.get(1));
    }
}
