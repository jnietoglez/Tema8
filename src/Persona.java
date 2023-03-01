import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
public class Persona {
    //crear clase con los atributos nombre, email y edad
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nombre;

    private String email;

    private int edad;
    public Persona() {//constructor
    }
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
    public static void main(String[] args) {
        //crear un objectMapper de jackson
        ObjectMapper objectMapper = new ObjectMapper();
        //crear un objeto de la clase Persona
        Persona persona = new Persona("Pepe Perez", "pepe@gmail.com", 25);
        try {
            //convertir el objeto persona a un String en formato JSON
            String json = objectMapper.writeValueAsString(persona);
            System.out.println(json);
            //crear una persona desde el objeto json String
            Persona persona2 = objectMapper.readValue(json, Persona.class);
            System.out.println(persona2);
        } catch (DatabindException e){
            System.out.println("Error al convertir el JSON");
            e.printStackTrace();
        } catch (JsonProcessingException e){
            System.out.println("Error al procesar el JSON");
        }


    }

}
