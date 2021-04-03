/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.text.Normalizer;

/**
 *
 * @author gvilleda
 */
public class acentos {
    
    public static void main(String[] args) throws Exception {
        String cadena = "áéíóú";
        System.out.println(cadena + " = " + cleanString(cadena));
        cadena = "àèìòù";
        System.out.println(cadena + " = " + cleanString(cadena)); 
        cadena = "äëïöü";
        System.out.println(cadena + " = " + cleanString(cadena));
        cadena = "âêîôû";
        System.out.println(cadena + " = " + cleanString(cadena));
        cadena = "2² + 2³";
        System.out.println(cadena + " = " + cleanString(cadena));
    }
 
    public static String cleanString(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return texto;
    }
}