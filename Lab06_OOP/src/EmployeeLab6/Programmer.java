package EmployeeLab6;
public class Programmer extends Employee{
    private int happiness;
    
    public void coding(String str){
        if (getEnergy() >= 30){
            System.out.println("Your code is " + str);
        } else {
            System.out.println("Error Error Error");
        }
        setEnergy(getEnergy() - 30);
        happiness -= 30;
    }
// String.valueOf เปลี่ยนค่าเป็น String
    public void coding (char str){
        this.coding(String.valueOf(str));
    }

// setter and getter
    public int getHappiness(){
        return happiness;
    }
    
    public void setHappiness(int happiness){
        this.happiness = happiness;
    }
}
