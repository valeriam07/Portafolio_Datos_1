package Tarea2;

import java.util.Scanner;

//La función pide un numerador y un denominador para hacer la division respectiva, siempre y cuando el resultado sea
// menor a 10, pide un numero para realizar una operacion

public class Ejemplos {

    public static void main(String[] args) {

            Scanner entrada = new Scanner(System.in);
            System.out.println("Ingrese un numerador");
            int numerador = entrada.nextInt();
            System.out.println("Ingrese un denominador");
            int denominador = entrada.nextInt();

            try {
                int res = 0;
                res = numerador / denominador;
                System.out.println("El resultado de la división es: " + res);
                throw new ArithmeticException("res>10");


            } catch (ArithmeticException e) {
                System.out.println("Ocurrió un error: "+ e);

            }finally {
                System.out.println("Terminó la ejecucion del código");
            }
        }

    }
