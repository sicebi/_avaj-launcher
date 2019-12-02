package WeatherProvider;

import Aircraft.Coordinates;

public class WeatherProvider {

    private static WeatherProvider weatherprovider = new WeatherProvider();
    private static  String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider(){
    }

    public static WeatherProvider getProvider(){
        return weatherprovider;

    }

    public String getCurrentWeather(Coordinates coordinates){
        int index = (coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude()) % 4;
        for (int c=0; index > 3; c++){
            index %= 4;
        }
        return weather[index];
    }

}
