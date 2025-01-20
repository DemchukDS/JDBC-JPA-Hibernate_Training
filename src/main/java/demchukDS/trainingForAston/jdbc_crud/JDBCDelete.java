package demchukDS.trainingForAston.jdbc_crud;

import java.sql.*;

public class JDBCDelete {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String DB_USER = "demchuk";
    static final String DB_PASSWORD = "demchuk";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM students WHERE id = ?");
            statement.setInt(1, 2);
            int deletedRows = statement.executeUpdate();
            System.out.println("Deleted " + deletedRows + " rows");
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

