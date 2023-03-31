import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonTypeName("Rectangulo")
public class Rectangulo extends Figura {

    private String tipo;
    private int base;
    private int altura;

    public Rectangulo(String tipo, int base, int altura) {
        this.tipo = tipo;
        this.base = base;
        this.altura = altura;
    }


    //método toString conStringBuilder
    @Override
    public String toString() {
        return new StringBuilder()
                .append("tipo='").append(tipo).append('\'')
                .append(", base=").append(base)
                .append(", altura=").append(altura)
                .toString();
    }




    public static void main(String[] args) {
        Figura figura = new Rectangulo("FiguraRectangulo",10, 5);
        System.out.println(figura);
        System.out.println("Serializando: ");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.writerWithDefaultPrettyPrinter();


        try {
            String json = objectMapper.writeValueAsString(figura);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }
}
