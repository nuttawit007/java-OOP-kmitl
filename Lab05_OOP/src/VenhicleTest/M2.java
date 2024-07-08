/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VenhicleTest;

/**
 *
 * @author supitcha
 */
public class M2 {
    public static void main(String[] args) {
        Plane p1 = new Plane();
        p1.setPlaneInfo(300, "High");
        p1.showPlaneInfo();
        
        p1.fly();
        p1.showPlaneInfo();
        
        p1.fly();
        p1.showPlaneInfo();
    }
}
