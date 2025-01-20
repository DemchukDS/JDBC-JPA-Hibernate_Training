package demchukDS.trainingForAston.jdbc_crud;

import demchukDS.trainingForAston.entity.Student;

import java.sql.*;

public class JDBCInsert_v3 {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String DB_USER = "demchuk";
    static final String DB_PASSWORD = "demchuk";

    public static void main(String[] args) {
        Connection connection = null;
        Student student = new Student("David", "Vazovski", 7.3);

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO students(name, surname, avg_grade) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setDouble(3, student.getAvgGrade());

            int numberOfRows = statement.executeUpdate();

            if (numberOfRows == 0) {
                throw new SQLException("Failed to add student to the database");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                student.setId(generatedKeys.getLong(2));
            } else {
                throw new SQLException("Failed to create student ID");
            }
            System.out.println(student);

            statement.close();
            generatedKeys.close();
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
