package com.taller.practico;

import java.util.Scanner;

public class EjercicioIntegrador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        int totalUnidadesAlmacen = 0;
        int totalProductosRegistrados = 0;
        double valorTotalInventario = 0;
        final int CAPACIDAD_MAXIMA = 500;

        do {
            System.out.println("\n--- SISTEMA DE CONTROL DE INVENTARIO ---");
            System.out.println("1. Registrar Lote de Productos");
            System.out.println("2. Ver Estado del Almacén");
            System.out.println("3. Salir del Sistema");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad de productos del lote (N): ");
                    int n = scanner.nextInt();
                    boolean sobrecupo = false;

                    for (int i = 1; i <= n; i++) {
                        System.out.println("\n--- Producto " + i + " de " + n + " ---");

                        System.out.print("¿El producto está descontinuado? (true/false): ");
                        boolean descontinuado = scanner.nextBoolean();


                        if (descontinuado) {
                            System.out.println("Producto descontinuado. Omitiendo...");
                            continue;
                        }


                        double precio = 0;
                        while (precio <= 0) {
                            System.out.print("Ingrese el precio unitario (> 0): ");
                            precio = scanner.nextDouble();
                            if (precio <= 0) {
                                System.out.println("Error: El precio debe ser mayor a cero.");
                            }
                        }


                        int stock = 0;
                        while (stock <= 0) {
                            System.out.print("Ingrese la cantidad en stock (> 0): ");
                            stock = scanner.nextInt();
                            if (stock <= 0) {
                                System.out.println("Error: La cantidad debe ser mayor a cero.");
                            }
                        }


                        if (totalUnidadesAlmacen + stock > CAPACIDAD_MAXIMA) {
                            System.out.println("¡ALERTA DE SOBRECUPO! Se excede la capacidad máxima de " + CAPACIDAD_MAXIMA + " unidades.");
                            sobrecupo = true;
                            break;
                        }

                        totalUnidadesAlmacen += stock;
                        totalProductosRegistrados++;
                        valorTotalInventario += (precio * stock);
                        System.out.println("¡Producto registrado exitosamente!");
                    }

                    if (sobrecupo) {
                        System.out.println("El procesamiento del lote fue abortado debido al sobrecupo.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- ESTADO ACTUAL DEL ALMACÉN ---");
                    System.out.println("Productos registrados: " + totalProductosRegistrados);
                    System.out.println("Capacidad utilizada: " + totalUnidadesAlmacen + " / " + CAPACIDAD_MAXIMA + " unidades");
                    System.out.println("Valor total del inventario: $" + valorTotalInventario);
                    break;

                case 3:
                    System.out.println("Saliendo del sistema de inventario. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}