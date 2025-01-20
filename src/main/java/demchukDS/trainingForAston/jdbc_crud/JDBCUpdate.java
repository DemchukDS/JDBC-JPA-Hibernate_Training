package demchukDS.trainingForAston.jdbc_crud;

import java.sql.*;
import java.util.Scanner;

public class JDBCUpdate {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String DB_USER = "demchuk";
    static final String DB_PASSWORD = "demchuk";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter name: ");
            String enteredName = scanner.nextLine();

//          Небезопасный код
//            Statement statement = connection.createStatement();
//            String sqlQuery = "UPDATE students SET avg_grade = 7.5 " +
//                    "Where name = '" + enteredName + "'";
//
//            statement.executeUpdate(sqlQuery);
//
//            statement.close();
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE students SET avg_grade = 7.5 WHERE name = ?");
                    statement.setString(1, enteredName);
                    statement.executeUpdate();
                    statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

        PreparedStatement ps = null;
    }
}

