package Collection3;
import java.util.*;
public class Customer {
    private String firstName;
    private String lastName;
    private ArrayList <Account> acct;
    private int numOfAccount;

    public Customer() {
        this("", "");
        acct = new ArrayList();
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        acct = new ArrayList();
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
        return acct.get(index);
    }

    public int getNumOfAccount(){
        return this.numOfAccount;
    }
    
    public void addAccount(Account acct){
        this.acct.add(acct);
        numOfAccount += 1;
    }
    
    @Override
    public String toString() {
        for (int i = 0; i < acct.size() ; i++){
            return getFirstName() + " " + getLastName() + " has " + getNumOfAccount() + " accounts.";
        }
        return null;
    }
    
    public boolean equals(Customer c) {
        return (this.getFirstName().equals(c.getFirstName())) && (this.getLastName().equals(c.getLastName()));
    }
}
