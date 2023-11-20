package ru.sberbank.edu;


import org.h2.tools.Server;
import ru.sberbank.edu.dbconnection.H2DbEmbedded;
import ru.sberbank.edu.repository.CarDbRepositoryImpl;
import ru.sberbank.edu.repository.CarRepository;
import ru.sberbank.edu.service.CarService;
import ru.sberbank.edu.service.CarServiceImpl;

import java.sql.ResultSet;
import java.sql.Statement;

public class CarBootstrap {
    public static void main(String[] args) throws Exception {
        Server server = Server.createTcpServer(args).start();
        H2DbEmbedded.initDb();

        try(H2DbEmbedded h2DbEmbedded = new H2DbEmbedded()) {
            CarRepository carRepository = new CarDbRepositoryImpl(H2DbEmbedded.getConnection());
            CarService carService = new CarServiceImpl(carRepository);

            carService.addCar("777", "Lada");
            carService.addCar("BMW", "x3");
            carService.addCar("BMV", "x3");
            carService.addCar("Suzuki", "Jimny");

            // Test check start
            String readAllCarsSql = "SELECT * FROM car";
            Statement statement = H2DbEmbedded.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(readAllCarsSql);

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String model = resultSet.getString(2);
                System.out.println("id=" + id + "; model=" + model);
            }

            carService.deleteCar("777");
            // Test check start


            ResultSet resultSet1 = statement.executeQuery(readAllCarsSql);

            while (resultSet1.next()) {
                String id = resultSet1.getString(1);
                String model = resultSet1.getString(2);
                System.out.println("id=" + id + "; model=" + model);
            }

            // Test end
        }
        server.stop();
    }
}
