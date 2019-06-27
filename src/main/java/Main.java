import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        String user;
        StrategyGame game = new StrategyGame();

        user = game.validateInput();
        try {
            System.out.println("Preparando conexión. ip local, puerto 9999");
            Socket socket = new Socket("127.0.0.1 ", 9999);
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF(user);
            output.close();
            System.out.println("Respuesta enviada a Maquina Servidor...");
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            System.out.println(e1.getMessage());
        }
        game.logicGame();
    }
}
