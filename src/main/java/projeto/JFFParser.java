package projeto;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.util.List;

public class JFFParser {
    public Automaton parse(File file) throws Exception {
        Automaton automaton = new Automaton();

        // Parse o arquivo usando JDOM
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(file);

        // Acessa o elemento raiz
        Element root = document.getRootElement();
        Element automatonElement = root.getChild("automaton");

        // Processa os estados
        List<Element> stateElements = automatonElement.getChildren("state");
        for (Element stateElement : stateElements) {
            String id = stateElement.getAttributeValue("id");
            String name = stateElement.getAttributeValue("name");

            boolean isInitial = stateElement.getChild("initial") != null;
            boolean isFinal = stateElement.getChild("final") != null;

            State state = new State(id, name);
            automaton.addState(state, isInitial, isFinal);
        }

        // Processa as transições
        List<Element> transitionElements = automatonElement.getChildren("transition");
        for (Element transitionElement : transitionElements) {
            String fromId = transitionElement.getChildText("from");
            String toId = transitionElement.getChildText("to");
            String symbol = transitionElement.getChildText("read");

            State fromState = automaton.getStateById(fromId);
            State toState = automaton.getStateById(toId);

            automaton.addTransition(new Transition(fromState, symbol, toState));
        }

        return automaton;
    }
}
