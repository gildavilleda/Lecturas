/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class MetodosBD{
    Conexion coneccion = new Conexion();
    Connection cin = coneccion.Entrar();
  private String MendigoRegistro;
  
    public String getRegistroActual(){
        return MendigoRegistro;
    }
  
    public Boolean Guardar (
            String CitStrRegMedico,
            String CitNumCUI, 
            String CitStrNombre, 
            String CitStrNombre2, 
            String CitStrApellido,  
            String CitStrApellido2, 
            String CitStrApellidoCasada, 
            String CitBitGenero,
            String FecNacimiento,
            String CitStrDireccion, 
            String CitNumTelefono, 
            String CitStrCorreoElec, 
            String CitStrReferido, 
            String CitStrLugRef, 
            String CitStrObservacion,                       
            String CitStrContacto,
            String CitNumTelefono2,
            String CitStrParentesco) {
   
        Boolean resultado = false;
        
        Connection cn = null;
        
//        String SSQL= "INSERT INTO cita.Paciente (CitStrRegMedico,CitNumCUI,CitStrPrimerNombre,CitStrSegundoNombre,CitStrPrimerApellido,CitStrSegundoApellido, CitStrApellidoCasada,CitBitGenero,FecNacimiento,CitStrDireccion,CitNumTelefono,CitStrCorreoElec,CitStrReferido,CitStrLugRef,CitStrObservacion)"
//            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
       // "EXEC [cita].[sp_AgFam] ?, ?, ?, ?"; 
       
     String SSQL=  "EXEC cita.SP_Insert_PacienteFam ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
      String MiRegistroMedico = "";  
        
        try{
           cn = coneccion.Entrar();
           
            CallableStatement  psql = cn.prepareCall (SSQL);
            psql.registerOutParameter(1, java.sql.Types.VARCHAR);     
            psql.setString(2, CitNumCUI);
            psql.setString(3, CitStrNombre);
            psql.setString(4, CitStrNombre2);
            psql.setString(5, CitStrApellido);
            psql.setString(6, CitStrApellido2);
            psql.setString(7, CitStrApellidoCasada);
            psql.setString(8, CitBitGenero);
            psql.setString(9, FecNacimiento);
            psql.setString(10, CitStrDireccion);
            psql.setString(11, CitNumTelefono);
            psql.setString(12, CitStrCorreoElec);
            psql.setString(13, CitStrReferido);
            psql.setString(14, CitStrLugRef);
            psql.setString(15, CitStrObservacion);
                    
            psql.setString(16, CitStrContacto);
            psql.setString(17, CitNumTelefono2);
            psql.setString(18, CitStrParentesco);
                                                         
            resultado = psql.execute();
            MiRegistroMedico = psql.getString(1);
            System.out.println("Registro Medico: ");
            System.out.println(MiRegistroMedico);
            MendigoRegistro = MiRegistroMedico;
            psql.close();
            
        }catch (SQLException es){
            JOptionPane.showMessageDialog(null, "SQLException Guardar: "
                                     + es.getMessage(), "Error en la operación", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Exception Guardar" + e.getMessage());
        }
        
        
        return resultado;
    }

    int Guardar(String text, String text0, String text1, String text2, String text3, String text4, String text5, String toString, String text6, String text7, String text8, String text9, String toString0, String text10, String text11, String text12, String text13, String text14, String text15) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
