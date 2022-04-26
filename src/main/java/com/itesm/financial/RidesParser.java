package com.itesm.financial;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RidesParser {

  static final String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";

  public static Ride parseFromList(List<String> line) {

    Ride newRide = null;
    try {
      long taxiId = Long.parseLong(line.get(0));
      Date pickUpTime = new SimpleDateFormat(DATE_FORMAT).parse(line.get(1));
      Date dropOffTime = new SimpleDateFormat(DATE_FORMAT).parse(line.get(2));
      int passengerCount = Integer.parseInt(line.get(3));
      double tripDistance = Double.parseDouble(line.get(4));
      double totalAmount = Double.parseDouble(line.get(5));
      
      // USO DEL PATRÓN BUILDER PARA CONSTRUIR UN OBJETO RIDE() SIN USAR UN CONSTRUCTOR DE MÚLTIPLES ARGUMENTOS
      newRide = new Ride();

      newRide.setTaxiId(taxiId)
            .setPickUpTime(pickUpTime)
            .setDropOffTime(dropOffTime)
            .setPassengerCount(passengerCount)
            .setTripDistance(tripDistance)
            .setTollsAmount(totalAmount);
              

    } catch (Exception e) { }

    return newRide;
  }

}
