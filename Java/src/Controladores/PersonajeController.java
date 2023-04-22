package Controladores;

import ORIGEN.Factory.CazadorFactory;
import ORIGEN.Factory.LicantropoFactory;
import ORIGEN.Factory.VampiroFactory;
import ORIGEN.Personaje;
import ORIGEN.Usuario;
import ORIGEN.Vampiro;

import java.util.Scanner;

public class PersonajeController {

    public void menu(){
        System.out.println("Seleccione una opción");
        System.out.println("1. Vampiro");
        System.out.println("2. Licántropo");
        System.out.println("3. Cazador");
        System.out.println("4. Cancelar");
    }
    public void registrarPersonaje(Usuario user){
        Scanner sc = new Scanner(System.in);
        int option = 0;
        while (option != 1 && option != 2 && option != 3 && option != 4) {
            menu();
            option = sc.nextInt();
        }
        switch (option) {
            case 1:
                VampiroFactory personaje = new VampiroFactory();
                user.setPersonaje(personaje.crearPersonaje());
                break;
            case 2:
                LicantropoFactory licantropo = new LicantropoFactory();
                user.setPersonaje((Personaje) licantropo);
                break;
            case 3:
                CazadorFactory cazador = new CazadorFactory();
                user.setPersonaje((Personaje) cazador);
                break;
            case 4:
                break;
        }
    }
    public void crearArma(){

    }
    public void crearArmadura(){

    }
    public void editarEquipo(){

    }
    public Personaje cambiarArma(Personaje personaje){

        return personaje;
    }
    public Personaje cambiarArmadura(Personaje personaje){
        return personaje;

    }
    public void crearDebilidad(){

    }
    public void crearFortaleza(){

    }
    public void modificarPersonaje() {

    }
}

