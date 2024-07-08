import java.awt.*;
import javax.swing.*;
public class MyFrame {
    public  MyFrame(){
        JFrame frame = new JFrame();
        MyClock clock = new MyClock();
        Thread t = new Thread(clock);
        t.start();
        
        frame.setLayout(new FlowLayout());
        frame.add(clock);
        frame.setSize(100, 60);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        new MyFrame();
    }
}
