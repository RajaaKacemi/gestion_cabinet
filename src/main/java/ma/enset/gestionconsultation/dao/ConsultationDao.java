package ma.enset.gestionconsultation.dao;

import ma.enset.gestionconsultation.entities.Consultation;
import ma.enset.gestionconsultation.entities.Patient;

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
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO CONSULTATIONS(DATE_CONSULTATION, DESCRIPTION, ID_PATIENT)" + "VALUES(?,?,?)");
            pstm.setDate(1,consultation.getDateConsultation());
            pstm.setString(2,consultation.getDescription());
            pstm.setLong(3,consultation.getPatient().getId());
            pstm.executeUpdate();
    }

    @Override
    public void update(Consultation consultation) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("Update CONSULTATIONS SET DATE_CONSULTATION=?,DESCRIPTION=? ,ID_PATIENT=?  WHERE ID_CONSULTATION=?");
        pstm.setDate(1,consultation.getDateConsultation());
        pstm.setString(2,consultation.getDescription());
        pstm.setLong(3, consultation.getPatient().getId());
        pstm.setLong(4,consultation.getId());
        pstm.executeUpdate();
    }

    @Override
    public void delete(Consultation consultation) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM CONSULTATIONS WHERE ID_CONSULTATION=?");
        pstm.setLong(1,consultation.getId());
        pstm.executeUpdate();
    }


    @Override
    public List<Consultation> findAll() throws SQLException {
        List<Consultation> consultations = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        String query = "SELECT * FROM CONSULTATIONS";
        PreparedStatement pstm = connection.prepareStatement(query);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            Consultation consultation = new Consultation();
            consultation.setId(rs.getLong("ID_CONSULTATION"));
            consultation.setDateConsultation(rs.getDate("DATE_CONSULTATION"));
            consultation.setDescription(rs.getString("DESCRIPTION"));

            Patient patient = new Patient();
            patient.setId(rs.getLong("ID_PATIENT"));
            consultation.setPatient(patient);

            consultations.add(consultation);
        }

        return consultations;
    }

    @Override
    public Consultation findbyId(Long id) throws SQLException {
        return null;
    }


}
