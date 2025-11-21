// Task 1: Sports car
public class SportsCar extends Car {
  private static final double ACCELERATION_BOOST = 1.5;

  public SportsCar(String typeName) {
    super(typeName);
  }

  public SportsCar(String typeName, double maxGasoline, double maxSpeed) {
    super(typeName, maxGasoline, maxSpeed);
  }

  @Override
  public void accelerate() {
    if (isCruiseControlOn()) {
      super.accelerate();
      return;
    }

    super.accelerate();

    if (getGasolineLevel() > 0 && getSpeed() < getMaxSpeed()) {
      super.accelerate();
      if (getSpeed() >= getMaxSpeed()) {
        return;
      }
    }
  }

  @Override
  public void decelerate(int amount) {
    if (isCruiseControlOn()) {
      super.decelerate(amount);
      return;
    }

    int boostedAmount = (int) (amount * ACCELERATION_BOOST);
    super.decelerate(boostedAmount);
  }
}
