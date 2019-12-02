package main;

import Aircraft.*;

public abstract class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitute, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitute, latitude, height);

        if (type.equalsIgnoreCase("JetPlane")){
           return new Jetplane(name, coordinates);
        }
        if (type.equalsIgnoreCase("Baloon")){
            return new Ballon(name, coordinates) ;
        }
        if (type.equalsIgnoreCase("Helicopter")){
            return new Helicopter(name, coordinates) ;
        }
        return null;
    }
}
