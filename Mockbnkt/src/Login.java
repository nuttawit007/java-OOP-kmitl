
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.*;

/*
 * IG : i_am_bnkt
 */
/**
 *
 * @author BNKT
 */
public class Login implements ActionListener {

    private JFrame jFrame;
    private JPanel panelUp, panelDown, loginPanel, passwoPanel;
    private JLabel loginLabel, passwordLabel;
    private JTextField loginTextField, passwordTextField;
    private JButton loginButton;

    public Login() {
        try ( FileInputStream fis = new FileInputStream("jisso_shop.dat");  ObjectInputStream ois = new ObjectInputStream(fis);) {
            Data.data = (ArrayList<Item>) ois.readObject();
        } catch (Exception exx) {
            exx.printStackTrace();
        }
        jFrame = new JFrame();
        loginPanel = new JPanel();
        passwoPanel = new JPanel();

        jFrame.setLayout(new GridLayout(4, 1));

        panelUp = new JPanel();

        jFrame.add(panelUp);

        loginPanel.setLayout(new GridLayout(1, 2));
        loginPanel.setBounds(1000, 1000, 1000, 1000);
        passwoPanel.setLayout(new GridLayout(1, 2));

        loginLabel = new JLabel("Login");
        loginTextField = new JTextField("jisoo");
        passwordLabel = new JLabel("Password");
        passwordTextField = new JTextField("flower_me");

        loginPanel.add(loginLabel);
        loginPanel.add(loginTextField);

        passwoPanel.add(passwordLabel);
        passwoPanel.add(passwordTextField);

        jFrame.add(loginPanel);
        jFrame.add(passwoPanel);

        panelDown = new JPanel();
        loginButton = new JButton("Login");

        panelDown.add(loginButton);

        jFrame.add(panelDown);

        loginButton.addActionListener(this);

        jFrame.setSize(500, 200);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e
    ) {
        if (e.getSource().equals(loginButton)) {
            if (loginTextField.getText().equals("jisoo") && passwordTextField.getText().equals("flower_me")) {
                DashBoard dashBoard = new DashBoard();

                jFrame.setVisible(false);
                jFrame.dispose();
            }
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}