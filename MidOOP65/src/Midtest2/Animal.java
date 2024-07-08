/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Midtest2;
public abstract class Animal {
    private int age;
    private String name;
    private int power;
    
    public Animal(){
        this("", 0, 0);
    }
    
    public Animal(String name, int power, int age) {
        this.name= name;
        this.power = power;
        this.age = age;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getPower(){
        return this.power;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPower(int power) {
        this.power = power;
    }
    
    public abstract void eat(Food f);
    
    public boolean equals(Animal a){
        return (this.getName().equals(a.getName()) && (this.getAge() == a.getAge()));
    }
    
    @Override
    public String toString(){
        return "Animal : name" + getName() + " , power = " + getPower() + " , age = " + getAge();
    }
}  

