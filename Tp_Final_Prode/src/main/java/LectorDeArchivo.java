import java.sql.*;
public class LectorDeArchivo {
    public static Campeonato leerPartidosDesdeBD() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Equipos?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from Partidos");

        Campeonato campeonatoActual = new Campeonato();

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
        return campeonatoActual;
    }

    public static Prode leerApuestasDesdeDB(Campeonato campeonatoActual)throws SQLException{
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
        return prodeActual;




    }













}
