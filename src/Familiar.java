public class Familiar extends Contacto{
    private Fecha fecha;
    //constructor
    public Familiar(String nombre, String email, int telefono, Fecha fecha) {
        super(nombre, email, telefono);
        this.fecha = fecha;
    }
    //getters y setters
    public Fecha getFecha() {
        return fecha;
    }
    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
    //toString
    @Override
    public String toString() {
        return super.toString() + ", fecha=" + fecha;
    }

}
