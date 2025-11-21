// Task 2: Bus
public class Bus extends Car {
  private int currentPassengers;
  private int maxPassengers;

  public Bus(String typeName) {
    super(typeName);
    this.currentPassengers = 0;
    this.maxPassengers = 50;
  }

  public Bus(String typeName, double maxGasoline, double maxSpeed, int maxPassengers) {
    super(typeName, maxGasoline, maxSpeed);
    this.currentPassengers = 0;
    this.maxPassengers = maxPassengers;
  }

  public int passengerEnter(int count) {
    if (count < 0) {
      return 0;
    }
    int availableSpace = maxPassengers - currentPassengers;
    int passengersEntered = Math.min(count, availableSpace);
    currentPassengers += passengersEntered;
    return passengersEntered;
  }

  public int passengerExit(int count) {
    if (count < 0) {
      return 0;
    }
    int passengersExited = Math.min(count, currentPassengers);
    currentPassengers -= passengersExited;
    return passengersExited;
  }

  public int getCurrentPassengers() {
    return currentPassengers;
  }

  public int getMaxPassengers() {
    return maxPassengers;
  }

  public boolean isFull() {
    return currentPassengers >= maxPassengers;
  }

  public boolean isEmpty() {
    return currentPassengers == 0;
  }
}
