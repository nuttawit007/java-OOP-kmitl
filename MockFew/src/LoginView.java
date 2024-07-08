//GUI
import java.awt.*;
import javax.swing.*;

public class LoginView {
//    private JFrame fr;
//    private JPanel infopanel;
//    private JLabel loginlabel, passlabel;
//    private JTextField logintf, passtf;
//    private JButton loginbtn;
    
    private JFrame fr;
    private JTextArea txtArea;
    private JTextField txtField;
    private JPanel panel;
    private JButton btnSubmit, btnReset;
    
    public LoginView(){
//        fr = new JFrame();
//        infopanel = new JPanel();
//        loginlabel = new JLabel("Login");
//        passlabel = new JLabel("Password");
//        logintf = new JTextField();
//        passtf = new JTextField();
//        loginbtn = new JButton("Login");
//        
//        
//        fr.setLayout(new BorderLayout());
//        
//        infopanel.setLayout(new GridLayout(2,2));
//        infopanel.add(loginlabel);
//        infopanel.add(logintf);
//        infopanel.add(passlabel);
//        infopanel.add(passtf);
//        fr.add(infopanel, BorderLayout.NORTH);
//        
//        fr.add(loginbtn, BorderLayout.CENTER);
//        
//        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        fr.pack();
//        fr.setVisible(true);
            fr = new JFrame();
        txtArea = new JTextArea(20, 45);
        txtField = new JTextField(45);
        panel = new JPanel();
        btnSubmit = new JButton("Submit");
        btnReset = new JButton("Reset");
        
        fr.setLayout(new BorderLayout());
        txtArea.setEditable(false);
        fr.add(txtArea, BorderLayout.NORTH);
        fr.add(txtField, BorderLayout.CENTER);
        fr.add(panel, BorderLayout.SOUTH);
        
       
        panel.add(btnSubmit);
        panel.add(btnReset);
                fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
          
          
        
    }
    public static void main(String[] args) {
        new LoginView();
    }
}
