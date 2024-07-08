
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LAB203_62
 */
public class MessageLog implements Serializable {
    private int id;
    private String message, date;
    public MessageLog(int id, String date, String message) {
      this.id = id;
      this.date = date;
      this.message = message;
    }
    
    public String generateMessage() {
        return date + " : " + message;
    }
}
