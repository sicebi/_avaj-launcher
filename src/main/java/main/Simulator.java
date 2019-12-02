package main;

import java.io.*;
import java.util.ArrayList ;
import java.util.List;

import Aircraft.Flyable;
import Tower.WeatherTower;

public class Simulator {

    public static PrintWriter Display;
    private static List<Flyable> flyables = new ArrayList<>();

    public static void main(String[] args) {
        WeatherTower weatherTower = new WeatherTower();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            Display = new PrintWriter(new FileWriter("simulation.txt"));
            String line = reader.readLine();
            if (line == null) return;
            int Run = Integer.parseInt(line.split(" ")[0]);
            if (Run < 0) {
                System.out.println("Invalid simulations count: " + Run);
                System.exit(1);
            }
            while ((line = reader.readLine()) != null) {
                Flyable flyable = AircraftFactory.newAircraft(
                        line.split(" ")[0], line.split(" ")[1],
                        Integer.parseInt(line.split(" ")[2]),
                        Integer.parseInt(line.split(" ")[3]),
                        Integer.parseInt(line.split(" ")[4]));
                if (flyable == null) {
                    System.err.println("Error : invalid aircraft type");
                    System.exit(1);
                }
                flyables.add(flyable);
            }
            for (Flyable flyable : flyables) {
                flyable.registerTower(weatherTower);
            }
            for (int i = 0; i < Run; i++) {
                weatherTower.changeWeather();
            }

        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.err.println("Error : the file does not exist or is invalid.");
        } finally {
            if (Display != null)
                Display.close();
        }
  }
}
