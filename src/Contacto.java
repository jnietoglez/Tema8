public class Contacto {
    private String nombre;
    private String email;
    private int telefono;
    //constructor
    public Contacto(String nombre, String email, int telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }
    //getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    //sobreescribimos el método toString
    @Override
    public String toString() {
        return
                "nombre='" + getNombre() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", telefono=" + getTelefono()    ;

    }
}
