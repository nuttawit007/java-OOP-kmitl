import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public final class CalculatorSimpleWin implements ActionListener{
    private JFrame fr;
    private JTextField text1;
    private JPanel panel;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9 ,btn0, btnplus, btnminus, btnmultiple, btnc, btnequal, btndivide;
    
    private ActionEvent operator = null;
    private double total;
    
    public CalculatorSimpleWin(){
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
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        
        // addActionListener()
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btn0.addActionListener(this);
        btnc.addActionListener(this);
        btnequal.addActionListener(this);
        btnplus.addActionListener(this);
        btnminus.addActionListener(this);
        btnmultiple.addActionListener(this);
        btndivide.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        if (event.getSource() == btnplus || event.getSource() == btnminus || event.getSource() == btnmultiple || event.getSource() == btndivide){
            if (operator == null) {
                operator = event;
                this.calculator(operator);
                text1.setText(""); 
            }
            // operator ต่อๆกัน
            else if (operator != null && text1.getText() != ""){
                operator = event;
                this.setTotal(this.toDouble(text1));
                text1.setText("");
            }
        }
        // =
        else if (event.getSource() == btnequal){
            this.calculator(operator);
            text1.setText(this.toString());
        }
        // c
        else if (event.getSource() == btnc){
            this.setTotal(0.0);
            text1.setText("");
        }
        // เลขต่อกันเรื่อยๆ
        else {
            JButton text = (JButton) event.getSource();
            text1.setText(text1.getText() + text.getText());
        }
    }

    public void calculator(ActionEvent operator){
        if (total == 0.0){
            total = this.toDouble(text1);
        }
        // +
        else if (operator.getSource() == btnplus){
            total = total + this.toDouble(text1);
        }
        // -
        else if (operator.getSource() == btnminus){
            total = total - this.toDouble(text1);
        }
        // *
        else if (operator.getSource() == btnmultiple){
            total = total * this.toDouble(text1);
        }
        // /
        else if (operator.getSource() == btndivide){
                total = total / this.toDouble(text1);
        }
    }

    public double getTotal(){
        return total;
    }
    
    public void setTotal(double total){
        this.total = total;
    }
    
    @Override
    public String toString(){
        return total + "";
    }
    
    public double toDouble(JTextField textfield){
        return Double.parseDouble(textfield.getText());
    }
    
    public static void main(String[] args){ 
        new CalculatorSample();
    }
}
