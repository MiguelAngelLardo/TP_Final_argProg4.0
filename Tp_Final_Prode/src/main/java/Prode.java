import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Prode { //guarda a todos los apostadores
    private ArrayList<Apuesta> listaDeApuestas;
    private Campeonato fecha; //es para crear en el constructor la instancia Fecha
    private int puntosGanador, puntosEmpate;

    public Prode(Campeonato fecha) { //le paso como parametro una instancia de Campeonato. => los metodos de PRODE acceden a la lista de partidos de Campeonato.
        listaDeApuestas = new ArrayList<>();
        this.fecha = fecha;
        pedirPuntos();
    }

    public void agregarApuesta(Apuesta nueva) {
        listaDeApuestas.add(nueva);
    } //viene del while

    public void pedirPuntos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de puntos otorgados por acertar el ganador:");
        puntosGanador = scanner.nextInt();
        System.out.println("Ingrese la cantidad de puntos otorgados por acertar el empate:");
        puntosEmpate = scanner.nextInt();
    }

    public String apuestasCorrectasPorParticipante() {
        HashMap<String, Integer> apuestasCorrectasPorParticipante = new HashMap<>(); //clave String para el nombre del apostador y el valor Integer para la cantidad de apuestas.

        for (Apuesta ap : listaDeApuestas) {   //recorro cada apuesta de la lista
            for (Partido p : fecha.getListaDePartidos()) {  //por cada apuesta recorro la lista de partidos usando el get ya que la lista esta en otra clase
                if (p.getEquipoLocal().equalsIgnoreCase(ap.getEquipoLocal()) && p.getEquipoVisitante().equalsIgnoreCase(ap.getEquipoVisitante())) { //compara
                    int resultado = p.resultadoPerSe(); //resultado del partido
                    int puntos = 0; // acumulador de puntos por esta apuesta
                    int puntosObtenidos = p.resultadoSegunPuntaje(puntosGanador, puntosEmpate); // obtiene los puntos que corresponde según la apuesta y los parámetros de Prode
                    if (resultado == ap.getResultado()) {
                        puntos += puntosObtenidos;
                    }

                    if (puntos > 0) { // solo si obtuvo puntos se acumula la cantidad para el apostador correspondiente
                        apuestasCorrectasPorParticipante.merge(ap.getNombre(), puntos, Integer::sum);
                    }
                }
            }
        }

        String resultadoFinal = "";
        for (String participante_X : apuestasCorrectasPorParticipante.keySet()) { //keyset devuelve todas las KEYS del mapa. en este caso es el String del nombre. KeySet asigna ese nombre a "participante_X"
            int apuestasCorrectas = apuestasCorrectasPorParticipante.get(participante_X); //toma el valor asociado a la clave(nombre) con el .get
            resultadoFinal += participante_X + ": " + apuestasCorrectas + "\n";                 //similar al toString del Tikcet con Items.
        }

        return resultadoFinal;
    }






}





