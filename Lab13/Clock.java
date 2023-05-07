import java.awt.*;
import java.util.Calendar;
import javax.swing.*;

public class Clock extends JLabel implements Runnable{
    public void run(){
        while (true) {
            Calendar d = Calendar.getInstance();
            int sec = d.get(Calendar.SECOND);
            int min = d.get(Calendar.MINUTE);
            int hour = d.get(Calendar.HOUR_OF_DAY);
            String timer = String.format("%02d:%02d:%02d", hour, min, sec);
            setText(timer);
            try {
            System.out.println(getText());
            Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public Clock(){
        setText(getText());
        setFont(new Font("Arial", Font.BOLD, 34));
        setVisible(true);
    }
}
