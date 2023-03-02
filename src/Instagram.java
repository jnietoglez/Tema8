public class Instagram extends Contacto{
    private String usuario;
    //constructor
    public Instagram(String nombre, String email, int telefono, String usuario) {
        super(nombre, email, telefono);
        this.usuario = usuario;
    }
    //toString
    @Override
    public String toString() {
        return super.toString() + ", usuario='" + usuario + '\'';
    }

}
