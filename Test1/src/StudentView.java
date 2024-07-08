import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class StudentView implements ActionListener{
    private JFrame fr;
    private JTextField tf;
    private JButton btn;
    private Student std;
    private ArrayList<Student> data = Data.data;
    
    public StudentView(){
        fr = new JFrame();
        tf = new JTextField();
        btn = new JButton("Show");
        std = new Student();
        
        fr.setLayout(new GridLayout(2,1));
        fr.add(tf);
        fr.add(btn);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(100,100);
        fr.setVisible(true);
        //Event
        btn.addActionListener(this);
        new StudentShow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btn)){
            std.setName(tf.getText());
        }
    }
    
    public static void main(String[] args) {
        new StudentView();
    } 
}
