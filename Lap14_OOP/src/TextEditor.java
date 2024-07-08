import java.awt.*;
import javax.swing.*;
// Event
import java.awt.event.*;
//File
import java.io.*;
public class TextEditor implements ActionListener{
    private JFrame fr;
    private JMenuBar mb;
    private JMenu file;
    private JMenuItem newbtn, openbtn, savebtn, closebtn;
    private JTextArea ta;
    
    public TextEditor(){
        fr = new JFrame();
        mb = new JMenuBar();
        file = new JMenu("File");
        newbtn = new JMenuItem("New");
        openbtn = new JMenuItem("Open");
        savebtn = new JMenuItem("Save");
        closebtn = new JMenuItem("Close");
        ta = new JTextArea();
        
        fr.setJMenuBar(mb);
        fr.setLayout(new BorderLayout());
        fr.add(ta);
        mb.add(file);
        
        file.add(newbtn);
        file.add(openbtn);
        file.add(savebtn);
        file.addSeparator();
        file.add(closebtn);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(200,200);
        fr.setVisible(true);
        
        //Event
        newbtn.addActionListener(this);
        openbtn.addActionListener(this);
        savebtn.addActionListener(this);
        closebtn.addActionListener(this);
        
        
    }
    public static void main(String[] args) {
        new TextEditor();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(newbtn)){
            ta.setText("");
        }
        else if (e.getSource().equals(openbtn)){
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(fr);
            File file = fc.getSelectedFile();
            String text = "";

            try ( FileReader fileReader = new FileReader(file)) {
                int ch;
                while ((ch = fileReader.read()) != -1) {
                    text += (char) ch;
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if (e.getSource().equals(savebtn)){
            JFileChooser fc = new JFileChooser();
            fc.showSaveDialog(fr);
            File file = fc.getSelectedFile();
            String text = ta.getText();
            
            try ( FileWriter fw = new FileWriter(file)) {
                for (int i = 0; i < text.length(); i++) {
                    fw.write(text.charAt(i));
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
                
            
        }
        else if (e.getSource().equals(closebtn)){
            System.exit(0);
        }
    }
        
    
}
