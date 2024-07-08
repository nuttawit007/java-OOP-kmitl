package Vehicle3;
public class Car extends Vehicle {
    private String typeEngine;
    
    public void setTypeEngine (String t){
        typeEngine = t;
    }
    
    public String getTypeEngine () {
        return typeEngine;
    }
    
    public void showCarInfo () {
        System.out.println("Car engine is " + typeEngine + ".");
        System.out.println("Fuel is " + getFuel() + " litre and Top Speed is " + getTopSpeed() + " m/s.");
    }
    
    public void setCarInfo (int s, String t, String y){
        setFuel(s);
        setTopSpeed(t);
        setTypeEngine(y);
    }
    
    public void move () {
        int fuel = getFuel();
        if (fuel >=50) {
            System.out.println("Move.");
            setFuel(getFuel()-50);
        } else {
            System.out.println("Please add fuel.");
        }
    }
}
//public class Car extends Vehicle {
//
//    private String typeEngine;
//
//    public void setTypeEngine(String t) {
//        this.typeEngine = t;
//    }
//
//    public String getTypeEngine() {
//        return this.typeEngine;
//    }
//
//    public void showCarInfo() {
//        System.out.println("Car engine is " + this.typeEngine + ".");
//        System.out.println("Fuel is " + getFuel() + " litre and Top Speed is " + getTopSpeed() + " m/s.");
//    }
//
//    public void setCarInfo(int s, String t, String y) {
//        setFuel(s);
//        setTopSpeed(t);
//        setTypeEngine(y);
//    }
//
//    public void move() {
//        int fuel = getFuel();
//        if (fuel >= 50) {
//            System.out.println("Move.");
//            setFuel(getFuel() - 50);
//        } else {
//            System.out.println("Please add fuel.");
//        }
//    }
//}
