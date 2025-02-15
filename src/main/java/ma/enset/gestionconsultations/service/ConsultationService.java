package ma.enset.gestionconsultations.service;

import ma.enset.gestionconsultations.dao.ConsultationDao;
import ma.enset.gestionconsultations.dao.IConsultationDao;
import ma.enset.gestionconsultations.entities.Consultation;

import java.util.List;

public class ConsultationService implements IConsultationService {
    private IConsultationDao consultationDao = new ConsultationDao();
    @Override
    public void addConsultation(Consultation consultation) {

    }

    @Override
    public void updateConsultation(Consultation consultation) {

    }

    @Override
    public void deleteConsultation(Consultation consultation) {

    }

    @Override
    public Consultation getConsultation(Long id) {
        return null;
    }

    @Override
    public List<Consultation> getConsultations() {
        return List.of();
    }
}
