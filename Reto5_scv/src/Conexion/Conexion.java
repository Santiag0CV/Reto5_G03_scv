package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexion {

    private static final String Bd = "ProyectosConstruccion.db";

    String url = "jdbc:sqlite:" + Bd;
    
    Connection conn = null;

    public Conexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);

            System.out.println("Conectado con la base de datos");
        } catch (Exception e) {
            System.out.println("Error de conexion " + e);
        }
    }

    public ResultSet consultarRegistros(String strSentenciaSQL) {
        try {

            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
