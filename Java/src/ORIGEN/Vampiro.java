package ORIGEN;

import Controladores.Pantalla;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Vampiro implements Personaje, Serializable {
    private int puntosSangre;
    private int edad;
    private String nombre;
    private ArrayList<Arma> armas;
    private ArrayList<Armadura> armaduras;
    private ArrayList<Arma> armasActivas;
    private Armadura armaduraActiva;
    private ArrayList<Esbirro> esbirros;
    private int oro;
    private int salud;
    private int poder;
    private ArrayList<Debilidad> debilidades;
    private ArrayList<Fortaleza> fortalezas;
    private String disciplina;
    private int atqHab;
    private int defHab;
    private int costeDisciplina;

    public int getPuntosSange() {
        return puntosSange;
    }

    public void setPuntosSange(int puntosSange) {
        this.puntosSange = puntosSange;
    }

    private int puntosSange;


    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void setArmas(ArrayList<Arma> armas) {
        this.armas = armas;
    }
    public void addArmas(Arma a) {
        this.armas.add(a);
    }
    @Override
    public ArrayList<Arma> getArmas() {
        return this.armas;
    }

    @Override
    public void setArmadura(ArrayList<Armadura> armaduras) {
        this.armaduras = armaduras;
    }
    public void addArmaduras(Armadura a) {
        this.armaduras.add(a);
    }
    @Override
    public ArrayList<Armadura> getArmadura() {
        return this.armaduras;
    }

    @Override
    public void setArmasActivas(ArrayList<Arma> armasActivas) {
        this.armasActivas = armasActivas;
    }
    public void addArmasActivas(Arma a) {
        this.armasActivas.add(a);
    }
    @Override
    public ArrayList<Arma> getArmasActivas() {
        return this.armasActivas;
    }

    @Override
    public void setArmaduraActiva(Armadura armaduraActiva) {
        this.armaduraActiva = armaduraActiva;
    }

    @Override
    public Armadura getArmaduraActiva() {
        return this.armaduraActiva;
    }

    @Override
    public void setEsbirros(ArrayList<Esbirro> esbirros) {
        this.esbirros = esbirros;
    }

    public void addEsbirro(Esbirro e){
        this.esbirros.add(e);
    }

    @Override
    public ArrayList<Esbirro> getEsbirros() {
        return this.esbirros;
    }

    @Override
    public void setOro(int oro) {
        this.oro = oro;
    }

    @Override
    public int getOro() {
        return this.oro;
    }

    @Override
    public void setSalud(int salud) {
        this.salud = salud;
    }

    @Override
    public int getSalud() {
        return this.salud;
    }

    @Override
    public void setPoder(int poder) {
        this.poder = poder;
    }
    public int getPoder(){
        return this.poder;
    }
    @Override
    public void setDebilidades(ArrayList<Debilidad> Debilidad) {
        this.debilidades = Debilidad;
    }
     public void addDebilidades(Debilidad d){
        this.debilidades.add(d);
     }
    @Override
    public ArrayList<Debilidad> getDebilidades() {
        return this.debilidades;
    }

    @Override
    public void setFortalezas(ArrayList<Fortaleza> fortalezas) {
        this.fortalezas = fortalezas;
    }
    public void addFortalezas(Fortaleza f){
        this.fortalezas.add(f);
    }

    @Override
    public ArrayList<Fortaleza> getFortalezas() {
        return this.fortalezas;
    }

    @Override
    public void setHabilidad(String Disciplina) {
        this.disciplina = Disciplina;
    }
    public String getHabilidad(){return this.disciplina;}

    @Override
    public void setAtqHab(int ataque) {
        this.atqHab = ataque;
    }
    public int getAtqHab(){
        return this.atqHab;
    }

    @Override
    public void setDefHab(int defensa) {
        this.defHab = defensa;
    }
    public int getDefHab(){
        return  this.defHab;
    }

    @Override
    public void usarHabilidad() {
        Pantalla.imprimir(" se uso la disciplina: "+  getHabilidad()+ ".");
        this.puntosSangre -= costeDisciplina;

    }
    public int getPuntosSangre() {
        return puntosSangre;
    }

    public void setPuntosSangre(int puntosSangre) {
        this.puntosSangre = puntosSangre;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public int getCosteHabilidad(){
        return costeDisciplina;
    }

    public void setCosteHabilidad(int coste){
        this.costeDisciplina = coste;
    }

    @Override
    public void ganarRonda() {

    }

    @Override
    public void perderRonda() {

    }

    @Override
    public int calcularAtaque() {
        return 0;
    }

    @Override
    public int calcularDefensa() {
        return 0;
    }

    @Override
    public int saludEsbirros() {
        return 0;
    }

    @Override
    public void modificarDatos(){
        Pantalla.imprimir("Si no quieres cambiar un valor, escribe el mismo.");
        Pantalla.imprimir("Nombre: "+this.nombre);
        setNombre(Pantalla.pedircadena("Nuevo nombre: "));
        Pantalla.imprimir("Nombre habilidad: "+this.disciplina);
        setHabilidad(Pantalla.pedircadena("Nuevo nomHabilidad: "));
        Pantalla.imprimir("Ataque habilidad: "+Integer.toString(this.atqHab));
        setAtqHab(Pantalla.pedirenteros("Nuevo valor: "));
        Pantalla.imprimir("Defensa habilidad: "+Integer.toString(this.defHab));
        setDefHab(Pantalla.pedirenteros("Nuevo valor: "));
        Pantalla.imprimir("Coste habilidad: "+this.costeDisciplina);
        setCosteHabilidad(Pantalla.pedirenteros("Nuevo valor: "));
        Pantalla.imprimir("Poder: "+this.poder);
        setPoder(Pantalla.pedirenteros("Nuevo valor: "));
        Pantalla.imprimir("Oro actual: "+this.oro);
        setOro(Pantalla.pedirenteros("Nuevo valor: "));
        Pantalla.imprimir("Salud del personaje: "+this.salud);
        setSalud(Pantalla.pedirenteros("Nuevo valor: "));

        Pantalla.imprimir("Edad: " + this.edad);
        setEdad(Pantalla.pedirenteros("Nuevo valor: "));
        Pantalla.imprimir("Puntos de sangre: " + this.puntosSangre);
        setPuntosSangre(Pantalla.pedirenteros("Nuevo valor: "));
    }

    @Override
    public Esbirro crearEsbirros() {
        Pantalla.imprimir("1. Añadir Ghoul");
        Pantalla.imprimir("2. Añadir demonio");
        Pantalla.imprimir("Otro. Cancelar");
        int o = Pantalla.pedirenteros("Elije una opción:");
        if (o==1){
            String esbirroNombre = Pantalla.pedircadena("Nombre del esbirro: ");
            int esbirroSalud = Pantalla.pedirenteros("Salud del esbirro: ");
            String esbirroDependencia = Pantalla.pedircadena("Descripcion de su dependencia: ");
            int valorDependencia = Pantalla.pedirenteros("Valor de la dependencia: ");
            Ghoul ghoul = new Ghoul(esbirroNombre,esbirroSalud,valorDependencia,esbirroDependencia);
            return ghoul;
        }
        else if(o==2){
            String esbirroNombre = Pantalla.pedircadena("Nombre del esbirro: ");
            int esbirroSalud = Pantalla.pedirenteros("Salud del esbirro: ");
            int e = Pantalla.pedirenteros("Si tiene otros esbirros pulse 1. ");
            Demonio demonio;
            List<Esbirro> subLista = new ArrayList<Esbirro>();
            while (e==1){
                subLista.add(crearEsbirros());
                e = Pantalla.pedirenteros("Si tiene otros esbirros este esbirro pulse 1. ");
            }
            demonio = new Demonio(esbirroNombre,esbirroSalud,subLista);
            Pantalla.imprimir("Lista de esbirros añadida.");
            /*
            else
                demonio = new Demonios(esbirroNombre,esbirroSalud,null);
            */
            return demonio;
        }
        else
            return null;
    }
}
