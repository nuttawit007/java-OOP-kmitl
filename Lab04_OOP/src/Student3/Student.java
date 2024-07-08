package Student3;
public class Student {
    public String name;
    public double mScore;
    public double fScore;
    public void showGrade(){
        double score = (mScore*0.4)+(fScore*0.4)+20;
        if (score >= 80){
            System.out.println("Your grade is A.");
        }else if (70 <= score && score < 80){
            System.out.println("Your grade is B.");
        }else if (60 <= score && score < 70){
            System.out.println("Your grade is C.");
        }else if (50 <= score && score < 60){
            System.out.println("Your grade is D.");
        }else{
            System.out.println("Your grade is F.");
        }
    }
}
