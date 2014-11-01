import java.util.Scanner;
import java.util.Random;
public class Loops{
  
  public static void main(String[] args){
    //Both of these loop examples do the same thing: print the numbers 1-5

    //This is a while loop.
    System.out.println("While:");
    int a = 1;
    while(a<=5){
      System.out.println(a);
      a++;
    }

    //This is a for loop.
    System.out.println("For:");
    for(int b = 1; b<=5; b++){
      System.out.println(b);
    }

    //This is a do-while loop.
    System.out.println("Do while:");
    int c = 1;
    do{
      System.out.println(c);
      c++;
    }while(c<=5);
  }
}
