package BL;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
Autor: Grupo2
*/

public class BLEncrypt {

    public BLEncrypt() {
        
        
    }
    
    // Metodo que permite encriptar la contraseña
    public String getEncrypt(String input) {
        // Metodo utlizado (MD%)
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
            
            
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
