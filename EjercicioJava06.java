
package com.jmrh.ejerciciojava06;

import java.util.Scanner;                                                   // 1 paso

/**
 *
 * Andrey Felipe Pinto Uribe         192177
 * Angel Alfredo Urrego Olivera      192179
 */
public class EjercicioJava06 {                                              // 1 paso

    private static Tablero tablero;                                         // 1 paso
    private static Scanner scanner;                                         // 1 paso
    private static boolean partidaEnJuego;                                  // 1 paso

    public static void main(String[] args) {                                // 1 paso

        scanner = new Scanner(System.in);                                   // 1 paso
        menuPrincipal();                                                    //

    }                                                                       // 1 paso

    public static void menuPrincipal() {                                    // 1 paso

        int opcion;                                                         // 1 paso

        do {                                                                // n 
            System.out.println("\nMenu Principal\n");                       // n
            System.out.println("1. Iniciar Nueva Partida");                 // n
            System.out.println("2. Continuar partida actual");              // n
            System.out.println("3. Salir");                                 // n
            System.out.println("Introduce opción: ");                       // n

            try {                                                           // n
                opcion = Integer.parseInt(scanner.nextLine());              // n
            }                                                               // n
            catch (Exception e) {                                           // n
                opcion = 0;                                                 // n
            }                                                               // n

            switch (opcion) {                                               // n
                case 1:                                                     // n
                    iniciarPartida();                                       //
                    break;
                case 2:
                    if(partidaEnJuego)
                        continuarPartida();
                    else
                        System.out.println("No hay partida en juego");
                    break;
                case 3:
                    System.out.println("Fin del juego");
                    break;
                default:
                    System.out.println("Opción desconocida");
            }

        } while (opcion != 3);                                          // n + 1

    }

    public static void iniciarPartida() {                               // 1 paso
        tablero = new Tablero();                                        // 5 pasos
        partidaEnJuego = true;                                          // 1 paso
        juego();                                                        //
    }                                                                   // 1 paso
    
    public static void continuarPartida() {                             // 1 paso
        juego();                                                        // 
    }

    public static void juego() {                                        // 1 paso
        String direccion;                                               // 1 paso

        do {                                                            //n
        tablero.mostrar();                                              // n
        System.out.println("izq (a) / der (d) / arriba (w) / abajo (s) / menu (m): "); // n
        direccion = scanner.nextLine();                                 // n

        switch (direccion) {                                            // n
            case "w":                                                   // n
                tablero.moverArriba();                                  // n
                break;                                                  // n
            case "s":                                                   // n
                tablero.moverAbajo();                                   // n
                break;                                                  // n
            case "a":                                                   // n
                tablero.moverIzquierda();                               // n 
                break;                                                  // n
            case "d":                                                   // n
                tablero.moverDerecha();                                 // n
                break;                                                  // n
            case "m":                                                   // n
                System.out.println("Volviendo al menu...");             // n
                break;                                                  // n
            default:                                                    // n
                System.out.println("Opción desconocida");               // n
        }                                                               // n
        
        }                                                               // n 
        while(!direccion.equals("m") && !tablero.finPartida());         // n + 1

        if (tablero.finPartida()) {                                     //
            tablero.mostrar();
            String mensaje = tablero.ganador() ? "Has Ganado!!!" : "Has perdido";
            System.out.println(mensaje);
            partidaEnJuego = false;
        }

    }
}
