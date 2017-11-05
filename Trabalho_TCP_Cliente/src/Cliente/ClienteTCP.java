package Cliente;
import  javax.swing.JOptionPane;


/**
 *
 * @author Rafael
 */
public class ClienteTCP {
    public static void main(String[] args) {
        
        String nome = JOptionPane.showInputDialog(null,"Digite seu nome: ", " ", JOptionPane.PLAIN_MESSAGE);
                
        Chat chat = new Chat(nome);
        chat.setVisible(true);
    }
    
}
