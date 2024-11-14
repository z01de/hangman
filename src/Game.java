import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private final WordBook wordBook;
    private final ArrayList<Character> checkedLetters = new ArrayList<>();
    private String word;
    private String wordLowerCase;
    private String mysteryWord;
    private int healthPoints;

    public Game(WordBook wordBook) {
        this.wordBook = wordBook;
        healthPoints = 6;
    }

    private void setWord(String word) {
        this.word = word;
    }

    public void launch(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Вы хотите сыграть в игру? (Д/Н): ");
            String answer = scanner.nextLine();
            if(answer.equals("Д") || answer.equals("д")){
                play();
            }
            else if(answer.equals("Н") || answer.equals("н")){
                System.out.println("До свидания!");
                System.exit(0);
            }
        }
    }

    private String hide(){
        return "_".repeat(word.length());
    }

    private String show(char letter, String mysteryWord, String word){
        char[] hiddenToArray = mysteryWord.toCharArray();
        for(int i = 0; i < word.length(); i++){
            if (word.charAt(i) == letter || word.toLowerCase().charAt(i) == letter){
                hiddenToArray[i] = word.charAt(i);
            }
        }
        StringBuilder result = new StringBuilder();
        for(char i: hiddenToArray){
            result.append(i);
        }
        return result.toString();
    }

    private void initialize(){
        setWord(wordBook.getRandomWord());
        checkedLetters.clear();
        healthPoints = 6;
        wordLowerCase = word.toLowerCase();
        mysteryWord = hide();
    }

    private void play(){
        initialize();
        System.out.println("Я загадал слово!\n");
        System.out.println("Загаданное слово: " + mysteryWord);
        Scanner scanner = new Scanner(System.in);
        while(!mysteryWord.equals(word)) {
            Gallow.drawGallow(healthPoints);
            System.out.println("Ваши жизни: " + healthPoints);
            int countInWord = 0;
            System.out.print("\nВведите букву: ");
            char letter = scanner.next().charAt(0);
            if (!checkedLetters.contains(letter)) {
                for (int i = 0; i < word.length(); i++) {
                    if (wordLowerCase.charAt(i) == letter || word.charAt(i) == letter) {
                        countInWord++;
                        checkedLetters.add(word.toLowerCase().charAt(i));
                        checkedLetters.add(word.charAt(i));
                        mysteryWord = show(letter, mysteryWord, word);
                    }
                }
                if (countInWord == 0) {
                    System.out.println("Неверно!\n");
                    if(healthPoints > 1) {
                        System.out.println("Загаданное слово: " + mysteryWord);
                    }
                    healthPoints--;
                }
                else{
                    System.out.println("Верно!\n");
                    System.out.println("Загаданное слово: " + mysteryWord);
                }
                if (healthPoints == 0){
                    Gallow.drawGallow(healthPoints);
                    System.out.println("Вы проиграли!");
                    System.out.println("Загаданное слово: " + word);
                    launch();
                }
            }
            else {
                System.out.println("Вы уже пробовали эту букву!\n");
                System.out.println("Загаданное слово: " + mysteryWord);
            }
        }
        Gallow.drawGallow(healthPoints);
        System.out.println("Ваши жизни: " + healthPoints);
        System.out.println("Вы выиграли!");
        launch();
    }
}
