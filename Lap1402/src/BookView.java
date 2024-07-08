import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class BookView implements ActionListener, WindowListener {

    private JFrame fr;
    private JLabel nameLabel, priceLabel, TypeLabel;
    private JTextField nameTextField, priceTextField, pageTextField;
    private JComboBox TypeComboBox;
    private JPanel infoPanel, pagePanel, buttonPanel;
    private JButton leftButton, rightButton, addButton, updateButton, deleteButton;
    private int now = 0;

    public BookView() {
        fr = new JFrame();
        nameLabel = new JLabel("Name");
        priceLabel = new JLabel("Price");
        TypeLabel = new JLabel("Type");
        nameTextField = new JTextField();
        priceTextField = new JTextField();
        pageTextField = new JTextField();
        TypeComboBox = new JComboBox();
        infoPanel = new JPanel();
        pagePanel = new JPanel();
        buttonPanel = new JPanel();
        leftButton = new JButton("<<");
        rightButton = new JButton(">>");
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        fr.setLayout(new BorderLayout());

        infoPanel.setLayout(new GridLayout(3, 2));

        infoPanel.add(nameLabel);
        infoPanel.add(nameTextField);
        infoPanel.add(priceLabel);
        infoPanel.add(priceTextField);
        infoPanel.add(TypeLabel);

        TypeComboBox.addItem("General");
        TypeComboBox.addItem("Computer");
        TypeComboBox.addItem("Math&Sci");
        TypeComboBox.addItem("Photo");
        TypeComboBox.setSelectedItem("General");

        infoPanel.add(TypeComboBox);

        fr.add(infoPanel, BorderLayout.NORTH);

        pagePanel.setLayout(new FlowLayout());
        pagePanel.add(leftButton);
        pageTextField.setPreferredSize(new Dimension(60, 30));
        pagePanel.add(pageTextField);
        pagePanel.add(rightButton);

        fr.add(pagePanel, BorderLayout.CENTER);

        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        fr.add(buttonPanel, BorderLayout.SOUTH);

        leftButton.addActionListener(this);
        rightButton.addActionListener(this);
        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(300, 200);
        fr.setVisible(true);
        fr.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(leftButton)) {
            if (now != 0) {
                now -= 1;
                Book bookData = Data.data.get(now);
                nameTextField.setText(bookData.getName());
                priceTextField.setText(String.valueOf(bookData.getPrice()));
                TypeComboBox.setSelectedItem(bookData.getType());
                pageTextField.setText(String.valueOf(now + 1));
            }

        } else if (source.equals(rightButton)) {
            if ((now + 1) <= (Data.data.size() - 1)) {
                now += 1;
                Book bookData = Data.data.get(now);
                nameTextField.setText(bookData.getName());
                priceTextField.setText(String.valueOf(bookData.getPrice()));
                TypeComboBox.setSelectedItem(bookData.getType());
                pageTextField.setText(String.valueOf(now + 1));
            }

        } else if (source.equals(addButton)) {
            new AddBook();

        } else if (source.equals(updateButton)) {
            JOptionPane.showMessageDialog(null, "Done it.", "Update Command", JOptionPane.INFORMATION_MESSAGE);
            if (Data.data.size() != 0) {
                Book bookData = Data.data.get(now);
                nameTextField.setText(bookData.getName());
                priceTextField.setText(String.valueOf(bookData.getPrice()));
                TypeComboBox.setSelectedItem(bookData.getType());
                pageTextField.setText(String.valueOf(now + 1));
                //Update ที่จริงใจ
//                String name = nameTextField.getText();
//                double price = Double.parseDouble(priceTextField.getText());
//                String type = (String) TypeComboBox.getSelectedItem();
//                Book updatebook = new Book(name, price, type);
//                Data.data.set(now,updatebook);
//                nameTextField.setText(updatebook.getName());
//                priceTextField.setText(String.valueOf(updatebook.getPrice()));
//                TypeComboBox.setSelectedItem(updatebook.getType());
//                pageTextField.setText(String.valueOf(now + 1));
                
                

            }
            System.out.println(Data.data.size());
        } else if (source.equals(deleteButton) && Data.data.size() != 0) {
            JOptionPane.showMessageDialog(null, "Done it.", "Delete Command", JOptionPane.INFORMATION_MESSAGE);
            Data.data.remove(now);
            if (Data.data.size() == 0) {
                nameTextField.setText("");
                priceTextField.setText("");
                TypeComboBox.setSelectedItem("General");
                pageTextField.setText("0");
            } else if (now == 0) {
                Book bookData = Data.data.get(now);
                nameTextField.setText(bookData.getName());
                priceTextField.setText(String.valueOf(bookData.getPrice()));
                TypeComboBox.setSelectedItem(bookData.getType());
                pageTextField.setText(String.valueOf(now + 1));
            } else {
                Book bookData = Data.data.get(now - 1);
                nameTextField.setText(bookData.getName());
                priceTextField.setText(String.valueOf(bookData.getPrice()));
                TypeComboBox.setSelectedItem(bookData.getType());
                pageTextField.setText(String.valueOf(now));
                now -= 1;
            }
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try ( FileOutputStream fos = new FileOutputStream("Book.data");  ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(Data.data);
            System.out.println(Data.data.size());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        try ( FileInputStream fis = new FileInputStream("Book.data");  ObjectInputStream ois = new ObjectInputStream(fis);) {
            Data.data = (ArrayList<Book>) ois.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        if (Data.data.size() == 0) {
            pageTextField.setText("0");
            return;
        }
        Book bookData = Data.data.get(now);
        nameTextField.setText(bookData.getName());
        priceTextField.setText(String.valueOf(bookData.getPrice()));
        TypeComboBox.setSelectedItem(bookData.getType());
        pageTextField.setText(String.valueOf(now + 1));
    }

    @Override
    public void windowActivated(WindowEvent e
    ) {
    }

    @Override
    public void windowIconified(WindowEvent e
    ) {
    }

    @Override
    public void windowDeiconified(WindowEvent e
    ) {
    }

    @Override
    public void windowDeactivated(WindowEvent e
    ) {
    }

    @Override
    public void windowClosed(WindowEvent e
    ) {
    }
    
    public static void main(String[] args) {
        new BookView();
    }

}
