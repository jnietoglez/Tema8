import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Tema8 {
    public static void main(String[] args) {
        //creamos un objeto de la clase Agenda
        AgendaContacto agendaContacto = new AgendaContacto();
        //creamos un objeto Json de la clase ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        //creamos un objeto de la clase Fecha
        Fecha fecha = new Fecha(1, 1, 2000);
        try {
            agendaContacto =  mapper.readValue( "agenda.json", AgendaContacto.class ) ;
            System.out.println( "Arrancando con datos...\n" );
        } catch(JsonProcessingException exc) {
            agendaContacto = new AgendaContacto();
            System.out.println( "Archivo con errores, arrancando sin datos...\n" );
        } catch(IOException exc) {
            agendaContacto = new AgendaContacto();
            System.out.println( "Archivo no encontrado. arrancando sin datos...\n" );
        }
        //llamamos al metodo inicializarAgenda
        inicializarAgenda(agendaContacto);
        agendaContacto.mostrarAgenda();


    }

    private static void inicializarAgenda(AgendaContacto agendaContacto) {
        if (agendaContacto.getNum() == 0) {
            agendaContacto.insertarContacto(new Contacto("Baltasar", "jbgarcia@uvigo.es",
                    988111111));
            agendaContacto.insertarContacto(new Contacto("Encarnacion", "nrufino@uvigo.es",
                    988222222));
            agendaContacto.insertarContacto(new Familiar("Carlos", "------@uvigo.es",88333333, new Fecha(28, 05, 2002), Familiar.TipoFamiliar.HERMANO));
            agendaContacto.insertarContacto(new Instagram("Pedro", "pcuesta@uvigo.es",988444444, "@pcuesta"));
        }
    }
}
