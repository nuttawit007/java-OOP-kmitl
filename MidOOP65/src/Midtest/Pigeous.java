/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Midtest;

/**
 *
 * @author supitcha
 */
public class Pigeous extends Bird{
    public Pigeous() {
        this("", 0);
        setPower(150);
    }
    
    public Pigeous(String name, int age){
        super(name, age);
        setPower(150);
    }
    
    @Override
    public void eat(Food f) {
        setPower(getPower()+2*f.getPower());
    }

    @Override
    public void fly() {
        System.out.println(getName() + " fly fly ...");
    }
    
    @Override
    public void wingAttack(Animal a) {
        a.setPower(a.getPower() - 5);
    }
    
    public void wingAttack(Animal a, int times) {
        for (int i = 0; i < times; i++) {
            this.wingAttack(a);
        }
    }
    
}
