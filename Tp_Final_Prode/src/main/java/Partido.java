import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Partido{

    private String equipoLocal, equipoVisitante, ronda;
    private int golesLocal, golesVisitante;



    public Partido(String equipoLocal, String equipoVisitante, int golesLocal, int golesVisitante, String ronda) {
        this.equipoLocal = equipoLocal; this.equipoVisitante = equipoVisitante; this.golesLocal = golesLocal; this.golesVisitante = golesVisitante; this.ronda = ronda;
    }

    public String toString() {
        return  equipoLocal + " " +  equipoVisitante + " " + golesLocal + " " + golesVisitante;
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

    public int resultadoSegunPuntaje(int puntosGanador, int puntosEmpate) { //entra por parametro el valor y sale pro return
        if (golesLocal > golesVisitante)
            return puntosGanador;
         else if (golesVisitante == golesLocal)
            return puntosEmpate;
         else return 0; //esto es para que si no se cumple el if o else if devuelva algo el metodo
    }




}
