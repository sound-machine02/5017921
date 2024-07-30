public class TestCommand {

  public static void main(String[] args) {

    Light bedRoomLight = new Light();

    Command turnOnLight = new LightOnCommand(bedRoomLight);
    Command turnOffLight = new LightOffCommand(bedRoomLight);

    RemoteControl remote = new RemoteControl();

    remote.setCommand(turnOnLight);
    remote.activateRemote();

    remote.setCommand(turnOffLight);
    remote.activateRemote();
    
  }
}