package com.taller.practico;

import java.util.Scanner;

public class Ejercicio1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int acumulador = 0;
        int contador = 0;

        System.out.print("Ingresa un número (-99 para salir): ");
        int numero = scanner.nextInt();

        while (numero != -99) {
            acumulador += numero;
            contador++;
            System.out.print("Ingresa otro número (-99 para salir): ");
            numero = scanner.nextInt();
        }

        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Total acumulado: " + acumulador);
        System.out.println("Cantidad de números válidos ingresados: " + contador);
        scanner.close();
    }
}
