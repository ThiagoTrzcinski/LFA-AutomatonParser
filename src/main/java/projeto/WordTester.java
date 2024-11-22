package projeto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class WordTester {
    public static void main(String[] args) throws Exception {
        JFFParser parser = new JFFParser();
        Automaton automaton = parser.parse(new File("src/main/java/projeto/AutomatonsInputs/example-ND.jff"));     
        
        AutomatonSimulator simulator = new AutomatonSimulator(automaton);
        List<String> words = readWordsFromFile("src/main/java/projeto/AutomatonsInputs/inputs-ND.txt");

        for (String word : words) {
            boolean accepted = simulator.accepts(word);
            System.out.println("Word: " + word + " - " + (accepted ? "ACCEPTED" : "REJECTED"));
        }
    }

    private static List<String> readWordsFromFile(String filePath) throws IOException {
        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line.trim());
            }
        }
        return words;
    }
}
