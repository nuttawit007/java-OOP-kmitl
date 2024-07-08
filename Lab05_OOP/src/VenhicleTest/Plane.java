package VenhicleTest;
public class Plane extends Vehicle{
    public void showPlaneInfo() {
        System.out.print("Plane detail is, ");
        showInfo();
    }
    
    public void setPlaneInfo(int s, String t) {
        setFuel(s);
        setTopSpeed(t);
    }
    
    public void fly() {
        if (getFuel() >= 200) {
            setFuel(getFuel()-200);
            System.out.println("Fly.");
        }
        else {
            System.out.println("Please add fuel.");
        }
        
    }
}
