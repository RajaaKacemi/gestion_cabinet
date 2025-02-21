package ma.enset.gestionconsultation.service;

import ma.enset.gestionconsultation.dao.ConsultationDao;
import ma.enset.gestionconsultation.dao.PatientDao;
import ma.enset.gestionconsultation.entities.Patient;

import java.util.List;

public class ServiceTest {
    public static void main(String[] args) {
        ICabinetService service = new CabinetService(new PatientDao(), new ConsultationDao() );
        /*
        Patient patient = new Patient();
        patient.setNom("siham");
        patient.setPrenom("alami");
        patient.setTel("123456789");
        service.addPatient(patient);
        */

        /*
        List<Patient> patients = service.getAllPatients();
        patients.forEach(p-> System.out.println(p));
         */
        Patient patient = service.getPatientById(10L);
        System.out.println("patient " + patient);
        patient.setTel("454545454");
        service.updatePatient(patient);
    }
}
