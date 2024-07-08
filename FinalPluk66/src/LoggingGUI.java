
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author LAB203_62
 */
public class LoggingGUI implements ActionListener, WindowListener {

    private JFrame frame;
    private JPanel pane1;
    private JScrollPane scrollPane;
    private JTextArea textArea;
    private JTextField id;
    private JButton _delete;
    public static ArrayList<MessageLog> logger = new ArrayList<>();

    public LoggingGUI() {
        // FRAME
        this.frame = new JFrame();
        this.frame.setLayout(new BorderLayout());
        // PANE
        this.pane1 = new JPanel(new FlowLayout());
        // Text & Button
        this.textArea = new JTextArea(10, 40);
        this.id = new JTextField("", 30);
        this._delete = new JButton("Delete");
        this._delete.addActionListener(this);
        this.scrollPane = new JScrollPane(textArea);

        // ADDER
        this.pane1.add(id);
        this.pane1.add(_delete);
        this.frame.add(scrollPane);
        this.frame.add(pane1, BorderLayout.SOUTH);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.addWindowListener(this);
        this.frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    public void relog() {
        this.textArea.setText("");
        if (logger.size() > 0) {
            int length = logger.size() - 1;
            for (int i = 0; i <= length; i++) {
                textArea.setText(textArea.getText() + "#MessageID-" + (i + 1) + " " + logger.get(i).generateMessage() + "\n");
            }
        }
    }

    public static void main(String[] args) {
        LoggingGUI logger = new LoggingGUI();
        new CalculatorGUI(logger);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (id.getText().equals("")) {
                throw new FormException("Please Provide Id");
            }
            if (e.getSource().equals(_delete)) {
                int _id = Integer.parseInt(id.getText());
                LoggingGUI.logger.remove(_id - 1);
                this.relog();
            }
        } catch (FormException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "", JOptionPane.PLAIN_MESSAGE);
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "", JOptionPane.PLAIN_MESSAGE);
        } catch (IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "", JOptionPane.PLAIN_MESSAGE);
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {
        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream("message_log.data"))) {
            logger = (ArrayList<MessageLog>) obj.readObject();
            if (logger.size() > 0) {
                int length = logger.size() - 1;
                for (int i = 0; i <= length; i++) {
                    textArea.setText(textArea.getText() + "#MessageID-" + (i + 1) + " " + logger.get(i).generateMessage() + "\n");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("message_log.data"))) {
            obj.writeObject(logger);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
