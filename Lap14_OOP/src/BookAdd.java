// GUI
import java.awt.*;
import javax.swing.*;
// Event
import java.awt.event.*;
//ArrayList
import java.util.*;

public class BookAdd implements ActionListener{
    private JFrame fr;
    private JPanel infoPanel, insertPanel;
    private JLabel namelb, pricelb, typelb;
    private JTextField nametf, pricetf;
    private JComboBox typecb;
    private JButton insertbtn;
    private ArrayList<Book> data = Data.data;
    
    public BookAdd(){
        fr = new JFrame();
        infoPanel = new JPanel();
        insertPanel = new JPanel();
        namelb = new JLabel("Name");
        pricelb = new JLabel("Price");
        typelb = new JLabel("Type");
        nametf = new JTextField();
        pricetf = new JTextField();
        typecb = new JComboBox();
        insertbtn = new JButton("insert");
        
        fr.setLayout(new BorderLayout());
        
        //info
        infoPanel.setLayout(new GridLayout(3,2));
        infoPanel.add(namelb);
        infoPanel.add(nametf);
        infoPanel.add(pricelb);
        infoPanel.add(pricetf);
        infoPanel.add(typelb);
        typecb.addItem("General");
        typecb.addItem("Computer");
        typecb.addItem("Math&Sci");
        typecb.addItem("Photo");
        infoPanel.add(typecb);
        fr.add(infoPanel, BorderLayout.NORTH);
        
        //btn
        insertPanel.setLayout(new FlowLayout());
        insertPanel.add(insertbtn);
        fr.add(insertPanel, BorderLayout.CENTER);
        
        //set View
        fr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
        
        //Event
        insertbtn.addActionListener(this);   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == insertbtn) {
            if (!(nametf.getText().isEmpty() || pricetf.getText().isEmpty())){ // กรอกรายละเอียด Book แล้วจริง
                // เก็บข้อมูลจากที่เขียน >> สร้าง Book >> เก็บใน ArrayList
                String name = nametf.getText();
                double price = Double.parseDouble(pricetf.getText());
                String type = (String) typecb.getSelectedItem();
                // สร้าง Book
                Book newbook = new Book(name, price, type);
                //เก็บ Book ใน ArrayList
                data.add(newbook);
                
                JOptionPane.showMessageDialog(null, "Done it.", "", JOptionPane.INFORMATION_MESSAGE);
                fr.dispose();
            }
            
            
        }
    }
        
    
    
    
    

}
