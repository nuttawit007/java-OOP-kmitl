
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * IG : i_am_bnkt
 */
/**
 *
 * @author BNKT
 */
public class DashBoard implements ActionListener, WindowListener {

    private JFrame fr;
    private JPanel panelUp, panelButton, tmppanel;
    private JTable table;
    private JLabel label;
    private JButton add, edit, logout;
    private JScrollPane scrollPane;
    private ArrayList<Item> data = Data.data;

    public DashBoard() {
        fr = new JFrame();
        panelUp = new JPanel();
        table = new JTable();
        label = new JLabel("Welcome to Jisoo Marketplace");
        add = new JButton("Add item");
        edit = new JButton("Edit item");
        logout = new JButton("Logout");
        panelButton = new JPanel();
        tmppanel = new JPanel();
        scrollPane = new JScrollPane();

        tmppanel.setLayout(new BorderLayout());
        panelUp.setLayout(new FlowLayout());
        panelUp.add(label);

        panelButton.setLayout(new FlowLayout());

        panelButton.add(add);
        panelButton.add(edit);
        panelButton.add(logout);

        tmppanel.add(panelUp, BorderLayout.NORTH);
        tmppanel.add(panelButton, BorderLayout.CENTER);

        fr.add(tmppanel, BorderLayout.NORTH);

        add.addActionListener(this);
        edit.addActionListener(this);
        logout.addActionListener(this);

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Price");
        model.addColumn("Created_On");
        if (data.size() != 0) {
            for (int i = 0; i <= data.size() - 1; i++) {
                int id = data.get(i).getId();
                String name = data.get(i).getName();
                double price = data.get(i).getPrice();
                Date date = data.get(i).getCreated_on();

                int day = date.getDay();
                int month = date.getMonth() + 1;
                int year = date.getYear() + 1900;
                String datefor = day + "/" + month + "/" + year;
                model.addRow(new Object[]{id, name, price, datefor});
            }
        }
        scrollPane.setViewportView(table);

        fr.add(scrollPane, BorderLayout.CENTER);

        fr.setSize(500, 200);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
        fr.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ex
    ) {
        if (ex.getSource().equals(add)) {
            AddItem addItem = new AddItem();
            fr.setVisible(false);
            fr.dispose();
        } else if (ex.getSource().equals(edit)) {
            EditItem editItem = new EditItem();
            fr.setVisible(false);
            fr.dispose();
        } else if (ex.getSource().equals(logout)) {
            try ( FileOutputStream fos = new FileOutputStream("jisso_shop.dat");  ObjectOutputStream oos = new ObjectOutputStream(fos);) {
                oos.writeObject(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Login login = new Login();

            fr.setVisible(
                    false);
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