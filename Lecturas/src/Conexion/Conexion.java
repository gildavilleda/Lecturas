package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.CallableStatement;
            
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gvilleda
 */
public class Conexion {
    Connection cn = null;
    public static String usuario;
    public static String password;
    public static boolean status = false;
    Object dataSource;
    
   
    
    public Connection Entrar (){
        status = false;
        String url = "jdbc:sqlserver://LAPTOP-6FCJ8T66:60829;databaseName=HNE001";
        //String url = "jdbc:sqlserver://172.16.0.102:1433;DatabaseName = HNE001";
    
    try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
        }catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "No se pudo establece la conexion... revisar Driver" + e.getMessage(),
            "Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }
        try{
            cn = DriverManager.getConnection(url,"DPI","Djjox5747");
            status = true;
            
//             JOptionPane.showMessageDialog(null,"BIENVENIDOS AL SISTEMA");
             
        }catch (SQLException e){
             JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
            "Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }
        return cn;
    }

    
    }
