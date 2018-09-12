public class Game {
  private String answer;
  private String hits;
  private String misses;
  public int guessCount;
  public static int MAX_GUESS_COUNT = 7;
  
  
  
  public Game(String answer) {
      this.answer = answer.toLowerCase();
      hits = "";
      misses = "";
      guessCount = 0;
      
  }
  
  public String getAnswer() {
      return answer;
  };
  
  public boolean applyGuess(char let) {
      
      boolean isLetter = Character.isLetter(let);
      
      if (!isLetter) {
          throw new IllegalArgumentException("Please enter only alphabetic characters");
      } else {
      
          char letter = Character.toLowerCase(let);
          if (hits.indexOf(letter) != -1 || 
              misses.indexOf(letter) != -1 ) {
              throw new IllegalArgumentException("**** " + letter + " has already been submitted ****");
          } else {
               boolean isHit = answer.indexOf(letter) != -1;
              if (isHit) {
                  hits += letter;
              } else {
                  guessCount++;
                  misses += letter;
              }
              return isHit;
          }
      }
  }

public boolean applyGuess(String letters) {
  if (letters.length() == 0) {
    throw new IllegalArgumentException("No letter found");
  };
      return applyGuess(letters.charAt(0));
};
  
  public int getRemainingTrys() {
      return (Game.MAX_GUESS_COUNT - misses.length());
  };
  
  public String getCurrentProgress() {
      String progress = "";
      for (char letter : answer.toCharArray()) {
          char display = '-';
          if (hits.indexOf(letter) != -1) {
              display = letter;
          }
          progress += display;
         
      };
      return progress;
  };

public boolean isWon() {
  return getCurrentProgress().indexOf('-') == -1;
};

}