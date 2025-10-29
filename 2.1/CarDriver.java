public class CarDriver {
  public static void main(String[] args) {
    Car myCar = new Car("Toyota Corolla");
    myCar.fillTank();

    for (int i = 0; i < 6; i++) {
      myCar.accelerate();
      System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
    }

    System.out.println("=== Testing Cruise Control ===");

    boolean result = myCar.turnOnCruiseControl();
    System.out.println("Attempted to turn on cruise control: " + (result ? "Success" : "Failed - no target speed set"));

    myCar.setTargetSpeed(80);
    System.out.println("Target speed set to: " + myCar.getTargetSpeed() + " km/h");

    result = myCar.turnOnCruiseControl();
    System.out.println("Turning on cruise control: " + (result ? "Success" : "Failed"));

    if (result) {
      System.out.println("Cruise control is now ON");
      System.out.println("Current speed: " + myCar.getSpeed() + " km/h");

      System.out.println("Cruise control adjusting speed to target...");
      for (int i = 0; i < 5; i++) {
        myCar.accelerate();
        System.out.println("Current speed: " + myCar.getSpeed() + " km/h");
      }

      myCar.turnOffCruiseControl();
      System.out.println("Cruise control turned OFF");
    }

    System.out.println("=== Testing Invalid Target Speed ===");
    result = myCar.setTargetSpeed(250);
    System.out.println("Set target speed to 250: " + (result ? "Success" : "Failed - exceeds max cruise speed"));

    result = myCar.setTargetSpeed(25);
    System.out.println("Set target speed to 25: " + (result ? "Success" : "Failed - below minimum cruise speed"));

    result = myCar.setTargetSpeed(60);
    if (result) {
      System.out.println("Target speed set to: " + myCar.getTargetSpeed() + " km/h");
      result = myCar.turnOnCruiseControl();
      System.out.println("Turning on cruise control: " + (result ? "Success" : "Failed"));
    }
  }
}
