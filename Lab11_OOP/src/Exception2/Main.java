package Exception2;
public class Main {
    // 2.1 >> เกิด error เนื่องจากเงินไม่เพียงพอต่อการถอน
//    public static void main(String[] args) throws WithdrawException {
//        CheckingAccount acct1 = new CheckingAccount(1000, "A0001", 500);
//        Customer cust = new Customer("Sompong", "Sookjai", acct1);
//        cust.getAcct().deposit(500);
//        cust.getAcct().withdraw(1800);
//        cust.getAcct().withdraw(300);
//        cust.getAcct().deposit(1000);
//        cust.getAcct().withdraw(200);
//    }
    
    //2.2 >> ไม่ error เพราะมีการดัก try-catch ไว้
        public static void main(String[] args) throws WithdrawException {
            try {
                CheckingAccount acct1 = new CheckingAccount(1000, "A0001", 500);
                Customer cust = new Customer("Sompong", "Sookjai", acct1);
                cust.getAcct().deposit(500);
                cust.getAcct().withdraw(1800);
                cust.getAcct().withdraw(300);
                cust.getAcct().deposit(1000);
                cust.getAcct().withdraw(200);
            } catch (WithdrawException e) {
                System.out.println("WithdrawException: Account A0001 has not enough money!");
            } finally {
                System.out.println("Thank you.");
            }
                
    }
}
