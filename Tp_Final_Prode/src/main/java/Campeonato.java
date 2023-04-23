import lombok.Getter;
import java.util.ArrayList;
@Getter
public class Campeonato {
   private ArrayList<Partido> listaDePartidos;
   public Campeonato(){
       listaDePartidos = new ArrayList<>();
   }
   public void agregarPartido (Partido nuevo){listaDePartidos.add(nuevo);}
   public ArrayList<Partido> getListaDePartidos() {
        return listaDePartidos;
   }
    public int cantidadFecha(){
        return  listaDePartidos.size();
    }
    @Override
   public String toString(){
      String listado = "\u001B[4mCampeonato\u001B[0m:\u26BD \n";
      for (Partido p: listaDePartidos)
        listado += p.toString() + "\n";

      listado += "\n\u001B[4mCantidad de partidos\u001B[0m: " + listaDePartidos.size() + "\n";
      return listado;
   }
}
