package com.itesm.financial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

// USO DE INTERFACES
public class InputFile implements InputFileInterface {
    
    
    public void exportFile(String CSV_FILENAME, String type) throws IOException{
        List<Ride> result = new ArrayList<>();

        InputStream inputStream = Client.class.getClassLoader().getResourceAsStream(CSV_FILENAME);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        for (String rawLine; (rawLine = reader.readLine()) != null;) {
            List<String> line = CSVUtils.parseLine(rawLine);
            Ride newRide = RidesParser.parseFromList(line);
            if(newRide != null) {
                result.add(newRide);
            }
        }
        
        //USO DEL PATRÓN SIMPLE FACTORY CON UN MÉTODO ESTÁTICO
        ReportCreator.createReportObject(result, type);
    }

}
