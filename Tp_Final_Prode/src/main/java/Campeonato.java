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

   @Override
   public String toString(){
      String listado = "Campeonato: \n";
      for (Partido p: listaDePartidos)  //por cada partido de la LISTA-PARTIDO
        listado += p.toString() + "\n";       //el p. llama al toString que cree en Partido

      listado += "Cantidad de partidos: " + listaDePartidos.size();
      return listado;
   }
















    public int cantidadFecha(){
        return  listaDePartidos.size();
    }


  /* public int resultadoLocalvsVisitante (String equipoLocalBuscado, String equipoVisitanteBuscado){
       int ganaLocal = 0, ganaVisitante = 0, empate = 0;
       for(Partido p: listaDePartidos){
           if (p.getEquipoLocal().equals(equipoLocalBuscado) && p.resultadoPerSe() == 1) {
               ganaLocal++;
           } else if (p.getEquipoVisitante().equals(equipoVisitanteBuscado) && p.resultadoPerSe() == 2) {
               ganaVisitante++;
           } else if (p.resultadoPerSe() == 0) {
               empate++;
           }
       }
       if (ganaLocal > ganaVisitante)
           return 1;
       else if (ganaLocal < ganaVisitante)
           return 2;
       else
           return 0;

   }*/




}
