import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
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
            System.out.println("1");
        }
        conn.close(); rs.close();

        Connection conn2 = DriverManager.getConnection("jdbc:mysql://localhost/Equipos?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
        Statement st2 = conn2.createStatement();
        ResultSet rs2 = st2.executeQuery("select * from Apuestas");

        Prode prodeActual = new Prode(campeonatoActual); //aca uno las 2 listas.

        while (rs2.next()){
            String nombre = rs2.getString("nombre");
            String equipoLocalApuesta = rs2.getString("equipolocal");
            String equipoVisitanteApuesta = rs2.getString("equipovisitante");
            int resultado = rs2.getInt("resultado");
            System.out.println("hola");
            Apuesta nueva = new Apuesta(nombre, equipoLocalApuesta, equipoVisitanteApuesta,resultado);
            prodeActual.agregarApuesta(nueva);
            System.out.println("chau");

        }
        conn2.close(); rs2.close();


       // System.out.println(campeonatoActual);

        String resultado = prodeActual.apuestasCorrectasPorParticipante();
        System.out.println(resultado);


        // System.out.println(fecha.resultadoDeLaFeCha("chile","polonia"));




    }
}
