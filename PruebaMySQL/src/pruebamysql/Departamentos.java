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

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "ejemplo", "ejemplo");
        } catch (SQLException ex) {
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int Create(Departamento dep) throws SQLException {
        int filas;
        String sql = "INSERT INTO departamentos VALUES ( ?, ?, ? )";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, dep.getDept_no());
        sentencia.setString(2, dep.getDnombre());
        sentencia.setString(3, dep.getLoc());
        filas = sentencia.executeUpdate();
        return filas;
    }

    public int Update(int dep_no, Departamento dep) throws SQLException {
        String sql = "UPDATE departamentos SET dnombre = ?, loc = ? WHERE dept_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        int filas;
        sentencia.setString(1, dep.getDnombre());
        sentencia.setString(2, dep.getLoc());
        sentencia.setInt(3, dep_no);
        filas = sentencia.executeUpdate();
        return filas;
    }

    public ArrayList<Departamento> Read() throws SQLException {
        ResultSet rs;
        ArrayList<Departamento> listado = new ArrayList<>();
        String sql = "SELECT * FROM departamentos";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.execute();
        rs = sentencia.getResultSet();
        while(rs.next()){
        Departamento dep = new Departamento(rs.getInt("dept_no"), rs.getString("dnombre"), rs.getString("loc"));   
        listado.add(dep);
        }
        return listado;
    }
    
    public Departamento ReadOne(int dep_no) throws SQLException {
        ResultSet rs;
        String sql = "SELECT * FROM departamentos WHERE dept_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, dep_no);
        sentencia.execute();
        rs = sentencia.getResultSet();
        rs.next();
        Departamento dep = new Departamento(rs.getInt("dept_no"), rs.getString("dnombre"), rs.getString("loc"));    
        return dep;
    }

    public Departamento SearchOne(String dnombre) throws SQLException {
        ResultSet rs;
        String sql = "SELECT * FROM departamentos WHERE dnombre = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, dnombre);
        sentencia.execute();
        rs = sentencia.getResultSet();
        rs.next();
        Departamento dep = new Departamento(rs.getInt("dept_no"), rs.getString("dnombre"), rs.getString("loc"));    
        return dep;
    }
    
    public int Delete(int dep_no) throws SQLException {
        String sql = "DELETE FROM departamentos WHERE dept_no = ? ";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        int filas;
        sentencia.setInt(1, dep_no);
        filas = sentencia.executeUpdate();
        return filas;
    }

}
