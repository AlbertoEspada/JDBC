package pruebamysql;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Bligor
 */
public class PruebaMySQL {

    public static void main(String[] args) throws SQLException, IOException, ParseException {
        Scanner sc = new Scanner(System.in);

        //Objetos Vacios
        
            //Empleados    
            Empleado emp = new Empleado();
            Empleados empp = new Empleados();
            //Departamentos
            Departamento dep = new Departamento();
            Departamentos depp = new Departamentos();
            //Imprimir
            Listado li = new Listado();
            Buscar bs = new Buscar();
            //Crear
            Create cr = new Create();

        int cases;

        do {
            
            /*--------------------------Conexion--------------------------------------------*/
            Connection conexion = null;

            try {
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "ejemplo", "ejemplo");
                System.out.println("Conexión satisfactoria" + "\n");
                System.out.println("Bienvenido a la Base de Datos " + conexion.getCatalog()+ "\n");
            } catch (SQLException e) {
                System.err.println("Error al acceder a la BBDD " + e.getMessage());
            }
            /*--------------------------------------------------------------------------------*/
            
            System.out.printf("%-50s %n %n", "Elija su opcion:");
            System.out.printf("%-2s %-3s %s %n", " ", "(1)", "Listar");
            System.out.printf("%-2s %-3s %s %n", " ", "(2)", "Buscar");
            System.out.printf("%-2s %-3s %s %n", " ", "(3)", "Crear");
            System.out.printf("%-2s %-3s %s %n", " ", "(4)", "Borrar");
            System.out.printf("%-2s %-3s %s %n", " ", "(0)", "Salir");
            System.out.printf("%-2s %-3s %n %-5s", " ", "----------------------------------------------------------------", " ");

            cases = sc.nextInt();

            System.out.printf("%n");
            
            /*Seleccion de Accion*/
            switch (cases) {
                case 1: /*Listar*/
                    System.out.printf("%-3s %n %n", "_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                    System.out.printf("%-2s %-3s %s %n", " ", "(1)", "Departamento");
                    System.out.printf("%-2s %-3s %s %n", " ", "(2)", "Empleado");
                    System.out.printf("%-2s %-3s %n %-5s", " ", "----------------------------------------------------------------", " ");

                    int cases1 = sc.nextInt();
                    System.out.printf("%n");
                    
                    /*Seleccion de Tabla*/
                    if (cases1 == 1) {
                        li.Departamentos();
                    } else if (cases1 == 2) {
                        li.Empleados();
                    }
                    
                    break;

                case 2: /*Buscar*/
                    System.out.printf("%-3s %n %n", "_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                    System.out.printf("%-2s %-3s %s %n", " ", "(1)", "Departamento");
                    System.out.printf("%-2s %-3s %s %n", " ", "(2)", "Empleado");
                    System.out.printf("%-2s %-3s %n %-5s", " ", "----------------------------------------------------------------", " ");

                    int cases2 = sc.nextInt();
                    System.out.printf("%n");

                    /*Seleccion de Tabla*/
                    if (cases2 == 1) {
                        bs.Departamento();
                    } else if (cases2 == 2) {
                        bs.Empleado();
                    }

                    break;
                    
                case 3: /*Crear*/
                    System.out.printf("%-3s %n %n", "_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                    System.out.printf("%-2s %-3s %s %n", " ", "(1)", "Departamento");
                    System.out.printf("%-2s %-3s %s %n", " ", "(2)", "Empleado");
                    System.out.printf("%-2s %-3s %n %-5s", " ", "----------------------------------------------------------------", " ");

                    int cases3 = sc.nextInt();
                    System.out.printf("%n");

                    /*Seleccion de Tabla*/
                    if (cases3 == 1) {
                        cr.Departamento();
                    } else if (cases3 == 2) {
                        cr.Empleado();
                    }

                    break;
                    
                case 4: /*Borrar*/
                    System.out.printf("%-3s %n %n", "_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                    System.out.printf("%-2s %-3s %s %n", " ", "(1)", "Departamento");
                    System.out.printf("%-2s %-3s %s %n", " ", "(2)", "Empleado");
                    System.out.printf("%-2s %-3s %n %-5s", " ", "----------------------------------------------------------------", " ");

                    int cases4 = sc.nextInt();
                    System.out.printf("%n");

                    /*Seleccion de Tabla*/
                    if (cases4 == 1) {
                        System.out.printf("%-2s %s", " ", "Numero de Departamento: ");
                        int ndep = sc.nextInt();
                        System.out.printf("%n");
                        depp.Delete(ndep);
                    } else if (cases4 == 2) {
                        System.out.printf("%-2s %s", " ", "Numero de Empleado: ");
                        int nemp = sc.nextInt();
                        System.out.printf("%n");
                        empp.Delete(nemp);
                    }

                    break;
            }

            /*-----------------------------------Conexion----------------------------------------------*/
            conexion.close();

            System.out.printf("%s %n %n %n %n", "Conexion Cerrada con Exito");
            
            /*-----------------------------------------------------------------------------------------*/

        } while (cases != 0);
    }
}
