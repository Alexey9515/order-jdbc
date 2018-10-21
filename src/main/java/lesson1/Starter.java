package lesson1;

import java.sql.*;
import java.util.Properties;

public class Starter {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/internet_shop";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "root");

        try (Connection conn = DriverManager.getConnection(url, props)) {
            try (Statement statement = conn.createStatement()) {
                ResultSet resultSet = statement.executeQuery("select * from products");
                while (resultSet.next()) {
                    printProduct(resultSet);

                }
            }
            try (PreparedStatement preparedStatement = conn.prepareCall("select * from products where articale = ?")) {
                preparedStatement.setObject(1, 123456);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    printProduct(resultSet);
                }
            }
        }
    }

    private static void printProduct(ResultSet resultSet) throws SQLException {
        System.out.println("******************************************************************");
        System.out.println(String.format("Наименование: %s\nЦена: %s\nАртикль: %s"
                , resultSet.getObject("name")
                , resultSet.getObject("price")
                , resultSet.getObject("articale")));
        System.out.println("******************************************************************\n");
    }
}
