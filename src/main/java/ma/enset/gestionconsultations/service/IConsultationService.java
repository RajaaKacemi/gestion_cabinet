package ma.enset.gestionconsultations.service;

import ma.enset.gestionconsultations.entities.Consultation;

import java.util.List;

public interface IConsultationService {
    void addConsultation(Consultation consultation);
    void updateConsultation(Consultation consultation);
    void deleteConsultation(Consultation consultation);
    Consultation getConsultation(Long id);
    List<Consultation> getConsultations();
}
