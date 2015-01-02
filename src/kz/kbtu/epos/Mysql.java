package kz.kbtu.epos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.PreparedStatement;



public class Mysql {
    private static Connection getDBConnection() {
        String DB_DRIVER = "com.mysql.jdbc.Driver";
        String DB_USER = "java";
        String DB_PASSWORD = "d$7hF_r!9Y";
        String DB_CONNECTION = "jdbc:mysql://localhost:3306/javabase";

        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    private static void createDbUserTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = "CREATE TABLE ACCOUNTS (\n" +
                "\tid INT NOT NULL AUTO_INCREMENT,\n" +
                "\tUSER VARCHAR(30) NOT NULL,\n" +
                "\tCID BIGINT(16) NOT NULL,\n" +
                "\tACCOUNT DOUBLE(10,2),\n" +
                "\tPRIMARY KEY (id));";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table \"dbuser\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }


    private static void selectTableSQL() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String selectTableSQL = "SELECT USER, CID from ACCOUNTS";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);

            // И если что то было получено то цикл while сработает
            while (rs.next()) {
                String userid = rs.getString("USER");
                String cid = rs.getString("CID");

                System.out.println("userid : " + userid);
                System.out.println("cid : " + cid);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] argv) {
        try {
            createDbUserTable();
            selectTableSQL();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
