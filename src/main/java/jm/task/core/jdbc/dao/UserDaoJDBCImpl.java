package jm.task.core.jdbc.dao;
//
//import com.sun.xml.bind.v2.model.core.ID;
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import javax.persistence.Id;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoJDBCImpl implements UserDao {
//
//    public UserDaoJDBCImpl() {
//
//    }
//
//    public void createUsersTable() {
//        try (Connection connection = Util.getConnection()) {
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("CREATE TABLE IF NOT EXISTS users (`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY ,\n" +
//                    "  `name` varchar(45) NOT NULL,\n" +
//                    "  `lastname` varchar(45) NOT NULL,\n" +
//                    "  `age` int DEFAULT NULL)");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void dropUsersTable() {
//        try (Connection connection = Util.getConnection()) {
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("DROP TABLE IF EXISTS users");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        try (Connection connection = Util.getConnection()) {
//            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)");
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setInt(3, age);
//            preparedStatement.executeUpdate();
//            System.out.println("User с именем - " + name + " добавлен в базу данных");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void removeUserById(long id) {
//        try (Connection connection = Util.getConnection()) {
//            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    public List<User> getAllUsers() {
//        List<User> list = new ArrayList<>();
//        try (Connection connection = Util.getConnection()) {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT id, name, lastName, age FROM users");
//            while (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getLong("id"));
//                user.setName(resultSet.getString("name"));
//                user.setLastName(resultSet.getString("lastName"));
//                user.setAge(resultSet.getByte("age"));
//                list.add(user);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return list;
//
//    }
//
//    public void cleanUsersTable() {
//        try (Connection connection = Util.getConnection()) {
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("TRUNCATE TABLE users");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//}
