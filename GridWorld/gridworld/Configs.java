package gridworld;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class Configs{
    public static final String CONFIG_FILE_NAME = ".gwconf";
    private static HashMap<String,String> configObject = null;
    private static HashMap<String,String> getConfigObject(){
        if(configObject==null){
            configObject = new HashMap<String,String>();
            try{
                Scanner in = new Scanner(new FileInputStream(CONFIG_FILE_NAME));
                while(in.hasNextLine()){
                    String line = in.nextLine().trim();
                    if(line.isEmpty())
                        continue;
                    int delim = line.indexOf(":");
                    String kw = line.substring(0,delim).trim();
                    String value = line.substring(delim+1).trim();
                    configObject.put(kw, value);
                }
                in.close();
            }
            catch(Throwable t){
                throw new RuntimeException(
                    "Invalid GridWorld Config File: "+t.toString()
                );
            }
        }
        return configObject;
    }
    public static String getKWConfig(String keyword){
        return getConfigObject().get(keyword);
    }
}
