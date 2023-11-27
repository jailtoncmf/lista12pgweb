package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WebspringApplication {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/atv_menu";
        String user = "postgres";
        String password = "fifa16";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexão bem-sucedida!");

            inserirDados(connection);

            consultarDados(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void inserirDados(Connection connection) throws SQLException {
        String insertQuery = "INSERT INTO prato (id, nome, ingredientes, tipo_de_prato) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setInt(1, 3);
            preparedStatement.setString(2, "Milkshake");
            preparedStatement.setString(3, "Açúcar, Leite, Sorvete");
            preparedStatement.setString(4, "sobremesa");
            preparedStatement.executeUpdate();

           

            System.out.println("Dados inseridos com sucesso!");
        }
    }

    private static void consultarDados(Connection connection) throws SQLException {
        String selectQuery = "SELECT * FROM prato";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String ingredientes = resultSet.getString("ingredientes");
                String tipoDePrato = resultSet.getString("tipo_de_prato");

                System.out.println("ID: " + id + ", Nome: " + nome + ", Ingredientes: " + ingredientes + ", Tipo de Prato: " + tipoDePrato);
            }
        }
    }
}

