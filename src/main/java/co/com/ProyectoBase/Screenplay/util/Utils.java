package co.com.ProyectoBase.Screenplay.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static long operar(String operacion) {
        return resolverExpresion(operacion);
    }

    public static long resolverExpresion(String expresion) {
        Stack<Long> numeros = new Stack<>();
        Stack<Character> operadores = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);

            if (Character.isDigit(caracter)) {
                long numero = 0;
                while (i < expresion.length() && Character.isDigit(expresion.charAt(i))) {
                    numero = numero * 10 + Character.getNumericValue(expresion.charAt(i));
                    i++;
                }
                numeros.push(numero);
                i--; // Retroceder para compensar el incremento en el bucle for
            } else if (caracter == '+' || caracter == '-') {
                while (!operadores.isEmpty() && (operadores.peek() == '+' || operadores.peek() == '-' || operadores.peek() == '*' || operadores.peek() == '/')) {
                    ejecutarOperacion(numeros, operadores);
                }
                operadores.push(caracter);
            } else if (caracter == '*' || caracter == '/') {
                while (!operadores.isEmpty() && (operadores.peek() == '*' || operadores.peek() == '/')) {
                    ejecutarOperacion(numeros, operadores);
                }
                operadores.push(caracter);
            }
        }

        while (!operadores.isEmpty()) {
            ejecutarOperacion(numeros, operadores);
        }
        return numeros.pop();
    }

    public static void ejecutarOperacion(Stack<Long> numeros, Stack<Character> operadores) {
        long num2 = numeros.pop();
        long num1 = numeros.pop();
        char operador = operadores.pop();
        long resultado = 0;

        switch (operador) {
            case '+':
                resultado = num1 + num2;
                break;
            case '-':
                resultado = num1 - num2;
                break;
            case '*':
                resultado = num1 * num2;
                break;
            case '/':
                resultado = num1 / num2;
                break;
        }
        numeros.push(resultado);
    }

    public static int encontrarNumerosEnCadena(String texto){

        String regexNumeros = "\\d+";
        int numeroEncontrado=0;
        Pattern patternNumeros = Pattern.compile(regexNumeros);
        Matcher matcherNumeros = patternNumeros.matcher(texto);

        if (matcherNumeros.find()) {
            numeroEncontrado = Integer.parseInt(matcherNumeros.group());
        } else {
            System.out.println("No se encontró ningún número en el texto.");
        }
        return numeroEncontrado;
    }

    public static int encontrarCiclosLetra(String cadena) {

        Pattern patron = Pattern.compile("\\d+");
        Matcher matcher = patron.matcher(cadena);
        int numero = 0;

        if (matcher.find()) {
            String numeroEncontrado = matcher.group();
            numero = Integer.parseInt(numeroEncontrado);
        } else {
            System.out.println("No se encontraron números en la cadena.");
        }
        return numero;
    }

    public static int encontrarCiclos(String cadena) {

        Pattern patron = Pattern.compile("\\d{2}$");
        Matcher matcher = patron.matcher(cadena);
        String ultimosDigitos = "";

        if (matcher.find()) {
            ultimosDigitos = matcher.group();
        } else {
            System.out.println("No se encontraron dos últimos dígitos en el texto.");
        }
        return Integer.parseInt(ultimosDigitos);
    }

    public static String encontrarLetra(String texto){

        String regex = "\"([^\"]*)\"";
        String textoEncontrado="";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        if (matcher.find()) {
            textoEncontrado = matcher.group(1); // El grupo 1 contiene el texto entre comillas
        } else {
            System.out.println("No se encontró ningún texto entre comillas en el texto proporcionado.");
        }
        return textoEncontrado;
    }

    public static String decision(String texto){

        String regexVerificar = "\\b(desde el|desde antes de)\\b";
        String palabraEncontrada="";
        Pattern patternVerificar = Pattern.compile(regexVerificar);
        Matcher matcherVerificar = patternVerificar.matcher(texto);

        if (matcherVerificar.find()) {
            palabraEncontrada = matcherVerificar.group();
        } else {
            System.out.println("La frase no contiene 'desde el' o 'desde antes de'.");
        }
        return palabraEncontrada;
    }

    public static String fechaDespuesDe(String fechaInicial, int dias) {

        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fechaInicial);
        String fechaEncontrada = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if (matcher.find()) {
            fechaEncontrada = matcher.group();
        } else {
            System.out.println("No se encontró ninguna fecha en el texto.");
        }

        LocalDate fecha = LocalDate.parse(fechaEncontrada, formatter);
        LocalDate fechaDespues = fecha.plusDays(dias);
        return fechaDespues.format(formatter);
    }

    public static String fechaDesdeAntesDe(String texto, int dias) {

        String regexFecha = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
        String fechaEncontrada="";
        Pattern patternFecha = Pattern.compile(regexFecha);
        Matcher matcherFecha = patternFecha.matcher(texto);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if (matcherFecha.find()) {
            fechaEncontrada = matcherFecha.group();
        } else {
            System.out.println("No se encontró ninguna fecha en el texto.");
        }

        LocalDate fecha = LocalDate.parse(fechaEncontrada, formatter);
        LocalDate fechaAntes = fecha.minusDays(dias);
        return fechaAntes.format(formatter);
    }

    public static String obtenerExprecion(String cadena){

        String regexExpresion = "[\\d+\\-*\\/()]+";
        String expresionEncontrada="";
        Pattern patternExpresion = Pattern.compile(regexExpresion);
        Matcher matcherExpresion = patternExpresion.matcher(cadena);

        if (matcherExpresion.find()) {
            expresionEncontrada = matcherExpresion.group();
        } else {
            System.out.println("No se encontró ninguna expresión matemática en la cadena.");
        }
        return expresionEncontrada;
    }
}