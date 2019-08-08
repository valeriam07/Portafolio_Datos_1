package Tarea2;

import java.util.Scanner;

public class MyException extends Throwable {
    public MyException(String msj) {
        super(msj);
    }

    public static void main(String[] args) {
        Scanner entry = new Scanner(System.in);
        System.out.println("Ingrese su edad");
        int edad = entry.nextInt();

        try {
            rangoEdad(edad);
            System.out.println("Su edad se encuentra dentro del rango valido");

        } catch (MyException e) {
            System.out.println("Ocurrio un Error: " + e);

        }

    }

    private static void rangoEdad(int edad) throws MyException {
        if (edad < 16) {
            throw new MyException("La edad mínima es 16 años");
        }
    }


}
