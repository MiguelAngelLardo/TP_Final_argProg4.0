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

        }
        conn.close(); rs.close();

        /*Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el archivo con los partidos: ");
        String a = sc.nextLine();
        Path archivo = Paths.get(a);
        Scanner lector = new Scanner(archivo);
        lector.useDelimiter("[;\\n\\r]+");
        Campeonato campeonatoActual = new Campeonato();

        while (lector.hasNextLine()){
            String equipoLocal = lector.nextLine();
            int golesLocal = lector.nextInt();
            int golesVisitante = lector.nextInt();
            String equipoVisitante = lector.nextLine();
            Partido partido = new Partido(equipoLocal, equipoVisitante, golesLocal, golesVisitante);
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


        System.out.println(campeonatoActual);

       // String resultado = prodeActual.apuestasCorrectasPorParticipante();
        //System.out.println(resultado);





    }
}



