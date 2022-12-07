import java.util.Scanner;

public class Runner {
    //word list
    private static final String[] words = {"reindeer", "mistletoe", "christmas", "festive", "present", "rudolph", "eggnog", "santa", "snowman", "gingerbread", "grinch", "ornament", "sleigh", "tinsel", "frostbite", "snowflake", "blizzard", "snowboard", "bobsleigh", "chocolate", "sugarplum", "fruitcake", "peppermint"};
    public static void main(String[] args){
        System.out.println("Welcome to Winter/Christmas Hangman! \nThis is a two player game.\nOne player will see the word, one player will guess.\nHeads up! Every failed guess is a body part. 6 failed guesses and you're out! \nStart!");
        Scanner input = new Scanner(System.in);
        String word = words[(int) (Math.random() * words.length)];
        Game game1 = new Game(word);
        int count = 0;
        int failedGuesses = 0;
        game1.Hangman();

        boolean done = false;
        while(!done){
            System.out.println("Tried: " + game1.getTry());
            System.out.println("Failed guesses: " + failedGuesses);
            System.out.println(game1.getGuess());
            System.out.println();

            System.out.print("Enter next letter (or type quit): ");
            String s = input.next();
            if(s.equals("quit")){
                System.exit(1);
            }
            if (s.length() != 1) {
                System.out.println("Invalid input");
            } else {
                int result = game1.tryLetter(s.charAt(0));
                if (result == 0) {
                    System.out.println("Already tried");
                } else if(result == -1){
                    System.out.println("Sorry, not there");
                    failedGuesses++;
                } else {
                    System.out.println("Yes!");
                }
            }
            if(failedGuesses >= 6){
                System.out.println("You guessed too many times! Your man is dead! Game over!");
                System.exit(1);
            }

            count++;

            if (game1.getGuess().indexOf('-') == -1) {
                System.out.println("You guessed " + word + " in " + count + " tries.");
                done = true;
            }

        }
    }
}