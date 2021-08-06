package manager;

import db.DBConnectionProvider;
import model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();

    public boolean addCar(Car car) {
        String sql = "INSERT INTO cars(brand,model,year,mator_volume,pic_url,price,rented) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, car.getBrand());
            statement.setString(2, car.getModel());
            statement.setInt(3, car.getYear());
            statement.setDouble(4, car.getMatorVolume());
            statement.setString(5, car.getPicUrl());
            statement.setDouble(6, car.getPrice());
            statement.setBoolean(7, car.isRented());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                car.setId(generatedKeys.getInt(1));
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Car getByID(int id) {
        String sql = "SELECT * FROM cars where id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return getCarsFromResultSet(resultSet);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Car> getByUserId(int id) {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars where user_id=" + id;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                cars.add(getCarsFromResultSet(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cars;
    }


//    public User getByEmailAndPassword(String email, String password) {
//        String sql = "SELECT * FROM users where email=? and password=?";
//        try {
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, email);
//            statement.setString(2, password);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                return getUsersFromResultSet(resultSet);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return null;
//    }

    public Car getByBrand(String brand) {
        String sql = "SELECT * FROM cars where brand=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, brand);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return getCarsFromResultSet(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                cars.add(getCarsFromResultSet(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cars;
    }

    private Car getCarsFromResultSet(ResultSet resultSet) {
        try {
            return Car.builder()
                    .id(resultSet.getInt(1))
                    .brand(resultSet.getString(2))
                    .model(resultSet.getString(3))
                    .year(resultSet.getInt(4))
                    .matorVolume((resultSet.getDouble(5)))
                    .picUrl(resultSet.getString(6))
                    .price(resultSet.getDouble(7))
                    .rented(resultSet.getBoolean(8))
                    .build();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void deleteCars(int id) {
        String sql = "DELETE FROM cars where id=" + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateCar(Car car) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("Update cars set rented='1' WHERE id=" + car.getId());
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCars(Car car) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("Update cars set rented='0' WHERE id=" + car.getId());
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }

