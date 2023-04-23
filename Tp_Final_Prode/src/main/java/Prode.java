import lombok.Getter;
import java.util.*;
@Getter
public class Prode {
    private ArrayList<Apuesta> listaDeApuestas;
    private Campeonato fecha;

    public Prode(Campeonato fecha) {
        listaDeApuestas = new ArrayList<>();
        this.fecha = fecha;
    }
    public void agregarApuesta(Apuesta nueva) {
        listaDeApuestas.add(nueva);
    }
    public String apuestasCorrectasPorParticipante() {
        HashMap<String, Integer> apuestasCorrectasPorParticipante = new HashMap<>();
        int maxPuntaje = 0;
        String ganador = "";

        for (Apuesta ap : listaDeApuestas) {
            for (Partido p : fecha.getListaDePartidos())
                if (p.getEquipoLocal().equalsIgnoreCase(ap.getEquipoLocal()) && p.getEquipoVisitante().equalsIgnoreCase(ap.getEquipoVisitante())) {
                    int resultado = p.resultadoPerSe();
                    if (resultado == ap.getResultado())
                        apuestasCorrectasPorParticipante.merge(ap.getNombre(), 1, Integer::sum);
                }
        }

        String resultadoFinal = "\u001B[4mParticipantes\u001B[0m:\n";
        for (String participante_X : apuestasCorrectasPorParticipante.keySet()) {
            int apuestasCorrectas = apuestasCorrectasPorParticipante.get(participante_X);
            resultadoFinal += participante_X + ": " + apuestasCorrectas + "\n";

            if (apuestasCorrectas > maxPuntaje){
                maxPuntaje = apuestasCorrectas;
                ganador = participante_X;
            }
        }

        resultadoFinal += "\n\u001B[4mEl ganador fue\u001B[0m: \ud83c\udfc6 " + ganador.toUpperCase() + "\n";
        return resultadoFinal;
    }
}





