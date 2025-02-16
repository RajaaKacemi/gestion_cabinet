package ma.enset.gestionconsultations.dao;

import ma.enset.gestionconsultations.entities.Consultation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultationDao implements IConsultationDao {
    @Override
    public void create(Consultation consultation) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO CONSULTATION(DATE_CONSULTATION, DESCRIPTION, PATIENT_ID) " +
                "VALUES (?, ?, ?)");
        System.out.println("consultation "+ consultation);
        pstm.setString(1, consultation.getDateConsultation().toString());
        pstm.setString(2, consultation.getDescription());
        pstm.setLong(3, consultation.getPatient().getId());
        pstm.executeUpdate();
        System.out.println("consultation created");
    }

    @Override
    public void update(Consultation consultation) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE CONSULTATION SET DATE_CONSULTATION = ?, DESCRIPTION = ?, PATIENT_ID = ?");
        pstm.setString(1, consultation.getDateConsultation().toString());
        pstm.setString(2, consultation.getDescription());
        pstm.setLong(3, consultation.getPatient().getId());
        pstm.executeUpdate();

    }

    @Override
    public void delete(Consultation consultation) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM CONSULTATION WHERE ID = ?");
        pstm.setLong(1, consultation.getId());
        pstm.executeUpdate();

    }

    @Override
    public List<Consultation> findAll() throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM CONSULTATION");
        ResultSet rs = pstm.executeQuery();
        List<Consultation> consultations = new ArrayList<>();

        while(rs.next()){
            Consultation consultation = new Consultation();
            consultation.setId(rs.getLong("ID"));
            consultation.setDateConsultation(rs.getDate("DATE_CONSULTATION"));
            consultation.setDescription(rs.getString("DESCRIPTION"));
            consultations.add(consultation);
        }
        return consultations;
    }

    @Override
    public Consultation findById(Long id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM CONSULTATION WHERE ID = ?");
        ResultSet rs = pstm.executeQuery();
        Consultation consultation = new Consultation();

        if(rs.next()){
            consultation.setId(rs.getLong("ID"));
            consultation.setDateConsultation(rs.getDate("DATE_CONSULTATION"));
            consultation.setDescription(rs.getString("DESCRIPTION"));
        }
        return consultation;
    }
}
