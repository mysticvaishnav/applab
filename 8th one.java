import java.sql.*;
public class StudentDatabaseExample {
 public static void main(String[] args) {
 String dbUrl = "jdbc:mysql://localhost:3306/university";
 String dbUsername = "your_username";
 String dbPassword = "your_password";
 try {
 Class.forName("com.mysql.cj.jdbc.Driver");
 Connection connection = DriverManager.getConnection(dbUrl, dbUsername, 
dbPassword);
 Statement statement = connection.createStatement();
 String createTableQuery = "CREATE TABLE IF NOT EXISTS students (" +
 "id INT AUTO_INCREMENT PRIMARY KEY," +
 "name VARCHAR(100) NOT NULL," +
 "age INT NOT NULL," +
 "major VARCHAR(100) NOT NULL" +
 ")";
 statement.executeUpdate(createTableQuery);
 System.out.println("Table 'students' created successfully.");
 String insertQuery = "INSERT INTO students (name, age, major) VALUES 
('John Doe', 20, 'Computer Science')";
 int rowsAffected = statement.executeUpdate(insertQuery);
 if (rowsAffected > 0) {
 System.out.println("New student record added successfully!");
 } else {
 System.out.println("Failed to add a new student record.");
 }
 String selectQuery = "SELECT id, name, age, major FROM students";
 ResultSet resultSet = statement.executeQuery(selectQuery);
 System.out.println("\nStudent Records:");
 while (resultSet.next()) {
 int id = resultSet.getInt("id");
 String name = resultSet.getString("name");
 int age = resultSet.getInt("age");
 String major = resultSet.getString("major");
System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Major: " + 
major);
 }
 resultSet.close();
 statement.close();
 connection.close();
 } catch (ClassNotFoundException e) {
 System.err.println("Failed to load JDBC driver. Make sure you have added the 
JDBC library to the classpath.");
 e.printStackTrace();
 } catch (SQLException e) {
 System.err.println("Failed to connect to the database or execute the query.");
 e.printStackTrace();
 }
 }
}
