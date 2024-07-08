import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CalculatorSample  implements ActionListener {
    private JFrame frame;
    private JButton bt01,bt02,bt03,bt04,bt05,bt06,bt07,bt08,bt09,bt10,bt11,bt12,bt13,bt14,bt15,bt16;
    private JTextField textfield;
    private JPanel panel01,panel02;
    private float total;
    private ActionEvent operator = null;
    public CalculatorSample(){
        total = 0;
        frame = new JFrame("My Calculator");
        textfield = new JTextField();
        panel01 = new JPanel();
        panel02 = new JPanel();
        
        bt01 = new JButton("0");
        bt02 = new JButton("1");
        bt03 = new JButton("2");
        bt04 = new JButton("3");
        bt05 = new JButton("4");
        bt06 = new JButton("5");
        bt07 = new JButton("6");
        bt08 = new JButton("7");
        bt09 = new JButton("8");
        bt10 = new JButton("9");
        bt11 = new JButton("+");
        bt12 = new JButton("-");
        bt13 = new JButton("x");
        bt14 = new JButton("/");
        bt15 = new JButton("=");
        bt16 = new JButton("c");
        
        panel02.setLayout(new GridLayout(4,4));
        panel02.add(bt08);
        panel02.add(bt09);
        panel02.add(bt10);
        panel02.add(bt11);
        panel02.add(bt05);
        panel02.add(bt06);
        panel02.add(bt07);
        panel02.add(bt12);
        panel02.add(bt02);
        panel02.add(bt03);
        panel02.add(bt04);
        panel02.add(bt13);
        panel02.add(bt01);
        panel02.add(bt16);
        panel02.add(bt15);
        panel02.add(bt14);
        
        frame.setLayout(new BorderLayout());
        frame.add( textfield, BorderLayout.NORTH);
        frame.add(panel01);
        frame.add(panel02);
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //+-*/
        bt11.addActionListener(this);
        bt12.addActionListener(this);
        bt13.addActionListener(this);
        bt14.addActionListener(this);
        // 0-9
        bt01.addActionListener(this);
        bt02.addActionListener(this);
        bt03.addActionListener(this);
        bt04.addActionListener(this);
        bt05.addActionListener(this);
        bt06.addActionListener(this);
        bt07.addActionListener(this);
        bt08.addActionListener(this);
        bt09.addActionListener(this);
        bt10.addActionListener(this);
        // c
        bt16.addActionListener(this);
        // =
        bt15.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent event){
        if (event.getSource() == bt11 || event.getSource() == bt12 || event.getSource() == bt13 || event.getSource() == bt14){
            if (operator != null){
                this.calcurator(operator);
                operator = event;
                textfield.setText("");
            }
            if (textfield.getText() != "" && operator == null) {
                operator = event;
                this.setTotal(this.toFloat(textfield));
                textfield.setText("");
            }
        }
        else if  (event.getSource() == bt15){
            this.calcurator(operator);
            textfield.setText(this.toString());
            this.setTotal(0);
        }
        else if  (event.getSource() == bt16){
            this.setTotal(0);
            textfield.setText("");
        }
        else{
            JButton text = (JButton) event.getSource();
            textfield.setText(textfield.getText() + text.getText());
        }
        
    }
    public float getTotal(){
        return total;
    }
    public void setTotal(float total){
        this.total = total;
    }
    public float toFloat(JTextField textfield){
        return Float.parseFloat(textfield.getText());
    }
    @Override
    public String toString(){
        return total + "";
    }
    public void calcurator(ActionEvent operator){
        if (total == 0.0){
            total = this.toFloat(textfield);
        }
        // +
        else if (operator.getSource() == bt11){
            total = total + this.toFloat(textfield);
        }
        // -
        else if (operator.getSource() == bt12){
            total = total - this.toFloat(textfield);
        }
        // *
        else if (operator.getSource() == bt13){
            total = total * this.toFloat(textfield);
        }
        // /
        else if (operator.getSource() == bt14){
            total = total / this.toFloat(textfield);
        }
    }
    public static void main(String[] args){ 
        new CalculatorSample();
    }
}
