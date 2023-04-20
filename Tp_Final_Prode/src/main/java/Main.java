import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Equipos?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from Partidos");

        Campeonato campeonatoActual = new Campeonato(); //a este Array le agrego mas partidos

        while (rs.next()){
            String equipoLocal = rs.getString("equipolocal");
            int golesLocal = rs.getInt("goleslocal");
            int golesVisitante = rs.getInt("golesvisitante");
            String equipoVisitante = rs.getString("equipovisitante");
            String ronda = rs.getString("ronda");

            Partido nuevo = new Partido(equipoLocal, equipoVisitante, golesLocal, golesVisitante, ronda);
            campeonatoActual.agregarPartido(nuevo);

        }
        conn.close(); rs.close();

        /*Scanner sc = new Scanner(System.in);
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
        lector.close();*/


        Connection conn2 = DriverManager.getConnection("jdbc:mysql://localhost/Equipos?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
        Statement st2 = conn2.createStatement();
        ResultSet rs2 = st2.executeQuery("select * from Apuestas");

        Prode prodeActual = new Prode(campeonatoActual); //aca uno las 2 listas.

        while (rs2.next()){
            String nombre = rs2.getString("nombre");
            String equipoLocalApuesta = rs2.getString("equipolocal");
            String equipoVisitanteApuesta = rs2.getString("equipovisitante");
            int resul = rs2.getInt("resultado");
            String rondaApuesta = rs2.getString("ronda");
            Apuesta nueva = new Apuesta(nombre, equipoLocalApuesta, equipoVisitanteApuesta,rondaApuesta, resul);
            prodeActual.agregarApuesta(nueva);
        }
        conn2.close(); rs2.close();

        /*System.out.print("Ingrese el archivo con las apuestas: ");
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



