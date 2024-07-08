//GUI
import java.awt.*;
import javax.swing.*;
//Event 
import java.awt.event.*;
//ArrayList
import java.util.*;
// Date
import java.util.Date;

public class AddItem  implements ActionListener, WindowListener{
    private JFrame fr;
    private JPanel infopanel, controlpanel;
    private JLabel idlabel, namelabel, pricelabel;
    private JTextField idtf, nametf, pricetf;
    private JButton insert;
    private ArrayList<Item> data = Data.data;
    
    public AddItem(){
        fr = new JFrame();
        infopanel = new JPanel();
        controlpanel = new JPanel();
        idlabel = new JLabel("id");
        namelabel = new JLabel("Name");
        pricelabel = new JLabel("Price");
        idtf = new JTextField();
        nametf = new JTextField();
        pricetf = new JTextField();
        insert = new JButton("insert");
        
        fr.setLayout(new BorderLayout());
        //info
        infopanel.setLayout(new GridLayout(3,2));
        infopanel.add(idlabel);
        infopanel.add(idtf);
        infopanel.add(namelabel);
        infopanel.add(nametf);
        infopanel.add(pricelabel);
        infopanel.add(pricetf);
        fr.add(infopanel, BorderLayout.NORTH);
        
        //control
        controlpanel.setLayout(new FlowLayout());
        controlpanel.add(insert);
        fr.add(controlpanel, BorderLayout.CENTER);
        
        //set
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(300,150);
        fr.setVisible(true);
        
        //Event
        insert.addActionListener(this);
        //File
        fr.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== insert){
            if (!(nametf.getText().isEmpty() || pricetf.getText().isEmpty())){
                int id = Integer.parseInt(idtf.getText());
                String name = nametf.getText();
                double price = Double.parseDouble(pricetf.getText());
                Date currentDate = new Date();
                
                Item newitem = new Item(id,name,price,currentDate);
                data.add(newitem);
                
                JOptionPane.showConfirmDialog(null, "Done it.", "AddItem", JOptionPane.INFORMATION_MESSAGE);
                fr.dispose();
                new DashBoard();
            }
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
        new DashBoard();
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }
        
}
