/*
McKenna Pasquale
Software Development 1
202420 - CEN - 3024C - 24667

Book class: sets up variables that will be used throughout other classes, creates what it means to be a book, and starts the toString methods to be edited in other classes.
 */


import java.io.Serializable;
//implement serializable so its easier to send to another system over the network.
public class Book implements Serializable {

//assigning variables
    private int barcode;
    private String title, author;

//making variables usable across project
    public Book() {
        barcode = 0;
        title = null;
        author = null;
    }
//creating collection of what is included in a book
    public Book(int barcode, String title, String author) {
        this.barcode = barcode;
        this.title = title;
        this.author = author;

    }
//defining text to be printed, which can be called and edited in other classes
    @Override
    public String toString() {
        //return string
        return "\nTitle: " + title + "\nAuthor: " + author + "\nBarcode: " + barcode + "/n";
    }


}


