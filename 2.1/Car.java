public class Car {
  private double speed;
  private double gasolineLevel;
  private String typeName;
  private double maxGasoline;
  private double maxSpeed;
  private boolean cruiseControlOn;
  private double targetSpeed;
  private final double MIN_CRUISE_SPEED = 40;
  private final double MAX_CRUISE_SPEED = 120;

  public Car(String typeName) {
    speed = 0;
    gasolineLevel = 0;
    this.typeName = typeName;
    maxGasoline = 100;
    maxSpeed = 200;
    cruiseControlOn = false;
    targetSpeed = 0;
  }

  public Car(String typeName, double maxGasoline, double maxSpeed) {
    speed = 0;
    gasolineLevel = 0;
    this.typeName = typeName;
    this.maxGasoline = maxGasoline;
    this.maxSpeed = maxSpeed;
    cruiseControlOn = false;
    targetSpeed = 0;
  }

  public void accelerate() {
    if (cruiseControlOn) {
      if (speed < targetSpeed) {
        speed += 10;
        if (speed > targetSpeed) {
          speed = targetSpeed;
        }
      } else if (speed > targetSpeed) {
        speed -= 10;
        if (speed < targetSpeed) {
          speed = targetSpeed;
        }
      }

      if (speed < MIN_CRUISE_SPEED || speed > MAX_CRUISE_SPEED) {
        cruiseControlOn = false;
      }
    } else {
      if (gasolineLevel > 0) {
        speed += 10;
        if (speed > maxSpeed) {
          speed = maxSpeed;
        }
      } else {
        speed = 0;
      }
    }
  }

  public void decelerate(int amount) {
    if (cruiseControlOn) {
      accelerate();
    } else {
      if (gasolineLevel > 0) {
        if (amount > 0) {
          speed = Math.max(0, speed - amount);
        }
      } else {
        speed = 0;
      }
    }
  }

  public double getSpeed() {
    return speed;
  }

  public String getTypeName() {
    return typeName;
  }

  public void fillTank() {
    gasolineLevel = maxGasoline;
  }

  public double getGasolineLevel() {
    return gasolineLevel;
  }

  public double getMaxSpeed() {
    return maxSpeed;
  }

  public double getMaxGasoline() {
    return maxGasoline;
  }

  public boolean setTargetSpeed(double target) {
    if (target >= MIN_CRUISE_SPEED && target <= MAX_CRUISE_SPEED) {
      targetSpeed = target;
      return true;
    }
    return false;
  }

  public double getTargetSpeed() {
    return targetSpeed;
  }

  public boolean turnOnCruiseControl() {
    if (targetSpeed == 0) {
      return false;
    }
    if (targetSpeed < MIN_CRUISE_SPEED || targetSpeed > MAX_CRUISE_SPEED) {
      return false;
    }
    cruiseControlOn = true;
    return true;
  }

  public void turnOffCruiseControl() {
    cruiseControlOn = false;
  }

  public boolean isCruiseControlOn() {
    return cruiseControlOn;
  }
}
