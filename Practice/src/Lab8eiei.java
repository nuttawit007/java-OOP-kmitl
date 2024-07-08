import java.awt.*;
import javax.swing.*;
public class Lab8eiei {
    private JFrame fr;
    private JTextField text1, text2, text3;
    private JButton btn1, btn2, btn3, btn4;
    private JPanel panel;
    
    
    public Lab8eiei(){
        fr = new JFrame("Calculator");
        text1 = new JTextField();
        text2 = new JTextField();
        text3 = new JTextField();
        btn1 = new JButton("บวก");
        btn2 = new JButton("ลบ");
        btn3 = new JButton("คูณ");
        btn4 = new JButton("หาร");
        panel = new JPanel();
        
        fr.setLayout(new GridLayout(4,1));
        fr.add(text1);
        fr.add(text2);
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        fr.add(panel);
        fr.add(text3);
        
        text3.setEditable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Lab8eiei();
    }
    
}
