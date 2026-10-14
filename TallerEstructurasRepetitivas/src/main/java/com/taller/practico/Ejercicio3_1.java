package com.taller.practico;
import java.util.Scanner;
public class Ejercicio3_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa un número entero N: ");
        int n = scanner.nextInt();

        System.out.println("\n--- TABLA DE MULTIPLICAR ---");
        for (int i = 1; i <= 12; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }

        System.out.println("\n--- CONTEO REGRESIVO ---");
        for (int i = n; i >= 0; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
        scanner.close();
    }
}
