public class PasswordCracker{

    public static void main(String[] args) throws Throwable{
        String pass = "password";
        System.out.println("Trying password '"+pass+"'");

        //try the password
        if(CrackerUtils.tryPassword(pass)){
            System.out.println("That was the right password!");
        }
        else{
            System.out.println("That's not the right password.");
        }
    }

}
