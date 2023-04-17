import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Setter @Getter @AllArgsConstructor

public class Apuesta {
    private String nombre, equipoLocal, equipoVisitante;
    private int resultado;

    public String toString() {
        return nombre + ":";
    }

    public boolean acertoResultado(Apuesta apuesta, Partido partido) {
        int resultadoPartido = partido.resultadoPerSe();
        int resultadoApuesta = apuesta.getResultado();
        return resultadoPartido == resultadoApuesta;
    }




    }


