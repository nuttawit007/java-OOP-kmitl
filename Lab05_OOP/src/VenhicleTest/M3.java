/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VenhicleTest;

/**
 *
 * @author supitcha
 */
public class M3 {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.setCarInfo(60, "High", "Diesel");
        c1.showCarInfo();
        
        c1.move();
        c1.showCarInfo();
        
        c1.move();
        c1.showCarInfo();
    }
}
