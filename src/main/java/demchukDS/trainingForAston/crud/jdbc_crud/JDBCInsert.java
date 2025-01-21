package demchukDS.trainingForAston.crud.jdbc_crud;

import demchukDS.trainingForAston.crud.entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCInsert {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String DB_USER = "postgres";
    static final String DB_PASSWORD = "postgres";

    public static void main(String[] args) {
        Connection connection = null;
        Student student = new Student("Shane", "King", 9.1);

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO students(name, surname, avg_grade) VALUES (?, ?, ?)");
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setDouble(3, student.getAvgGrade());

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
