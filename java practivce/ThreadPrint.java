import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class javaThread extends Thread {
    int x=0;
    
    public void start(DateTimeFormatter formatter) {
        while (true) {
LocalDateTime now = LocalDateTime.now();
System.out.println("thread is running: " + now.format(formatter));
            
            x++;
            try {
               Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("thread sleep error: ");
            } 
            if(x==10)
            {
                break;
            }
        }
    }
}

public class ThreadPrint{

    public static void main(String[] args) {
        javaThread thre = new javaThread();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        thre.start(formatter);
        
    }

}