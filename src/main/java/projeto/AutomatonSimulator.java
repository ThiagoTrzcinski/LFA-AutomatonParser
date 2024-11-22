package projeto;

import java.util.HashSet;
import java.util.Set;

public class AutomatonSimulator {
    private Automaton automaton;

    public AutomatonSimulator(Automaton automaton) {
        this.automaton = automaton;
    }

    public boolean accepts(String input) {
        Set<State> currentStates = new HashSet<>();
        currentStates.add(automaton.getInitialState());

        for (char c : input.toCharArray()) {
            Set<State> nextStates = new HashSet<>();
            for (State state : currentStates) {
                for (Transition transition : automaton.getTransitions(state, String.valueOf(c))) {
                    nextStates.add(transition.getToState());
                }
            }
            currentStates = nextStates;
        }

        for (State state : currentStates) {
            if (automaton.isFinalState(state)) {
                return true;
            }
        }
        return false;
    }
}
