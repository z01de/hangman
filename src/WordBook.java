import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class WordBook {
    private ArrayList<String> words;

    public WordBook(String fileName){
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(fileName))){
            words = bufferedReader.lines().collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getRandomWord() {
       int randomIndex = (int) (Math.random() * words.size());
       return words.get(randomIndex);
    }
}
