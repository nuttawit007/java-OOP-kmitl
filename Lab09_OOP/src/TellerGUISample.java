import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class TellerGUISample implements ActionListener{
    //Attribute
    private JFrame fr;
    private JLabel la1, la2;
    private JPanel pnl1, pnl2, pnl3, pnl4;
    private JTextField text1, text2;
    private JButton btnD, btnW, btnEx;
    private ActionEvent operator = null;
    private double total = 6000;
    
    //Consturctor
    public TellerGUISample(){
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
        btnD = new JButton("Deposit");
        btnW = new JButton("Withdraw");
        btnEx = new JButton("Exit");
        
        // กำหนดขนาด
        fr.setLayout(new GridLayout(4,0));
        pnl1.setLayout(new GridLayout(1, 1));
        pnl2.setLayout(new GridLayout(1, 1));
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
        pnl3.add(btnD);
        pnl3.add(btnW);
        pnl3.add(btnEx);
        fr.add(pnl3);
        
        // ช่องว่างท้าย >> add pnl4 เปล่าๆลง JFrame
        fr.add(pnl4);
        
        // pack, visible
        fr.pack();
        fr.setVisible(true);
        
        // addActionListener
        btnD.addActionListener(this);
        btnW.addActionListener(this);
        btnEx.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        if (event.getSource() == btnD){
            operator = event;
            this.calculator(operator);
            text1.setText(this.toString());
        }
        else if (event.getSource() == btnW){
            operator = event;
            this.calculator(operator);
            text1.setText(this.toString());
        }
    }
    public void calculator(ActionEvent operator){
        if (operator.getSource() == btnD){
            total += this.toDouble(text2);
        }
        else if (operator.getSource() == btnW){
            if (Double.parseDouble(text2.getText()) <= Double.parseDouble(text1.getText())){
                total -= this.toDouble(text2);
            }
        }
    }
    
    public double getTotal(){
        return this.total;
    }
    
    public void setTotal(double total){
        this.total = total;
    }
    
    public double toDouble(JTextField text2){
        return  Double.parseDouble(text2.getText());
    }
    
    @Override
    public String toString(){
        return total + "";
    }
    public static void main(String[] args) {
        new TellerGUISample();
    }
}
