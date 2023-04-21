import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        Campeonato campeonatoActual = LectorDeArchivo.leerPartidosDesdeBD();
        Prode prodeActual = LectorDeArchivo.leerApuestasDesdeDB(campeonatoActual);

        //Leer desde Archivo
        /*
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el archivo con los partidos: ");
        String a = sc.nextLine();
        Path archivo = Paths.get(a);
        Scanner lector = new Scanner(archivo);
        lector.useDelimiter("[;\\n\\r]+");
        Campeonato campeonatoActual = new Campeonato();

        while (lector.hasNext()){
            String equipoLocal = lector.next();
            int golesLocal = lector.nextInt();
            int golesVisitante = lector.nextInt();
            String equipoVisitante = lector.next();
            String ronda = lector.next();
            Partido nuevo = new Partido(equipoLocal, equipoVisitante, golesLocal, golesVisitante, ronda);
            campeonatoActual.agregarPartido(nuevo);
        }
        lector.close();

        ////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.print("Ingrese el archivo con las apuestas: ");
        String b = sc.nextLine();
        Path archivo2 = Paths.get(b);
        Scanner lector2 = new Scanner(archivo2);
        lector2.useDelimiter("[;\\n\\r]+");
        Prode prodeActual = new Prode(campeonatoActual);

        while (lector2.hasNext()){
            String nombre = lector2.next();
            String equipoLocalApuesta = lector2.next();
            String equipoVisitanteApuesta = lector2.next();
            int resul = lector2.nextInt();
            String rondaApuesta = lector2.next();
            Auesta nueva = new Apuesta(nombre, equipoLocalApuesta, equipoVisitanteApuesta,rondaApuesta, resul);
            prodeActual.agregarApuesta(nueva);
        }
        lector2.close();*/

        System.out.println(campeonatoActual);//muestra el toString de Campeonato (que tiene el de Partido)
        String resultado = prodeActual.apuestasCorrectasPorParticipante();
        System.out.println(resultado);

        //Json
        ObjectMapper om = new ObjectMapper();
        //System.out.println (om.writerWithDefaultPrettyPrinter().writeValueAsString(campeonatoActual));
        //om.writeValue(Paths.get("partidos.json").toFile(),campeonatoActual);

        ObjectMapper om2 = new ObjectMapper();
        //System.out.println(om2.writerWithDefaultPrettyPrinter().writeValueAsString(prodeActual));
        //om.writerWithDefaultPrettyPrinter().writeValue(Paths.get("apuestas.json").toFile(), prodeActual);


    }
}



