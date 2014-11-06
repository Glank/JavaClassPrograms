import java.io.*;
import java.util.*;
public class CrackerUtils{
    //tries entering the password into the GradeDatabase program
    public static boolean tryPassword(String password) throws Exception{
        Runtime rt = Runtime.getRuntime();
        String[] commands = {"java","GradeDatabase"};
        Process proc = rt.exec(commands);
        PrintWriter out = new PrintWriter(proc.getOutputStream());
        out.write(password+"\n");
        out.close();
        Scanner in = new Scanner(proc.getInputStream());
        String line;
        boolean correct = true;
        while(in.hasNext()){
            line = in.nextLine();
            System.out.println(line);
            if(line.contains("That password is incorrect."))
                correct = false;
        }
        proc.waitFor();
        return correct;
    }

    //returns a list of the 250 most common passwords
    public static String[] getPasswords() throws Exception{
        Scanner in = new Scanner(new FileInputStream("passwords.txt"));
        String[] passwords = new String[250];
        int i = 0;
        while(in.hasNextLine() && i<passwords.length){
            passwords[i] = in.nextLine();
            i=i+1;
        }
        in.close();
        return passwords;
    }

}
