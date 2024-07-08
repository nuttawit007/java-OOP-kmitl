//GUI
import java.awt.*;
import javax.swing.*;
//Event
import java.awt.event.*;
//Time
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//File
import java.io.*;

public class ChatDemo2  implements ActionListener, WindowListener{
    private JFrame fr;
    private JPanel btnpanel;
    private JTextArea outputta;
    private JTextField inputtf;
    private JButton submitbtn, resetbtn;
    private File file;
    
    public ChatDemo2(){
        fr = new JFrame();
        btnpanel = new JPanel();
        outputta = new JTextArea(20,45);
        inputtf = new JTextField(45);
        submitbtn = new JButton("Submit");
        resetbtn = new JButton("Reset");
        
        fr.setLayout(new BorderLayout());
        fr.add(outputta, BorderLayout.NORTH);
        fr.add(inputtf, BorderLayout.CENTER);
        
        btnpanel.setLayout(new FlowLayout());
        btnpanel.add(submitbtn);
        btnpanel.add(resetbtn);
        fr.add(btnpanel, BorderLayout.SOUTH);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
        
        //Event
        submitbtn.addActionListener(this);
        resetbtn.addActionListener(this);
        
        //File
        file = new File("ChatDemo2.dat");
        fr.addWindowListener(this);
        
    }
    public static void main(String[] args) {
        new ChatDemo2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitbtn && !inputtf.getText().isEmpty()) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            outputta.setText(outputta.getText() + "\n"+dtf.format(LocalDateTime.now()) + " : " + inputtf.getText());
            inputtf.setText("");
        }
        else if (e.getSource() == resetbtn) {
            outputta.setText("");
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        int ch;
        String txt = "";       
        try(FileReader fr = new FileReader(file);){
           while ((ch = fr.read()) != -1){
                txt += (char) ch;
           }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        outputta.setText(txt);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try(FileWriter fw = new FileWriter(file)){
            fw.write(outputta.getText());
        } catch (IOException ex) {
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
    
        
}
