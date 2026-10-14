package com.taller.practico;
import java.util.Scanner;
public class Ejercicio2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- PLATAFORMA BANCARIA ---");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Realizar Depósito");
            System.out.println("3. Realizar Retiro");
            System.out.println("4. Salir del Sistema");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("-> Tu saldo actual es de $500.000");
                    break;
                case 2:
                    System.out.println("-> Depósito realizado con éxito.");
                    break;
                case 3:
                    System.out.println("-> Retiro realizado con éxito.");
                    break;
                case 4:
                    System.out.println("-> Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("-> Opción inválida. Intenta nuevamente.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
