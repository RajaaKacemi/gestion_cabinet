package ma.enset.gestionconsultations.service;

import ma.enset.gestionconsultations.dao.ConsultationDao;
import ma.enset.gestionconsultations.dao.IConsultationDao;
import ma.enset.gestionconsultations.entities.Consultation;

import java.util.ArrayList;
import java.util.List;

public class ConsultationService implements IConsultationService {
    private IConsultationDao consultationDao = new ConsultationDao();

    public ConsultationService(IConsultationDao consultationDao) {
        this.consultationDao = consultationDao;
    }

    @Override
    public void addConsultation(Consultation consultation) {
        try{
            consultationDao.create(consultation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateConsultation(Consultation consultation) {
        try{
            consultationDao.update(consultation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteConsultation(Consultation consultation) {
        try{
            consultationDao.delete(consultation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Consultation getConsultation(Long id) {
        Consultation consultation = new Consultation();

        try{
            consultation = consultationDao.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return consultation;
    }

    @Override
    public List<Consultation> getConsultations() {
        List<Consultation> consultations = new ArrayList<>();
        try{
            consultations = consultationDao.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return consultations;
    }
}
