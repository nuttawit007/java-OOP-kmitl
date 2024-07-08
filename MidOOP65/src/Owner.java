public class Owner {
    protected final String name;
    protected Animal animal;

    public Owner(){
        this.name = "";
        this.animal = null;
    }
    public Owner(String name) {
        this.name = name;
    }
    
    public Owner(Animal animal) {
        this.animal = animal;
        this.name = "";
    }
    
    public Owner(String name, Animal animal) {
        this.name = name;
        this.animal = animal;
    }
    
    public String getName() {
        return this.name;
    }
    public Animal getAnimal() {
        return this.animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    public void feedFood(Food f) {
        animal.eat(f);
    }
    
    @Override
    public String toString() {
        return "Owner : name = " + this.getName() + ", Animal : name = " + animal.getName() + ", power = " + animal.getPower() + ", age = " + animal.getAge();
    }
    
    public void protectOwnerFrom(Animal a) {
        if (getAnimal() instanceof Dog) {
            ((Dog) getAnimal()).kick(a);
        }
        else if (getAnimal() instanceof Pigeous){
            ((Pigeous) getAnimal()).wingAttack(a);
        }
    }
    
    
}
