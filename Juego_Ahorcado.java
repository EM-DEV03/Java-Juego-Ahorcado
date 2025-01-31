import java.util.Scanner;

public class Juego_Ahorcado {
    public static void main(String[] args) {
        // Clase scanner que nos permite que el usuario escriba
        Scanner let = new Scanner(System.in);

        // Declaracion y Asignacion
        String plabraSecreta = "programa";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        // Arreglos:
        char[] letrasAdivinadas = new char[plabraSecreta.length()];

        // Estructura de control: Iterativa (Bucle)
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        // Estructura de control: Iterativa (Bucle)
        while (!palabraAdivinada && intentos < intentosMaximos) {
            System.out.println("Plabra a divinar: " + String.valueOf(letrasAdivinadas) + " (" + plabraSecreta.length() + " letras)");

            System.out.print("Introduce una letra, por favor: ");
            char letra = Character.toLowerCase(let.next().charAt(0));

            boolean letraCorrecta = false;

            for (int i = 0; i < plabraSecreta.length(); i++) {
                if (plabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta) {
                intentos++;
                System.out.println("Letra incorrecta! Te quedan " + (intentosMaximos - intentos) + " Intentos.");
            }

            if (String.valueOf(letrasAdivinadas).equals(plabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("Felicidades, has adivinado la palabra secreta: " + plabraSecreta);
            }
        }

        if (!palabraAdivinada) {
            System.out.println("GAME OVER");
        }
        let.close();
    }
}