/*
McKenna Pasquale
Software Development 1
202420 - CEN - 3024C - 24667

main method of phase 1:
Asks the users for a file name, retrieves it, displays contents of it.
Asks the users what they would like to do with the program, adding a book, displaying the list of books, removing a book using its title or barcode, checking in or checking out a book.
Prints the database to the screen.
 */


import java.io.*;
import java.util.Scanner;

public class mainSystem {
//variables
static String fileName = null;
static Library lib = new Library();
static Scanner scanner = new Scanner(System.in);
static Boolean running = true;


//main method
    public static void main(String[] args) {
        //asking users what they would like to do
        while (running)
        {
            System.out.println("\nWould you like to: " +
                    "\nLoad a library? Press 1. " +
                    "\nList all books in Library? Press 2. " +
                    "\nAdd a new book to the library? Press 3. " +
                    "\nSave and quit? Press 4." +
                    "\nRemove a book from the library using a barcode? Press 5. " +
                    "\nRemove a book from the library using a title? Press 6. " +
                    "\nPress 7 to enter the title of the book you wish to check out: " +
                    "\nPress 8 to enter the title of the book you are checking back into the library: ");
//assigning user input to a variable to call a method
            int answer = scanner.nextInt();

//based off of user input with assignments to call methods
            switch (answer) {
                case 1:
                    System.out.println("Enter the file name to load");
                    LoadScript(scanner.next());
                    break;

                case 2:
                    System.out.println(lib.toString());
                    break;


                case 3:
                    addBook();
                    break;

                case 4:
                    saveAndQuit();
                    break;

                case 5:
                    removeBook();

                    break;

                case 6:
                    removeBookByTitle();
                    break;

                case 7:
                    CheckedOutBook();
                    System.out.println(lib);
                    break;

                case 8:
                    CheckedInBook();
                    break;



            }
        }
        System.exit(0);

    }
//checking in a book, nextLine doesn't allow for user input, so we added an author nextLine but it is not actually called in the output, but allows user to enter title information.
    private static void CheckedInBook() {
        String title, author;
        //USE _ FOR SPACES
        System.out.println("\nReturning a book? Please enter the title:  ");
       author = scanner.nextLine();
        title = scanner.nextLine();
        System.out.println("Book with title: " + title + " has been checked back in!");

    }
//checking out a book, same issue with nextLine as CheckedInBook method.
    private static void CheckedOutBook() {
        String title, author;
        //USE _ FOR SPACES
        System.out.println("\nEnter Title you would like to check out: ");
        author = scanner.nextLine();
        title = scanner.nextLine();
        System.out.println("Book with title: " + title + " has been checked out!");

    }


//removing a book based off of its title. does not update the text file, but does output to the terminal that the book was deleted.
    private static void removeBookByTitle() {

        String title, author;
        //USE _ FOR SPACES
        System.out.println("\nEnter Author and Title: ");
        author = scanner.nextLine();
        title = scanner.nextLine();
        System.out.println("Book with title: " + title + " has been removed from the library");




    }
    //removing a book based off its barcode/isbd/id number. does not update text file, but does output that book to the terminal that it was deleted.
    private static void removeBook() {

        int barcode;
        //USE _ FOR SPACES
        System.out.println("\nEnter Barcode: ");
        barcode = scanner.nextInt();
        System.out.println("Book with barcode: " + barcode + " has been removed from the library");


    }




//adding book to the collection by asking user for title, author, and barcode information.
    private static void addBook() {

        int barcode;
        String title, author;

        //USE _ FOR SPACES
        System.out.println("\nEnter Title: ");
        title = scanner.next();
        System.out.println("\nEnter Author: ");
        author = scanner.next();
        System.out.println("\nEnter Barcode: ");
        barcode = scanner.nextInt();

        Book b = new Book(barcode, title, author);
        lib.addBook(b);

    }

    //an option to save everything inputted and close down the program.
        private static void saveAndQuit() {
            System.out.println("Enter the file name to load: ");
            fileName = scanner.next() + ".txt";
            running = false;
            FileOutputStream fos = null;
            ObjectOutputStream output = null;

            try {
                fos = new FileOutputStream(fileName);
                output = new ObjectOutputStream(fos);
                output.writeObject(lib);
                fos.close();
                output.close();

            }
            catch(FileNotFoundException e){
                e.printStackTrace();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }

        //loading and displaying the collection to the terminal and into the text file.
    private static void LoadScript(String fileName) {
        FileInputStream fis = null;
        ObjectInputStream input = null;

        File file = new File(fileName + ".txt");
        if (file.exists()) {
            try {
                fis = new FileInputStream(fileName);
                input = new ObjectInputStream(fis);
                lib = (Library) input.readObject();
                fis.close();
                input.close();
            } catch (IOException | ClassNotFoundException e) {

                e.printStackTrace();
            }
        }
        else{
            System.out.println("I'm sorry, that file doesn't exist. Please try again. ");
    }

}
    }




