package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class Mensagem {

    private Socket s;
    private ArrayList<PrintStream> clientes;

    public Mensagem(Socket s, ArrayList<PrintStream> clientes) {
        this.s = s;
        this.clientes = clientes;
        Thread();
    }

    private void Thread() {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {

                String mensagem = "";

                try {
                    InputStreamReader isr = new InputStreamReader(s.getInputStream());
                    BufferedReader br = new BufferedReader(isr);

                    while ((mensagem = br.readLine()) != null) {
                        enviaMensagem(mensagem);

                    }

                } catch (IOException ex) {

                    Logger.getLogger(Mensagem.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        
        thread.start();

    }

    private void enviaMensagem(String mensagem) {

        for (int a = 0; a < clientes.size(); a++) {

            clientes.get(a).println(mensagem);
            clientes.get(a).flush();

        }
    }

}
