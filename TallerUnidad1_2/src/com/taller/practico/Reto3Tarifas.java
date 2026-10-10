package com.taller.practico;

public class Reto3Tarifas {
    public static void main(String[] args) {

        String tipoEntrada = "ESTUDIANTE";
        double precioBase = 100.0;

        double precioFinal;
        String detalle;

        if (tipoEntrada.equals("VIP")) {
            precioFinal = precioBase + (precioBase * 0.10);
            detalle = "Recargo del 10% por beneficios exclusivos";
        } else if (tipoEntrada.equals("ESTUDIANTE")) {
            precioFinal = precioBase - (precioBase * 0.50);
            detalle = "Descuento del 50%";
        } else if (tipoEntrada.equals("ADULTO_MAYOR")) {
            precioFinal = precioBase - (precioBase * 0.40);
            detalle = "Descuento del 40%";
        } else if (tipoEntrada.equals("GENERAL")) {
            precioFinal = precioBase;
            detalle = "Tarifa base sin modificaciones";
        } else {
            precioFinal = precioBase;
            detalle = "Tipo de entrada no reconocido, se cobra tarifa base";
        }

        System.out.println("=== RETO 3: TARIFAS DE ENTRADA ===");
        System.out.println("Tipo de entrada: " + tipoEntrada);
        System.out.println("Precio base: $" + precioBase);
        System.out.println("Detalle: " + detalle);
        System.out.println("Monto final a pagar: $" + precioFinal);
    }
}
