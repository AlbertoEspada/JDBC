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
public class Departamentos {

    private Connection conexion;
    private ArrayList<Departamento> departamentos;

    public Departamentos() {

        /*-------------------Conexion-------------------------*/
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "ejemplo", "ejemplo");
        } catch (SQLException ex) {
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*----------------------------------------------------*/
    }

    /*Crear*/
    public int Create(Departamento dep) throws SQLException {
        int filas;
        /*Sentencia SQL*/
        String sql = "INSERT INTO departamentos VALUES ( ?, ?, ? )";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        /*Settear Valores en Sentencia*/
        sentencia.setInt(1, dep.getDept_no());
        sentencia.setString(2, dep.getDnombre());
        sentencia.setString(3, dep.getLoc());
        /*Ejecutar la sentencia*/
        filas = sentencia.executeUpdate();
        /*Devolver el valor de la sentencia*/
        return filas;
    }

    /*Actualizar*/
    public int Update(int dep_no, Departamento dep) throws SQLException {
        /*Sentencia SQL*/
        String sql = "UPDATE departamentos SET dnombre = ?, loc = ? WHERE dept_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        int filas;
        /*Settear Valores en la Sentencia*/
        sentencia.setString(1, dep.getDnombre());
        sentencia.setString(2, dep.getLoc());
        sentencia.setInt(3, dep_no);
        /*Ejecutar la sentencia*/
        filas = sentencia.executeUpdate();
        /*Devolver valor de la sentencia*/
        return filas;
    }

    /*Listar Tabla Entera*/
    public ArrayList<Departamento> Read() throws SQLException {
        ResultSet rs;
        /*Guardamos todos los valores de la tabla en un ArrayList*/
        ArrayList<Departamento> listado = new ArrayList<>();
        /*Sentencia SQL*/
        String sql = "SELECT * FROM departamentos";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        /*Ejecutar la Sentencia*/
        sentencia.execute();
        /*Obtenemos los resultados de la sentencia*/
        rs = sentencia.getResultSet();
        /*Bucle para guardar los datos de la tabla*/
        while(rs.next()){
        Departamento dep = new Departamento(rs.getInt("dept_no"), rs.getString("dnombre"), rs.getString("loc"));   
        listado.add(dep);
        }
        return listado;
    }
    
    /*Listar un unico Dato de la tabla buscado por numero*/
    public Departamento ReadOne(int dep_no) throws SQLException {
        ResultSet rs;
        /*Sentencia SQL*/
        String sql = "SELECT * FROM departamentos WHERE dept_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        /*Setteamos el numero de departamento en la sentencia*/
        sentencia.setInt(1, dep_no);
        /*Ejecutar la sentencia*/
        sentencia.execute();
        rs = sentencia.getResultSet();
        rs.next();
        /*Guardamos el Departamento buscado*/
        Departamento dep = new Departamento(rs.getInt("dept_no"), rs.getString("dnombre"), rs.getString("loc"));    
        return dep;
    }

    /*Buscar un departamento por el nombre*/
    public Departamento SearchOne(String dnombre) throws SQLException {
        ResultSet rs;
        /*Sentencia SQL*/
        String sql = "SELECT * FROM departamentos WHERE dnombre = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        /*Setteamos el nombre de departamento en la sentencia*/
        sentencia.setString(1, dnombre);
        /*Ejecutar la sentencia*/
        sentencia.execute();
        rs = sentencia.getResultSet();
        rs.next();
        /*Guardamos el departamento buscado*/
        Departamento dep = new Departamento(rs.getInt("dept_no"), rs.getString("dnombre"), rs.getString("loc"));    
        return dep;
    }
    
    /*Borrar un departamento*/
    public int Delete(int dep_no) throws SQLException {
        /*Sentencia SQL*/
        String sql = "DELETE FROM departamentos WHERE dept_no = ? ";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        int filas = 0;
        /*Setteamos el numero de departamento en la sentencia*/
        sentencia.setInt(1, dep_no);
        /*Ejecutar la sentencia*/
        try{
        filas = sentencia.executeUpdate();
        }
        /*Imprimir el error si llega a darlo*/
        catch(SQLException e){
            System.err.println("Error al borrar el Empleado: " + e);
        }
        return filas;
    }

}
