public class CoffeeMaker {
  private boolean isOn;
  private String coffeeType;
  private int coffeeAmount;

  public CoffeeMaker() {
    isOn = false;
    coffeeType = "normal";
    coffeeAmount = 40;
  }

  public boolean isOn() {
    return isOn;
  }

  public void pressOnOff() {
    isOn = !isOn;
  }

  public String getCoffeeType() {
    return coffeeType;
  }

  public void setCoffeeType(String type) {
    if (isOn && (type.equals("normal") || type.equals("espresso"))) {
      coffeeType = type;
    }
  }

  public int getCoffeeAmount() {
    return coffeeAmount;
  }

  public void setCoffeeAmount(int amount) {
    if (isOn && amount >= 10 && amount <= 80) {
      coffeeAmount = amount;
    } else if (!isOn && amount >= 10 && amount <= 80) {
      coffeeAmount = amount;
    }
  }
}
