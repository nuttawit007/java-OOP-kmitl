import java.awt.Font;
import javax.swing.*;
public class MyClock_3 extends JLabel implements Runnable{
    private int sec = 0;
    private int min = 0;
    private int hour = 0;
    private boolean paused = false;
    @Override
    public void run() {
        while (true){
            this.checkPaused();
            if (sec == 59){
                sec = 0;
                min += 1;
                if (min > 60){
                    min = 0;
                    hour += 1;
                }
            }
            else if (sec < 60){
                sec += 1;
            }
            this.setFont(new Font("Apple Casual", Font.PLAIN, 18));
            this.setText(String.format("%02d:%02d:%02d", hour, min, sec));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private synchronized void checkPaused(){
        while (paused){
            try{
                this.wait();
            }
            catch (InterruptedException ex){ 
                ex.printStackTrace(); 
            }
        }
    }
    public synchronized void opposite(){  
        
        this.paused = !paused;    
        System.out.println(this.paused);
        if (this.paused == false){
            this.notify();
        } 
    }
    public boolean getPaused(){
        return this.paused;
    }
}
