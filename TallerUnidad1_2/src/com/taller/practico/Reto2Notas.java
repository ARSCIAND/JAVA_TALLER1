package com.taller.practico;

public class Reto2Notas {
    public static void main(String[] args) {

        double calificacionFinal = 65.0;
        int porcentajeAsistencia = 75;
        boolean entregoProyectoFinal = true;

        String estado;


        if (calificacionFinal >= 70.0 && porcentajeAsistencia >= 80) {
            estado = "Aprobado";
        } else if (entregoProyectoFinal == true && calificacionFinal >= 60.0) {

            estado = "Pendiente de Examen Extraordinario";
        } else {
            estado = "Reprobado";
        }

        System.out.println("=== RETO 2: APROBACION DE NOTAS Y ASISTENCIA ===");
        System.out.println("Calificacion final: " + calificacionFinal);
        System.out.println("Asistencia: " + porcentajeAsistencia + "%");
        System.out.println("Entrego proyecto final: " + entregoProyectoFinal);
        System.out.println("Dictamen academico: " + estado);
    }
}
