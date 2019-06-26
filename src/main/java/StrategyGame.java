import java.util.Scanner;

public class StrategyGame {
    private byte aleatorio;
    private String usuario = "", ordenador = "";
    private Scanner scanner = new Scanner(System.in);

    public StrategyGame() {
        System.out.println("*** Juego Piedra Papel y Tijera ***");
        System.out.println("*** Elige una opción ***");
        usuario = scanner.next();
    }

    public void validateInput() {
        if (!usuario.equals("piedra") && !usuario.equals("papel") && !usuario.equals("tijera")) {
            System.out.println("*** La opción ingresada es incorrecta, intenta con 'piedra', 'papel' o 'tijera' ***");
        } else {
            aleatorio = (byte) (Math.random() * 3);
            switch (aleatorio) {
                case 0:
                    ordenador = "piedra";
                    break;
                case 1:
                    ordenador = "papel";
                    break;
                case 2:
                    ordenador = "tijera";
                    break;
            }

        }
        System.out.println("ordenador " + ordenador);
    }

    public void logicGame(){
        if(usuario.equals(ordenador)){
            System.out.println("\n** Empate **\n");
        }else{
            if ((usuario.equals("piedra") && ordenador.equals("papel"))
                    || (usuario.equals("papel") && ordenador.equals("tijera"))
                    || (usuario.equals("tijera") && ordenador.equals("piedra")))
            {
                System.out.println("\n** Perdite **\n");
            }
            else{
                System.out.println("\n** Ganaste **\n");
            }
        }
    }
}