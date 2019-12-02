package Tower;

import Aircraft.Coordinates;
import WeatherProvider.WeatherProvider;

public class WeatherTower extends Tower {

public String getWeather(Coordinates coordinates){
    return WeatherProvider.getProvider().getCurrentWeather(coordinates);
}
public void changeWeather(){
    conditionChange();
}

}
