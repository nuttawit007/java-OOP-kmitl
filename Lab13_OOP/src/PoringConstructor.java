import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PoringConstructor implements ActionListener {
    private JFrame frame;
    private JButton bt_add;
    private int num = 0;

    public PoringConstructor() {
        frame = new JFrame();
        bt_add = new JButton("ADD");
        bt_add.addActionListener(this);
        frame.setLayout(new FlowLayout());
        frame.add(bt_add);
        frame.setSize(125, 75);
        frame.setLocation(990, 540);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        num += 1;
        new Poring(num);
    }

    public static void main(String[] args) {
        new PoringConstructor();
    }
}