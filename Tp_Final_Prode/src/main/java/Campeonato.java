import java.util.ArrayList;

public class Campeonato { //  //guarda todos los partidos con el Array
   private ArrayList<Partido> listaDePartidos;
   public Campeonato(){
       listaDePartidos = new ArrayList<>();
   }
   public void agregarPartido (Partido nuevo){listaDePartidos.add(nuevo);}// aca empieza la COMPOSICION
   public ArrayList<Partido> getListaDePartidos() {
        return listaDePartidos;
   }

    public int cantidadFecha(){
        return  listaDePartidos.size();
    }

    @Override
   public String toString(){
      String listado = "Campeonato: \n";
      for (Partido p: listaDePartidos)  //por cada partido de la LISTA-PARTIDO
        listado += p.toString() + "\n";       //el p. llama al toString que cree en Partido

      listado += "Cantidad de partidos: " + listaDePartidos.size();
      return listado;
   }









}