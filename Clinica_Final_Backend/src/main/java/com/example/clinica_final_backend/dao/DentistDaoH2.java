package com.example.clinica_final_backend.dao;

import com.example.clinica_final_backend.model.Dentist;
import org.apache.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DentistDaoH2 implements IDao<Dentist> {

    public final static Logger logger = Logger.getLogger(DentistDaoH2.class.toString());

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/dentist;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    public final static String SQL_INSERT = "INSERT INTO dentists (registrationNumber, firstName, lastName) VALUES (?,?,?)";
    public final static String SQL_SELECT = "SELECT * FROM dentists WHERE id = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM dentists";

    public DentistDaoH2() {}

    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DB_JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

    }

    @Override
    public Dentist register(Dentist dentist) {
        Connection connection;

        try {
            connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(SQL_INSERT);
            pstmt.setInt(1, Dentist.getRegistrationNumber());
            pstmt.setString(2, Dentist.getFirstName());
            pstmt.setString(3, Dentist.getLastName());

            pstmt.executeUpdate();
            pstmt.close();

        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error("ERROR: Please make sure you're inserting the data correctly");

        }
        logger.info(Dentist.getLastName() + ", " + Dentist.getFirstName() + " " + "with registration number: " +
                Dentist.getRegistrationNumber() + ", " + " has been successfully added to the data base.");

        return dentist;
    }

    public Dentist findById(Integer id) {
        Connection connection;
        Dentist answer = null;

        try {
            connection = getConnection();

            PreparedStatement pstmt = connection.prepareStatement(SQL_SELECT);

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                answer = new Dentist(rs.getInt("id"),
                        rs.getInt("registrationNumber"),
                        rs.getString("firstName"),
                        rs.getString("lastName"));
            }
            System.out.println(answer);
            pstmt.close();

        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error("ERROR: The id you are looking for cannot be found, please retry." + e);
        }
        logger.info("The id requested was found.");

        return answer;
    }

    @Override
    public List<Dentist> showAll() {

        Connection connection;
        List<Dentist> dentists = new ArrayList<>();

        try {
            connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(SQL_SELECT_ALL);

            ResultSet result = pstmt.executeQuery();

            while (result.next()){
                Integer id = result.getInt("id");
                Integer registrationNumber = result.getInt("registrationNumber");
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                dentists.add(new Dentist(id, registrationNumber,firstName, lastName));

            }
            logger.info("Here's the full list of all registered odontologists" );
            pstmt.close();

        }
        catch (Exception e){
            e.printStackTrace();
            logger.error("Failed to connect to the database, please retry later.", e);

        }

        return dentists;

    }

}