import java.awt.*;
import javax.swing.*;
//import javax.swing.JFrame;
public class MDIFromGUI04 {
    private JFrame fr;
    private JMenuBar mb;
    private JMenu m1, m2, m3, ms1;
    private JMenuItem mi2, mi3, mi4, msi1, msi2;
    
    private JDesktopPane dp;
    private JInternalFrame app1, app2, app3;
    
    public MDIFromGUI04(){
        fr = new JFrame("SubMenuItem Demo");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //ใส่ menuBar ใน JFrame
        mb = new JMenuBar();
        fr.setJMenuBar(mb);

        // ใส่ menu บน menubar
        m1 = new JMenu("File");
        m2 = new JMenu("Edit");
        m3 = new JMenu("View");
        
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        
        // ใส่ muitem ใน menu1
        ms1 = new JMenu("New");
        mi2 = new JMenuItem("Open");
        mi3 = new JMenuItem("Save");
        mi4 = new JMenuItem("Exit");

        m1.add(ms1);
        m1.addSeparator();
        m1.add(mi2);
        m1.addSeparator();
        m1.add(mi3);
        m1.addSeparator();
        m1.add(mi4);
        
        // ใส่ menuitem ใน menus1
        msi1 = new JMenuItem("Window");
        msi2 = new JMenuItem("Message");
        
        ms1.add(msi1);
        ms1.addSeparator();
        ms1.add(msi2);
        
        // MDI
        dp = new JDesktopPane();
        app1 = new JInternalFrame("Application01", true, true, true, true);
        app2 = new JInternalFrame("Application02", true, true, true, true);
        app3 = new JInternalFrame("Application03", true, true, true, true);
        
        // app1
        app1.setSize(300, 200);
        app1.setLocation(100, 500);
        app1.setVisible(true);
        
        // app2
        app2.setSize(400, 300);
        app2.setLocation(300, 200);
        app2.setVisible(true);
        
        // app3
        app3.setSize(600, 300);
        app3.setLocation(700, 400);
        app3.setVisible(true);
        
        // add app ลง dp
        dp.add(app1);
        dp.add(app2);
        dp.add(app3);
        dp.setBackground(Color.black);
        fr.add(dp);
        
        // set result
        fr.add(dp, BorderLayout.CENTER);
        fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
        
    }
   
    
    
    
    
}
