package Controladores;

import ORIGEN.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Appcontroller{
    Scanner scanner = new Scanner(System.in);
    private List<Usuario> usuarios;
    public Appcontroller(){
        usuarios = new ArrayList<>();
    }
    public void iniciarSesion(){
        String usuario = new String();
        String contraseña = new String();
        System.out.println("Usuario");
        usuario = scanner.nextLine();
        System.out.println("Contraseña");
        contraseña = scanner.nextLine();
    }

    public void registrarse() {
        String usuario = new String();
        String contraseña = new String();
        System.out.println("Elija un nombre de usuario");
        usuario = scanner.nextLine();
        System.out.println("Elija una contraseña");
        contraseña = scanner.nextLine();
    }

    public void cargarDatos(){

    }

    public void guardarDatos() {

    }

    public void menu(){
        System.out.println("**----Bienvenido Dark Chronicles----**");
        System.out.println("Seleccione que quiere hacer:");
        System.out.println("  1.Iniciar Sesión");
        System.out.println("  2.Registrarse");
        System.out.println("  3.Salir");
        System.out.println();
    }
    public void start() {
        menu();
        int option = scanner.nextInt();
        while ((option != 1) && (option != 2) && (option != 3)){
            System.out.println("La opción escogida no es válida.");
            System.out.println();
            menu();
            option = scanner.nextInt();
        }
        switch (option){
            case 1:
                this.iniciarSesion();
                break;
            case 2:
                this.registrarse();
                break;
            case 3:
                ///
                break;
        }
    }
}
