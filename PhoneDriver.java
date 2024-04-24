/**
 * @author: Nicolas Gugliemo
 * @date 11/29/2022
 * Assignment: Programming Assignment #4
 */

import java.io.File;
import java.util.Scanner;

/**
 * This class is used as a main file that uses the contact and phonebook classes
 * to run the program. It shows a menu for the user to select which method they
 * want to run on the phone book. It also includes an add and search method.
 */

public class PhoneDriver {
    public static PhoneBook phoneBook; // Phone book object that is used to create and work with the phonebook and its methods
    public static File details;        // File object that is used to send the file location to the phonebook constructor
    public static String menu;         // String to show menu options
    public static Scanner scan;        // Scanner object to take user input for menu selection.

    /**
     * The main function for the program. Does what is stated above for the class description
     * @param args Default param
     */
    public static void main(String[] args) {

        // Make new phone book object using file location
        phoneBook = new PhoneBook(details=new File("C:\\Users\\nicol\\OneDrive\\Desktop\\ContactDetails -1.txt\\"));

        // Menu string
        menu = """
                Phone Book Menu:
                P: Print PhoneBook
                B: Sort Phonebook By first Name
                L: Sort Phonebook by Last name
                S: Search Contact By Last Name
                A: Add Contact to Phonebook
                Q: Quit
                """;

        scan = new Scanner(System.in);      // Scanner object is made using system.in for input for menu selection
        String input;                       // String input to store user choice
        boolean run = true;                 // Boolean to make sure the user wants to keep making selections

        while (run) {           // While loop to keep making selections

            System.out.println(menu);
            System.out.println("Pick one of the options Above: ");      // Print the menu and ask the user to make a selection
            input = scan.nextLine().toUpperCase();

            switch (input){     // Switch statement to use user choice to make disposition

                case "P":
                    print();        // P will call the print method
                    break;

                case "B":
                    System.out.println("Sorting by first name\n");
                    phoneBook.bubbleSort();                             // B will sort the phonebook by first name using bubble sort
                    break;

                case "L":
                    System.out.println("Sorting by Last name\n");
                    phoneBook.selectionSort();                          // L will sort the phonebook by last name using selection sort
                    break;

                case "S":
                    search();       // S will call the search method
                    break;

                case "A":
                    add();          // A will call the add method
                    break;

                case "Q":
                    run =false;     // Q will set run to false and end the loop
                    break;

                default:
                    System.out.println("\nIncorrect Input, Please try again\n");        // Incorrect input is everything else entered
                    break;
            }
        }
        System.out.println("Have a Great Day!");    //Final statement
    }

    /**
     * Print method calls the phonebook class's toString method to print the phonebook
     */
    public static void print () {

        System.out.println(phoneBook);      // Prints phonebook
    }

    /**
     * Search method asks the user for the last name of the person they are looking for.
     * Takes input using scanners nextline and sends the input to the binarySearch method.
     * If true, this means the name was found and the contact is printed, if not contact not found
     * is printed for the user.
     */
    public static void search () {
        // Takes input from user
        System.out.println("Last Name of the person you are Searching for: ");
        Scanner user = new Scanner(System.in);
        String input = user.nextLine();

        if (phoneBook.binarySearch(input)) {         //If found, let user know

            System.out.println("Contact Found");
        } else {

            System.out.println("Contact Not Found"); //Not found, let user know
        }
    }

    /**
     * Add method asks the user a series of questions to fill in a new contact object.
     * The contact is made and sent to the phonebook and added using the add method from
     * the phonebook class.
     */
    public static void add() {

        String firstName,lastName,emailAddress;
        long homeNumber,officeNumber;               // Initializes the variables used in the contact object
        Scanner user = new Scanner(System.in);

        // Asks the user questions
        System.out.println("First name?");
        firstName = user.nextLine();

        System.out.println("Last name?");
        lastName = user.nextLine();

        System.out.println("email?");
        emailAddress = user.nextLine();

        System.out.println("home number?");
        homeNumber = Long.parseLong(user.nextLine());

        System.out.println("office number?");
        officeNumber =Long.parseLong(user.nextLine());

        Contact n = new Contact(firstName,lastName,homeNumber,officeNumber,emailAddress);       // Make new contact object and add it to the phonebook
        phoneBook.add(n);
    }
}