package pruebamysql;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author bligor
 */
public class Buscar {
    Scanner sc = new Scanner(System.in);

    /*Buscar un Departamento por el nombre*/
    public void Departamento() throws SQLException {
        /*Objetos Vacios*/
        Departamentos depp = new Departamentos();
        Departamento dep = new Departamento();

        /*Nombre del Departamento*/
        String nom;
        System.out.printf("%-2s %s", " ", "Nombre de Departamento: ");
        nom = sc.nextLine();
        System.out.printf("%n");

        dep = depp.SearchOne(nom);

        System.out.printf("%s %n", "+----------------+----------------+----------------+");
        System.out.printf("|%-15s |%-15s |%-15s |%n",
                "Dept_no", "Dnombre", "Loc");
        System.out.println("+----------------+----------------+----------------+");
        System.out.printf("|%-15d |%-15s |%-15s |%n",
                dep.getDept_no(),
                dep.getDnombre(),
                dep.getLoc());
        System.out.printf("%s %n %n", "+----------------+----------------+----------------+");

    }

    /*Buscar un Empleado por Nombre*/
    public void Empleado() throws SQLException {
        /*Objetos Vacios*/
        Empleados empp = new Empleados();
        Empleado emp = new Empleado();

        /*Nombre del Empleado*/
        String nom;
        System.out.printf("%-2s %s", " ", "Nombre de Empleado: ");
        nom = sc.nextLine();
        System.out.printf("%n");

        emp = empp.SearchOne(nom);

        System.out.printf("%s %n", "+----------------+----------------+----------------+----------------+----------------+----------------+----------------+----------------+");
        System.out.printf("|%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%n",
                "Emp_no", "Apellido", "Oficio", "Dir", "Fecha_alt", "Salario", "Comision", "Dept_no");
        System.out.println("+----------------+----------------+----------------+----------------+----------------+----------------+----------------+----------------+");
        System.out.printf("|%-15d |%-15s |%-15s |%-15d |%-15s |%-15f |%-15f |%-15d |%n",
                emp.getEmp_no(),
                emp.getApellido(),
                emp.getOficio(),
                emp.getDir(),
                emp.getFecha_alt(),
                emp.getSalario(),
                emp.getComision(),
                emp.getDept_no());
        System.out.printf("%s %n %n", "+----------------+----------------+----------------+----------------+----------------+----------------+----------------+----------------+");

    }
}
