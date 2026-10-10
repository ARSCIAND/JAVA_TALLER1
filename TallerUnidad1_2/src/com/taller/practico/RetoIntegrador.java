package com.taller.practico;

import java.util.Locale;

// Seccion 4: Reto Integrador
// Simulador Practico de Caja e Inventario (tienda tecnologica)
public class RetoIntegrador {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        double precioUnitario = 250.00;
        double porcentajeIva = 0.16;

        int cantidad = 3;
        String tipoCliente = "VIP";
        String cupon = "PROMO1 año";

        double subtotalBase = cantidad * precioUnitario;

        double porcentajeDescuento;
        switch (tipoCliente) {
            case "VIP":
                porcentajeDescuento = 0.20;
                break;
            case "REGULAR":
                porcentajeDescuento = 0.10;
                break;
            case "NUEVO":
                porcentajeDescuento = 0.05;
                break;
            default:
                porcentajeDescuento = 0.0;
                break;
        }
        double descuentoCliente = subtotalBase * porcentajeDescuento;
        double subtotalConDescuento = subtotalBase - descuentoCliente;

        double descuentoCupon;
        if (cupon.equals("PROMO1 año") && subtotalConDescuento >= 500.00) {
            descuentoCupon = 50.00;
        } else {
            descuentoCupon = 0.00;
        }

        double baseImponible = subtotalConDescuento - descuentoCupon;
        double iva = baseImponible * porcentajeIva;
        double total = baseImponible + iva;

        System.out.println("=== CASO DE PRUEBA A ===");
        System.out.println("Cantidad: " + cantidad + " | Cliente: " + tipoCliente + " | Cupon: " + cupon);
        System.out.printf("Subtotal base:          $%.2f%n", subtotalBase);
        System.out.printf("Descuento cliente:     -$%.2f%n", descuentoCliente);
        System.out.printf("Subtotal con descuento: $%.2f%n", subtotalConDescuento);
        System.out.printf("Descuento cupon:       -$%.2f%n", descuentoCupon);
        System.out.printf("Base imponible:         $%.2f%n", baseImponible);
        System.out.printf("IVA (16%%):             +$%.2f%n", iva);
        System.out.printf("Total a pagar = $%.2f%n", total);
        System.out.println();

        cantidad = 1;
        tipoCliente = "NUEVO";
        cupon = "PROMO1 año";

        subtotalBase = cantidad * precioUnitario;

        switch (tipoCliente) {
            case "VIP":
                porcentajeDescuento = 0.20;
                break;
            case "REGULAR":
                porcentajeDescuento = 0.10;
                break;
            case "NUEVO":
                porcentajeDescuento = 0.05;
                break;
            default:
                porcentajeDescuento = 0.0;
                break;
        }
        descuentoCliente = subtotalBase * porcentajeDescuento;
        subtotalConDescuento = subtotalBase - descuentoCliente;

        if (cupon.equals("PROMO1 año") && subtotalConDescuento >= 500.00) {
            descuentoCupon = 50.00;
        } else {
            descuentoCupon = 0.00;
        }

        baseImponible = subtotalConDescuento - descuentoCupon;
        iva = baseImponible * porcentajeIva;
        total = baseImponible + iva;

        System.out.println("=== CASO DE PRUEBA B ===");
        System.out.println("Cantidad: " + cantidad + " | Cliente: " + tipoCliente + " | Cupon: " + cupon);
        System.out.printf("Subtotal base:          $%.2f%n", subtotalBase);
        System.out.printf("Descuento cliente:     -$%.2f%n", descuentoCliente);
        System.out.printf("Subtotal con descuento: $%.2f%n", subtotalConDescuento);
        System.out.printf("Descuento cupon:       -$%.2f%n", descuentoCupon);
        System.out.printf("Base imponible:         $%.2f%n", baseImponible);
        System.out.printf("IVA (16%%):             +$%.2f%n", iva);
        System.out.printf("Total a pagar = $%.2f%n", total);
    }
}
