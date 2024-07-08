import java.awt.Font;
import java.util.Calendar;
import javax.swing.*;
public class MyClock extends JLabel implements Runnable{

    @Override
    public void run() {
        while (true){
            Calendar d = Calendar.getInstance();
            int sec = d.get(Calendar.SECOND);
            int min = d.get(Calendar.MINUTE);
            int hour = d.get(Calendar.HOUR_OF_DAY);
            this.setFont(new Font("Apple Casual", Font.PLAIN, 18));
            this.setText(String.format("%02d:%02d:%02d", hour, min, sec));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new MyClock();
    }
    
}
