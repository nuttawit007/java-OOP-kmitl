package Student22;
//GUI
import java.awt.*;
import javax.swing.*;
//Event
import java.awt.event.*;
//File
import java.io.*;

public class StudentView implements ActionListener, WindowListener {
    private JFrame fr;
    private JLabel idlabel, namelabel, moneylabel;
    private JTextField idtf, nametf, moneytf;
    private JButton depositbtn, withdrawbtn;
    private File file;
    private Student std;
    
    public StudentView(){
        fr = new JFrame();
        idlabel = new JLabel("ID: ");
        namelabel = new JLabel("Name: ");
        moneylabel = new JLabel("Money: ");
        idtf = new JTextField();
        nametf = new JTextField();
        moneytf = new JTextField("0");
        depositbtn = new JButton("Deposit");
        withdrawbtn = new JButton("Withdraw");
        std = new Student();
        
        fr.setLayout(new GridLayout(4,4));
        fr.add(idlabel);
        fr.add(idtf);
        fr.add(namelabel);
        fr.add(nametf);
        fr.add(moneylabel);
        moneytf.setEditable(false);
        fr.add(moneytf);
        fr.add(depositbtn);
        fr.add(withdrawbtn);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
        
        //Event
        depositbtn.addActionListener(this);
        withdrawbtn.addActionListener(this);
        
        //File
        file = new File("Student2.dat");
        try{
            file.createNewFile();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        fr.addWindowListener(this);
                
        
        
    }
    public static void main(String[] args) {
        new StudentView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depositbtn) {
            int currentmoney =  Integer.parseInt(moneytf.getText());
            moneytf.setText(String.valueOf(currentmoney + 100));
        }
        else if (e.getSource() == withdrawbtn) {
            int currentmoney =  Integer.parseInt(moneytf.getText());
            if (currentmoney > 0){
                moneytf.setText(String.valueOf(currentmoney - 100));
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        try(FileInputStream fin = new FileInputStream(file); ObjectInputStream oin = new ObjectInputStream(fin);){
            std = (Student)oin.readObject();
            
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        if (std.getID() == 0){
            idtf.setText("");
        }
        else {
           idtf.setText(String.valueOf(std.getID())); 
        }
        nametf.setText(std.getName());
        moneytf.setText(String.valueOf(std.getMoney()));
    }

    @Override
    public void windowClosing(WindowEvent e) {
        std.setID(Integer.parseInt(idtf.getText()));
        std.setMoney(Integer.parseInt(moneytf.getText()));
        std.setName(nametf.getText());
        try(FileOutputStream fout = new FileOutputStream(file); ObjectOutputStream oout = new ObjectOutputStream(fout);){
            oout.writeObject(std);
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
        

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
    
}
