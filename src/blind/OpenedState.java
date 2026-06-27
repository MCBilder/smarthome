package blind;

public class OpenedState implements BlindState {

    @Override
    public void open(SmartBlind blind) {
        System.out.println("Roleta juz jest otwarta");
    }

    @Override
    public void close(SmartBlind blind) {
        new MovingState(blind, false);
    }

    @Override
    public void stop(SmartBlind blind) {
        System.out.println("Roleta jest otwarta, nie ma czego zatrzymywac");
    }
}