package com.itesm.financial;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PrintReport {
    
    public String createContent(List<Ride> rides) {
        StringBuilder builder = new StringBuilder();
        builder.append(createTitle("Taxi Report"));
        builder.append(createDocHeaders());
        rides.forEach( ride -> {
            builder.append(addRide(ride));
        });

        return builder.toString();
    }

    public void createFile(String content) throws IOException {
        FileWriter fileWriter = new FileWriter("financial-report.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(content);
        printWriter.close();
    }

    private String createTitle(String title){
        return title+"\n";
    }
    
    private String createDocHeaders() {
        return 
                    "TaxiID\t\t" +
                    "Pickup time\t\t\t\t\t\t" +
                    "Dropoff time\t\t\t" +
                    "Passenger count\t\t" +
                    "Trip Distance\t\t" +
                    "Total amount\n"
                ;
    }

    

    private String addRide(Ride ride) {
        String tipoEspacio = getTamañoEspacio(ride.getTaxiId());
        String espacioTripDistance = getTamañoTrip(ride.getTripDistance());
        return
                ride.getTaxiId() + tipoEspacio +
                ride.getPickUpTime() + "\t" +
                ride.getDropOffTime() + "\t" +
                ride.getPassengerCount() + "\t\t\t\t" +
                ride.getTripDistance() + espacioTripDistance +
                formatAmount(ride.getTollsAmount()) + "\n";
    }

/**
 * Funcion para obtener el tamaño del espacio necesario para que el espacio 
 * entre TaxiId y PickupTime esté alineado
 * @param numero
 * @return string con el espacio necesario
 */
    private String getTamañoEspacio(long numero) {
    
        int tamaño = (int) (Math.log10(numero) + 1);
        String espacio = "";
        for (int i = 0; i < 8-tamaño; i++) {
            espacio += " ";
        }
        return espacio; 
    }


/**
 * Funcion para obtener el tamaño del espacio necesario para que el espacio 
 * entre TripDistance y TotalAmount esté alineado
 * @param distance
 * @return string con el espacio necesario
 */
    private String getTamañoTrip(double distance) {
    
        int tamaño = String.valueOf(distance).length();
        if (tamaño >= 4){
            return "\t\t\t\t";
        }
        return "\t\t\t\t\t";
    }

    private String formatAmount(double amount) {
        if(amount < 0) {
            return "(" + amount + ")";
        }
        return Double.toString(amount);
    }
}


