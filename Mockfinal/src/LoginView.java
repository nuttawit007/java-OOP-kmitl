//GUI
import java.awt.*;
import javax.swing.*;
//Event
import java.awt.event.*;

public class LoginView implements ActionListener{
    private JFrame fr;
    private JPanel toppanel, btnpanel, loginpanel, passpanel;
    private JLabel loginlabel, passlabel;
    private JTextField logintf, passtf;
    private JButton loginbtn;

    
    public LoginView(){
        fr = new JFrame();
        loginpanel = new JPanel();
        passpanel = new JPanel();
        toppanel = new JPanel();
        btnpanel = new JPanel();
        loginlabel = new JLabel("Login");
        passlabel = new JLabel("Password");
        logintf = new JTextField();
        passtf = new JTextField();
        loginbtn = new JButton("Login");
        
        
        
        fr.setLayout(new GridLayout(4,1));
        fr.add(toppanel);
        
        loginpanel.setLayout(new GridLayout(1,2));
        loginpanel.add(loginlabel);
        loginpanel.add(logintf);
        fr.add(loginpanel);
        
        passpanel.setLayout(new GridLayout(1,2));
        passpanel.add(passlabel);
        passpanel.add(passtf);
        fr.add(passpanel);
        
        loginbtn.setPreferredSize(new Dimension(200, 30)); // set ขนาด loginbtn
        btnpanel.add(loginbtn);
        fr.add(btnpanel);
       
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(500,200);
        fr.setVisible(true);
        
        //Event
        loginbtn.addActionListener(this);
    }
    public static void main(String[] args) {
        new LoginView();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(loginbtn)) {
            if (logintf.getText().equals("win") && passtf.getText().equals("123")){
               new DashBoard();
               fr.dispose();
            }
        }
    }
        
}
