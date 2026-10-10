package com.taller.practico;


public class Reto1Edades {
    public static void main(String[] args) {


        int edadUsuario = 15;

        String categoria;
        String perfil;


        if (edadUsuario < 12) {
            categoria = "Infante";
            perfil = "Requiere tutor de cuenta";
        } else if (edadUsuario >= 12 && edadUsuario <= 17) {
            categoria = "Adolescente";
            perfil = "Acceso restringido a foros comunitarios";
        } else if (edadUsuario >= 18 && edadUsuario <= 64) {
            categoria = "Adulto";
            perfil = "Acceso a funcionalidades estandar";
        } else {

            categoria = "Adulto Mayor";
            perfil = "Acceso con interfaz adaptada";
        }

        System.out.println("=== RETO 1: CLASIFICACION DE EDADES ===");
        System.out.println("Edad del usuario: " + edadUsuario);
        System.out.println("Categoria asignada: " + categoria);
        System.out.println("Perfil de acceso: " + perfil);
    }
}
