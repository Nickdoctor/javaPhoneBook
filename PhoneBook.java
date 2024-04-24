import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * This class is the main part of the program. It handles most of the functions,
 * creates the array list that stores the contact objects, and has all the sorting
 * and searching methods used in the program.
 */
public class PhoneBook {
    public ArrayList<Contact> contacts;     // Creates an array list of type contact object

    public PhoneBook () {

        contacts = new ArrayList<>();       // Default constructor if the file is not passed
    }
    public PhoneBook (File file) {          // Main constructor that has a file passed to it, reads from the file,
                                            // and creates the arraylist that is used for the phonebook
        contacts =new ArrayList<>();
        Scanner fileReader =null;           // Makes a new array list called contacts and a file reader scanner

        try {

            fileReader = new Scanner(file);     // Try to make a scanner that can read from the file if it exists

        } catch (FileNotFoundException e) {     // If the file is not found, throw a new filenotfound exception and tell user

            System.out.println("File was not found! ");
        }
        String firstName,lastName,emailAddress;     // Initializes strings and longs that are used to set the files contents to
        long homeNumber,officeNumber;

        while (fileReader.hasNextLine()) {      // While there are lines to be read from file

            String inLine=fileReader.nextLine();
            String[] tokens = inLine.split(",");     //Create a temp array to store all the strings that are split up by ,

            firstName = tokens[0];

            lastName = tokens[1];

            if (tokens[2].equalsIgnoreCase("-")) {      // If there is an -, that means there is no number, so set to 0, if not set to what is there
                homeNumber =0;
            } else {
                homeNumber = Long.parseLong(tokens[2]);
            }

            if (tokens[3].equalsIgnoreCase("-")) {       // If there is an -, that means there is no number, so set to 0, if not set to what is there
                officeNumber =0;
            } else {
                officeNumber = Long.parseLong(tokens[3]);
            }

            emailAddress =tokens[4];

            contacts.add(new Contact(firstName,lastName,homeNumber,officeNumber,emailAddress));     // Add the new contact object to the contacts list
        }
    }

    /**
     * Add method takes a contact object and adds it to the contacts list (To the back)
     * @param c Contact object that is passed to be added
     */
    public void add(Contact c){

        contacts.add(c);
    }

    /**
     * Overrides the toString method for phonebook to print the contents of the contacts list, one by one
     * calling that contacts toString method. This is done by looping through the contents of the list,
     * creating a phonebook style print to the user.
     * @return Nothing, just a placeholder
     */
    public String toString(){

        System.out.printf("%-16s %-16s %-16s %-16s %6s", "First Name","Last Name", "Home Number","Office Number", "Email Address");     //Print labels for columns
        System.out.println();

        for (int i =0; i<contacts.size(); i++) {        // Loops through the list and prints each contact

            System.out.println(contacts.get(i));
        }

        return "";
    }

    /**
     * Bubble sort method sorts the phonebook by first name using the bubble sort algorithm.
     * This is done by comparing the first name of the contact and the contact to the right of it,
     * swapping places if the current first name is higher in the alphabet than the one on its right.
     * This continues until the whole list is covered twice O(N^2)
     */
    public void bubbleSort(){

        for (int i=0; i<contacts.size()-1; i++) {           // For loop to cover the whole list

            for (int j=0; j<contacts.size()-i-1; j++) {     // For loop for each individual element in the list

                if(contacts.get(j).getFirstName().compareToIgnoreCase(contacts.get(j+1).getFirstName())>0){     //If the word on the left is higher than the number on the right, swap places

                    Collections.swap(contacts,j,j+1);
                }
            }
        }
    }

    /**
     * Selection sort method sorts the phonebook by last name using the selection sort algorithm. This works by
     * starting at the first last name in the list, and compares it to all the other names looking for the smallest
     * one. When found, it swaps positions and moves to the next name in the list. Repeat until we reach the end of the
     * list.
     */
    public void selectionSort() {

        int size = contacts.size();     // Size of contacts is saved for use
        int min;

        for (int i =0; i<size-1; i++) {     // Start at front of the list

            min = i;

            for (int j = i+1; j<size; j++) {        // Look for the smallest name then save the index to switch

                int compare = contacts.get(j).getLastName().compareToIgnoreCase(contacts.get(min).getLastName());

                if (compare < 0) {      // If the name is smaller, save this index

                    min =j;
                }
            }
            Collections.swap(contacts,i,min);
        }
    }

    /**
     * Binary Search method is used to find a last name in the phone book using the bintray search algorithm.
     * This works by first checking if the list is too big to run binary since it is a long run time. It starts
     * at the middle name in the list, then checks to see if that is the name we are looking for. If we find the name
     * return it, if not adjust the min and max index depending on if the name checked is higher or lowered than the
     * name we are looking for.
     * @param lastName The name we're looking for
     * @return The name if found
     */
        public boolean binarySearch( String lastName){

        if (this.contacts.size()>=0) {      //Checks if a list exists

            if(this.contacts.size() >14) {      //If the list is too big, don't run this method

                this.selectionSort();
            }

            int foundIndex, min=0,max=contacts.size()-1;

            while(min<=max){        //While the indexes don't cross

                int middle =(min+max)/2;
                int current = lastName.compareToIgnoreCase(String.valueOf(contacts.get(middle).getLastName()));

                if (current ==0) {
                    System.out.println(contacts.get(middle).toString());
                    return true;

                } else if (current <0) {

                    max =middle -1;
                } else {

                    min =middle +1;
                }
            }
        }
            return false;
        }
}
