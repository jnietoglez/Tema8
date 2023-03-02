public class Familiar extends Contacto{
    public static enum TipoFamiliar {PADRE, MADRE, HERMANO, HIJO, TIO, TIA, ABUELO, ABUELA, OTRO}
    private Fecha fecha;
    private TipoFamiliar tipoFamiliar;
    public Familiar() {
        super();

    }
    //constructor
    public Familiar(String nombre, String email, int telefono, Fecha fecha, TipoFamiliar tipoFamiliar) {
        super(nombre, email, telefono);
        this.fecha = fecha;
        this.tipoFamiliar = tipoFamiliar;
    }
    //getters y setters
    public Fecha getFecha() {
        return fecha;
    }
    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
    public TipoFamiliar getTipoFamiliar() {
        return tipoFamiliar;
    }
    public void setTipoFamiliar(TipoFamiliar tipoFamiliar) {
        this.tipoFamiliar = tipoFamiliar;
    }
    //toString
    @Override
    public String toString() {
        return super.toString() + ", fecha=" + fecha + ", tipoFamiliar=" + tipoFamiliar;
    }

}
