/**
 * This class is used to make contact objects for the phonebook to use. Each contact
 * consists of a first name, last name, home number, office number, and an email address.
 * Setters and getters are made for each variable and a toString method is made to print
 * the contact by column.
 */
public class Contact {

    // Variables used for contact information
    private String firstName;
    private String lastName;
    private long homeNumber;
    private long officeNumber;
    private String emailAddress;

    public Contact () {     // Default constructor

        this.firstName = "";
        this.lastName = "";
        this.homeNumber = 0;
        this.officeNumber = 0;
        this.emailAddress = "";
    }

    public Contact(String firstName, String lastName, long homeNumber, long officeNumber, String emailAddress) {        // Constructor used to make contact and fill in its fields.

        this.firstName = firstName;
        this.lastName = lastName;
        this.homeNumber = homeNumber;
        this.officeNumber = officeNumber;
        this.emailAddress = emailAddress;
    }

    /**
     * Gets first Name
     * @return First name
     */
    public String getFirstName() {

        return firstName;
    }

    /**
     * Sets first name
     * @param firstName Takes string to have change contacts first name
     */
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }
    /**
     * Gets Last Name
     * @return Last name
     */
    public String getLastName() {

        return lastName;
    }

    /**
     * Sets Last Name
     * @param lastName Takes string to have change contacts last name
     */
    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    /**
     * Gets Home number
     * @return Home number
     */
    public long getHomeNumber() {

        return homeNumber;
    }

    /**
     * Sets home number
     * @param homeNumber Takes long to have change contacts home number
     */
    public void setHomeNumber(long homeNumber) {

        this.homeNumber = homeNumber;
    }

    /**
     * Gets office number
     * @return office number
     */
    public long getOfficeNumber() {

        return officeNumber;
    }

    /**
     * Sets office number
     * @param officeNumber Takes long to have change contacts office number
     */
    public void setOfficeNumber(long officeNumber) {

        this.officeNumber = officeNumber;
    }

    /**
     * Gets Email address
     * @return Email address
     */
    public String getEmailAddress() {

        return emailAddress;
    }

    /**
     * Sets Email address
     * @param emailAddress Takes string to have change contacts Email address
     */
    public void setEmailAddress(String emailAddress) {

        this.emailAddress = emailAddress;
    }

    /**
     * Overrides string method to print out the contact in a nice format
     * @return Nothing, just a placeholder.
     */
    public String toString() {

        System.out.printf("%-16s %-16s %-16s %-16s %6s", firstName,lastName,homeNumber,officeNumber, emailAddress);     //Uses printf format to space out strings
        return "";
    }
}