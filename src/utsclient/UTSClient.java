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
    public static void main(String[] args) throws IOException {
        String host = "10.151.43.147";
        
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        
        try {
            socket = new Socket(host, 6666);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(UTSClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        BufferedReader userIn;
        userIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        
        while(!(userInput = userIn.readLine()).equals("exit")){
            out.println(userInput);
            out.flush();
            System.out.println(in.readLine());
            for(int i = 0; in.ready(); i++) {
                System.out.println(in.readLine());
            }
        }
        
        in.close();
        out.close();
        userIn.close();
        socket.close();
    }
    
}
