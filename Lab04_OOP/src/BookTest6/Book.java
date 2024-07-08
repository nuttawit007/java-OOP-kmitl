package BookTest6;
public class Book {
    public String title;
    public String author;
    public String publisher;
    public int yearPublished;
    public double price;
    public boolean isAvailable;
    
    public void printDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publisher: " + publisher);
        System.out.println("Year Published: " + yearPublished);
        System.out.println("Price: $" + price);
        if (isAvailable == false) {
            System.out.println("Avaliable: No");
        }
        else {
            System.out.println("Avaliable: Yes");
        }
    }
    
    public void updatePrice(double newPrice) {
        price = newPrice;
    }
    
    public void markAsUnavailable() {
        isAvailable = false;
        
    }
    
    public void markAsAvailable() {
        isAvailable = true;
        
    }
    
    public boolean isPublishedAfter(int year) {
        return yearPublished > year;
    }
}
