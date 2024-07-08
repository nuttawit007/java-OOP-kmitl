import java.awt.*;
import javax.swing.*;

public class StudentView implements StudentRefInterface{
    private JFrame fr;
    private JPanel labelPanel, controlPanel, p;
    private JLabel firstNameLabel, lastNameLabel, courseLabel, addressLabel;
    private JTextField firstName, lastName, course, address;
    private JButton display, exit;
    
    public StudentView(){
        fr = new JFrame(); p = new JPanel(); display = new JButton("Show");exit = new JButton("Exit"); 
        firstNameLabel = new JLabel("FirstName ");
        lastNameLabel = new JLabel("Last Name "); 
        courseLabel = new JLabel("Course");
        addressLabel = new JLabel("Address "); 
        firstName = new JTextField();
        lastName = new JTextField(); 
        course = new JTextField(); 
        address = new JTextField();
        
        labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(4,2));
        
        labelPanel.add(firstNameLabel);     labelPanel.add(firstName); 
        labelPanel.add(lastNameLabel);      labelPanel.add(lastName); 
        labelPanel.add(courseLabel);        labelPanel.add(course);
        labelPanel.add(addressLabel);       labelPanel.add(address);
        
        controlPanel = new JPanel();
        controlPanel.add(display); controlPanel.add(exit);
        
        p.setLayout(new BorderLayout());
        p.add(labelPanel);  p.add(controlPanel, BorderLayout.SOUTH);
        fr.add(p); fr.pack(); fr.setVisible(true); fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public Object getUpdateRef(){   return display; }
    public String getFirstName(){   return firstName.getText(); }
    public String getLastName(){    return lastName.getText(); }
    public String getCourse(){      return course.getText(); }
    public String getAddress(){     return address.getText(); }
    
    public JButton getDisplay() {   return display; }
    public void setDisplay(JButton display) {   this.display = display; }
    public JButton getExit() {      return exit; }
    public void setExit (JButton exit) { this.exit = exit; }

    @Override
    public void refresh(String newFirstName, String newLastName, String newTitle, String newOrganization) {
        firstName.setText(newFirstName);
        lastName.setText(newLastName);
        course.setText(newTitle);
        address.setText(newOrganization);
    }
    
}
