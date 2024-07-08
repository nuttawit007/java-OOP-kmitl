//GUI
import java.awt.*;
import javax.swing.*;
//Event
import java.awt.event.*;
//Table
import javax.swing.table.*;
// ArrayList
import java.util.*;
//File
import java.io.*;

public class DashBoard implements ActionListener, WindowListener {
    private JFrame fr;
    private JPanel controlpanel, labelpanel, btnpanel;
    private JLabel jisoolabel;
    private JButton addbtn, editbtn, logoutbtn;
    private JTable table; // Table
    private JScrollPane scrollpane;
    private ArrayList<Item> data = Data.data;
    
    public DashBoard(){
        fr = new JFrame();
        controlpanel = new JPanel();
        labelpanel = new JPanel();
        btnpanel = new JPanel();
        jisoolabel = new JLabel("Welcome to Jisoo Marketplace");
        addbtn = new JButton("Add item");
        editbtn = new JButton("Edit item");
        logoutbtn = new JButton("Logout");
        table = new JTable();
        scrollpane = new JScrollPane();
        
        fr.setLayout(new BorderLayout());
        
        controlpanel.setLayout(new BorderLayout());
        fr.add(controlpanel, BorderLayout.NORTH);
        // jisoo
        labelpanel.setLayout(new FlowLayout());
        labelpanel.add(jisoolabel);
        controlpanel.add(labelpanel, BorderLayout.NORTH);
        // btn
        btnpanel.setLayout(new FlowLayout());
        btnpanel.add(addbtn);
        btnpanel.add(editbtn);
        btnpanel.add(logoutbtn);
        controlpanel.add(btnpanel, BorderLayout.CENTER);
        
        //Table
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Price");
        model.addColumn("Created_On");
        if (!data.isEmpty()){
            for (int i = 0;i<= data.size()-1; i++){
                int id = data.get(i).getId();
                String name = data.get(i).getName();
                double price = data.get(i).getPrice();
                Date createdon = data.get(i).getCreated_on();
                int day = createdon.getDay();
                int month = createdon.getMonth() + 1;
                int year = createdon.getYear() + 1900;
                String datefor = day + "/" + month + "/" + year;
                model.addRow(new Object[]{id, name, price, createdon});   
            } 
        }
        
        scrollpane.setViewportView(table);
        fr.add(scrollpane, BorderLayout.CENTER);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(500, 200);
        fr.setVisible(true);
        //Event
        addbtn.addActionListener(this);
        editbtn.addActionListener(this);
        logoutbtn.addActionListener(this);
        //File
        fr.addWindowListener(this);
    }
        public static void main(String[] args) {
        new DashBoard();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addbtn){
            new AddItem();
        }
        else if (e.getSource() == editbtn){
            new EditItem();
        }
        else if (e.getSource() == logoutbtn){
            try ( FileOutputStream fos = new FileOutputStream("jisso_shop.dat");  ObjectOutputStream oos = new ObjectOutputStream(fos);) {
                oos.writeObject(data);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            new LoginView();
            fr.dispose();
        }
    }
    
    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try ( FileOutputStream fos = new FileOutputStream("jisso_shop.dat");  ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(data);
        } catch (Exception ecc) {
            ecc.printStackTrace();
        }
    }
    @Override
    public void windowClosed(WindowEvent e) {
    }
}
