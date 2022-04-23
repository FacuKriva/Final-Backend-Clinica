package com.example.clinica_final_backend.dao;

import com.example.clinica_final_backend.model.Odontologist;
import org.apache.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologistDaoH2 implements IDao<Odontologist> {

    public final static Logger logger = Logger.getLogger(OdontologistDaoH2.class.toString());

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/odont;INIT=RUNSCRIPT FROM 'classpath:create.sql'";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    public final static String SQL_INSERT = "INSERT INTO odontologists (registrationNumber, name, surname) VALUES (?,?,?)";
    public final static String SQL_SELECT = "SELECT * FROM odontologists WHERE id = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM odontologists";

    public OdontologistDaoH2() {}

    private static Connection getConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName(DB_JDBC_DRIVER).newInstance();
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

    }

    @Override
    public Odontologist register(Odontologist odontologist) {
        Connection connection;

        try {
            connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(SQL_INSERT);
            pstmt.setInt(1, Odontologist.getRegistrationNumber());
            pstmt.setString(2, Odontologist.getName());
            pstmt.setString(3, Odontologist.getSurname());

            pstmt.executeUpdate();
            pstmt.close();

        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error("ERROR: Please make sure you're inserting the data correctly");

        }
        logger.info(Odontologist.getSurname() + ", " + Odontologist.getName() + " " + "with registration number: " +
                Odontologist.getRegistrationNumber() + ", " + " has been successfully added to the data base.");

        return odontologist;
    }

    public Odontologist findById(Integer id) {
        Connection connection;
        Odontologist answer = null;

        try {
            connection = getConnection();

            PreparedStatement pstmt = connection.prepareStatement(SQL_SELECT);

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                answer = new Odontologist(rs.getLong("id"),
                        rs.getInt("registrationNumber"),
                        rs.getString("name"),
                        rs.getString("surname"));
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
    public List<Odontologist> showAll() {

        Connection connection;
        List<Odontologist> odontologists = new ArrayList<>();

        try {
            connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(SQL_SELECT_ALL);

            ResultSet result = pstmt.executeQuery();

            while (result.next()){
                Long id = result.getLong("id");
                Integer registrationNumber = result.getInt("registrationNumber");
                String name = result.getString("name");
                String surname = result.getString("surname");
                odontologists.add(new Odontologist(id, registrationNumber, name, surname));

            }
            logger.info("Here's the full list of all registered odontologists" );
            pstmt.close();

        }
        catch (Exception e){
            e.printStackTrace();
            logger.error("Failed to connect to the database, please retry later.", e);

        }

        return odontologists;

    }

}