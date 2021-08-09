package manager;

import db.DBConnectionProvider;

import model.Admin;
import model.Clients;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClientManager {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();

    public boolean register(Clients clients) {
        String sql = "INSERT INTO client(name,surname,email,age,driver_license_number,car_id) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, clients.getName());
            statement.setString(2, clients.getSurName());
            statement.setString(3,clients.getEmail());
            statement.setInt(4, clients.getAge());
            statement.setString(5, clients.getDriverLicenseNumber());
            statement.setInt(6, clients.getCarID());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                clients.setId(generatedKeys.getInt(1));
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public Clients getByID(long id) {
        String sql = "SELECT * FROM client where id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return getClientsFromResultSet(resultSet);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    public Clients getByName(String name) {
        String sql = "SELECT * FROM client where email=? and password=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return getClientsFromResultSet(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Clients> getAllClients() {
        List<Clients> clients = new ArrayList<>();
        String sql = "SELECT * FROM client";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                clients.add(getClientsFromResultSet(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return clients;
    }

    private Clients getClientsFromResultSet(ResultSet resultSet) {
        try {
            return Clients.builder()
                    .id(resultSet.getInt(1))
                    .name(resultSet.getString(2))
                    .surName(resultSet.getString(3))
                    .email(resultSet.getString(4))
                    .age(resultSet.getInt(5))
                    .driverLicenseNumber(resultSet.getString(6))
                    .carID(resultSet.getInt(7))
                    .build();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void deleteUser(int id) {
        String sql = "DELETE FROM users where id=" + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

        public void updateClient(Clients client) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("Update client set car_id=null WHERE id=" + client.getId());
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Admin getByEmailAndPassword(String email, String password) {
        String sql = "SELECT * FROM admin where email=? and password=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Admin.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .surName(resultSet.getString(3))
                        .email(resultSet.getString(4))
                        .password(resultSet.getString(5))
                        .build();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Clients getByEmail(String email) {
        String sql = "SELECT * FROM client where email=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return getClientsFromResultSet(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
