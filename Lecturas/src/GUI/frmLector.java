package GUI;
import Conexion.Conexion;
import Datos.Persona;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.util.Calendar;
import java.sql.*;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

 /*
 * @author gvilleda
 */
public class 
frmLector extends javax.swing.JFrame {
    String dato;  
  Conexion coneccion = new Conexion();
  Connection cin = coneccion.Entrar();
  PreparedStatement ps; 
   
  public frmLector() {
        initComponents(); 
        
      
    }
  void ejecucion(){
      //Fechas
		Calendar fecha = Calendar.getInstance();
		Integer diaInteger = fecha.get(Calendar.DAY_OF_MONTH);
                Integer mesInteger = fecha.get(Calendar.MONTH)+1;
		Integer yearInteger = fecha.get(Calendar.YEAR);
		String archivo;
           
                //Construimos el nombre del archivo
               if (diaInteger < 10){
                 archivo =  ("C:\\DPI\\Log").concat("0");}                 
                else {
                 archivo = ("C:\\DPI\\Log");}
               
               
              //  String archivo = ("C:\\Users\\gvilleda\\Documents\\DPI\\Log").;
                archivo = archivo.concat(diaInteger.toString()).concat("");//Validaciones para agregar el 0  al dia
                archivo = archivo.concat(mesInteger.toString());//concat("0");
                archivo = archivo.concat(yearInteger.toString());
                archivo = archivo.concat(".txt");
                   

        
		try {
			File file = new File(archivo);//Obtiene el archivo completo
                        
                        
			FileReader fileReader = null; //Lectura del archivo
                        
                        
			BufferedReader bufferedReader = null;//Llena el bufer para el recorrido
			
			
                        fileReader = new FileReader(file);
                        
			//bufferedReader = new BufferedReader(fileReader);
                        
                         BufferedReader in = new BufferedReader(
                         new InputStreamReader(
                         new FileInputStream(file), "UTF8"));
                        

			Persona persona = new Persona();
			while(in.ready()) { //lectura linea por linea
			
				String lineaString = in.readLine();
                                
                                if(lineaString.contains("[RegistroMedico")) {
					String[] partes2 = lineaString.split(" =");
					String pnombre = partes2[1].replace("]","").trim();                                     
                                     
                                       persona.setRegistroMedico(pnombre);
				}
                                
                                                          
                                 if(lineaString.contains("[CUI")) {
////                                     System.out.print("holis si entro");
					String[] partes2 = lineaString.split(" =");
					String pnombre = partes2[1].replace("]","").trim();                                     
                                    
                                       persona.setCUI(pnombre);
				}
                                
				if(lineaString.contains("PrimerNombre")) {
					//obtener el valor
					String[] partes = lineaString.split("PrimerNombre =");
					String pnombre = partes[1].replace("]","").trim();
					                                                                         
					persona.setPrimerNombre(pnombre);
				}
                              
				
				if(lineaString.contains("SegundoNombre")) {
					String[] partes = lineaString.split("SegundoNombre =");
					String pnombre = partes[1].replace("]","").trim();
					
					persona.setSegundoNombre(pnombre);
				}
                                if(lineaString.contains("PrimerApellido")) {
					String[] partes = lineaString.split("PrimerApellido =");
					String pnombre = partes[1].replace("]","").trim();
					
					persona.setPrimerApellido(pnombre);
				}
                                if(lineaString.contains("SegundoApellido")) {
					String[] partes = lineaString.split("SegundoApellido =");
					String pnombre = partes[1].replace("]","").trim();
					
					persona.setSegundoApellido(pnombre);
				}
                                
                                if(lineaString.contains("ApellidoCasada")) {
					String[] partes = lineaString.split("ApellidoCasada =");
					String pnombre = partes[1].replace("]","").trim();
					
					persona.setApellidoCasada(pnombre);
				}
                                
                                if(lineaString.contains("Sexo")) {
					String[] partes = lineaString.split("Sexo =");
					String pnombre = partes[1].replace("]","").trim();
				        persona.setSexo(pnombre);
      
				}
  
                                if(lineaString.contains("FechaNacimiento")) {
					String[] partes = lineaString.split("FechaNacimiento =");
					String pnombre = partes[1].replace("]","").trim();
					
					persona.setFechaNacimiento(pnombre);
				}
                                if(lineaString.contains("DireccionCiudadMunicipio")) {
					String[] partes = lineaString.split("DireccionCiudadMunicipio =");
					String pnombre = partes[1].replace("]","").trim();
					
					persona.setDireccionCiudadMunicipio(pnombre);
				}
                                
                                     if(lineaString.contains("Telefono")) {
					String[] partes = lineaString.split("Telefono =");
					String pnombre = partes[1].replace("]","").trim();
					
					persona.setTelefono(pnombre);
				}
                              
                                if(lineaString.contains("CorreoElectronico")) {
					String[] partes = lineaString.split("CorreoElectronico =");
					String pnombre = partes[1].replace("]","").trim();
					
					persona.setCorreoElectronico(pnombre);
				}
                                
                               if(lineaString.contains("Referido")){
                               String[] partes = lineaString.split("Referido=");
                               String pnombre = partes[1].replace("]","").trim();
                               
                               persona.setReferido(pnombre);
                               }
                                
                              if(lineaString.contains("LugarReferido")){
                              String[] partes = lineaString.split("LugarRefereido=");
                              String pnombre = partes[1].replace("]","").trim();
                              
                              persona.setLugarReferido(pnombre);
                              }
                              
                              if(lineaString.contains("Observaciones")){
                              String[] partes = lineaString.split("Observaciones=");
                              String pnombre = partes[1].replace("]","").trim();
                              
                              persona.setObservaciones(pnombre);
                              }
                              
                              
                              // va  almacenado en la tabla familiares
                              if(lineaString.contains("Nombre1")){
                              String[] partes = lineaString.split("Nombre1=");
                              String pnombre = partes[1].replace("]","").trim();
                              
                              persona.setNombre1(pnombre);
                              }
                          
                               if(lineaString.contains("telefono1")){
                              String[] partes = lineaString.split("telefono1=");
                              String pnombre = partes[1].replace("]","").trim();
                              
                              persona.setTelefono1(pnombre);
                              }

                                if(lineaString.contains("familiar1")){
                              String[] partes = lineaString.split("familiar1=");
                              String pnombre = partes[1].replace("]","").trim();
                              
                              persona.setFamiliar1(pnombre);
                              }
                               
                          
		           System.out.println(lineaString);
			}
                        System.out.println("RegistroMedico"+ persona.getRegistroMedico());
                        System.out.println("CUI " + persona.getCUI());
			System.out.println("Primer Nombre " + persona.getPrimerNombre());
			System.out.println("Segundo Nombre " + persona.getSegundoNombre());
                        System.out.println("PrimerApellido " + persona.getPrimerApellido());
                        System.out.println("SegundoApellido " + persona.getSegundoApellido());
                        System.out.println("ApellidoCasada " + persona.getApellidoCasada());
                        System.out.println("Sexo " + persona.getSexo());
                        System.out.println("FechaNacimiento " + persona.getFechaNacimiento());
                        System.out.println("DireccionCiudadMunicipio " + persona.getDireccionCiudadMunicipio());
                        System.out.println(" Telefono" + persona.getTelefono());
                        System.out.println(" CorreoElectronico" + persona.getCorreoElectronico());
                        System.out.println("Referido" + persona.getReferido());
                        System.out.println("LugarReferido" + persona.getLugarReferido());
                        System.out.println("Observaciones" + persona.getObservaciones());
                        
                        // tabla familiares
                        
                        System.out.println("Nombre1 " + persona.getNombre1());
                        System.out.println("Telefono1" + persona.getTelefono1());
                        System.out.println("Familiar1" + persona.getFamiliar1());
                        
//                        jTexRegistroMedico.setText(persona.getRegistroMedico());
                        jTextCUI.setText(persona.getCUI());
                        texprimernombre.setText(persona.getPrimerNombre());
                        textsegundoNombre.setText(persona.getSegundoNombre());
                        textprimerapellido.setText(persona.getPrimerApellido());
                        textsegundoapellido.setText(persona.getSegundoApellido());
                        textapellidocasada.setText(persona.getApellidoCasada());
//                        jcomboxgenero.getSelectedItem(persona.getSexo());
                        TextFecNac.setText(persona.getFechaNacimiento());
                        TextDireccion.setText(persona.getDireccionCiudadMunicipio());
                        TextTelefono.setText(persona.getTelefono());
                        TextCorreo.setText(persona.getCorreoElectronico());
//                        textReferido.setText(persona.getReferido());
                        textlugarreferido.setText(persona.getLugarReferido());
                        textobservacion.setText(persona.getObservaciones());
                        
                       // tabla familiares
                       textNomFam.setText(persona.getNombre1());
                       texttelfam.setText(persona.getFamiliar1());
                       textrelfam.setText(persona.getFamiliar1());           
                           
                        eliminarArchivo(archivo);
                        
			//al finalizar la lectura
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
  
      
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCui = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        jTextCUI = new javax.swing.JTextField();
        texprimernombre = new javax.swing.JTextField();
        txtprimerApe = new javax.swing.JLabel();
        textprimerapellido = new javax.swing.JTextField();
        txtgenero = new javax.swing.JLabel();
        txtfecNac = new javax.swing.JLabel();
        TextFecNac = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JLabel();
        TextDireccion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TextTelefono = new javax.swing.JTextField();
        TextCorreo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        textsegundoNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textsegundoapellido = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textapellidocasada = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textlugarreferido = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textobservacion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        textNomFam = new javax.swing.JTextField();
        texttelfam = new javax.swing.JTextField();
        textrelfam = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTexRegistroMedico = new javax.swing.JTextField();
        jcomboxgenero = new javax.swing.JComboBox<>();
        jcomboxferido = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        btnCOEX = new java.awt.Button();
        btnlimpiar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 255));
        setMinimumSize(new java.awt.Dimension(605, 315));
        getContentPane().setLayout(null);

        txtCui.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtCui.setText("CUI");
        getContentPane().add(txtCui);
        txtCui.setBounds(350, 90, 30, 16);

        txtNombre.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtNombre.setText("Primer Nombre");
        getContentPane().add(txtNombre);
        txtNombre.setBounds(20, 110, 110, 16);

        jTextCUI.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jTextCUI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jTextCUI);
        jTextCUI.setBounds(380, 80, 290, 20);

        texprimernombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        texprimernombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texprimernombreActionPerformed(evt);
            }
        });
        getContentPane().add(texprimernombre);
        texprimernombre.setBounds(110, 110, 210, 20);

        txtprimerApe.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtprimerApe.setForeground(new java.awt.Color(51, 51, 51));
        txtprimerApe.setText("Primer Apellido");
        getContentPane().add(txtprimerApe);
        txtprimerApe.setBounds(20, 140, 90, 16);

        textprimerapellido.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textprimerapellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textprimerapellidoActionPerformed(evt);
            }
        });
        getContentPane().add(textprimerapellido);
        textprimerapellido.setBounds(110, 140, 210, 22);

        txtgenero.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtgenero.setText("Genero");
        getContentPane().add(txtgenero);
        txtgenero.setBounds(350, 170, 60, 16);

        txtfecNac.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtfecNac.setText("Fecha de Nacimento");
        getContentPane().add(txtfecNac);
        txtfecNac.setBounds(20, 200, 120, 16);

        TextFecNac.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        getContentPane().add(TextFecNac);
        TextFecNac.setBounds(150, 200, 170, 22);

        txtDireccion.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtDireccion.setText("Direccion");
        getContentPane().add(txtDireccion);
        txtDireccion.setBounds(350, 200, 70, 16);

        TextDireccion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        getContentPane().add(TextDireccion);
        TextDireccion.setBounds(410, 200, 260, 22);

        btnGuardar.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imganes/guardar111.png"))); // NOI18N
        btnGuardar.setBorder(null);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar);
        btnGuardar.setBounds(140, 450, 50, 50);

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        jLabel1.setText("Datos Personales ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(260, 40, 153, 20);

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        jLabel3.setText("HOSPITAL NACIONAL ESPECIALIZADO DE VIILA NUEVA ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 10, 510, 23);

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel6.setText("Telefono");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 230, 70, 16);

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel7.setText("Correo Electronico");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(350, 230, 110, 16);

        TextTelefono.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TextTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextTelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(TextTelefono);
        TextTelefono.setBounds(70, 230, 250, 22);

        TextCorreo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        getContentPane().add(TextCorreo);
        TextCorreo.setBounds(460, 230, 210, 22);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imganes/carpeta111.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 450, 50, 50);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imganes/copia111.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(80, 450, 60, 50);

        textsegundoNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        getContentPane().add(textsegundoNombre);
        textsegundoNombre.setBounds(460, 110, 210, 22);

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel4.setText("Segundo Nombre");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(350, 110, 110, 16);

        jLabel8.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel8.setText("Segundo Apellido");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(350, 140, 100, 16);

        textsegundoapellido.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textsegundoapellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textsegundoapellidoActionPerformed(evt);
            }
        });
        getContentPane().add(textsegundoapellido);
        textsegundoapellido.setBounds(460, 140, 210, 22);

        jLabel9.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel9.setText("Apeliido de Casada");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 170, 120, 14);

        textapellidocasada.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        getContentPane().add(textapellidocasada);
        textapellidocasada.setBounds(140, 170, 180, 22);

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel2.setText("Referido");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 260, 50, 14);

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel5.setText("Lugar referido");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(350, 260, 90, 16);
        getContentPane().add(textlugarreferido);
        textlugarreferido.setBounds(440, 260, 230, 22);

        jLabel10.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel10.setText("Observación");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(20, 300, 80, 16);
        getContentPane().add(textobservacion);
        textobservacion.setBounds(100, 300, 570, 20);

        jLabel11.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel11.setText("Familiares");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(20, 340, 90, 30);

        jLabel13.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel13.setText("Telefono");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(230, 380, 60, 10);

        jLabel14.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel14.setText("Relación Familiar ");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(440, 380, 100, 14);
        getContentPane().add(textNomFam);
        textNomFam.setBounds(10, 410, 190, 22);
        getContentPane().add(texttelfam);
        texttelfam.setBounds(220, 410, 190, 22);
        getContentPane().add(textrelfam);
        textrelfam.setBounds(430, 410, 190, 22);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 700, 70);

        jLabel15.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel15.setText("Registro Medico ");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(20, 80, 100, 16);

        jTexRegistroMedico.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jTexRegistroMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTexRegistroMedicoActionPerformed(evt);
            }
        });
        getContentPane().add(jTexRegistroMedico);
        jTexRegistroMedico.setBounds(120, 80, 200, 22);

        jcomboxgenero.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jcomboxgenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "F", "M" }));
        getContentPane().add(jcomboxgenero);
        jcomboxgenero.setBounds(410, 170, 260, 22);

        jcomboxferido.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jcomboxferido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N", "S" }));
        jcomboxferido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboxferidoActionPerformed(evt);
            }
        });
        getContentPane().add(jcomboxferido);
        jcomboxferido.setBounds(70, 260, 250, 22);

        jLabel16.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel16.setText("Nombre");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(20, 380, 70, 16);

        btnCOEX.setBackground(new java.awt.Color(0, 153, 255));
        btnCOEX.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        btnCOEX.setLabel("Formato COEX");
        btnCOEX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCOEXActionPerformed(evt);
            }
        });
        getContentPane().add(btnCOEX);
        btnCOEX.setBounds(550, 450, 110, 24);

        btnlimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imganes/limpiar.png"))); // NOI18N
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnlimpiar);
        btnlimpiar.setBounds(190, 450, 50, 50);

        jButton3.setBackground(new java.awt.Color(0, 153, 255));
        jButton3.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jButton3.setText("CARNE COEX");
        jButton3.setAutoscrolls(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(550, 490, 110, 23);

        setBounds(0, 0, 712, 561);
    }// </editor-fold>//GEN-END:initComponents

    private void textprimerapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textprimerapellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textprimerapellidoActionPerformed
        MetodosBD metodobd = new MetodosBD();
        
       //para almacenar datos familiares
       //MetodosFam metodofam = new MetodosFam();
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
     Boolean exito = true;
        try{
         exito = metodobd.Guardar(
             jTexRegistroMedico.getText().trim(),
             jTextCUI.getText().trim(), 
             texprimernombre.getText().trim(), 
             textsegundoNombre.getText().trim(), 
             textprimerapellido.getText().trim(), 
             textsegundoapellido.getText().trim(), 
             textapellidocasada.getText().trim(), 
             jcomboxgenero.getSelectedItem().toString().trim(), 
             TextFecNac.getText().trim(), 
             TextDireccion.getText().trim(), 
             TextTelefono.getText().trim(), 
             TextCorreo.getText().trim(), 
             jcomboxferido.getSelectedItem().toString().trim(), 
             textlugarreferido.getText().trim(), 
             textobservacion.getText().trim(),      
                textNomFam.getText().trim(),
                texttelfam.getText().trim(),
                textrelfam.getText().trim()
       );
        if (!exito){
        
       JOptionPane.showMessageDialog(null, "Datos Agregados con Exito:",
               "Exito en la operacion", JOptionPane.INFORMATION_MESSAGE);  
       
       jTexRegistroMedico.setText(metodobd.getRegistroActual());
       
       }else {
       JOptionPane.showMessageDialog(null, "Error al Agregar Datos"
                                     , "Error en la operación", JOptionPane.ERROR_MESSAGE);
       }
     }catch (Exception e){
                     JOptionPane.showMessageDialog(null, "Exception Guardar: "
                                     + e.getMessage(), "Error en la operación", JOptionPane.ERROR_MESSAGE);
     }
        
        
        
   
      

       
    
    }//GEN-LAST:event_btnGuardarActionPerformed

    
    private void TextTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextTelefonoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

   try
        {
            // Se lanza el ejecutable.
            Process p=Runtime.getRuntime().exec ("C:\\DPI\\LectorDPI.exe");
            
            // Se obtiene el stream de salida del programa
            InputStream is = p.getInputStream();
            
            /* Se prepara un bufferedReader para poder leer la salida más comodamente. */
            BufferedReader br = new BufferedReader (new InputStreamReader (is));
            
            // Se lee la primera linea
            String aux = br.readLine();

            // Mientras se haya leido alguna linea
            while (aux!=null)
            {
                // Se escribe la linea en pantalla
                System.out.println (aux);           
            System.out.println("esto solo lo tiene que ejecutar una vez");
                      
      
                // y se lee la siguiente.
                aux = br.readLine(); 
                
            }
             
        } 
        catch (Exception e)
        {
            // Excepciones si hay algún problema al arrancar el ejecutable o al leer su salida.*/
            e.printStackTrace();
        }
   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ejecucion();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void texprimernombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texprimernombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texprimernombreActionPerformed

    private void textsegundoapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textsegundoapellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textsegundoapellidoActionPerformed

    private void jcomboxferidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboxferidoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jcomboxferidoActionPerformed

    private void btnCOEXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCOEXActionPerformed
                //formato coex
       
        System.out.println("RegistroMedico");
        String CitStrRegMedico = jTexRegistroMedico.getText();
        System.out.print(CitStrRegMedico);
        EjecutarCoex("http://citas.hvn285.mspas.local/runreports/RepFormatoTarjetaCita.php?CitStrRegMedico="+CitStrRegMedico);               
    }//GEN-LAST:event_btnCOEXActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        // limpiar cajas de texto:
             jTexRegistroMedico.setText("");
             jTextCUI.setText(null); 
             texprimernombre.setText(null); 
             textsegundoNombre.setText(null); 
             textprimerapellido.setText(null); 
             textsegundoapellido.setText(null);
             textapellidocasada.setText(null);
           //  jcomboxgenero.setText(null); 
             TextFecNac.setText(null); 
             TextDireccion.setText(null);
             TextTelefono.setText(null); 
             TextCorreo.setText(null);
            // jcomboxferido.setText(null);
             textlugarreferido.setText(null); 
             textobservacion.setText(null);
       
                textNomFam.setText(null);
                texttelfam.setText(null);
                textrelfam.setText(null);
        
        
        
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // CARNE COEX
        System.out.println("RegistroMedico");
        String CitStrRegMedico = jTexRegistroMedico.getText();
        System.out.print(CitStrRegMedico);
        EjecutarCoex("http://citas.hvn285.mspas.local/runreports/CarneCOEX.php?CitStrRegMedico="+CitStrRegMedico);    
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTexRegistroMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTexRegistroMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTexRegistroMedicoActionPerformed
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLector().setVisible(true);
            }
        });
    }
   
    public static void eliminarArchivo(String archivo) throws IOException {
		BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo));
		buffer.write("");
		buffer.close();
		System.out.println("Archivo reiniciado...");
                
	}
    
    void EjecutarCoex(String enlaceAceder){
        
        Desktop enlace=Desktop.getDesktop();
        try {
                enlace.browse(new URI(enlaceAceder));
        } catch (IOException | URISyntaxException e) {
            e.getMessage();
        }
    }
    
    
    
    
    
    
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextCorreo;
    private javax.swing.JTextField TextDireccion;
    private javax.swing.JTextField TextFecNac;
    private javax.swing.JTextField TextTelefono;
    private java.awt.Button btnCOEX;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTexRegistroMedico;
    private javax.swing.JTextField jTextCUI;
    private javax.swing.JComboBox<String> jcomboxferido;
    private javax.swing.JComboBox<String> jcomboxgenero;
    private javax.swing.JTextField texprimernombre;
    private javax.swing.JTextField textNomFam;
    private javax.swing.JTextField textapellidocasada;
    private javax.swing.JTextField textlugarreferido;
    private javax.swing.JTextField textobservacion;
    private javax.swing.JTextField textprimerapellido;
    private javax.swing.JTextField textrelfam;
    private javax.swing.JTextField textsegundoNombre;
    private javax.swing.JTextField textsegundoapellido;
    private javax.swing.JTextField texttelfam;
    private javax.swing.JLabel txtCui;
    private javax.swing.JLabel txtDireccion;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtfecNac;
    private javax.swing.JLabel txtgenero;
    private javax.swing.JLabel txtprimerApe;
    // End of variables declaration//GEN-END:variables

}