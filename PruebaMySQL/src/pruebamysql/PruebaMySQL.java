package pruebamysql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.time.LocalDate;

/**
 *
 * @author Bligor
 */
public class PruebaMySQL {

    public static void main(String[] args) throws SQLException, IOException {

        /*--------------------------Conexion--------------------------------------------*/
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "ejemplo", "ejemplo");
            System.out.println("Conexión satisfactoria" + "\n");
        } catch (SQLException e) {
            System.err.println("Error al acceder a la BBDD " + e.getMessage());
        }

        /*--------------------------------------------------------------------------------*/
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //Objetos Vacios
        //Empleados    
        Empleado emp = new Empleado();
        Empleados empp = new Empleados();
        //Departamentos
        Departamento dep = new Departamento();
        Departamentos depp = new Departamentos();

        System.out.printf("%-50s %n %n", "Elija su opcion:");
        System.out.printf("%-2s %-3s %s %n", " ", "(1)", "Listar");
        System.out.printf("%-2s %-3s %s %n", " ", "(2)", "Buscar");
        System.out.printf("%-2s %-3s %s %n", " ", "(3)", "Crear");
        System.out.printf("%-2s %-3s %s %n", " ", "(4)", "Borrar");
        System.out.printf("%-2s %-3s %n %-5s", " ", "----------------------------------------------------------------", " ");

        String cas = bf.readLine();
        int cases = Integer.parseInt(cas);

        System.out.printf("%n");

        switch (cases) {
            case 1:
                System.out.printf("%-3s %n %n", "_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                System.out.printf("%-2s %-3s %s %n", " ", "(1)", "Departamento");
                System.out.printf("%-2s %-3s %s %n", " ", "(2)", "Empleado");
                System.out.printf("%-2s %-3s %n %-5s", " ", "----------------------------------------------------------------", " ");

                String cas1 = bf.readLine();
                int cases1 = Integer.parseInt(cas);

                if (cases1 == 1) {
                    System.out.printf("Numero de departamento a listar: ");
                    depp.Read(cases1);
                }
                break;
            case 2:
                System.out.printf("%-3s %n %n", "_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                System.out.printf("%-2s %-3s %s %n", " ", "(1)", "Departamento");
                System.out.printf("%-2s %-3s %s %n", " ", "(2)", "Empleado");
                System.out.printf("%-2s %-3s %n %-5s", " ", "----------------------------------------------------------------", " ");

                String cas2 = bf.readLine();
                int cases2 = Integer.parseInt(cas);
                break;
            case 3:
                System.out.printf("%-3s %n %n", "_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                System.out.printf("%-2s %-3s %s %n", " ", "(1)", "Departamento");
                System.out.printf("%-2s %-3s %s %n", " ", "(2)", "Empleado");
                System.out.printf("%-2s %-3s %n %-5s", " ", "----------------------------------------------------------------", " ");

                String cas3 = bf.readLine();
                int cases3 = Integer.parseInt(cas);
                break;
            case 4:
                System.out.printf("%-3s %n %n", "_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                System.out.printf("%-2s %-3s %s %n", " ", "(1)", "Departamento");
                System.out.printf("%-2s %-3s %s %n", " ", "(2)", "Empleado");
                System.out.printf("%-2s %-3s %n %-5s", " ", "----------------------------------------------------------------", " ");

                
                String cas4 = bf.readLine();
                int cases4 = Integer.parseInt(cas);
                break;

        }
        /*---------------------------------------------------------------------------------*/
        conexion.close();
        System.out.println("Conexion Cerrada");
    }
}
