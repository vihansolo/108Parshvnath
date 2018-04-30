package ga.vihanggarud.www.a108parshvnath.Entity;

public class Temple {

    private String templeName;
    private String templeAddress;
    private String templeImageURI;
    private String templePhone;

    public Temple() {
    }

    public Temple(String templeName, String templeAddress, String templeImageURI, String templePhone) {
        this.templeName = templeName;
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
