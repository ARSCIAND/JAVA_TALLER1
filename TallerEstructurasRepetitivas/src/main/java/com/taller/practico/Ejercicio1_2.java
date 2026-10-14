package com.taller.practico;
import java.util.Scanner;

public class Ejercicio1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean procesando = true;
        double acumulador = 0;
        String causa = "";

        while (procesando) {
            System.out.print("Ingresa el monto de la transacción: ");
            double monto = scanner.nextDouble();

            if (monto < 0) {
                procesando = false;
                causa = "Se ingresó un monto estrictamente negativo.";
            } else if (acumulador + monto > 1000000) {
                procesando = false;
                causa = "Se superó el límite máximo permitido de $1'000.000.";
            } else {
                acumulador += monto;
            }
        }

        System.out.println("\n--- INFORME DE CAJA ---");
        System.out.println("Saldo final acumulado: $" + acumulador);
        System.out.println("Causa de finalización: " + causa);
        scanner.close();
    }
}
