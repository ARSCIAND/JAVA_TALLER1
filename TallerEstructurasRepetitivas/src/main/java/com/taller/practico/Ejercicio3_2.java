package com.taller.practico;
import java.util.Scanner;
public class Ejercicio3_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa un número entero positivo N: ");
        int n = scanner.nextInt();

        // Parte A: Cálculo de Factorial
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println("El factorial de " + n + " (!) es: " + factorial);

        // Parte B: Patrón triangular
        System.out.println("\n--- PATRÓN TRIANGULAR ---");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
