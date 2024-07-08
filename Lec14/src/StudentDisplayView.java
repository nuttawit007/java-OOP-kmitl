import java.awt.*;
import javax.swing.*;

public class StudentDisplayView implements StudentRefInterface {
    private JTextArea studentDetail;
    private JPanel p;
    private JFrame fr;
    private JScrollPane scrollDisplay;
    
    public StudentDisplayView(){
        fr = new JFrame();
        p = new JPanel();
        p.setLayout(new BorderLayout());
        studentDetail = new JTextArea(10,40);
        studentDetail.setEditable(false);
        scrollDisplay = new JScrollPane(studentDetail);
        p.add(scrollDisplay, BorderLayout.CENTER);
        fr.add(p);
        fr.pack();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void refresh(String newFirstName, String newLastName, String newCourse, String newAddress) {
        studentDetail.setText("\n\tStudent Detail\n\t" + "\tName: "
                + newFirstName + "\n\t\tLast Name: " 
                + newLastName + "\n" + "\t\tCourse: " 
                + newCourse + "\n" + "\t\tAddress: " 
                + newAddress);
    }
}
