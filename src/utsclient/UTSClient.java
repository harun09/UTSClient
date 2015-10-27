/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utsclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Harun Al Rasyid
 */
public class UTSClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Socket socket;
        PrintWriter out;
        BufferedReader in;
        BufferedReader userin;
        
        try {
            socket = new Socket("10.151.34.155", 6666);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            userin = new BufferedReader(new InputStreamReader(System.in));
            String usrinp=userin.readLine();
            
            while (!usrinp.equals("exit")) {
                
                System.out.println(in.readLine());
                for(int i=1;in.ready();i++)
                {
                    out.println(usrinp);
                    out.flush();
                    System.out.println(in.readLine());
                }
                
            }
           out.close(); 
        } catch (IOException ex) {
            Logger.getLogger(UTSClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
