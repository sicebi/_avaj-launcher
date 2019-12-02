package Aircraft;

import Tower.WeatherTower;
import main.Simulator;


public class Ballon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;
    public Ballon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    @Override
    public void updateConditions(){
        String FORCAST = weatherTower.getWeather(coordinates);
        if (FORCAST.equals("SUN"))
        {
           coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getHeight() + 4,coordinates.getLatitude());
           Simulator.Display.println("Ballon#" + name + "(" + id + "): " + "Satan Is Cooking some fries");

        }
        if (FORCAST.equals("RAIN"))
        {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getHeight() -5,coordinates.getLatitude());
            Simulator.Display.println("Ballon#" + name + "(" + id + "): " + "God close the Tap");
        }
        if (FORCAST.equals("FOG"))
        {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getHeight() -3,coordinates.getLatitude());
            Simulator.Display.println("Ballon#" + name + "(" + id + "): " + "Some one Burn Something smoke all over the place");
        }
        if (FORCAST.equals("SNOW"))
        {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getHeight() - 15,coordinates.getLatitude());
            Simulator.Display.println("Ballon#" + name + "(" + id + "): " + "Ice cream is falling from the sky");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower){

            this.weatherTower = weatherTower;
            weatherTower.register(this);
        Simulator.Display.println("Balloon#" + this.name + "(" + this.id + ") registered to the tower.");

    }

}
