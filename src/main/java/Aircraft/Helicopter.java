package Aircraft;

import Tower.WeatherTower;
import main.Simulator;

public class Helicopter extends Aircraft implements Flyable  {
    private WeatherTower weatherTower;
    public Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    @Override
    public void updateConditions(){
        String FORCAST = weatherTower.getWeather(coordinates);
        if (FORCAST.equals("SUN"))
        {
            coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getHeight() + 2,coordinates.getLatitude());
           Simulator.Display.println("Helicopter#" + name + "(" + id + "): " + "summer lets go to Durban and swim");
        }
        if (FORCAST.equals("RAIN"))
        {
            coordinates = new Coordinates(coordinates.getLongitude() +5, coordinates.getHeight(),coordinates.getLatitude());
            Simulator.Display.println("Helicopter##" + name + "(" + id + "): " + "nice weather to make budle of Joy");
        }
        if (FORCAST.equals("FOG"))
        {
            coordinates = new Coordinates(coordinates.getLongitude() +1, coordinates.getHeight(),coordinates.getLatitude());
            Simulator.Display.println("Helicopter##" + name + "(" + id + "): " + "Gas is all over the place");
        }
        if (FORCAST.equals("SNOW"))
        {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getHeight() - 12,coordinates.getLatitude());
            Simulator.Display.println("Helicopter##" + name + "(" + id + "): " + "White weather");
        }
    }
    @Override
    public void registerTower(WeatherTower weatherTower){

        this.weatherTower = weatherTower;
        weatherTower.register(this);
            Simulator.Display.println("Helicopter#" + this.name + "(" + this.id + ") registered to the tower.");
        }
}
