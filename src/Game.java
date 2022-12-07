public class Game {
    private String word;
    private StringBuffer guess;
    private StringBuffer tried = new StringBuffer("");

    public Game(String word){
        this.word = word;
    }

    public void Hangman() {
        guess = new StringBuffer(word);
        for(int i=0; i<guess.length(); i++) {
            guess.setCharAt(i, '-');
        }
        System.out.println("Make sure only the host sees this word!");
        System.out.println("Word: " + word);
        System.out.println();
    }

    public String getGuess() {
        return guess.toString();
    }

    public String getTry() {

        return tried.toString();
    }

    public int tryLetter(char letter) {
        if (tried.toString().indexOf(letter) >= 0) {
            return 0;
        }

        tried.append(letter);

        if (word.indexOf(letter) >= 0) {

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == letter) {
                    guess.setCharAt(i, letter);
                }
            }

            return 1;
        }

        return -1;
    }
}