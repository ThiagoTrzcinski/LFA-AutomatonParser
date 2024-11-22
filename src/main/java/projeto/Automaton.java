package projeto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Automaton {
    private List<State> states;
    private State initialState;
    private Set<State> finalStates;
    private List<Transition> transitions;

    public Automaton() {
        this.states = new ArrayList<>();
        this.finalStates = new HashSet<>();
        this.transitions = new ArrayList<>();
    }

    public void addState(State state, boolean isInitial, boolean isFinal) {
        states.add(state);
        if (isInitial) {
            initialState = state;
        }
        if (isFinal) {
            finalStates.add(state);
        }
    }

    public State getStateById(String id) {
        for (State state : states) {
            if (state.getId().equals(id)) {
                return state;
            }
        }
        return null;
    }

    public void addTransition(Transition transition) {
        transitions.add(transition);
    }

    public State getInitialState() {
        return initialState;
    }

    public Set<State> getFinalStates() {
        return finalStates;
    }

    public List<Transition> getTransitions(State state, String symbol) {
        List<Transition> matchingTransitions = new ArrayList<>();
        for (Transition transition : transitions) {
            if (transition.getFromState().equals(state) && transition.getSymbol().equals(symbol)) {
                matchingTransitions.add(transition);
            }
        }
        return matchingTransitions;
    }

    public List<State> getAllStates() {
        return states;
    }
    
    public boolean isFinalState(State state) {
        return finalStates.contains(state);
    }

}
