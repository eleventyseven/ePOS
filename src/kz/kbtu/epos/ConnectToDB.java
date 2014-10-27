package kz.kbtu.epos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.PreparedStatement;

public class ConnectToDB{
    public Double readDataBase(Long cid, int amount) throws Exception {
        String url = "jdbc:mysql://localhost:3306/javabase";
        String username = "java";
        String password = "d$7hF_r!9Y";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        //PreparedStatement preparedStatement = null;


        try {
            System.out.println("Connecting database...");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
            statement = connection.createStatement();

            resultSet = statement.executeQuery("select * from ACCOUNTS WHERE cid="+cid);

            double account = writeResultSet(resultSet);
            System.out.println(amount);
            return account;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect the database!", e);
        } finally {
            System.out.println("Closing the connection.");
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }
    }

    private Double writeResultSet(ResultSet resultSet) throws SQLException {
        // resultSet is initialised before the first data set
        while (resultSet.next()) {
            // it is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g., resultSet.getSTring(2);
            String user = resultSet.getString("user");
            Long cid = resultSet.getLong("cid");
            Double account = resultSet.getDouble("account");
            System.out.println("User: " + user);
            //System.out.println("CID: " + cid);
            //System.out.println("ACCOUNT: " + account);
            return account;
        }

        return null;
    }
}

/*class ConnectToDBTest {
    public static void main(String[] args) throws Exception {
        ConnectToDB dao = new ConnectToDB();
        dao.readDataBase();
    }

}*/