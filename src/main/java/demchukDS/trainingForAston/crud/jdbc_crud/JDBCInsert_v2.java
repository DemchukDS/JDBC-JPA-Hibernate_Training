package demchukDS.trainingForAston.crud.jdbc_crud;

import demchukDS.trainingForAston.crud.entity.Student;

import java.sql.*;

public class JDBCInsert_v2 {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String DB_USER = "demchuk";
    static final String DB_PASSWORD = "demchuk";

    public static void main(String[] args) {
        Connection connection = null;
        Student student = new Student("Julia", "Dean", 8.8);

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            Statement statement = connection.createStatement();
            String sqlQuery = "INSERT INTO students(name, surname, avg_grade) VALUES " +
                    "('" + student.getName() +
                    "','" + student.getSurname() +
                    "'," + student.getAvgGrade() + ")";
            // в JDBC: INSERT INTO students(name, surname, avg_grade) VALUES ('Leo', 'Farrel', 6.8)

            statement.executeUpdate(sqlQuery);

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

