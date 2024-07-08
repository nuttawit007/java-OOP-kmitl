import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
public class MyFrame_3 implements MouseListener{
    private JFrame frame;
    private MyClock_3 clock;
    public  MyFrame_3(){
        frame = new JFrame();
        clock = new MyClock_3();
        Thread t = new Thread(clock);
        t.start();
        frame.setLayout(new FlowLayout());
        frame.add(clock);
        frame.setSize(100, 70);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addMouseListener(this);
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == frame){
            clock.opposite();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    public static void main(String[] args){
        new MyFrame_3();
    }
}
