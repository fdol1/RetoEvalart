package co.com.ProyectoBase.Screenplay.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static int calcular(String expresion) {
        Stack<Integer> numeros = new Stack<>();
        Stack<Character> operadores = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);

            if (caracter == ' ') {
                continue; // Saltar espacios en blanco
            }

            if (Character.isDigit(caracter)) {
                int numero = 0;
                while (i < expresion.length() && Character.isDigit(expresion.charAt(i))) {
                    numero = numero * 10 + (expresion.charAt(i) - '0');
                    i++;
                }
                numeros.push(numero);
                i--; // Retroceder el índice para compensar el avance adicional en el bucle
            } else if (caracter == '(') {
                operadores.push(caracter);
            } else if (caracter == ')') {
                while (operadores.peek() != '(') {
                    numeros.push(aplicarOperacion(operadores.pop(), numeros.pop(), numeros.pop()));
                }
                operadores.pop(); // Eliminar el '(' del stack de operadores
            } else if (caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/') {
                while (!operadores.empty() && tienePrecedencia(caracter, operadores.peek())) {
                    numeros.push(aplicarOperacion(operadores.pop(), numeros.pop(), numeros.pop()));
                }
                operadores.push(caracter);
            }
        }

        while (!operadores.empty()) {
            numeros.push(aplicarOperacion(operadores.pop(), numeros.pop(), numeros.pop()));
        }
        return numeros.pop();
    }

    public static boolean tienePrecedencia(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

    public static int aplicarOperacion(char operador, int b, int a) {
        switch (operador) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("División por cero no permitida");
                }
                return a / b;
        }
        return 0;
    }

    public static String fechaDesde(String fechaInicial) {

        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";

        // Compilar el patrón regex
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fechaInicial);
        String fechaEncontrada = "";

        // Encontrar la fecha en la cadena
        if (matcher.find()) {
            fechaEncontrada = matcher.group();
            System.out.println("Fecha encontrada: " + fechaEncontrada);
        } else {
            System.out.println("No se encontró ninguna fecha en el texto.");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(fechaEncontrada, formatter);
        LocalDate fechaDespues = fecha.plusDays(99);
        String fechaFormateada = fechaDespues.format(formatter);
        System.out.println("99 días después de " + fechaEncontrada + " es: " + fechaFormateada);
        return fechaFormateada;
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
}