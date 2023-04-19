import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Setter @Getter @AllArgsConstructor

public class Apuesta { //dice un jugador lo que va a ocurrir por cada partido
    private String nombre, equipoLocal, equipoVisitante, ronda;
    private int resultado;

    public String toString() {
        return nombre + ":";
    }

    }


