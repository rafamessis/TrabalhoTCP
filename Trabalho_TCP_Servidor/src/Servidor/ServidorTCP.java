package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.internal.util.xml.impl.Input;



/**
 *
 * @author Rafael
 */
public class ServidorTCP {
    public static void main(String[] args) {
        
        ArrayList<PrintStream> clientes = new ArrayList<>();
        
        
        try {
            ServerSocket server = new ServerSocket(1500);
            Socket socket;
            
            
            while(true){
               socket = server.accept();
               
               //Guarda o endereço do cliente
               clientes.add(new PrintStream(socket.getOutputStream()));
                
               Mensagem mensagem = new Mensagem(socket,clientes);
               
               
                
                
                
                
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(ServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
