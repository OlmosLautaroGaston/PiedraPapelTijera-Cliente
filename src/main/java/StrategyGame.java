import java.util.Scanner;

public class StrategyGame {
    private String usuario = "", ordenador = "";
    private Scanner scanner = new Scanner(System.in);

    public StrategyGame() {
        System.out.println("*** Juego Piedra Papel y Tijera - Cliente ***");
        System.out.println("*** Elige una opción ***");
    }

    public String readData() {
        usuario = scanner.next();
        return usuario;
    }

    public boolean validateInput() {
        boolean i = false;
        if (!usuario.equals("piedra") && !usuario.equals("papel") && !usuario.equals("tijera")) {
            System.out.println("*** La opción ingresada es incorrecta, intenta con 'piedra', 'papel' o 'tijera' ***");
        } else {
            i = true;
            System.out.println("Elejiste " + usuario);
        }
        return i;
    }

    public void logicGame(String ordenador) {
        System.out.println("Maquina Servidor eligió : " + ordenador);
        if (usuario.equals(ordenador)) {
            System.out.println("\n** Empate **\n");
        } else {
            if ((usuario.equals("piedra") && ordenador.equals("papel"))
                    || (usuario.equals("papel") && ordenador.equals("tijera"))
                    || (usuario.equals("tijera") && ordenador.equals("piedra"))) {
                System.out.println("\n** Perdite **\n");
            } else {
                System.out.println("\n** Ganaste **\n");
            }
        }
    }
}