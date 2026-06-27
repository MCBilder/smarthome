package blind;

public class MovingState implements BlindState {

    public MovingState(SmartBlind blind, boolean opening) {
        System.out.println("Roleta w ruchu...");
        if (opening) {
            System.out.println("Roleta dojechala - otwarta");
            blind.setState(new OpenedState());
        } else {
            System.out.println("Roleta dojechala - zamknieta");
            blind.setState(new ClosedState());
        }
    }

    @Override
    public void open(SmartBlind blind) {
        System.out.println("Roleta jest w ruchu, czekaj na zakonczenie");
    }

    @Override
    public void close(SmartBlind blind) {
        System.out.println("Roleta jest w ruchu, czekaj na zakonczenie");
    }

    @Override
    public void stop(SmartBlind blind) {
        System.out.println("Roleta jest w ruchu, czekaj na zakonczenie");
    }
}