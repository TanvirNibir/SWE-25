public class Television {
  private boolean isOn;
  private int channel;

  public Television() {
    isOn = false;
    channel = 1;
  }

  public boolean isOn() {
    return isOn;
  }

  public void pressOnOff() {
    isOn = !isOn;
  }

  public int getChannel() {
    return channel;
  }

  public void setChannel(int newChannel) {
    if (newChannel >= 1) {
      channel = newChannel;
      if (channel > 10) {
        channel = 1;
      }
    }
  }
}
