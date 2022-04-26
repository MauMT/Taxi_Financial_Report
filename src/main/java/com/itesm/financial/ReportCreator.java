package com.itesm.financial;

import java.io.IOException;
import java.util.List;

public class ReportCreator {
    //Open Closed Principle, si se desea agregar un nuevo tipo de archivo de salida, solo se debe agregar una nueva clase
    // que similar a WebReport o PrintReport y crear un nuevo else if con el nuevo tipo de archivo de salida
    public static void createReportObject(List<Ride> result, String type) throws IOException{

        if(type == "html"){
            WebReport webReport = new WebReport();
            String htmlReport = webReport.createContent(result);
            webReport.createFile(htmlReport);
        } else if(type == "print"){
            PrintReport printReport = new PrintReport();
            String docReport = printReport.createContent(result);
            printReport.createFile(docReport);
        }
    }

}
