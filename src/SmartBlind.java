public class SmartBlind {
    private BlindState state;

    public SmartBlind() {
        this.state = new ClosedState();
    }

    public void setState(BlindState state) {
        this.state = state;
    }

    public BlindState getState() {
        return state;
    }

    public void openBlind() {
        state.open(this);
    }

    public void closeBlind() {
        state.close(this);
    }

    public void stopBlind() {
        state.stop(this);
    }
}