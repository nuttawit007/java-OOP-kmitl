/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Midtest;

/**
 *
 * @author supitcha
 */
public abstract class Food {
    protected String name;
    
    public Food() {
        this.name = "";
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public abstract int getPower();
}
