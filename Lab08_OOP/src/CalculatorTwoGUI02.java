import java.awt.*;
import javax.swing.*;
public class CalculatorTwoGUI02 {
    private JFrame fr;
    private JTextField text1;
    private JPanel panel;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9 ,btn0, btnplus, btnminus, btnmultiple, btnc, btnequal, btndivide;
    
    public CalculatorTwoGUI02(){
        // สร้าง obj
        fr = new JFrame("My Calculator");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        text1 = new JTextField();
        panel = new JPanel();
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btn0 = new JButton("0");
        btnc = new JButton("c");
        btnequal = new JButton("=");
        btnplus = new JButton("+");
        btnminus = new JButton("-");
        btnmultiple = new JButton("x");
        btndivide = new JButton("/");
        
        // กำหนด Layout
        fr.setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(4, 4));
        
        //add text ลงบน JFrame
        fr.add(text1, BorderLayout.NORTH);
        
        // add btn ลงบน panel
        // row1
        panel.add(btn7);
        panel.add(btn8);
        panel.add(btn9);
        panel.add(btnplus);
        
        //row2
        panel.add(btn4);
        panel.add(btn5);
        panel.add(btn6);
        panel.add(btnminus);
        
        //row3
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btnmultiple);
        
        //row4
        panel.add(btn0);
        panel.add(btnc);
        panel.add(btnequal);
        panel.add(btndivide);
        
        // add panel ลงบน ๋JFraame ที่ ตน center ของ Border เมื่อไม่ระบุ
        fr.add(panel);
        
        // pack() >> จักขนาดที่เหมาะสม, setVisible() >> การมองเห็น
        fr.setSize(500, 500);
        fr.setVisible(true);
        
    }
}
