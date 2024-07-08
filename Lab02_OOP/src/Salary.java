import java.util.Scanner;
public class Salary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please insert your name : ");
        String name = input.nextLine();
        System.out.print("Please insert your age : ");
        int age = input.nextInt();
        System.out.print("Please insert number of working days : ");
        byte work = input.nextByte();
        System.out.print("Please insert number of absent days : ");
        byte absent = input.nextByte();
        System.out.print("Please insert your body weight : ");
        double weight = input.nextDouble();
        
        int salary;
        if ((51 <= age) && (age <= 60)){
            salary = work * 3000;   
        }else if ((41 <= age) && (age <= 50)){
            salary = (work*1000) - (absent*25);
        }else if ((31 <= age)&&(age <= 41)){
            salary = (work*500) - (absent*50);
        }else if ((21 <= age)&&(age <= 30)){
            salary = (work*300) - (absent*50);
        }else{
            salary = 0;
        }
        
        double bonus;
        if ((61 <= age)&&(age <= 90)){
            bonus = salary + (5000-((weight-60)*10)); //เนื่องจาก weight เป็น ทศนิยม bonus ต้องเป็น double
        }else if ((10 <= age)&&(age <= 60)){
            bonus = salary + 5000;
        }else{
            bonus = 0;
        }
        System.out.println("Hi, "+name);
        System.out.println("Your salary is "+salary+" Baht");
        System.out.println("Your salary and bonus is " +((int)bonus)+" Baht" );
    }
}
