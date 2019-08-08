package Tarea2;

import java.util.Scanner;

//La función pide un numerador y un denominador para hacer la division respectiva.
// Posteriormente, siempre y cuando el resultado sea menor a 10, pide un numero para realizar una suma

public class Ejemplos {
    private static int sum;

    public static void sumar(int res) {

        try {
            System.out.println("Ingrese la cantidad que desea sumar");
            Scanner entrada = new Scanner(System.in);
            sum = entrada.nextInt() + res;
            System.out.println("El resultado de la suma es: " + sum);

        } catch (ArithmeticException e) {
            System.out.println("Ocurrió un error: " + e);
        }
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese un numerador");
        int numerador = entrada.nextInt();
        System.out.println("Ingrese un denominador");
        int denominador = entrada.nextInt();

        try {
            int res = numerador / denominador;
            System.out.println("El resultado de la división es: " + res);
            sumar(res);

            if (sum > 10) {
                throw new ArithmeticException("resultado > 10");
            }

        } catch (ArithmeticException e) {
            System.out.println("Ocurrió un error: " + e);

        } finally {
            System.out.println("Terminó la ejecución del código");
        }
    }

}
