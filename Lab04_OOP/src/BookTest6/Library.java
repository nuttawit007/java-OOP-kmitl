package BookTest6;
public class Library {
    public String libraryName;
    public Book book1;
    public Book book2;
    public Book book3;
    
    public void addBook(Book book, int slot) {
        switch (slot){
            case 1:
                book1 = book;
                break;
            case 2:
                book2 = book;
                break;
            case 3:
                book3 = book;
                break;
        }
    }
    
    public void removeBook(int slot) {
        switch (slot){
            case 1:
                book1 = null;
                break;
            case 2:
                book2 = null;
                break;
            case 3:
                book3 = null;
                break;
        }
        
    }
    
    public void printLibraryDetails() {
        System.out.println("Library: " + libraryName);
        System.out.println("");
        printBookDetails(book1);
        System.out.println("");
        printBookDetails(book2);
        System.out.println("");
        printBookDetails(book3);
    }
    
    public void checkBookAvailability(int slot) {
        switch (slot) {
            case 1:
                if (book1 != null) {
                    System.out.println(book1.title + " is available.");
                }
            case 2:
                if (book2 != null) {
                    System.out.println(book2.title + " is available.");
                }
            case 3:
                if (book3 !=null) {
                    System.out.println(book3.title + " is available.");
                }
            default:
                System.out.println("Book in slot " + slot + " is not available.");
        }
    }
    
    public void updateBookPrice(int slot, double newPrice) {
        switch (slot) {
            case 1:
                if (book1 != null) {
                    book1.price = newPrice;
                    System.out.println("Update price of " + book1.title + "to $" + newPrice);
                    break;
                }
            case 2:
                if (book2 != null) {
                    book2.price = newPrice;
                    System.out.println("Update price of " + book2.title + "to $" + newPrice);
                }
                else {
                    System.out.println("No book in this solt.");
                }
                break;
            case 3:
                if (book3 !=null) {
                    book3.price = newPrice;
                    System.out.println("Update price of " + book3.title + "to $" + newPrice);
                    break;
                }
            default:
                System.out.println("No book in this slot.");
        }
    }
    
    public void printBookDetails(Book book) {
        if (book != null) {
            book.printDetails();
        }
        else {
            System.out.println("No book in this slot.");
        }
    }
}
