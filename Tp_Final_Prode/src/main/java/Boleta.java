import java.util.ArrayList;
import java.util.HashMap;

public class Boleta { //guarda a todos los apostadores
    private ArrayList<Apuesta> listaDeApuestas;
    private Campeonato fecha; //es para crear en el constructor la instancia Fecha

    public Boleta(Campeonato fecha) { //le paso como parametro una instancia de Campeonato. => los metodos de Apostador acceden a la lista de partidos de Campeonato.
        listaDeApuestas = new ArrayList<>();
        this.fecha = fecha;
    }
    public void agregarApuesta(Apuesta nueva) {
        listaDeApuestas.add(nueva);
    } //viene del while

    public String apuestasCorrectasPorParticipante() {
        HashMap<String, Integer> apuestasCorrectasPorParticipante = new HashMap<>(); //clave String para el nombre del apostador y el valor Integer para la cantidad de apuestas.

        for (Apuesta ap : listaDeApuestas)     //recorro cada apuesta de la lista
            for (Partido p : fecha.getListaDePartidos())  //por cada apuesta recorro la lista de partidos usando el get ya que la lista esta en otra clase
                if (p.getEquipoLocal().equalsIgnoreCase(ap.getEquipoLocal()) && p.getEquipoVisitante().equalsIgnoreCase(ap.getEquipoVisitante())) { //compara
                    int resultado = p.resultadoPerSe(); //resultado del partido
                    if (resultado == ap.getResultado())  //resultado del apostador comparado con el del partido
                        apuestasCorrectasPorParticipante.merge(ap.getNombre(), 1, Integer::sum);  //merge esun metodo del hashMap que toma la clave en este caso el nombre del Apostador
                }                                                                                     //toma el nombre "juan" y le agrega un 1, si  aparece de nuevo juan le suma otro 1 = 2
                                                                                                      //Integer:: sum es expresion lambda que suma el valor "1"
        String resultadoFinal = "";
        for (String participante_X : apuestasCorrectasPorParticipante.keySet()) { //keyset devuelve todas las KEYS del mapa. en este caso es el String del nombre. KeySet asigna ese nombre a "participante_X"
            int apuestasCorrectas = apuestasCorrectasPorParticipante.get(participante_X); //toma el valor asociado a la clave(nombre) con el .get
            resultadoFinal += participante_X + ": " + apuestasCorrectas + "\n";                 //similar al toString del Tikcet con Items.
        }

        return resultadoFinal;
    }























    public int cantidadApuesta() {
        return listaDeApuestas.size();
    }
}




