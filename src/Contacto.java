import com.fasterxml.jackson.annotation.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "className")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Familiar.class, name = "Familiar"),
        @JsonSubTypes.Type(value = Instagram.class, name = "Instagram")
})
public class Contacto {
    private String nombre;
    private String email;
    private int telefono;
    //constructor
    public Contacto() {
    }
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
        //para probar que funciona la excepción al deserializar ya que usa los setters
        //lanzar excepción si el teléfono es 988111111
        //if (telefono == 988111111) {
        // throw new IllegalArgumentException("El teléfono no puede ser 988111111");
        //}
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
