import java.util.Scanner;

class Prompter {
   private Game game;
    
   public Prompter(Game game) {
    this.game = game;
   };
    
    public boolean promptForGuess() {
       
        Scanner scanner = new Scanner(System.in);
     
        System.out.print("Enter a letter:  ");
        String guessInput = scanner.nextLine();
         boolean isHit = false;
        try {
         isHit = game.applyGuess(guessInput);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        };
      
        return isHit;
    };
    
    public void displayProgress() {
        System.out.printf("Try to solve:  %s%n", game.getCurrentProgress());
    };
    
    public void displayRemainingGuesses() {
        if (game.getRemainingTrys() > 1) {
        System.out.printf("You have %d guesses remaining.%n", game.getRemainingTrys());
        } else {
        System.out.printf("You have %d guess remaining.%n", game.getRemainingTrys());
        };
    };
    
  public void getGameResult() {
    if(game.isWon()) {
      System.out.printf("Nice! You have finished this game with %d guesses remaining.%n", game.getRemainingTrys());
    } else {
      System.out.printf("Sorry. You have reached your guess limit. The answer was: %s.%n", game.getAnswer());
    };
  };
   
}