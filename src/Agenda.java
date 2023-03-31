import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Agenda {//Crear un vector de Personas llamado agenda y un atributo num que almacene el número de personas en la agenda
    @JsonProperty("agenda")
    private Persona[] agenda;
    private int num;
    @JsonCreator
    public Agenda(@JsonProperty("agenda") Persona[] agenda, @JsonProperty("num") int num) {//constructor
        this.agenda = agenda;
        this.num = num;
    }



    public Agenda(int max) {//constructor que devuelve una excepción si el tamaño es negativo
        if (max < 0) {
            throw new RuntimeException("Tamaño negativo");
        }
        agenda = new Persona[max];
        num = 0;
    }
    /*
    public Persona[] getAgenda(){
        //retornar el vector de personas con valor distinto de null
        Persona[] personas = new Persona[num];
        for (int i = 0; i < num; i++) {
            personas[i] = agenda[i];
        }
        return personas;
    }

     */
    public void addPersona(Persona persona) {//metodo addPersona que añade una persona a la agenda o devuelve una excepción si no hay espacio o si la persona es null
        if (persona == null) {
            throw new RuntimeException("Persona nula");
        }
        if (num == agenda.length) {
            throw new RuntimeException("No hay espacio");
        }
        agenda[num] = persona;
        num++;
    }
    public void mostrarAgenda() {//metodo mostrarAgenda
        for (int i = 0; i < num; i++) {
            System.out.println(agenda[i]);
        }
        System.out.println("Numero de personas: " + num+" número máximo de personas: "+agenda.length);
    }
    public void buscarPersona(String nombre) {//metodo buscarPersona
        for (int i = 0; i < num; i++) {
            if (agenda[i].getNombre().equals(nombre)) {
                System.out.println(agenda[i]);
            }
        }
    }
    public void borrarPersona(String nombre) {//metodo borrarPersona
        for (int i = 0; i < num; i++) {
            if (agenda[i].getNombre().equals(nombre)) {
                agenda[i] = agenda[num - 1];
                num--;
            }
        }
    }
    public Persona getPersona(int i) {//metodo getPersona y lanza una excepción si el índice es negativo o mayor que el número de personas
        if (i < 0 || i >= num) {
            throw new RuntimeException("Índice no válido");
        }
        return agenda[i];
    }

    //metodo getPersona al que se le pasa un email y devuelve la persona con ese email
    public Persona getPersonaEmail(String email) {//metodo getPersonaEmail
        for (int i = 0; i < num; i++) {
            if (agenda[i].getEmail().equals(email)) {
                return agenda[i];
            }
        }
        return null;
    }

    public int getNum() {
        return num;
    }
    //método get que devuelve la persona en una posición dada o una RunTimeExceptión si no existe
    public Persona getPersonaPosicion(int posicion)  {
        if (posicion < 0 || posicion >= num) {
            throw new RuntimeException("Posicion no valida");
        }
        return agenda[posicion];
    }


    public static void main(String[] args) {
        Agenda agenda = new Agenda(10);
        agenda.addPersona(new Persona("Pepe Perez", "asdf@gmail.com", 25));
        agenda.addPersona(new Persona("Juan Perez", "asdfa@asdfs.com", 25));
        //mostrarAgenda
        agenda.mostrarAgenda();
        //Escribir en un String json el objeto agenda
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        try {
            //convertir el objeto agenda a un String en formato JSON
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(agenda);
            System.out.println(json);
            //crear una persona desde el objeto json String
            Agenda agenda2 = objectMapper.readValue(json, Agenda.class);
            agenda2.mostrarAgenda();
            //Escritura en un fichero
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("agenda.json"), agenda);
            //Lectura de un fichero
            Agenda agenda3 = objectMapper.readValue(new File("agenda.json"), Agenda.class);
            agenda3.mostrarAgenda();
            //Escritura en un fichero sin los valores nulos de  personas en la agenda y con formato
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("agenda2.json"), agenda);
        } catch (DatabindException e){
            System.out.println("Error al convertir el JSON");
            e.printStackTrace();
        } catch (JsonProcessingException e){
            System.out.println("Error al procesar el JSON");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida en el fichero");
        }





    }
}


