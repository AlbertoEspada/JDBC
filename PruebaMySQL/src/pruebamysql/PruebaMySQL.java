package pruebamysql;


import java.sql.*;

/**
 *
 * @author Bligor
 */
public class PruebaMySQL {

     public static void main(String[] args)
    {
        Connection conexion = null;
        Statement sentencia = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver"); // No necesario a partir del JDK 7
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "ejemplo", "ejemplo");
        } catch (SQLException e) {
            System.err.println("Error al acceder a la BBDD " + e.getMessage());
        }
        System.out.println("Conexión satisfactoria");

        String sql = "SELECT * FROM empleados";
        try {
            sentencia = (Statement) conexion.createStatement();

            sentencia.execute(sql);

            ResultSet rs = sentencia.getResultSet();
            while (rs.next()) {
                System.out.printf("%d, %s, %s %n",
                        rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            rs.close();

            sentencia.close();
            conexion.close();
        } catch (SQLException ex) {
            System.err.println("Error en BBDD" + ex.getMessage());
        }
    }
}
