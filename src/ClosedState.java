public class ClosedState implements BlindState {

    @Override
    public void open(SmartBlind blind) {
        blind.setState(new MovingState(blind, true));
    }

    @Override
    public void close(SmartBlind blind) {
        System.out.println("Roleta juz jest zamknieta");
    }

    @Override
    public void stop(SmartBlind blind) {
        System.out.println("Roleta jest zamknieta, nie ma czego zatrzymywac");
    }
}