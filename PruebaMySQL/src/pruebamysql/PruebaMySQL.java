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

        Empleados empp = new Empleados();
        Empleado emp = new Empleado();
        
        emp.setSalario(800);
        emp.setOficio("INFORM");
        emp.setDept_no(20);
        emp.setDir(7521);
        
        
        try{
            empp.Update(1234, emp);
            /*System.out.println("+---------------------+-----------------+---------------+");
        System.out.printf("|%-20s |%-16s |%-15s| %n",
                "Dept_no", "Dnombre", "Loc");
        System.out.println("+---------------------+-----------------+---------------+");
        System.out.printf("|%-20s |%-16s |%-15s| %n",
                dep.getDept_no(), dep.getDnombre(), dep.getLoc());
        System.out.println("+---------------------+-----------------+---------------+");
        */
        }
        catch(SQLException e){
            System.err.println("Error: " + e.getMessage());
        }
        
        /*---------------------------------------------------------------------------------*/
        conexion.close();
        System.out.println("Conexion Cerrada");
    }
}
