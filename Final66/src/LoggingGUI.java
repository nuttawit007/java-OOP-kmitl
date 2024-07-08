// GUI
import java.awt.*;
import javax.swing.*;
public class LoggingGUI {
    private JFrame fr;
    private JPanel pane;
    private JTextField idtf;
    private JTextArea ta;
    private JScrollPane scrollpane;
    private JButton delete;
    
    public LoggingGUI(){
        fr = new JFrame();
        pane = new JPanel();
        idtf = new JTextField();
        ta = new JTextArea(10,20);
        scrollpane = new JScrollPane();
        delete = new JButton();
        
        fr.setLayout(new BorderLayout());
        // TextArea
        ta.add(scrollpane);
        fr.add(scrollpane, BorderLayout.CENTER);
        // controal delete
        pane.setLayout(new FlowLayout());
        pane.add(idtf); pane.add(delete);
        
        
    }
}
