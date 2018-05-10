package pruebamysql;

import java.sql.Date;

/**
 *
 * @author ALberto Espada
 */
public class Departamento {
    private int dept_no;
    private String dnombre;
    private String loc;

    public Departamento() {
    }
    
    public Departamento(int dept_no, String dnombre, String loc) {
        this.dept_no = dept_no;
        this.dnombre = dnombre;
        this.loc = loc;
    }

    Departamento(int aInt, String string, String string0, int aInt0, Date date, float aFloat, float aFloat0, int aInt1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    

}

