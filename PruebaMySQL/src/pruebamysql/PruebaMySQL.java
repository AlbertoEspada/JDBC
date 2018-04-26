package pruebamysql;

import java.sql.*;

/**
 *
 * @author Bligor
 */
public class PruebaMySQL {

    public static void main(String[] args) throws SQLException {
        
        Connection conexion = null;
        
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "ejemplo", "ejemplo");
            System.out.println("Conexión satisfactoria");
        } catch (SQLException e) {
            System.err.println("Error al acceder a la BBDD " + e.getMessage());
        }

        /*-----------------------------------------------------------------------------------------------------*/

        Departamento dep = new Departamento();
        Departamentos depp = new Departamentos();
        
        dep.setDnombre("DDBB");
        dep.setLoc("CORUÑA");
        
        try{
            depp.Update(99, dep);
            System.out.println("Realizado");
        }
        catch(SQLException e){
            System.err.println("Error al crear la instancia" + e.getMessage());
        }
        
        /*---------------------------------------------------------------------------------*/
        conexion.close();
        System.out.println("Conexion Cerrada");
    }
}
