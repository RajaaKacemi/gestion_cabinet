package com.enset.java_avance_tp_findemodule.DAO;

import com.enset.java_avance_tp_findemodule.connection.BDConnection;
import com.enset.java_avance_tp_findemodule.entities.Patient;
import com.enset.java_avance_tp_findemodule.interfaces.IpatientDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO implements IpatientDAO {
    @Override
    public void insert(Patient patient) throws SQLException {
Connection connection= BDConnection.getConnection();
PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO PATIENT(NOM, PRENOM, TEL)"
        + "VALUES(?, ?, ?)");
preparedStatement.setString(1,patient.getFirstName());
preparedStatement.setString(2,patient.getLastName());
preparedStatement.setString(3, patient.getTel());
preparedStatement.execute();



    }

    @Override
    public void update(Patient patient) throws SQLException {
Connection connection= BDConnection.getConnection();
PreparedStatement psm= connection.prepareStatement("UPDATE PATIENT SET NOM = ?, PRENOM = ?, TEL = ? WHERE ID = ?");
        psm.setString(1,patient.getFirstName());
psm.setString(2,patient.getLastName());
psm.setString(3,patient.getTel());
psm.setLong(4,patient.getId());
psm.execute();
    }

    @Override
    public void delete(Patient patient) throws SQLException {
Connection connection= BDConnection.getConnection();
PreparedStatement psm=connection.prepareStatement("DELETE FROM PATIENT WHERE ID = ?");
        psm.setLong(1,patient.getId());
psm.execute();
    }

    @Override
    public List<Patient> getAll() throws SQLException {
        Connection connection= BDConnection.getConnection();

        PreparedStatement psm=connection.prepareStatement("SELECT * FROM PATIENT");
        ResultSet rs =psm.executeQuery();
        List<Patient> patients=new ArrayList<>();
        while (rs.next()){
            Patient patient=new Patient();
            patient.setId(rs.getLong("ID"));
            patient.setFirstName(rs.getString("NOM"));
            patient.setLastName(rs.getString("PRENOM"));
            patient.setTel(rs.getString("TEL"));
            patients.add(patient);

        }

        return patients;
    }

    @Override
    public Patient getById(Long id) throws SQLException {

        Connection connection= BDConnection.getConnection();
        PreparedStatement psm=connection.prepareStatement("SELECT * FROM PATIENT WHERE ID = ?");
        psm.setLong(1,id);
        ResultSet rs =psm.executeQuery();
        Patient patient=new Patient();
        while (rs.next()){
            patient.setId(rs.getLong("ID"));
            patient.setFirstName(rs.getString("NOM"));
            patient.setLastName(rs.getString("PRENOM"));
            patient.setTel(rs.getString("TEL"));

        }
        return patient;
    }
}
