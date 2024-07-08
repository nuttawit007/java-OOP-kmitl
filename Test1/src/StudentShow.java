import java.awt.*;
import javax.swing.*;
public class StudentShow{
    private JFrame fr;
    private JTextArea ta;
    private Student std;
    
    public StudentShow(){
        fr = new JFrame();
        ta = new JTextArea(200,200);
        std = new Student();
        ta.setText("Name : " + std.getName());
        fr.add(ta);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(200,200);
        fr.setVisible(true);
    }

    
}
