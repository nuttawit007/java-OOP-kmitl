import java.util.*;
public class StudentModel {
    private String firstName, lastName, course, address;
    private ArrayList studentViews = new ArrayList();
    
    public StudentModel() {
        this(null);
    }
    
    public StudentModel(StudentRefInterface view) {
        firstName = "";
        lastName = "";
        course = "";
        address = "";
        if (view != null){
            studentViews.add(view);
        }
    }
    
    public void addContactView(StudentRefInterface view) {
        if (!studentViews.contains(view)){
            studentViews.add(view);
        }     
    }
    
    public void removeContactView(StudentRefInterface view) {
        studentViews.remove(view);
    }
    
    public void updateModel(String newFName, String newLName, String newTitle, String newOrg) {
        setFirstName(newFName);
        setLastName(newLName);
        setCourse(newTitle);
        setAddress(newOrg);
        updateView();
    }
    
    public void updateView() {
        Iterator notifyViews = studentViews.iterator();
        while (notifyViews.hasNext()){
            ((StudentRefInterface) notifyViews.next()).refresh(firstName, lastName, course, address);
        }
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList getStudentViews() {
        return studentViews;
    }

    public void setStudentViews(ArrayList studentViews) {
        this.studentViews = studentViews;
    }
}
