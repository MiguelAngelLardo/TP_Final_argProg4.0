import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Partido{

    private String equipoLocal, equipoVisitante, ronda;
    private int golesLocal, golesVisitante;

    public Partido(String equipoLocal, String equipoVisitante, int golesLocal, int golesVisitante, String ronda) {
        this.equipoLocal = equipoLocal; this.equipoVisitante = equipoVisitante; this.golesLocal = golesLocal; this.golesVisitante = golesVisitante; this.ronda = ronda;
    }
    public int resultadoPerSe(){
        if (golesLocal > golesVisitante) {
            return 1;
        } else if (golesVisitante > golesLocal) {
            return 2;
        } else {
            return 0;
        }
    }

    public String toString() {
        return  String.format("| %-12s | %2d : %-2d | %-14s | %12s |",
                equipoLocal,golesLocal, golesVisitante, equipoVisitante, ronda);
    }

}
