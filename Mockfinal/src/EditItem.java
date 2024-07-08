//GUI
import java.awt.*;
import javax.swing.*;
//Event
import java.awt.event.*;
//Date
import java.util.Date;
//ArrayList
import java.util.*;

public class EditItem implements ActionListener, WindowListener{
    private JFrame fr;
    private JPanel infopanel, pagepanel, controlpanel;
    private JLabel idlabel, namelabel, pricelabel;
    private JTextField idtf, nametf, pricetf;
    private JButton left, right, delete, update, close;
    private ArrayList<Item> data = Data.data;
    private int indexitem = 0;
    
    public EditItem(){
        fr = new JFrame();
        infopanel = new JPanel();
        pagepanel = new JPanel();
        controlpanel = new JPanel();
        idlabel = new JLabel("id");
        namelabel = new JLabel("Name");
        pricelabel = new JLabel("Price");
        idtf = new JTextField();
        nametf = new JTextField();
        pricetf = new JTextField();
        left = new JButton("<<");
        right = new JButton(">>");
        delete = new JButton("Delete Item");
        update = new JButton("Update Item");
        close = new JButton("CLose Item");
        
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
        
        //page
        pagepanel.setLayout(new FlowLayout());
        pagepanel.add(left);
        pagepanel.add(right);
        fr.add(pagepanel, BorderLayout.CENTER);
        
        //control
        controlpanel.setLayout(new FlowLayout());
        controlpanel.add(delete);
        controlpanel.add(update);
        controlpanel.add(close);
        fr.add(controlpanel, BorderLayout.SOUTH);
        
        //set
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
        
        //Event
        left.addActionListener(this);
        right.addActionListener(this);
        delete.addActionListener(this);
        update.addActionListener(this);
        close.addActionListener(this);
        //File
        fr.addWindowListener(this);
        // show data
        if (data.size() == 0) {
            return;
        }
        Item firstindex = data.get(indexitem);
        idtf.setText(String.valueOf(firstindex.getId()));
        nametf.setText(firstindex.getName());
        pricetf.setText(String.valueOf(firstindex.getPrice()));
    }     

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == left) {
            if (indexitem != 0){
                indexitem -= 1;
                Item itemdata = data.get(indexitem);
                idtf.setText(String.valueOf(itemdata.getId()));
                nametf.setText(itemdata.getName());
                pricetf.setText(String.valueOf(itemdata.getPrice())); 
            }
            
        }
        else if (e.getSource() == right) {
          if (indexitem+1 <= data.size()-1){
                indexitem += 1;
                Item itemdata = data.get(indexitem);
                idtf.setText(String.valueOf(itemdata.getId()));
                nametf.setText(itemdata.getName());
                pricetf.setText(String.valueOf(itemdata.getPrice()));   
          }
        }
        else if (e.getSource() == update) {
            if (data.size() != 0){
                //ค่าที่  update
                int id = Integer.parseInt(idtf.getText());
                String name = nametf.getText();
                double price = Double.parseDouble(pricetf.getText());
                Date currentdate = new Date();
                // สร้างเป็น Book ใหม่แล้ว add ไปที่ index เดิม
                Item updateitem = new Item(id, name, price, currentdate);
                JOptionPane.showMessageDialog(null, "Done it.", "Update Command", JOptionPane.INFORMATION_MESSAGE);
            }
            
            
        }
        else if (e.getSource() == delete && !(Data.data.isEmpty())) {
            Data.data.remove(indexitem);
            JOptionPane.showMessageDialog(null, "Done it.", "Delete Command", JOptionPane.INFORMATION_MESSAGE);
            if (data.size() == 0){ // ลบตัวแรก แล้วไม่เหลือเลย
                idtf.setText("");
                nametf.setText("");
                pricetf.setText("");
            }
            else if (indexitem == 0){ // ลบตัวแรก แล้วเหลือตัวอื่น
                Item itemdata = data.get(indexitem);
                idtf.setText(String.valueOf(itemdata.getId()));
                nametf.setText(itemdata.getName());
                pricetf.setText(String.valueOf(itemdata.getPrice()));
            }
            else { // ลบตัวอื่นๆ
                Item itemdata = data.get(indexitem-1);
                idtf.setText(String.valueOf(itemdata.getId()));
                nametf.setText(itemdata.getName());
                pricetf.setText(String.valueOf(itemdata.getPrice()));
            }
        }
        else if (e.getSource() == close){
            fr.dispose();
            new DashBoard();
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
