import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Partido{

    private String equipoLocal, equipoVisitante, ronda;
    private int golesLocal, golesVisitante;

    public Partido(String equipoLocal, String equipoVisitante, int golesLocal, int golesVisitante, String ronda) {
        this.equipoLocal = equipoLocal; this.equipoVisitante = equipoVisitante; this.golesLocal = golesLocal; this.golesVisitante = golesVisitante; this.ronda = ronda;
    }
    public int resultadoPerSe(){            //cada partido sabe su resultado
        if (golesLocal > golesVisitante) {
            return 1;
        } else if (golesVisitante > golesLocal) {
            return 2;
        } else {
            return 0;
        }
    }

    public String toString() { //10s es que el string ocupa 10 caracteres, 2d es 2 caracteres de int)
        return  String.format("| %-12s | %2d : %-2d | %-14s | %12s |",
                equipoLocal,golesLocal, golesVisitante, equipoVisitante, ronda);
    }







}
