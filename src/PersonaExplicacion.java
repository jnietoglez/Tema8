import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Calendar;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PersonaExplicacion {
    private String nombre;

    private String apellidos;

    private Calendar fechNacimiento;
    //constructor
    public PersonaExplicacion(String nombre, String apellidos, Calendar fechNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechNacimiento = fechNacimiento;
    }
    //metodo toString
    @Override
    public String toString() {
        return "PersonaExplicacion{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechNacimiento=" + fechNacimiento +
                '}';
    }
    public PersonaExplicacion() {
    }


    public static void main(String[] args) {
        //crear un objectMapper de jackson
        ObjectMapper objectMapper = new ObjectMapper();
        //crear un objeto de la clase Persona
        //deshabilitamos fail_on_empty_beans para que no nos de error al serializar un objeto vacio
        //objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        PersonaExplicacion persona = new PersonaExplicacion("Pepe","Perez", Calendar.getInstance());
        //serializar el objeto persona a un String en formato JSON
        String json = null;

        try {
            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(persona);
        } catch (JsonProcessingException e) {
            System.out.println("Imposible serializar el objeto"+e.getMessage());
        }
        System.out.println(json);
        //crear una persona desde el objeto json String
        PersonaExplicacion persona2 = null;
        try {
            persona2 = objectMapper.readValue(json, PersonaExplicacion.class);
        } catch (JsonProcessingException e) {
            System.out.println("Error al realizar la lectura: formato incorrecto");;
        }
        System.out.println(persona2);

    }


}
