import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        String clientResp;
        String serverResp = "";
        boolean i;
        StrategyGame game = new StrategyGame();
        do {
            clientResp = game.readData();
            i = game.validateInput();
        } while (i == false);
        try {
            System.out.println("Preparando conexión. ip local, puerto 9999");
            /**Establishing connection... **/
            Socket socket = new Socket("127.0.0.1 ", 9999);   //conectamos el socket a la ip y puerto destino
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());  //Asignamos al socket un flujo de salida
            /**Sending package information... **/
            output.writeUTF(clientResp);           //lee caracteres y asigna ClientResponse a flujo de salida
            /**Receive package information.. **/
            DataInputStream input = new DataInputStream(socket.getInputStream()); //Devuelve un flujo de entrara al socket
            serverResp = input.readUTF();             //lee caracteres y los almacena en String ClientResponse.
            output.close();                            //Cerramos la conexión
            /** finished connection **/
            System.out.println("Respuesta enviada a Maquina Servidor...");
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            System.out.println(e1.getMessage());
        }
        game.logicGame(serverResp);
    }
}
