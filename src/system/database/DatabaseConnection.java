package system.database;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseConnection {

    Properties props = new Properties();


    public void connectDB() {



        try (FileInputStream fis = new FileInputStream("conf.properties")) {
            props.load(fis);

        } catch (IOException e) {
            e.printStackTrace();
            // handle exception correctly.
        }
        String url = props.getProperty("jdbc.url");
        String login = props.getProperty("jdbc.login");
        String password = props.getProperty("jdbc.password");

        try {
            Class.forName(props.getProperty("jdbc.driver.class"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(url, login, password)) {

            String sqlQuery = "INSERT INTO hero (id, type, name, health_points, attack_points, item)" +
                    "VALUES (1, 'Magicien', 'Merling', 6, 10, 'Nothing')";

            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(sqlQuery);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
