package app.model.food;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ramen")
public class Ramen {

    private String taste;

    private String area;

    public Ramen() {
    }

    public Ramen(String taste, String area) {
        this.taste = taste;
        this.area = area;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
