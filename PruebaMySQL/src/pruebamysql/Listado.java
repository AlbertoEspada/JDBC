package pruebamysql;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author bligor
 */
public class Listado {

    Scanner sc = new Scanner(System.in);

    public Listado() {
    }

    public void Departamentos() throws SQLException {
        Departamentos depp = new Departamentos();
        Departamento dep = new Departamento();

        System.out.printf("%-3s %n %n", "_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
        System.out.printf("%-2s %-3s %s %n", " ", "(1)", "Todos");
        System.out.printf("%-2s %-3s %s %n", " ", "(2)", "Uno");
        System.out.printf("%-2s %-3s %n %-5s", " ", "----------------------------------------------------------------", " ");

        int cases11 = sc.nextInt();

        if (cases11 == 1) {
            ArrayList<Departamento> deps = new ArrayList<>();

            deps = depp.Read();

            System.out.println("\n");
            System.out.printf("%s %n", "+----------------+----------------+----------------+");
            System.out.printf("|%-15s |%-15s |%-15s |%n",
                    "Dept_no", "Dnombre", "Loc");
            System.out.println("+----------------+----------------+----------------+");
            for (int i = 0; i < deps.size(); i++) {
                System.out.printf("|%-15d |%-15s |%-15s |%n",
                        deps.get(i).getDept_no(),
                        deps.get(i).getDnombre(),
                        deps.get(i).getLoc());
            }
            System.out.println("+----------------+----------------+----------------+");
        } else if (cases11 == 2) {

            int num;
            System.out.printf("%-2s %s", " ", "Numero de Departamento: ");
            num = sc.nextInt();
            System.out.printf("%n");

            dep = depp.ReadOne(num);
            System.out.println("\n");

            System.out.printf("%s %n", "+----------------+----------------+----------------+");
            System.out.printf("|%-15s |%-15s |%-15s |%n",
                    "Dept_no", "Dnombre", "Loc");
            System.out.println("+----------------+----------------+----------------+");
            System.out.printf("|%-15d |%-15s |%-15s |%n",
                    dep.getDept_no(),
                    dep.getDnombre(),
                    dep.getLoc());
            System.out.println("+----------------+----------------+----------------+");

        }
    }

    public void Empleados() throws SQLException {
        Empleados empp = new Empleados();
        Empleado emp = new Empleado();

        System.out.printf("%-3s %n %n", "_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
        System.out.printf("%-2s %-3s %s %n", " ", "(1)", "Todos");
        System.out.printf("%-2s %-3s %s %n", " ", "(2)", "Uno");
        System.out.printf("%-2s %-3s %n %-5s", " ", "----------------------------------------------------------------", " ");

        int cases11 = sc.nextInt();

        if (cases11 == 1) {
            ArrayList<Empleado> emps = new ArrayList<>();

            emps = empp.Read();

            System.out.println("\n");

            System.out.printf("%s %n", "+----------------+----------------+----------------+----------------+----------------+----------------+----------------+----------------+");
            System.out.printf("|%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%n",
                    "Emp_no", "Apellido", "Oficio", "Dir", "Fecha_alt", "Salario", "Comision", "Dept_no");
            System.out.println("+----------------+----------------+----------------+----------------+----------------+----------------+----------------+----------------+");
            for (int i = 0; i < emps.size(); i++) {
                System.out.printf("|%-15d |%-15s |%-15s |%-15d |%-15s |%-15f |%-15f |%-15d |%n",
                        emps.get(i).getEmp_no(),
                        emps.get(i).getApellido(),
                        emps.get(i).getOficio(),
                        emps.get(i).getDir(),
                        emps.get(i).getFecha_alt(),
                        emps.get(i).getSalario(),
                        emps.get(i).getComision(),
                        emps.get(i).getDept_no());
            }
            System.out.println("+----------------+----------------+----------------+----------------+----------------+----------------+----------------+----------------+");
        } else if (cases11 == 2) {

            int num;
            System.out.printf("%-2s %s", " ", "Numero de Empleado: ");
            num = sc.nextInt();
            System.out.printf("%n");

            emp = empp.ReadOne(num);

            System.out.println("\n");

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
            System.out.println("+----------------+----------------+----------------+----------------+----------------+----------------+----------------+----------------+");
        }
    }
}
