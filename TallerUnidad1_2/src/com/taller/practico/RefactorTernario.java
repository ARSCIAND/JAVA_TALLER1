package com.taller.practico;

public class RefactorTernario {
    public static void main(String[] args) {

        boolean cookieSesionActiva = true;

        String estadoConexion;
        if (cookieSesionActiva == true) {
            estadoConexion = "ACTIVA";
        } else {
            estadoConexion = "INACTIVA";
        }

        String estadoConexionTernario = cookieSesionActiva ? "ACTIVA" : "INACTIVA";

        System.out.println("=== REFACTORIZACION A OPERADOR TERNARIO ===");
        System.out.println("Con if-else:  " + estadoConexion);
        System.out.println("Con ternario: " + estadoConexionTernario);
    }
}
