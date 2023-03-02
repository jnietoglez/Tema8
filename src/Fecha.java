import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Fecha {
    int dia;
    int mes;
    int anho;
    //constructor por defecto
    public Fecha() {
    }
    public Fecha( int dia, int mes, int anho) {
        this.dia = dia;
        this.mes = mes;
        this.anho = anho;
    }
    //añadimos getters y setters
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public int getAnho() {
        return anho;
    }
    public void setAnho(int anho) {
        this.anho = anho;
    }
    //añadimos el método toString
    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anho;
    }
}
