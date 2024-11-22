package projeto;

public class Transition {
    private State fromState;
    private String symbol;
    private State toState;

    public Transition(State fromState, String symbol, State toState) {
        this.fromState = fromState;
        this.symbol = symbol;
        this.toState = toState;
    }

    public State getFromState() {
        return fromState;
    }

    public String getSymbol() {
        return symbol;
    }

    public State getToState() {
        return toState;
    }
}
