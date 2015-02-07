import java.util.Scanner;

public class IOExample{

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    String name;
    int age;
    
    System.out.println("Hello, what is your name?");
    name = scan.nextLine();
    System.out.println("How old are are you " + name + "?");
    age = scan.nextInt();
    System.out.println("Thats cool. I am " + age + " years old too");
  }
  
}
