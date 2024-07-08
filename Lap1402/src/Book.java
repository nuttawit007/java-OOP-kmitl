import java.io.Serializable;
public class Book implements Serializable {

    private String name;
    private double price;
    private String type;

    public Book() {
        this("", 0, "");
    }

    public Book(String name, double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

}
