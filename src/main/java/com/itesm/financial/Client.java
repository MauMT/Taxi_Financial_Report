package com.itesm.financial;
import java.io.IOException;

// USO DE INTERFACES PARA Interface Segregation Principle
// cada file conoce e utiliza solamente los métodos que necesita basados
// en el tipo de archivo de salida que se desee  
public class Client {
    private static final String CSV_FILENAME = "taxi-data.csv";

    public static void main(String[] args) throws IOException {
        System.out.println("Financial Report Generation");
        InputFile file1 = new InputFile();
        InputFile file2 = new InputFile();
        file1.exportFile(CSV_FILENAME,"print");
        file2.exportFile(CSV_FILENAME,"html");
    }
}