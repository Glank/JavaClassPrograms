import java.util.Scanner;
import java.util.Random;
public class NumberGame{
  //the maximum random number
  static final int MAX_NUMBER = 10;
  
  public static void main(String[] args){
    //set up resources
    Scanner keyboard = new Scanner(System.in);
    Random rand = new Random();
    int number = rand.nextInt(MAX_NUMBER)+1;
    int guess = -1;
    
    //display instructions
    System.out.println("I've got a number between 1 and "+MAX_NUMBER+". Can you guess it?");
    
    //prompt for guess
    System.out.print("Guess (1-"+MAX_NUMBER+"): ");
    guess = keyboard.nextInt();
    
    //check guess
    if(guess>number){
      System.out.println("You guessed too high.");
    }
    else if(guess<number){
      System.out.println("You guessed too low.");
    }
    else{
      System.out.println("Your guess was correct!");
    }
    
  }
}
