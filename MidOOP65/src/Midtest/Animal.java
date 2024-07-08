/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Midtest;

/**
 *
 * @author supitcha
 */
public abstract class Animal {
    private String name;
    private int power;
    private int age;
    
    public Animal(){
        this("", 0, 0);
    }
    
    public Animal(String name, int power, int age) {
        this.name = name;
        this.power = power;
        this.age = age;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setPower(int power) {
        this.power = power;
    }
    
    public int getPower() {
        return this.power;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public boolean equals(Animal a) {
        return (this.getName().equals(a.getName())) && (this.getAge() == (a.getAge()));
    }
    
    @Override
    public String toString() {
        return "Animal : name " + this.getName() + ", power = " + this.getPower() + " , age = " + this.getAge();
    }
    
    public abstract void eat(Food f);
}
