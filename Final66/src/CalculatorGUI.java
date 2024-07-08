//GUI
import java.awt.*;
import javax.swing.*;
public class CalculatorGUI {
    private JFrame fr;
    private JPanel pane;
    private JTextField num1, num2, result;
    private JButton add, minus, multiply, divide;
    
    public CalculatorGUI(){
        // Create Obj.
        fr = new JFrame();
        pane = new JPanel();
        num1 = new JTextField(); num2 = new JTextField(); result = new JTextField();
        add = new JButton("add"); minus = new JButton("minus"); multiply = new JButton("multiply"); divide = new JButton("divide");
        
        fr.setLayout(new GridLayout(4,1));
        // Num Input
        fr.add(num1); fr.add(num2);
        // Operation
        pane.setLayout(new FlowLayout());
        pane.add(add); pane.add(minus); pane.add(multiply); pane.add(divide);
        fr.add(pane);
        // Result show
        result.setEditable(false);
        fr.add(result);
        
        fr.setLocation(800,350);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);   
    }
    public static void main(String[] args) {
        new CalculatorGUI();
    }
    
}
