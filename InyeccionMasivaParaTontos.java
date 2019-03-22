import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class InyeccionMasivaParaTontos {
  public static void main(String[] args) {
    
    //Se invoca scanner para escribir por teclado
    Scanner scanner = new Scanner( System.in );   
    
    //Definición de ArrayList
    ArrayList<String> arrayF = new ArrayList<String>();
    
    //Definición de variables
    String sentencia;
    
    //Try/catch para controlar excepciones
    try {
      //Instanciamos BufferedReader para leer el documento
      BufferedReader br = new BufferedReader(new FileReader("Insert.txt"));
      
      String linea = "";
      
      //Bucle while para recorrer el documento hasta que se llegue a <EOF>
      while(linea != null) {
        //Se introduce en "linea" una línea del documento
        linea = br.readLine();
        //Si linea no es nula (<EOF>) se añade la línea al ArrayList
        if(linea != null) {
          arrayF.add(linea);
        }      
      }
      //Se cierra la lectura del documento
      br.close();
      
      System.out.println("Escribe la sentencia SQL:");
      sentencia = scanner.nextLine();
      
      for(int i = 0; i<arrayF.size();i++) {
        arrayF.set(i, sentencia+arrayF.get(i)+");");
      }
      //try/catch para controlar excepciones
      try {
        //Instanciamos BufferedWriter para escribir en el documento
        BufferedWriter bw = new BufferedWriter(new FileWriter("Insert.txt"));
        //Bucle for para escribir todos los elementos del ArrayList en el documento
        for(int j = 0; j < arrayF.size(); j++) {
          bw.write(arrayF.get(j));
          bw.newLine();
        }
        //Se cierra el archivo
        bw.close();
        System.out.println("Documento actualizado.");
      }catch(IOException io) {
           System.out.println("Error en la escritura del fichero.");
      }
    }catch(FileNotFoundException fnfe) {
      System.out.println("No se ha encontrado el archivo.");
    }catch(IOException io) {
      System.out.println("Error en la lectura del fichero.");
    }
  }
}
