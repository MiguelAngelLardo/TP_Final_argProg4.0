import lombok.Getter;
import java.util.*;
@Getter
public class Prode { //guarda a todos los apostadores
    private ArrayList<Apuesta> listaDeApuestas;
    private Campeonato fecha; //es para crear en el constructor la instancia Fecha

    public Prode(Campeonato fecha) { //le paso como parametro una instancia de Campeonato. => los metodos de PRODE acceden a la lista de partidos de Campeonato.
        listaDeApuestas = new ArrayList<>();
        this.fecha = fecha;
    }
    public void agregarApuesta(Apuesta nueva) {
        listaDeApuestas.add(nueva);
    } //viene del while

    public String apuestasCorrectasPorParticipante() {
        HashMap<String, Integer> apuestasCorrectasPorParticipante = new HashMap<>(); //clave String para el nombre del apostador y el valor Integer para la cantidad de apuestas.
        int maxPuntaje = 0;
        String ganador = "";

        for (Apuesta ap : listaDeApuestas) {   //recorro cada apuesta de la lista
            for (Partido p : fecha.getListaDePartidos()) {  //por cada apuesta recorro la lista de partidos usando el get ya que la lista esta en otra clase
                if (p.getEquipoLocal().equalsIgnoreCase(ap.getEquipoLocal()) && p.getEquipoVisitante().equalsIgnoreCase(ap.getEquipoVisitante())) { //compara
                    int resultado = p.resultadoPerSe(); //resultado del partido
                    if (resultado == ap.getResultado()) //resultado del apostador comparado con el del partido
                        apuestasCorrectasPorParticipante.merge(ap.getNombre(), 1, Integer::sum);
                }
            }
        }

        String resultadoFinal = "\u001B[4mParticipantes\u001B[0m:\n";
        for (String participante_X : apuestasCorrectasPorParticipante.keySet()) { //keyset devuelve todas las KEYS del mapa. en este caso es el String del nombre. KeySet asigna ese nombre a "participante_X"
            int apuestasCorrectas = apuestasCorrectasPorParticipante.get(participante_X); //toma el valor asociado a la clave(nombre) con el .get
            resultadoFinal += participante_X + ": " + apuestasCorrectas + "\n"; //similar al toString del Tikcet con Items. => el += guarda con un salto de linea cada STRING

            if (apuestasCorrectas > maxPuntaje){
                maxPuntaje = apuestasCorrectas;
                ganador = participante_X;
            }
        }

        resultadoFinal += "\n\u001B[4mEl ganador fue\u001B[0m: \ud83c\udfc6 " + ganador.toUpperCase() + "\n"; //al terminar todos los ciclos MUESTRO 1 VEZ SOLA este msj.
        return resultadoFinal;

    }


}





