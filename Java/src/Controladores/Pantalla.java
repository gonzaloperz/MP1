package Controladores;

import java.util.Scanner;

public abstract class Pantalla {


    public static void imprimir(String texto) {
        System.out.println(texto);
    }

    public static int pedirenteros(String texto) {
        imprimir(texto);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String pedircadena(String texto) {
        imprimir(texto);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
