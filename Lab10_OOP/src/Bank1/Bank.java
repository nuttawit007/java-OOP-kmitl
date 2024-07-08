package Bank1;
public class Bank {
    private Account acct[]; // ประกาศ array
    private int numAcct;
    
    public Bank(){
        acct = new Account[10]; // สร้าง array
    }
    
    public void addAccount(Account ac){
        acct[numAcct] = ac; // add ค่าเข้า array
        numAcct += 1;
        
    }
    
    public Account getAccount(int index){
        return this.acct[index];
    }
    
    public int getNumAccount(){
        return this.numAcct;
    }
    
}
