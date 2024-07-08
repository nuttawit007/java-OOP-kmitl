/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6test;
public class Food {
    public static final int energy = 10;
    public static double price = 50;
    
    public void setPrice(double price) {
        if (price > 10)
        Food.price = price;
    }
    
    public double getPrice() {
        return Food.price;
    }
    
    public int getEnergy() {
        return Food.energy;
    }
}
