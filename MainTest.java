package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {

        Car[] cars = {
                new Car("Zaz968", 1969, 400000, "white"),
                new Car("Vaz2101", 1975, 600000, "red"),
                new Car("Gaz24", 1989, 300000, "black"),
                new Car("Kamaz5320", 1985, 120000, "green"),
        };

        Car c = new Car("Kamaz5320", 1985, 120000, "green");


        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File("car111111111.json"), c);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Car car = mapper.readValue(new File("car111111111.json"), Car.class);
            System.out.println(car);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            mapper.writeValue(new File("carы.json"), cars);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Car[] carss = mapper.readValue(new File("carы.json"), Car[].class);
            System.out.println(Arrays.toString(carss));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ArrayList<Car> carss = mapper.readValue(new File("carы.json"),
                    mapper.getTypeFactory().constructCollectionType(List.class, Car.class));
            System.out.println(carss);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
