import java.awt.*;
import javax.swing.*;
public class CalculatorOneGUI01 {
    // Attribute
    private JFrame fr;
    private JTextField text1, text2, text3;
    private JPanel panel;
    private JButton btn1, btn2, btn3, btn4;
    
    public CalculatorOneGUI01(){
    //สร้าง Obj
        fr = new JFrame("เครื่องคิดเลข"); //สร้าง JFrame
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        text1 = new JTextField();
        text2 = new JTextField();
        text3 = new JTextField();
        panel = new JPanel();
        btn1 = new JButton("บวก");
        btn2 = new JButton("ลบ");
        btn3 = new JButton("คูณ");
        btn4 = new JButton("หาร");
    // JFrame ใช้รูปแบบ Grid
        fr.setLayout(new GridLayout(4, 0));
    // add text1,text2 ลง JFrame
        fr.add(text1);
        fr.add(text2);
    // add ปุ่มลง panel >> panel ลง Jframe 
    // FlowLayout >> เรียงซ้ายไปขวา
        panel.setLayout(new FlowLayout());
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        fr.add(panel);
    // add text3 ลง JFrame
        fr.add(text3);
    // pack() >> ขนาดเหมาะสม
    // Visible >> การมองเห็น
        fr.pack();
        fr.setVisible(true);  
    }
}
