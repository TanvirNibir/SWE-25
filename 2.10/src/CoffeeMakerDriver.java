public class CoffeeMakerDriver {
  public static void main(String[] args) {
    CoffeeMaker myCoffeeMaker = new CoffeeMaker();

    System.out.println("Coffee maker is on");
    myCoffeeMaker.pressOnOff();

    myCoffeeMaker.setCoffeeType("espresso");
    myCoffeeMaker.setCoffeeAmount(50);

    System.out.println("Coffee type is " + myCoffeeMaker.getCoffeeType());
    System.out.println("Coffee amount is " + myCoffeeMaker.getCoffeeAmount() + " ml");

    myCoffeeMaker.pressOnOff();
    System.out.println("Coffee maker is off");
  }
}
