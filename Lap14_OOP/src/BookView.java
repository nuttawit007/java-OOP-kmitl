// GUI 
import java.awt.*;
import javax.swing.*;
// Event 
import java.awt.event.*;
// File & Serializable
import java.io.*;
// ArrayList
import java.util.*;
public class BookView implements ActionListener, WindowListener{
    // ประกาศ Atrribute
    private JFrame fr;
    private JPanel infoPanel, pagePanel, btnPanel;
    private JLabel nameLabel, priceLabel, typeLabel;
    private JTextField nametf, pricetf, pagetf;
    private JComboBox typecb;
    private JButton leftbtn, rightbtn, addbtn, updatebtn, deletebtn;
    private int indexbook = 0;
    
    
    public BookView(){
        //สร้าง Object
        fr = new JFrame();
        infoPanel = new JPanel();
        pagePanel = new JPanel();
        btnPanel = new JPanel();
        nameLabel = new JLabel("Name");
        priceLabel = new JLabel("Price");
        typeLabel = new JLabel("Type");
        nametf = new JTextField();
        pricetf = new JTextField();
        pagetf = new JTextField();
        typecb = new JComboBox();
        leftbtn = new JButton("<<");
        rightbtn = new JButton(">>");
        addbtn = new JButton("Add");
        updatebtn = new JButton("Update");
        deletebtn = new JButton("Delete");
        
        
        fr.setLayout(new BorderLayout());
        //info
        infoPanel.setLayout(new GridLayout(3,2));
        infoPanel.add(nameLabel);
        infoPanel.add(nametf);
        infoPanel.add(priceLabel);
        infoPanel.add(pricetf);
        infoPanel.add(typeLabel);
        typecb.addItem("General");
        typecb.addItem("Computer");
        typecb.addItem("Math&Sci");
        typecb.addItem("Photo");
        infoPanel.add(typecb);
        fr.add(infoPanel, BorderLayout.NORTH);
        
        //page
        pagePanel.setLayout(new FlowLayout());
        pagePanel.add(leftbtn);
        pagetf.setPreferredSize(new Dimension(60, 30)); // set ขนาด TextField
        pagetf.setEditable(false);
        pagePanel.add(pagetf);
        pagePanel.add(rightbtn);
        fr.add(pagePanel, BorderLayout.CENTER);
        
        // btn
        btnPanel.setLayout(new FlowLayout());
        btnPanel.add(addbtn);
        btnPanel.add(updatebtn);
        btnPanel.add(deletebtn);
        fr.add(btnPanel, BorderLayout.SOUTH);
        
        // set View
        fr.setLocationRelativeTo(null); // กึ่งกลาง
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
        
        //event
        leftbtn.addActionListener(this);
        rightbtn.addActionListener(this);
        addbtn.addActionListener(this);
        updatebtn.addActionListener(this);
        deletebtn.addActionListener(this);
        
        //File
        fr.addWindowListener(this);
        
    }
    
    public static void main(String[] args) {
        new BookView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == leftbtn) {
            if (indexbook != 0){
                indexbook -= 1;
                Book bookdata = Data.data.get(indexbook);
                nametf.setText(bookdata.getName());
                pricetf.setText(String.valueOf(bookdata.getPrice()));
                typecb.setSelectedItem(bookdata.getType());
                pagetf.setText(String.valueOf(indexbook+1));
            }
            
        }
        else if (e.getSource() == rightbtn) {
          if (indexbook+1 <= Data.data.size()-1){
                indexbook += 1;
                Book bookdata = Data.data.get(indexbook);
                nametf.setText(bookdata.getName());
                pricetf.setText(String.valueOf(bookdata.getPrice()));
                typecb.setSelectedItem(bookdata.getType());
                pagetf.setText(String.valueOf(indexbook+1));
          }
        }
        else if (e.getSource() == addbtn) {
            new BookAdd();
        }
        else if (e.getSource() == updatebtn) {
            if (Data.data.size() != 0){
                //ค่าที่  update
                String name = nametf.getText();
                double price = Double.parseDouble(pricetf.getText());
                String type = (String) typecb.getSelectedItem();
                // สร้างเป็น Book ใหม่แล้ว add ไปที่ index เดิม
                Book updatebook = new Book(name, price, type);
                Data.data.set(indexbook, updatebook);
                nametf.setText(updatebook.getName());
                pricetf.setText(String.valueOf(updatebook.getPrice()));
                typecb.setSelectedItem(updatebook.getType());
                pagetf.setText(String.valueOf(indexbook+1));
                JOptionPane.showMessageDialog(null, "Done it.", "Update Command", JOptionPane.INFORMATION_MESSAGE);
            }
            
            
        }
        else if (e.getSource() == deletebtn && !(Data.data.isEmpty())) {
            Data.data.remove(indexbook);
            if (Data.data.size() == 0){ // ลบตัวแรก แล้วไม่เหลือเลย
                nametf.setText("");
                pricetf.setText("");
                typecb.setSelectedItem("General");
                pagetf.setText(String.valueOf("0"));
            }
            else if (indexbook == 0){ // ลบตัวแรก แล้วเหลือตัวอื่น
                Book bookdata = Data.data.get(indexbook);
                nametf.setText(bookdata.getName());
                pricetf.setText(String.valueOf(bookdata.getPrice()));
                typecb.setSelectedItem(bookdata.getType());
                pagetf.setText(String.valueOf(indexbook+1));
            }
            else { // ลบตัวอื่นๆ
                Book bookdata = Data.data.get(indexbook - 1);
                nametf.setText(bookdata.getName());
                pricetf.setText(String.valueOf(bookdata.getPrice()));
                typecb.setSelectedItem(bookdata.getType());
                pagetf.setText(String.valueOf(indexbook));
                indexbook -= 1;
                JOptionPane.showMessageDialog(null, "Done it.", "Delete Command", JOptionPane.INFORMATION_MESSAGE);
            }
            
            
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        try(FileInputStream fin = new FileInputStream("Book.eiei"); ObjectInputStream oin = new ObjectInputStream(fin);){
            Data.data = (ArrayList<Book>) oin.readObject();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        if (Data.data.isEmpty()){
            pagetf.setText("0");
        }
        else if (!Data.data.isEmpty()){
            Book bookdata = Data.data.get(indexbook);
            nametf.setText(bookdata.getName());
            pricetf.setText(String.valueOf(bookdata.getPrice()));
            typecb.setSelectedItem((String) bookdata.getType());
            pagetf.setText(String.valueOf(indexbook + 1));
        }
    }
        

    @Override
    public void windowClosing(WindowEvent e) {
        try(FileOutputStream fou = new FileOutputStream("Book.eiei"); ObjectOutputStream oou = new ObjectOutputStream(fou);){
            oou.writeObject(Data.data);
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
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
