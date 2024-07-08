public class Dog extends Animal{

    public Dog(String name, int age) {
        setName(name);
        setAge(age);
        setPower(200);
        
    }

    
    @Override
    public void eat(Food f) {
        setPower(getPower() + f.getPower());
    }
    
    public void kick(Animal a) {
        a.setPower(a.getPower() - 10);
    }
    
}
