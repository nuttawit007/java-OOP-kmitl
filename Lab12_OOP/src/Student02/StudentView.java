package Student02;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

import java.io.*;

public class StudentView implements ActionListener, WindowListener {
    // Attribute
    private JFrame fr;
    private JLabel laID, laName, laMoney;
    private JTextField tfID, tfName, tfMoney;
    private JButton btnDeposit, btnWithdraw;
    private JPanel panel1, panel2, panel3, panel4;
    private File file;
    private Student std;
    
    // Constructor สร้าง Object
    public StudentView(){
        std = new Student();
    // GUI
        fr = new JFrame();
        laID = new JLabel("ID: ");
        laName = new JLabel("Name: ");
        laMoney = new JLabel("Money: ");
        tfID = new JTextField();
        tfName = new JTextField();
        tfMoney = new JTextField(String.valueOf(std.getMoney()));
        btnDeposit = new JButton("Deposit");
        btnWithdraw = new JButton("Withdraw");
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        
        // setLayout
        fr.setLayout(new GridLayout(4, 2));
        // panel1
        panel1.setLayout(new GridLayout(1, 2));
        panel1.add(laID);
        panel1.add(tfID);
        fr.add(panel1);
        // panel2
        panel2.setLayout(new GridLayout(1, 2));
        panel2.add(laName);
        panel2.add(tfName);
        fr.add(panel2);
        //panel3
        panel3.setLayout(new GridLayout(1, 2));
        panel3.add(laMoney);
        panel3.add(tfMoney);
        tfMoney.setEditable(false);
        fr.add(panel3);
        //panel4
        panel4.setLayout(new GridLayout(1, 2));
        panel4.add(btnDeposit);
        panel4.add(btnWithdraw);
        fr.add(panel4);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
        
    // Event
        btnDeposit.addActionListener(this);
        btnWithdraw.addActionListener(this);
    
    // File
        file = new File("StudentM.dat");
//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        fr.addWindowListener(this);   
    }

//     Override Event Method
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDeposit) {
            std.setMoney(std.getMoney() + 100);
            tfMoney.setText(String.valueOf(std.getMoney()));
        }
        else if (e.getSource() == btnWithdraw) {
            if (std.getMoney() > 0){
                std.setMoney(std.getMoney() - 100);
                tfMoney.setText(String.valueOf(std.getMoney()));
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        try(FileInputStream fin = new FileInputStream(file); ObjectInputStream oin = new ObjectInputStream(fin)){
            std = (Student) oin.readObject();
        }
        catch (IOException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        if (std.getID() == 0){
            tfID.setText("");
        }
        else{
            tfID.setText(String.valueOf(std.getID()));
        }
        tfName.setText(std.getName());
        tfMoney.setText(String.valueOf(std.getMoney()));
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        std.setID(Integer.valueOf(tfID.getText()));
        std.setName(tfName.getText());
        std.setMoney(Integer.valueOf(tfMoney.getText()));
        try(FileOutputStream fOut = new FileOutputStream(file); ObjectOutputStream oout = new ObjectOutputStream(fOut)){
            oout.writeObject(std);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource().equals(btnDeposit)) {
//            std.setMoney(std.getMoney() + 100);
//            tfMoney.setText(String.valueOf(std.getMoney()));
//        } else if (e.getSource().equals(btnWithdraw)) {
//            if (std.getMoney() <= 0) {
//                std.setMoney(0);
//            } else if (std.getMoney() >= 100) {
//                std.setMoney(std.getMoney() - 100);
//                tfMoney.setText(String.valueOf(std.getMoney()));
//            }
//        }
//    }
//
//    @Override
//    public void windowOpened(WindowEvent e) {
//        try ( FileInputStream fi = new FileInputStream(file);  ObjectInputStream oip = new ObjectInputStream(fi);) {
//            std = (Student) oip.readObject();
//            if (std == null) {
//                std = new Student();
//                std.setID(-1);
//            }
//        } catch (IOException | ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
//        if (std.getID() == -1) {
//            tfID.setText("");
//        } else {
//            tfID.setText(String.valueOf(std.getID()));
//        }
//        tfName.setText(std.getName());
//        tfMoney.setText(String.valueOf(std.getMoney()));
//    }
//
//    @Override
//    public void windowClosing(WindowEvent e) {
//        if (tfID.getText().equals("")) {
//            std.setID(-1);
//        } else {
//            std.setID(Integer.parseInt(tfID.getText()));
//        }
//        std.setName(tfName.getText());
//        std.setMoney(Integer.parseInt(tfMoney.getText()));
//        try ( FileOutputStream fo = new FileOutputStream(file);  ObjectOutputStream oout = new ObjectOutputStream(fo);) {
//            oout.writeObject(std);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }

    @Override
    public void windowClosed(WindowEvent e) {}
    @Override
    public void windowIconified(WindowEvent e) {}
    @Override
    public void windowDeiconified(WindowEvent e) {}
    @Override
    public void windowActivated(WindowEvent e) {}
    @Override
    public void windowDeactivated(WindowEvent e) {}
    
    public static void main(String[] args) {
        new StudentView();
    }

}
