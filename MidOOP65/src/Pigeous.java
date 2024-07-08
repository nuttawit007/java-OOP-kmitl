public class Pigeous extends Bird{

    public Pigeous(){
        this("", 0);
        this.setPower(150); 
        // ใช้ super() ไม่ได้เพราะ super ได้แค่แม่ ยายไม่ได้ แต่ใช้ method ยายได้
    }
    
    public Pigeous(String name, int age) {
        super(name, age); // ใช้ supter ได้ เพราะ Bird มี constructor(name,age)
        this.setPower(150);
        
    }

    @Override
    public void wingAttack(Animal a) {
        a.setPower(a.getPower() - 5);
    }
    
    public void wingAttack(Animal a, int times) {
        for (int i=0; i<times; i++) {
            wingAttack(a);
        }
    }

    @Override
    public void eat(Food f) {
        setPower(getPower() + (2*f.getPower()));
    }

    @Override
    public void fly() {
        System.out.println(getName() + " fly fly ....");
    }
    
    
 
}
