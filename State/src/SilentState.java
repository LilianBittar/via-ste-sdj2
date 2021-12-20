public class SilentState implements PhoneState{

    @Override
    public void onReceiveMessage(String txt, Phone phone) {
        phone.vibrate();
        System.out.println(txt);
    }

    @Override
    public void onReceiveCall(Phone phone) {
     phone.vibrate();
    }

    @Override
    public void onVolumeButtonUp(Phone phone) {
      phone.turnVolumeUp();
      phone.goToSound();
    }

    @Override
    public void onVolumeButtonDown(Phone phone) {
      if (phone.getVolume() > 0) {
          phone.turnVolumeDown();
      }
    }
}
