
package cryptopricetracker;

import javax.swing.*;
import java.awt.*;

public class CryptoPriceTracker {

    
    public static void main(String[] args) {
        // TODO code application logic here
        SplashFrame sf = new SplashFrame();
        sf.setVisible(true);
        int x = 1;
        for (int i = 1; i <= 600; i+=8, x+=8){
            sf.setLocation(640 - (x + i)/2,400 - (i/2));
            sf.setSize(x + i,i);
            
        }
        sf.setVisible(true); 
        
                
    }
}
    
    class SplashFrame extends JFrame implements Runnable {
        Thread t1;
        
        @Override
        public void run(){
            try{
                Thread.sleep(3000);
                this.setVisible(false);
                new Dashboard().setVisible(true);
            }catch(Exception e){}
        }
        SplashFrame(){
            ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("cryptopricetracker.assets/stonks.jpg"));
            Image i2 = ii.getImage().getScaledInstance(1200,600,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel l1 = new JLabel(i3);
            
            add(l1);
            setUndecorated(true);
            t1 = new Thread(this);
            t1.start();
        }    
            
            
    }
    

