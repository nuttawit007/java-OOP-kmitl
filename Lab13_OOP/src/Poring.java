import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class Poring  implements MouseListener{
    private JFrame frame;
    private JPanel panel;
    private JLabel image;
    private JLabel textLabel;
    private ImageIcon icon;
    public Poring(int num){
        panel = new JPanel();
        icon = new ImageIcon("poring.png");
        image = new JLabel(icon);
        textLabel = new JLabel(num+"");
        panel.add(image, BorderLayout.CENTER);
        panel.add(textLabel, BorderLayout.SOUTH);
        frame = new JFrame("Poring");
        Random random = new Random();
        int randomnumber = random.nextInt(300);
        frame.setLocation(randomnumber, randomnumber);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.addMouseListener(this);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == frame){
            frame.dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) {}
}