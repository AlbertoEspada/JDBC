package pruebamysql;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author bligor
 */
public class Create {

    Scanner sc = new Scanner(System.in);

    //Empleados
    Empleado emp = new Empleado();
    Empleados empp = new Empleados();
    //Departamentos
    Departamento dep = new Departamento();
    Departamentos depp = new Departamentos();
    //Imprimir
    Listado li = new Listado();
    Buscar bs = new Buscar();

    public void Departamento() throws SQLException {
        System.out.printf("%s %n", "Numero Departamento: ");
        int ndep = sc.nextInt();
        System.out.printf("%s %n", "Nombre Departamento: ");
        String nombre = sc.next();
        System.out.printf("%s %n", "Localizacion: ");
        String loc = sc.next();
        
        Departamento dep = new Departamento(ndep, nombre, loc);
        
        depp.Create(dep);
    }

    public void Empleado() throws ParseException, SQLException {
        System.out.printf("%s %n", "Numero Empleado: ");
        int nemp = sc.nextInt();
        System.out.printf("%s %n", "Apellido: ");
        String apellido = sc.next();
        System.out.printf("%s %n", "Oficio: ");
        String oficio = sc.next();
        System.out.printf("%s %n", "Director: ");
        int dir = sc.nextInt();
        System.out.printf("%s %n", "Fecha de Alta: ");
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String fecha = sc.next();
        java.util.Date ud = df.parse(fecha);
        long ms = ud.getTime();
        java.sql.Date fecha_alt = new java.sql.Date(ms);
        System.out.printf("%s %n", "Salario: ");
        float salario = sc.nextFloat();
        System.out.printf("%s %n", "Comision: ");
        float comision = sc.nextFloat();
        System.out.printf("%s %n", "Numero de Departameno: ");
        int ndep = sc.nextInt();
    
        Empleado emp = new Empleado(nemp, apellido, oficio, dir, fecha_alt, salario, comision, ndep);
    
        empp.Create(emp);
    }
}
