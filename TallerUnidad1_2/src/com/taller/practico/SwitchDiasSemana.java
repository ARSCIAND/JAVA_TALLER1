package com.taller.practico;

import java.util.Scanner;

public class SwitchDiasSemana {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("=== SECCION 3: DIAS DE LA SEMANA Y TIPO DE JORNADA ===");
        System.out.print("Digite el numero del dia (1 = Lunes ... 7 = Domingo): ");
        int numeroDia = teclado.nextInt();


        String resultadoTradicional;

        switch (numeroDia) {
            case 1:
                resultadoTradicional = "Lunes - Jornada Laboral";
                break;
            case 2:
                resultadoTradicional = "Martes - Jornada Laboral";
                break;
            case 3:
                resultadoTradicional = "Miercoles - Jornada Laboral";
                break;
            case 4:
                resultadoTradicional = "Jueves - Jornada Laboral";
                break;
            case 5:
                resultadoTradicional = "Viernes - Jornada Laboral";
                break;
            case 6:
                resultadoTradicional = "Sabado - Fin de Semana (Descanso)";
                break;
            case 7:
                resultadoTradicional = "Domingo - Fin de Semana (Descanso)";
                break;
            default:
                resultadoTradicional = "Dia no valido, debe ser un numero del 1 al 7";
                break;
        }

        System.out.println("Switch tradicional: " + resultadoTradicional);

        String resultadoModerno = switch (numeroDia) {
            case 1 -> "Lunes - Jornada Laboral";
            case 2 -> "Martes - Jornada Laboral";
            case 3 -> "Miercoles - Jornada Laboral";
            case 4 -> "Jueves - Jornada Laboral";
            case 5 -> "Viernes - Jornada Laboral";
            case 6 -> "Sabado - Fin de Semana (Descanso)";
            case 7 -> "Domingo - Fin de Semana (Descanso)";
            default -> "Dia no valido, debe ser un numero del 1 al 7";
        };

        System.out.println("Switch moderno:     " + resultadoModerno);

        teclado.close();
    }
}
