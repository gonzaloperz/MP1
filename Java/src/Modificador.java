import java.io.Serializable;

public class Modificador implements Serializable {
    private String nombreDeb;//poneNombreDeb
    private int sensibilidadDeb;
    private String nombreFort;
    private int sensibilidadFort;

    public String getNombreFort() {
        return nombreFort;
    }

    public void setNombreFort(String nombreFort) {
        this.nombreFort = nombreFort;
    }

    public int getSensibilidadDeb() {
        return sensibilidadDeb;
    }

    public void setSensibilidadDeb(int sensibilidadDeb) {
        this.sensibilidadDeb = sensibilidadDeb;
    }

    public String getNombreDeb() {
        return nombreDeb;
    }

    public void setNombreDeb(String nombreDeb) {
        this.nombreDeb = nombreDeb;
    }

    public int getSensibilidadFort() {
        return sensibilidadFort;
    }

    public void setSensibilidadFort(int sensibilidadFort) {
        this.sensibilidadFort = sensibilidadFort;
    }

    public Modificador modificar(){
        System.out.println("Nombre: "+ this.getNombreDeb());
        this.setNombreDeb(nombreDeb);
        System.out.println("Nombre: "+ this.getNombreFort());
        this.setNombreFort(nombreFort);
        System.out.println("Valor: "+ this.getSensibilidadDeb());
        this.setSensibilidadDeb(sensibilidadDeb);
        System.out.println("Valor: "+ this.getSensibilidadFort());
        this.setSensibilidadFort(sensibilidadFort);
        return this;
    }
}
