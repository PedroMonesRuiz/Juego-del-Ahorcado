/* 
    Realizar el juego del ahorcado. 

    Primero se debe ingresar la palabra a adivinar. 
    Luego se muestra por cada letra un guión bajo para que el jugador 
    sepa la cantidad de letras a adivinar. 
    Se irá ingresando una a una las letras y si estas se encuentran en la palabra 
    las deberá ir mostrando en el lugar correspondiente. 
    Por cada letra que no se encuentre en la palabra perderá una vida. 
    El jugador dispondrá de 6 vidas para intentar ganar el juego. 
    
    Modificación: Ir completando el dibujo del muñeco del ahorcado cada vez 
    que se comete un error.

 */

import java.util.ArrayList;
import java.util.Scanner;

public class juegoDelAhorcado {

    static Scanner SC = new Scanner(System.in);
    static String palabraAdivinar;
    static char palabraOculta[];
    static int vidas = 6, palabraCompleta = 0;
    static ArrayList<Character> letras = new ArrayList<>();

    public static void main(String[] args) {
        int tamaño = 0;
        String respuesta = " ";

        do {
            vidas = 6; palabraCompleta = 0; tamaño = 0;
            letras.clear();
            while (tamaño < 2) {
                tamaño = inicio();
            }
            while (vidas > 0 && palabraCompleta != tamaño) {
                adivinar(tamaño);
            }
            respuesta = resultado();
        } while (respuesta.compareToIgnoreCase("si") == 0);
    }

    public static int inicio() {
        System.out.println("¡Bienvenido al juego del ahorcado!");
        System.out.println("");
        System.out.print("Ingrese la palabra a adivinar de al menos 2 caracteres: ");
        palabraAdivinar = SC.next();
        if (palabraAdivinar.length()< 2) {
            System.out.println("");
            System.out.println("ERROR.");
            System.out.println("Ingrese una palabra de mas de 2 caracteres.");
            System.out.println("");
            return palabraAdivinar.length();
        }
        palabraOculta = palabraAdivinar.toCharArray();
        for (int i = 0; i < palabraAdivinar.length(); i++) {
            palabraOculta[i] = '_';
        }

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        return palabraAdivinar.length();
    }

    public static int adivinar(int tamaño) {
        int incorrecto = 0;
        System.out.println("¿Cual es la siguiente palabra de " + tamaño + " caracteres?");
        dibujo();
        System.out.println("");
        for (int i = 0; i < tamaño; i++) {
            System.out.print(palabraOculta[i] + " ");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("Cantidad de vidas: " + vidas);
        System.out.println("");
        System.out.print("Ingrese una letra: ");
        char letra = SC.next().charAt(0);
        for (int i = 0; i < letras.size(); i++) {
            if (letra == letras.get(i)) {
                System.out.println("");
                System.out.println("Ya ingresaste esa letra.");
                System.out.println("Por favor ingresa una letra diferente.");
                System.out.println("");
                return incorrecto;
            }
        }
        letras.add(letra);
        System.out.println("");

        for (int i = 0; i < tamaño; i++) {
            if (letra == palabraAdivinar.charAt(i)) {
                palabraOculta[i] = letra;
                palabraCompleta++;
                System.out.println(palabraCompleta);
            } else {
                incorrecto++;
            }
        }
        if (incorrecto == tamaño) {
            vidas--;
            System.out.println("");
            System.out.println("Incorrecto");
            System.out.println("");
        } else {
            System.out.println("");
            System.out.println("Correcto");
            System.out.println("");
        }
        return incorrecto;
    }

    public static void dibujo() {
        if (vidas == 6) {
            System.out.println("");
            System.out.println("|-----¬");
            System.out.println("|      ");
            System.out.println("|      ");
            System.out.println("|      ");
        } else if (vidas == 5) {
            System.out.println("");
            System.out.println("|-----¬");
            System.out.println("|     o");
            System.out.println("|      ");
            System.out.println("|      ");
        } else if (vidas == 4) {
            System.out.println("");
            System.out.println("|-----¬");
            System.out.println("|     o");
            System.out.println("|     |");
            System.out.println("|      ");
        } else if (vidas == 3) {
            System.out.println("");
            System.out.println("|-----¬");
            System.out.println("|     o");
            System.out.println("|    /|");
            System.out.println("|      ");
        } else if (vidas == 2) {
            System.out.println("");
            System.out.println("|-----¬");
            System.out.println("|     o");
            System.out.println("|    /|\\");
            System.out.println("|      ");
        } else if (vidas == 1) {
            System.out.println("");
            System.out.println("|-----¬");
            System.out.println("|     o");
            System.out.println("|    /|\\");
            System.out.println("|    /");
        } else if (vidas == 0) {
            System.out.println("");
            System.out.println("|-----¬");
            System.out.println("|     o");
            System.out.println("|    /|\\");
            System.out.println("|    / \\");
        }
    }

    public static String resultado() {
        if (vidas == 0) {
            System.out.println("");
            System.out.println("¡Perdiste, te quedaste sin vidas! La palabra era: " + palabraAdivinar);
            System.out.println("");
            dibujo();
        } else {
            System.out.println("");
            System.out.println("¡Felicidades! Adivinaste la palabra " + palabraAdivinar);
            System.out.println("");
            dibujo();
        }
        System.out.println("");
        System.out.print("¿Desea volver a jugar? Si - No: ");
        String respuesta = SC.next();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        return respuesta;
    }
}
