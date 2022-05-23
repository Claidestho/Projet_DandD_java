package system.database;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Properties;

public class DatabaseConnection {

    Properties props = new Properties();


    public Connection connectDB() throws SQLException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("conf.properties");
        props.load(fis);
        String url = props.getProperty("jdbc.url");
        String login = props.getProperty("jdbc.login");
        String password = props.getProperty("jdbc.password");
        Class.forName(props.getProperty("jdbc.driver.class"));
        return DriverManager.getConnection(url, login, password);
    }

    public void listHeroesFromDB(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                System.out.println("***************************" +
                        "\nNom du héros : " + resultSet.getString("name") +
                        "\nClasse du héros : " + resultSet.getString("type") +
                        "\nPoints de vie : " + resultSet.getInt("health_points") +
                        "\nNiveau d'attaque : " + resultSet.getInt("attack_points") +
                        "\n***************************"
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet executeQueries(String query) {
        ResultSet resultSet = null;
        try {
            Statement statement = connectDB().createStatement();
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultSet;
    }

    public void updateDB(String query) {
        try {
            Statement statement = connectDB().createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
