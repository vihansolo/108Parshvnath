package ga.vihanggarud.www.a108parshvnath.Entity;

public class Temple {

    private String templeName;
    private double lati;
    private double longi;
    private String templeAddress;
    private String templeImageURI;
    private String templePhone;

    public Temple() {
    }

    public Temple(String templeName, double lati, double longi, String templeAddress, String templeImageURI, String templePhone) {
        this.templeName = templeName;
        this.lati = lati;
        this.longi = longi;
        this.templeAddress = templeAddress;
        this.templeImageURI = templeImageURI;
        this.templePhone = templePhone;
    }

    public String getTempleName() {
        return templeName;
    }

    public void setTempleName(String templeName) {
        this.templeName = templeName;
    }

    public double getLati() {
        return lati;
    }

    public void setLati(double lati) {
        this.lati = lati;
    }

    public double getLongi() {
        return longi;
    }

    public void setLongi(double longi) {
        this.longi = longi;
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

    public String getTemplePhone() {
        return templePhone;
    }

    public void setTemplePhone(String templePhone) {
        this.templePhone = templePhone;
    }
}
