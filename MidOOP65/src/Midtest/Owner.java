/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Midtest;

/**
 *
 * @author supitcha
 */
public class Owner {
    protected final String name;
    protected Animal animal;
    
    public Owner(){
        this("", null);
    }
    
    public Owner(String name) {
        this(name, null);
    }
    
    public Owner(Animal a) {
        this("", a);
    }
    
    public Owner(String name, Animal animal) {
        this.name = name;
        this.animal = animal;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    public Animal getAnimal() {
        return this.animal;
    }
    
    public void feedFood(Food f) {
        animal.setPower(animal.getPower()+f.getPower());
    }
    @Override
    public String toString() {
        return "Owner : name = " + this.getName() + ", Animal : name = " + animal.getName() + ", power = " + animal.getPower() + ", age = " + animal.getAge();
    }
    
    public void protectOwnerFrom(Animal a) {
        //ใช้ instanceof
        if (getAnimal() instanceof Dog) {
            ((Dog) getAnimal()).kick(a);
        }
        else {
            ((Pigeous) getAnimal()).wingAttack(a);
        }
    }
}
