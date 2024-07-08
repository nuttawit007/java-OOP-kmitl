package Bank1;
public class Customer {
    private String firstName;
    private String lastName;
    private CheckingAccount acct;

    public Customer() {
        this("", "", null);
    }

    public Customer(String firstName, String lastName) {
        this(firstName, lastName, null);
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.acct = null;
    }
    
    public Customer(String firstName, String lastName, CheckingAccount acct) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.acct = acct;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CheckingAccount getAcct() {
        return acct;
    }

    public void setAcct(CheckingAccount acct) {
        this.acct = acct;
    }
    
    
    public String toString() {
        if (getAcct() == null) {
            return getFirstName() +" "+ getLastName() + " doesn’t have account.";
        }
        else {
            return "The " + getFirstName() + " account has " + acct.getBalance() + " baht and " + acct.getCredit() + " credits.";
        }
    }
    
    public boolean equals(Customer c) {
        return (this.getFirstName().equals(c.getFirstName())) && (this.getLastName().equals(c.getLastName()));
    }
}
