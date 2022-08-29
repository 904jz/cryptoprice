
package cryptopricetracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

public class Dashboard extends JFrame implements ActionListener{
    String[] coinIds = {"bitcoin","ethereum","tether","usd-coin","binancecoin","binance-usd","ripple","cardano","solana","dogecoin","shiba-inu"};
    Choice c1;
    JTextField j1,j2;
    JButton b1;
    String id;
    Dashboard(){
        setBounds(200,200,400,250);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,600,800);
        add(p1);
        
        JLabel l1 = new JLabel("Choose coin:");
        l1.setBounds(80,10,100,30);
        p1.add(l1);
        
        c1 = new Choice();
        c1.setBounds(190,15,100,30);
        c1.add("Bitcoin");
        c1.add("Ethereum");
        c1.add("Tether");
        c1.add("USD Coin");
        c1.add("BNB");
        c1.add("Binance USD");
        c1.add("Ripple");
        c1.add("Cardano");
        c1.add("Solana");
        c1.add("Doge Coin");
        c1.add("Shiba Inu");
        p1.add(c1);
        
        JLabel l2 = new JLabel("Price in USD:");
        l2.setBounds(80,60,100,30);
        p1.add(l2);
        
        JLabel l3 = new JLabel("24h change in USD:");
        l3.setBounds(50,110,130,30);
        p1.add(l3);
        
        j1 = new JTextField();
        j1.setBounds(190,60,100,25);
        p1.add(j1);
        
        j2 = new JTextField();
        j2.setBounds(190, 110,100,25);
        p1.add(j2);
        
        b1 = new JButton("Get Price");
        b1.setBounds(120,160,120,30);
        p1.add(b1);
        
        b1.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == b1){
            String coin = c1.getSelectedItem();
            switch (coin) {
                case "Bitcoin":
                    id = coinIds[0];
                    break;
                case "Ethereum":
                    id = coinIds[1];
                    break;
                case "Tether":
                    id = coinIds[2];
                    break;
                case "USD Coin":
                    id = coinIds[3];
                    break;
                case "BNB":
                    id = coinIds[4];
                    break;
                case "Binance USD":
                    id = coinIds[5];
                    break;
                case "Ripple":
                    id = coinIds[6];
                    break;
                case "Cardano":
                    id = coinIds[7];
                    break;
                case "Solana":
                    id = coinIds[8];
                    break;
                case "Doge Coin":
                    id = coinIds[9];
                    break;
                case "Shiba Inu":
                    id = coinIds[10];
                   
                    break;
                    
                }
            
            URL url = null;
            try {
                url = new URL("https://api.coingecko.com/api/v3/simple/price?ids="+ id + "&vs_currencies=usd&include_24hr_change=true");
            } catch (MalformedURLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            String out = "";
            try{
            URLConnection urlConnection = url.openConnection();
            InputStream input = urlConnection.getInputStream();
            int data = input.read();
            while(data != -1){
                out += ((char) data);
                data = input.read();
                }
            input.close();
            } catch(IOException exc){
                System.out.println(exc.getMessage());
            }
            String[] comps = out.split(":");
            //System.out.println(out);
            
            String one = comps[2].split(",")[0];
            //System.out.println(one);
            
            String two = String.format("%.2f",Float.parseFloat(comps[3].split("}")[0]));
            //System.out.println(two);
            j1.setText(one);
            j2.setText(two);
            //System.out.println(comps[3]);
            
            
            
            
            
        }
    }
    public static void main(String[] args){
        new Dashboard().setVisible(true);
    }
}


//https://api.coingecko.com/api/v3/simple/price?ids=| |&vs_currencies=usd&include_24hr_change=true
