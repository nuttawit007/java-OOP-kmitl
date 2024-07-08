
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LAB203_62
 */
public class CalculatorGUI implements ActionListener {
    private JFrame frame;
    private JPanel pane1, pane2, pane3;
    private JTextField first, second, answer;
    private JButton plus, minus, multiply, divide;
    private LoggingGUI loggingGUI;
    public CalculatorGUI(LoggingGUI loggingGUI) {
        this.loggingGUI = loggingGUI;
        // FRAME
        this.frame = new JFrame(); this.frame.setLayout(new BorderLayout());
        // PANEL
        this.pane1 = new JPanel(new GridLayout(2, 1));
        this.pane2 = new JPanel(new FlowLayout());
        this.pane3 = new JPanel(new GridLayout(1, 1));
        
        // BUTTON
        this.plus = new JButton("Plus");this.minus = new JButton("Minus");
        this.multiply = new JButton("Multiply");this.divide = new JButton("Divide");
        
        this.plus.addActionListener(this);this.minus.addActionListener(this);this.multiply.addActionListener(this);this.divide.addActionListener(this);
        
        // TEXT FIELD
        this.first = new JTextField();this.second = new JTextField();this.answer = new JTextField(); this.answer.setEditable(false);
        
        // ADDER
        this.pane1.add(first); this.pane1.add(second);
        this.pane2.add(plus);this.pane2.add(minus);this.pane2.add(multiply);this.pane2.add(divide);
        this.pane3.add(answer);
        this.frame.add(pane1, BorderLayout.NORTH);this.frame.add(pane2, BorderLayout.CENTER);this.frame.add(pane3, BorderLayout.SOUTH);
        
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {  
        try {
            if(first.getText().equals("") || second.getText().equals("")) throw new FormException("Please Provide Operator");
            if(e.getSource().equals(plus)) {
                int id = LoggingGUI.logger.size() + 1;
                double _first = Double.parseDouble(first.getText());
                double _second = Double.parseDouble(second.getText());
                double _answer = _first + _second;
                String mesage = _first + " Add " + _second + " = " + _answer;
                answer.setText(_answer + "");
                LoggingGUI.logger.add(new MessageLog(id, this.generateDate(), mesage));
            } else if(e.getSource().equals(minus)) {
                int id = LoggingGUI.logger.size() + 1;
                double _first = Double.parseDouble(first.getText());
                double _second = Double.parseDouble(second.getText());
                double _answer = _first - _second;
                String mesage = _first + " Minus " + _second + " = " + _answer;
                answer.setText(_answer + "");
                LoggingGUI.logger.add(new MessageLog(id, this.generateDate(), mesage));
            } else if(e.getSource().equals(multiply)) {
                int id = LoggingGUI.logger.size() + 1;
                double _first = Double.parseDouble(first.getText());
                double _second = Double.parseDouble(second.getText());
                double _answer = _first * _second;
                String mesage = _first + " Multiply " + _second + " = " + _answer;
                answer.setText(_answer + "");
                LoggingGUI.logger.add(new MessageLog(id, this.generateDate(), mesage));
            } else if(e.getSource().equals(divide)) {
                int id = LoggingGUI.logger.size() + 1;
                double _first = Double.parseDouble(first.getText());
                double _second = Double.parseDouble(second.getText());
                double _answer = _first / _second;
                String mesage = _first + " Divide " + _second + " = " + _answer;
                answer.setText(_answer + "");
                LoggingGUI.logger.add(new MessageLog(id, this.generateDate(), mesage));
            }
        } catch(FormException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "", JOptionPane.PLAIN_MESSAGE);
            answer.setText(ex.getMessage() + "");
        }catch (ArithmeticException ex) {
           int id = LoggingGUI.logger.size() + 1;
           LoggingGUI.logger.add(new MessageLog(id, this.generateDate(), ex.getMessage()));
           answer.setText(ex.getMessage() + "");
        } catch(NumberFormatException ex) {
            int id = LoggingGUI.logger.size() + 1;
           LoggingGUI.logger.add(new MessageLog(id, this.generateDate(), ex.getMessage()));
           answer.setText(ex.getMessage() + "");
        } catch (Exception ex) {
            int id = LoggingGUI.logger.size() + 1;
           LoggingGUI.logger.add(new MessageLog(id, this.generateDate(), ex.getMessage()));
           answer.setText(ex.getMessage() + "");
        } finally {
            this.loggingGUI.relog();
        }
    }
    
    private String generateDate() {
        Date days = new Date();
        String day = "" + days.getDate();
        String month = "" + days.getMonth();
        String year = "" + days.getYear();
        String time = "" + days.getHours()+ ":" + days.getMinutes()+ ":" + days.getSeconds();
        String date = day + "/" + month + "/" + year + " " + time;
        return date;
    }
}
