import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;
import java.io.*;

public class GradeDatabase{

    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    private static Cipher ecipher;
    private static Cipher dcipher;
    private static SecretKey key;
    private static String salt = "salt";

    public static void initCrypto(String password) throws Exception{
        // generate secret key using AES algorithm
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes("UTF-8"), 65536, 256);
        SecretKey tmp = factory.generateSecret(spec);
        key = new SecretKeySpec(tmp.getEncoded(), "AES");
        ecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        dcipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] iv = { 8, 1, 2, 8, 2, 2, 3, 1, 4, 1, 5, 9, 2, 6, 5, 3 };
        IvParameterSpec ivspec = new IvParameterSpec(iv);
        // initialize the ciphers with the given key
        ecipher.init(Cipher.ENCRYPT_MODE, key, ivspec);
        dcipher.init(Cipher.DECRYPT_MODE, key, ivspec);
    }

    public static byte[] encrypt(byte[] bytes) throws Exception {
        return ecipher.doFinal(bytes);
    }

    public static byte[] decrypt(byte[] enc) throws Exception {
        return dcipher.doFinal(enc);
    }

    public static byte[] readFile(String fileName) throws Exception{
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        FileInputStream in = new FileInputStream(fileName);
        try{
            byte[] buffer = new byte[1024];
            int read;
            while((read=in.read(buffer, 0, buffer.length))>0)
                out.write(buffer, 0, read);
        }
        finally{
            in.close(); 
        }
        return out.toByteArray();
    }

    public static void writeFile(String fileName, byte[] bytes) throws Exception{
        FileOutputStream out = new FileOutputStream(fileName);
        try{
            out.write(bytes, 0, bytes.length);
        }
        finally{
            out.close();
        }
    }

    public static void main(String[] args) throws Throwable{
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Password: ");
        String password = keyboard.nextLine();

         //check the password
        byte[] passwordBytes = (password+salt).getBytes("UTF-8");
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(passwordBytes);
        String hashHex = bytesToHex(hash);
        boolean correct = hashHex.equals("CBE8FC383CC7B77925C04A430E04EE06");
        if(!correct){
            System.out.println("That password is incorrect.");
            System.exit(0);
        }

        //open encrypted file
        initCrypto(password);
        byte[] fileData = readFile("grades.enc");
        byte[] decrypted = decrypt(fileData);
        writeFile("grades.csv", decrypted);
        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec("gedit grades.csv");
        pr.waitFor();
        fileData = readFile("grades.csv");
        //remove temp file
        File file = new File("grades.csv");
        file.delete();
        file = new File("grades.csv~");
        file.delete();
        //update encrypted file
        byte[] encrypted = encrypt(fileData);
        writeFile("grades.enc", encrypted);
    }
}
