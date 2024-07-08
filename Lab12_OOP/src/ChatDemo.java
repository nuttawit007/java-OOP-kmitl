import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatDemo implements ActionListener, WindowListener {
    
    private JFrame fr;
    private JTextArea txtArea;
    private JTextField txtField;
    private JPanel panel;
    private JButton btnSubmit, btnReset;
    private File file;
    
    public ChatDemo(){
    
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
        
     
   
        btnSubmit.addActionListener(this);
        btnReset.addActionListener(this);  
        
   
        file = new File("ChatDemo.dat");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fr.addWindowListener(this);
        
   
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btnSubmit){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            txtArea.setText(txtArea.getText() + "\n" + dtf.format(LocalDateTime.now()) + " " + txtField.getText());
            txtField.setText("");
        }
        else if (e.getSource() == btnReset){
            txtArea.setText("");
        }
        
    }

    @Override
    public void windowOpened(WindowEvent e) {
        int ch;
        String txt = "";
        try(FileReader fr = new FileReader(file)){
            while ((ch = fr.read()) != -1){
                txt += (char) ch;
            }
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
        txtArea.setText(txt);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        String str = "";
        try (FileWriter fw = new FileWriter(file)){
            fw.write(txtArea.getText());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

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
        new ChatDemo();
    }
}

