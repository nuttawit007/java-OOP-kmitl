import java.awt.*;
import javax.swing.*;
public class TellerGUI03 {
    //Attribute
    private JFrame fr;
    private JLabel la1, la2;
    private JPanel pnl1, pnl2, pnl3, pnl4;
    private JTextField text1, text2;
    private JButton btn1, btn2, btn3;
    
    //Constructure
    public TellerGUI03(){
        // สร้าง obj
        fr = new JFrame("Teller GUI");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        text1 = new JTextField("6000");
        text2 = new JTextField();
        la1 = new JLabel("Balance");
        la2 = new JLabel("Amount");
        pnl1 = new JPanel();
        pnl2 = new JPanel();
        pnl3 = new JPanel();
        pnl4 = new JPanel();
        btn1 = new JButton("Deposit");
        btn2 = new JButton("Withdraw");
        btn3 = new JButton("Exit");
        
        // กำหนดขนาด
        fr.setLayout(new GridLayout(4,0));
        pnl1.setLayout(new GridLayout(1, 2));
        pnl2.setLayout(new GridLayout(1, 2));
        pnl3.setLayout(new FlowLayout());
        
        // add text1, la1 ลงบน pnl1 >> add pnl1 ลง JFrame
        pnl1.add(la1);
        text1.setEditable(false);
        pnl1.add(text1);
        fr.add(pnl1);
        
        //add text2, la2 ลงบน pnl2 >> add pnl2 ลง JFrame
        pnl2.add(la2);
        pnl2.add(text2);
        fr.add(pnl2);
        
        //add btn ลงบน pn3 >> add pnl3 ลง JFrame
        pnl3.add(btn1);
        pnl3.add(btn2);
        pnl3.add(btn3);
        fr.add(pnl3);
        
        // ช่องว่างท้าย >> add pnl4 เปล่าๆลง JFrame
        fr.add(pnl4);
        
        // pack, visible
        fr.pack();
        fr.setVisible(true);
     
    }
    
}
