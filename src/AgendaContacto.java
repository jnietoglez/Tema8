import java.util.ArrayList;

public class AgendaContacto {
    private ArrayList<Contacto> agenda;
    //constructor
    public AgendaContacto() {
        agenda = new ArrayList<>();
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
