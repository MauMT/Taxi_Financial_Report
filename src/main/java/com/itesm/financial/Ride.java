package com.itesm.financial;

import java.util.Date;

// CLASE ENCARGADA ÚNICAMENTE DE DEFINIR LA ESTRUCTURA DE Ride
// SOLO TIENE UNA RESPONSABILIDAD --> PROVEER LA ESTRUCTURA
public class Ride {

  private String error;
  private long taxiId;
  private Date pickUpTime;
  private Date dropOffTime;
  private int passengerCount;
  private double tripDistance;
  private double tollsAmount;


  public Ride(String error) {
    this.error = error;
  }

/*   public Ride(
      long taxiId,
      Date pickUpTime,
      Date dropOffTime,
      int passengerCount,
      double tripDistance,
      double tollsAmount) {
    this.taxiId = taxiId;
    this.pickUpTime = pickUpTime;
    this.dropOffTime = dropOffTime;
    this.passengerCount = passengerCount;
    this.tripDistance = tripDistance;
    this.tollsAmount = tollsAmount;
  } */

  public Ride(){
    
  }

  // MODIFICACIÓN DE LOS MÉTODOS set PARA EL BUILDER PATTERN

  public String getError() {
    return error;
  }

  public Ride setError(String error) {
    this.error = error;
    return this;
  }

  public long getTaxiId() {
    return taxiId;
  }

  public Ride setTaxiId(long taxiId) {
    this.taxiId = taxiId;
    return this;
  }

  public Date getPickUpTime() {
    return pickUpTime;
  }

  public Ride setPickUpTime(Date pickUpTime) {
    this.pickUpTime = pickUpTime;
    return this;
  }

  public Date getDropOffTime() {
    return dropOffTime;
  }

  public Ride setDropOffTime(Date dropOffTime) {
    this.dropOffTime = dropOffTime;
    return this;
  }

  public int getPassengerCount() {
    return passengerCount;
  }

  public Ride setPassengerCount(int passengerCount) {
    this.passengerCount = passengerCount;
    return this;
  }

  public double getTripDistance() {
    return tripDistance;
  }

  public Ride setTripDistance(double tripDistance) {
    this.tripDistance = tripDistance;
    return this;
  }

  public double getTollsAmount() {
    return tollsAmount;
  }

  public Ride setTollsAmount(double tollsAmount) {
    this.tollsAmount = tollsAmount;
    return this;
  }
}
