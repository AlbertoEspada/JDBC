package pruebamysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alberto Espada
 */
public class Empleados {

    private Connection conexion;
    private ArrayList<Departamento> departamentos;

    public Empleados() {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "ejemplo", "ejemplo");
        } catch (SQLException ex) {
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int Create(Empleado emp) throws SQLException {
        int filas;
        String sql = "INSERT INTO empleados VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, emp.getEmp_no());
        sentencia.setString(2, emp.getApellido());
        sentencia.setString(3, emp.getOficio());
        sentencia.setInt(4, emp.getDir());
        sentencia.setDate(5, emp.getFecha_alt());
        sentencia.setFloat(6, emp.getSalario());
        sentencia.setFloat(7, emp.getComision());
        sentencia.setInt(8, emp.getDept_no());
        filas = sentencia.executeUpdate();
        return filas;
    }

    public int Update(int emp_no, Empleado emp) throws SQLException {
        String sql = "UPDATE empleados SET apellido = ?, oficio = ?, dir = ?, fecha_alt = ?, salario = ?, comision = ?, dept_no = ? WHERE emp_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        int filas;
        sentencia.setString(1, emp.getApellido());
        sentencia.setString(2, emp.getOficio());
        sentencia.setInt(3, emp.getDir());
        sentencia.setDate(4, emp.getFecha_alt());
        sentencia.setFloat(5, emp.getSalario());
        sentencia.setFloat(6, emp.getComision());
        sentencia.setInt(7, emp.getDept_no());
        sentencia.setInt(8, emp_no) ;
        filas = sentencia.executeUpdate();
        return filas;
    }

    public ArrayList<Empleado> Read() throws SQLException {
        ResultSet rs;
        ArrayList<Empleado> listado = new ArrayList<>();
        String sql = "SELECT * FROM empleados";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.execute();
        rs = sentencia.getResultSet();
        while(rs.next()){
        Empleado emp = new Empleado(rs.getInt("emp_no"), rs.getString("apellido"), rs.getString("oficio"), rs.getInt("dir"), rs.getDate("fecha_alt"), rs.getFloat("salario"), rs.getFloat("comision"), rs.getInt("dept_no"));   
        listado.add(emp);
        }
        return listado;
    }
    
    public Empleado ReadOne(int emp_no) throws SQLException {
        ResultSet rs;
        String sql = "SELECT * FROM empleados WHERE emp_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, emp_no);
        sentencia.execute();
        rs = sentencia.getResultSet();
        rs.next();
        Empleado emp = new Empleado(rs.getInt("emp_no"), rs.getString("apellido"), rs.getString("oficio"), rs.getInt("dir"), rs.getDate("fecha_alt"), rs.getFloat("salario"), rs.getFloat("comision"), rs.getInt("dept_no"));   
        return emp;
    }
    
    public Empleado SearchOne(String apellido) throws SQLException {
        ResultSet rs;
        String sql = "SELECT * FROM empleados WHERE apellido = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, apellido);
        sentencia.execute();
        rs = sentencia.getResultSet();
        rs.next();
        Empleado emp = new Empleado(rs.getInt("emp_no"), rs.getString("apellido"), rs.getString("oficio"), rs.getInt("dir"), rs.getDate("fecha_alt"), rs.getFloat("salario"), rs.getFloat("comision"), rs.getInt("dept_no"));   
        return emp;
    }

    public int Delete(int emp_no) throws SQLException {
        String sql = "DELETE FROM empleados WHERE emp_no = ? "; 
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        int filas;
        sentencia.setInt(1, emp_no);
        filas = sentencia.executeUpdate();
        return filas;
    }

    
}
