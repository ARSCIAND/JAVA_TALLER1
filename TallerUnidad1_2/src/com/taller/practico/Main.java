package com.taller.practico;


public class Main {
    public static void main(String[] args) {


        int x = 7;
        boolean flag = false;

        System.out.println("=== SECCION 1: CALENTAMIENTO DE OPERADORES ===");


        int seg = 86400 % 3600;
        System.out.println("1) seg = " + seg);


        x = 7;

        int y = ++x + x++;
        System.out.println("2) y = " + y + "   (x termino en " + x + ")");


        double div1 = 15 / 2;

        double div2 = 15.0 / 2;
        System.out.println("3) div1 = " + div1);
        System.out.println("   div2 = " + div2);


        x = 7;

        boolean res = flag && (++x > 0);
        System.out.println("4) res = " + res + "   (x termino en " + x + ")");
    }
}
