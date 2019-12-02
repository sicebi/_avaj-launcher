package Aircraft;

import Tower.WeatherTower;
import main.Simulator;

public class Jetplane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    public Jetplane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    @Override
    public void updateConditions(){
        String FORCAST = weatherTower.getWeather(coordinates);
        if (FORCAST.equals("SUN"))
        {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getHeight(),coordinates.getLatitude() +2);
           Simulator.Display.println("JetPlane#" + name + "(" + id + "): " + "HOT hot hot hot hot");
        }
        if (FORCAST.equals("RAIN"))
        {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getHeight(),coordinates.getLatitude() +5);
            Simulator.Display.println("JetPlane#" + name + "(" + id + "): " + "Sea is licking ");
        }
        if (FORCAST.equals("FOG"))
        {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getHeight(),coordinates.getLatitude() +1);
            Simulator.Display.println("JetPlane#" + name + "(" + id + "): " + "Rastas is close by ");
        }
        if (FORCAST.equals("SNOW"))
        {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getHeight() - 7,coordinates.getLatitude());
            Simulator.Display.println("JetPlane#" + name + "(" + id + "): " + "Snow man is close by");
        }
    }
    @Override
    public void registerTower(WeatherTower weatherTower){

        this.weatherTower = weatherTower;
        weatherTower.register(this);
        Simulator.Display.println("Jetplane#" + this.name + "(" + this.id + ") registered to the tower.");

    }
}
