package com.educacion.ahorcado;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    // palabras del juego (sin tildes para no complicar la comparacion)
    static final String[] PALABRAS = {"JAVA", "CLASE", "OBJETO", "METODO", "VARIABLE", "STRING", "BUCLE", "CONSOLA"};

    // estadisticas de toda la sesion
    static int partidasJugadas = 0;
    static int partidasGanadas = 0;
    static double puntajeAcumulado = 0.0;
    static double mejorPuntaje = 0.0;

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n===== ADIVINA LA PALABRA SECRETA =====");
            System.out.println("1. Jugar");
            System.out.println("2. Ver Estadisticas");
            System.out.println("3. Salir");

            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    jugar();
                    break;
                case 2:
                    mostrarEstadisticas();
                    break;
                case 3:
                    System.out.println("Gracias por jugar, hasta luego!");
                    break;
            }
        } while (opcion != 3);

        sc.close();
    }

    // lee la opcion como texto y la pasa a numero, repite hasta que sea 1, 2 o 3
    static int leerOpcion() {
        int opcion = 0;
        boolean valida = false;

        while (!valida) {
            System.out.print("Elige una opcion: ");
            String entrada = sc.nextLine().trim();
            try {
                opcion = Integer.parseInt(entrada);
                if (opcion >= 1 && opcion <= 3) {
                    valida = true;
                } else {
                    System.out.println("  [!] Esa opcion no existe, solo puedes elegir 1, 2 o 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("  [!] '" + entrada + "' no es un numero. Escribe 1, 2 o 3.");
            }
        }
        return opcion;
    }

    static void jugar() {
        // ---------- registro del jugador ----------
        String nombreJugador = "";
        while (nombreJugador.length() == 0) {
            System.out.print("\nEscribe tu nombre: ");
            nombreJugador = sc.nextLine().trim().toUpperCase();
            if (nombreJugador.length() == 0) {
                System.out.println("  [!] El nombre no puede estar vacio.");
            }
        }

        // palabra al azar
        String palabraSecreta = PALABRAS[(int) (Math.random() * PALABRAS.length)];

        // reto 2: entre mas larga la palabra, mas intentos
        final int MAX_INTENTOS;
        if (palabraSecreta.length() <= 4) {
            MAX_INTENTOS = 6;
        } else if (palabraSecreta.length() <= 6) {
            MAX_INTENTOS = 7;
        } else {
            MAX_INTENTOS = 8;
        }

        int intentosRestantes = MAX_INTENTOS;
        double puntaje = 0.0;
        boolean juegoGanado = false;
        char ultimaLetra = ' ';
        int aciertos = 0;
        int fallos = 0;
        boolean pistaUsada = false;

        // mascara tipo "_ _ _ _" y el historial de letras
        StringBuilder mascara = new StringBuilder();
        for (int i = 0; i < palabraSecreta.length(); i++) {
            mascara.append("_ ");
        }
        StringBuilder historial = new StringBuilder();

        System.out.printf("%nHola %s! La palabra tiene %d letras y tienes %d intentos.%n",
                nombreJugador, palabraSecreta.length(), MAX_INTENTOS);
        System.out.println("(escribe RENDIRSE si te quieres rendir)");

        // ---------- bucle del juego ----------
        while (intentosRestantes > 0 && !juegoGanado) {
            System.out.println("\nPalabra:   " + mascara);
            System.out.println("Usadas:    " + (historial.length() == 0 ? "-" : historial));
            System.out.println("Intentos:  " + intentosRestantes + " / " + MAX_INTENTOS);
            System.out.print("Letra: ");
            String entrada = sc.nextLine().trim();

            if (entrada.length() == 0) {
                System.out.println("  [!] No escribiste nada.");
                continue;
            }
            if (entrada.equalsIgnoreCase("RENDIRSE")) {
                System.out.println("Te rendiste...");
                break;
            }

            ultimaLetra = Character.toUpperCase(entrada.charAt(0));

            if (!Character.isLetter(ultimaLetra)) {
                System.out.println("  [!] Eso no es una letra.");
                continue;
            }
            if (historial.indexOf(String.valueOf(ultimaLetra)) >= 0) {
                System.out.println("  [!] Ya habias usado la " + ultimaLetra + ", prueba otra.");
                continue;
            }

            historial.append(ultimaLetra).append(" ");

            // buscar la letra en la palabra y destapar en la mascara
            boolean acierto = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                String letraPalabra = String.valueOf(palabraSecreta.charAt(i));
                if (letraPalabra.equalsIgnoreCase(String.valueOf(ultimaLetra))) {
                    mascara.setCharAt(i * 2, palabraSecreta.charAt(i)); // *2 por los espacios
                    acierto = true;
                }
            }

            if (acierto) {
                aciertos++;
            } else {
                fallos++;
                intentosRestantes--; // solo se resta cuando falla
            }

            System.out.println(acierto ? "  Bien! La " + ultimaLetra + " si esta."
                    : "  Uy, la " + ultimaLetra + " no esta.");

            // si ya no quedan guiones gano
            if (mascara.indexOf("_") == -1) {
                juegoGanado = true;
                break;
            }

            // reto 1: pista cuando queda un solo intento
            if (intentosRestantes == 1 && !pistaUsada) {
                for (int i = 0; i < palabraSecreta.length(); i++) {
                    if (mascara.charAt(i * 2) == '_') {
                        System.out.println("  PISTA: una de las letras que faltan es la "
                                + palabraSecreta.substring(i, i + 1));
                        break;
                    }
                }
                pistaUsada = true;
            }
        }

        // ---------- calculos ----------
        int turnos = aciertos + fallos;
        int intentosConsumidos = MAX_INTENTOS - intentosRestantes;

        // casting a double para que no haga division entera
        double porcentajeAciertos = (turnos > 0) ? (double) aciertos / turnos * 100 : 0.0;

        // reto 3: base 100 si gana, mas bono por intentos que sobraron y por rapidez
        if (juegoGanado) {
            double bonoIntentos = intentosRestantes * 10.0;
            double bonoRapidez = Math.max(0, palabraSecreta.length() * 2 - turnos) * 5.0;
            puntaje = 100.0 + bonoIntentos + bonoRapidez;
            if (pistaUsada) {
                puntaje = puntaje * 0.8; // usar pista quita un 20%
            }
        } else {
            puntaje = aciertos * 10.0;
        }

        // estadisticas
        partidasJugadas++;
        if (juegoGanado) {
            partidasGanadas++;
        }
        puntajeAcumulado += puntaje;
        if (puntaje > mejorPuntaje) {
            mejorPuntaje = puntaje;
        }

        // ---------- resumen ----------
        System.out.println("\n====================================================");
        System.out.println("              RESUMEN DE LA PARTIDA");
        System.out.println("====================================================");
        System.out.printf(" %-21s%s%n", "Jugador:", nombreJugador);
        System.out.printf(" %-21s%s%n", "Estado Final:", juegoGanado ? "¡VICTORIA!" : "DERROTA");
        System.out.printf(" %-21s%s%n", "Palabra Secreta:", palabraSecreta);
        System.out.printf(" %-21s%d%n", "Intentos Consumidos:", intentosConsumidos);
        System.out.printf(" %-21s%d / %d%n", "Intentos Restantes:", intentosRestantes, MAX_INTENTOS);
        System.out.printf(" %-21s%.2f%%%n", "Porcentaje Aciertos:", porcentajeAciertos);
        System.out.printf(" %-21s%.2f pts%n", "Puntaje Final:", puntaje);
        System.out.println("====================================================");
    }

    static void mostrarEstadisticas() {
        if (partidasJugadas == 0) {
            System.out.println("\nTodavia no has jugado ninguna partida.");
            return;
        }
        double porcentajeVictorias = (double) partidasGanadas / partidasJugadas * 100;
        double promedio = puntajeAcumulado / partidasJugadas;

        System.out.println("\n============== ESTADISTICAS ==============");
        System.out.printf(" %-20s%d%n", "Partidas jugadas:", partidasJugadas);
        System.out.printf(" %-20s%d%n", "Partidas ganadas:", partidasGanadas);
        System.out.printf(" %-20s%d%n", "Partidas perdidas:", partidasJugadas - partidasGanadas);
        System.out.printf(" %-20s%.2f%%%n", "% de victorias:", porcentajeVictorias);
        System.out.printf(" %-20s%.2f pts%n", "Puntaje promedio:", promedio);
        System.out.printf(" %-20s%.2f pts%n", "Mejor puntaje:", mejorPuntaje);
        System.out.println("==========================================");
    }
}