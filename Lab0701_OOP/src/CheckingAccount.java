public class CheckingAccount extends Account{
    private double credit;
// default constructor 
    public CheckingAccount() {
        super(0, "");
        this.credit = 0;
    }

// constructor method
    public CheckingAccount(double balance, String name, double credit) {
        super(balance, name); //เรียกใช้ constructor ของแม่
        this.credit = credit;
    }
    
    public double getCredit() {
        return this.credit;
    }

    public void setCredit(double credit) {
        if (credit > 0) {
            this.credit = credit;
        }
        else {
            System.out.println("Input number must be positive integer.");
        }
        
    }
// override 2 method เขียนทีเดียวพอ
    @Override
    public void withdraw(double a) {
        if (getBalance() > a) {
            setBalance(getBalance() - a);
            System.out.println(a + " baht is withdrawn from " + this.name + " and your credit balance is " + this.credit + ".");
        }
        else if (this.balance - a + this.credit > 0) {
            this.balance = 0;
            System.out.println(a + " baht is withdrawn from " + this.name + " and your credit balance is " + this.credit + ".");
        }
        else {
            System.out.println("Not enough money!");
        }
    }
     
    public void withdraw(String a) {
        this.withdraw(Double.valueOf(a));
    }

    public String toString() {
        return "The " + getName() + " account has " + getBalance() + " baht and " + getCredit() + " credits.";
    }
}
