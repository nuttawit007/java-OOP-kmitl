package Vehicle3;
public class Plane extends Vehicle{
    public void showPlaneInfo() {
        System.out.println("Plane detail is, Fuel is " + getFuel() + " litre and Top Speed is " + getTopSpeed() + " m/s.");
    }
    
    public void setPlaneInfo(int s, String t){
        setFuel(s);
        setTopSpeed(t);
    }
    
    public void fly(){
        int fuel = getFuel();
        if (fuel >= 200){
            setFuel(getFuel() - 200);
            System.out.println("Fly.");
        } else {
            System.out.println("Please add fuel.");
        }
    }
}
