public class Persona {
    //crear clase con los atributos nombre, email y edad
    private String nombre;
    private String email;
    private int edad;
    public Persona(String nombre, String email, int edad) {//constructor
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }
    public String getNombre() {//metodo getNombre
        return nombre;
    }
    public void setNombre(String nombre) {//metodo setNombre
        this.nombre = nombre;
    }
    public String getEmail() {//metodo getEmail
        return email;
    }
    public void setEmail(String email) {//metodo setEmail
        this.email = email;
    }
    public int getEdad() {//metodo getEdad
        return edad;
    }
    public void setEdad(int edad) {//metodo setEdad
        this.edad = edad;
    }
    //sobreescribir metodo toString usando String.format
    @Override
    public String toString() {//metodo toString
        return String.format("Nombre: %s, Email: %s, Edad: %d", getNombre(), getEmail(), getEdad());
    }
}
