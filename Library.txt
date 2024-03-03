/*
McKenna Pasquale
Software Development 1
202420 - CEN - 3024C - 24667


Library class: builds the collection list of the database and creates methods to display list, add books to the list, and delete books from the list.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library extends Object implements Serializable {
//creates list of books
    private List<Book> collection;
//makes it public/usable and transforms it into an array list so we can call to it better
    public Library(){
         collection = new ArrayList<Book>();
    }
//adding books to the collection-used more in mainSystem
    public void addBook(Book book){

        collection.add(book);
    }
//removing books from the collection -used more in mainSystem
public void removeBook(Book book){
        collection.remove(book);
}




//output text
    @Override
    public String toString(){
        String total = "\n";
        Iterator<Book> i = collection.iterator();
        while(i.hasNext()){
            Book b = (Book)i.next();
            total = total + b.toString();

        }
        return total;
    }
}
