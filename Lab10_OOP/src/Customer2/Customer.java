package Customer2;
public class Customer {
    private String firstName;
    private String lastName;
    private Account acct[];
    private int numOfAccount;

    public Customer() {
        this("", "");
        acct = new Account[5];
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        acct = new Account[5];
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
    
    public Account getAccount(int index){
        return acct[index];
    }

    public int getNumOfAccount(){
        return this.numOfAccount;
    }
    
    public void addAccount(Account acct){
        this.acct[numOfAccount] = acct; 
        numOfAccount += 1;
    }
    
    @Override
    public String toString() {
        for (int i = 0; i < acct.length ; i++){
            return getFirstName() + " " + getLastName() + " has " + getNumOfAccount() + " accounts.";
        }
        return null;
    }
    
    public boolean equals(Customer c) {
        return (this.getFirstName().equals(c.getFirstName())) && (this.getLastName().equals(c.getLastName()));
    }
}
