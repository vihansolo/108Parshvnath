package ga.vihanggarud.www.a108parshvnath.Entity;

public class Temple {

    private String templeName;
    private double latitude;
    private double longitude;
    private String templeAddress;
    private String templeImageURI;

    public Temple() {
    }

    public Temple(String templeName, double latitude, double longitude, String templeAddress, String templeImageURI) {
        this.templeName = templeName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.templeAddress = templeAddress;
        this.templeImageURI = templeImageURI;
    }

    public String getTempleName() {
        return templeName;
    }

    public void setTempleName(String templeName) {
        this.templeName = templeName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTempleAddress() {
        return templeAddress;
    }

    public void setTempleAddress(String templeAddress) {
        this.templeAddress = templeAddress;
    }

    public String getTempleImageURI() {
        return templeImageURI;
    }

    public void setTempleImageURI(String templeImageURI) {
        this.templeImageURI = templeImageURI;
    }
}
