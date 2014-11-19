package gridworld;
import org.json.JSONObject;
import org.json.JSONException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class Configs{
    public static final String CONFIG_FILE_NAME = ".gwconf";
    private static JSONObject configObj = null;
    private static JSONObject getConfigObject(){
        if(configObj==null){
            try{
                byte[] bytes = 
                    Files.readAllBytes(Paths.get(CONFIG_FILE_NAME));
                String source = new String(
                    bytes, StandardCharsets.UTF_8
                );
                configObj = new JSONObject(source);
            }
            catch(Throwable t){
                throw new RuntimeException(
                    "Invalid GridWorld Config File: "+t.toString()
                );
            }
        }
        return configObj;
    }
    public static String getKWConfig(String keyword){
        try{
            return getConfigObject().getString(keyword);
        }
        catch(JSONException ex){
            throw new RuntimeException(
                "Invalid GridWorld Config File: "+ex.toString()
            );
        }
    }
}
