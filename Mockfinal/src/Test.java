import javax.swing.*;
import java.awt.*;

//public class Test {
//    private JFrame fr;
//    private JRadioButton ra1,ra2, ra3;
//    private ButtonGroup gr;
//    
//    public Test(){
//        fr = new JFrame();
//        // สร้างปุ่ม
//        ra1 = new JRadioButton("OOP");
//        ra2 = new JRadioButton("Data");
//        ra3 = new JRadioButton("Stat");
//        // สร้างกลุ่ม
//        gr = new ButtonGroup();
//        // gr add btn
//        gr.add(ra1); gr.add(ra2); gr.add(ra3);
//        // fr add btn
//        fr.setLayout(new GridLayout(3,1));
//        fr.add(ra1); fr.add(ra2); fr.add(ra3);
//        // Method
//        ra1.setSelected(true);
//        if (ra1.isSelected())
//         
//        
//        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        fr.pack();
//        fr.setVisible(true);
//    }


//    public class Test {
//    private JFrame fr;
//    private JComboBox cb;
//    
//    public Test(){
//        fr = new JFrame();
//        cb = new JComboBox();
//        // Method
//        cb.addItem("OOP");
//        cb.addItem("Data");
//        cb.setSelectedItem("OOP");// เจาะจง
//        cb.setSelectedIndex(1); // ลำดับ
//        cb.getSelectedItem(); // return Object
//        fr.add(cb);
//         
//        
//        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        fr.pack();
//        fr.setVisible(true);
//    }

    public class Test {
    private JFrame fr;
    private JList list;
    private String option[] = {"OOP", "Data"};
    
    public Test(){
        fr = new JFrame();
        list = new JList(option);
        // เลือก mode
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.getSelectedValue(); // return Object
        fr.setLayout(new FlowLayout());
        fr.add(list);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(100, 100);
        fr.setVisible(true);
    }
    public static void main(String[] args) {
        new Test();
    }
}
