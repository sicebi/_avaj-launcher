package Aircraft;


public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height)
    {
        longitude = longitude;
        latitude = latitude;
        height = height;
//        height = height < 0 ? 0 : height > 100 ? 100 : height;

    }
    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }
}
