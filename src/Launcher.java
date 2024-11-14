public class Launcher {
    public static void main(String[] args) {
        WordBook wordBook = new WordBook("C:\\Games\\HangmanGame\\Words.txt");
        Game hangman = new Game(wordBook);
        hangman.launch();
    }
}
