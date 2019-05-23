package app.model.user;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "user")
public class User implements Serializable {

    private Name name;

    private String address;

    private String favorite;

    public User() {
    }

    public User(String firstName, String lastName, String address, String favorite) {
        this.name = new Name(firstName, lastName);
        this.address = address;
        this.favorite = favorite;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    @Override
    public String toString() {
        return "User{" +
                "name=" + name +
                ", address='" + address + '\'' +
                ", favorite='" + favorite + '\'' +
                '}';
    }
}
