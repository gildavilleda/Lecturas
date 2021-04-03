package Datos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;


public class Lector {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
           
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
               
//               if (mesInteger < 10){
//                 archivo =  ("C:\\DPI\\Log");}                 
//                else {
//                 archivo = ("C:\\DPI\\Log").concat("0");}
    
               
              //  String archivo = ("C:\\Users\\gvilleda\\Documents\\DPI\\Log").;
                archivo = archivo.concat(diaInteger.toString());//.concat("0");//Validaciones para agregar el 0  al dia
		archivo = archivo.concat(mesInteger.toString());//.concat("0");
		archivo = archivo.concat(yearInteger.toString());
		archivo = archivo.concat(".txt");
                   
		System.out.println(archivo);
        
		try {
			File file = new File(archivo);//Obtiene el archivo completo
			FileReader fileReader = null; //Lectura del archivo
			BufferedReader bufferedReader = null;//Llena el bufer para el recorrido
			
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			Persona persona = new Persona();
			while(bufferedReader.ready()) { //lectura linea por linea
			
				String lineaString = bufferedReader.readLine();
                                
                                
                                                              
//                                 if(lineaString.contains("CUI")) {
//					String[] partes = lineaString.split("CUI =");
//					String pnombre = partes[1].replace("]","").trim();
//                                    
//                                       persona.setCUI(pnombre);
//				}
                                
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
                                
                                
		           System.out.println(lineaString);
			}
                        
//                        System.out.println("CUI " + persona.getCUI());
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
                        
                    
                        
                     //   txtNombre.txt = persona.getPrimerNombre;
                        
                        eliminarArchivo(archivo);
                        
			//al finalizar la lectura
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
         
	}
     

    
        
	public static void eliminarArchivo(String archivo) throws IOException {
		BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo));
		buffer.write("");
		buffer.close();
		System.out.println("Archivo reiniciado...");
                
	}
        

}




