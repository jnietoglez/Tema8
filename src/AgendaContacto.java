import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
//para que ignore los atributos que no estén en la clase como getNum ya que al ser un getter...
//también podríamos poner @JsonIgnoreProperties({"num"}) en vez de @JsonIgnore
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgendaContacto {
    //como no hay un getter para agenda tenemos que usar @JsonProperty("agenda")
    @JsonProperty("agenda")
    private ArrayList<Contacto> agenda;
    //constructor

    //indicamos que serialice agenda usando el constructor de la clase
    @JsonCreator
    public AgendaContacto(@JsonProperty("agenda") ArrayList<Contacto> agenda) {
        this.agenda = agenda;
    }


    public AgendaContacto() {
        agenda = new ArrayList<>();
    }
    //getters y setters
    //indicamos que no queremos que se serialice  num -en nuestro caso no es un atributo de la clase-
    @JsonIgnore
    public int getNum() {
        return agenda.size();
    }
    //inserta contacto
    public void insertarContacto(Contacto contacto){
        agenda.add(contacto);
    }
    //muestra agenda
    public void mostrarAgenda(){
        for (Contacto contacto : agenda) {
            System.out.println(contacto);
        }
    }
    //busca contacto por email
    public void get(String email){
        for (Contacto contacto : agenda) {
            if (contacto.getEmail().equals(email)) {
                System.out.println(contacto);
            }
        }
    }
    //get contacto por posicion retornando excepcion si no existe
    public Contacto get(int posicion){
        if (posicion < 0 || posicion >= agenda.size()) {
            throw new RuntimeException("Índice no válido");
        }
        return agenda.get(posicion);
    }
    //método toString recorriendo y añadiendo contactos a un StringBuilder
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Contacto contacto : agenda) {
            sb.append(contacto).append('\n');

        }
        return sb.toString();
    }
}
