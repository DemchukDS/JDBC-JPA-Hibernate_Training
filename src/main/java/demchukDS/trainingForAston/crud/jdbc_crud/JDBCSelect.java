package demchukDS.trainingForAston.crud.jdbc_crud;

import demchukDS.trainingForAston.crud.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCSelect {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String DB_USER = "demchuk";
    static final String DB_PASSWORD = "demchuk";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM students WHERE avg_grade > ?");
            statement.setDouble(1, 8.0);
            ResultSet resultSet = statement.executeQuery();

            List<Student> students = new ArrayList<Student>();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setAvgGrade(resultSet.getDouble("avg_grade"));
                students.add(student);
            }
            System.out.println(students);
            statement.close();
            resultSet.close();
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

