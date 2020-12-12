import edu.duke.*;
import java.util.*;

public class Tester {
    
    public void testCaesarCracker(){
        CaesarCracker cc = new CaesarCracker();
        FileResource fr = new FileResource("TestData/titus-small_key5.txt");
        System.out.println(cc.decrypt(fr.asString()));
        
        fr = new FileResource("TestData/oslusiadas_key17.txt");
        cc = new CaesarCracker('a');
        System.out.println(cc.decrypt(fr.asString()));
    }
    
    public void testVigenereCipher(){
        int[] key = {17, 14, 12, 4};
        VigenereCipher vc = new VigenereCipher(key);
        FileResource fr = new FileResource("TestData/titus-small.txt");
        String encrypted = vc.encrypt(fr.asString());
        System.out.println(encrypted);        
        System.out.println(vc.decrypt(encrypted));
    }
   
    public void testVigenereBreaker(){
        FileResource fr = new FileResource("messages/secretmessage2.txt");
        VigenereBreaker vb = new VigenereBreaker();
        vb.breakVigenereEng(fr);
    }
    
    public void testVigenereBreaker2(){
        FileResource fr = new FileResource("messages/secretmessage2.txt");
        int keyLength = 32;
        char mostCommon = 'e';
        VigenereBreaker vb = new VigenereBreaker();
        vb.breakVigenere(fr,keyLength,mostCommon);
    }
    
    public void testBreakVigenere(){
        FileResource fr = new FileResource("messages/secretmessage3.txt");
        VigenereBreaker vb = new VigenereBreaker();
        vb.breakVigenere(fr);
        
        fr = new FileResource("messages/secretmessage4.txt");
        vb.breakVigenere(fr);
        
    }
}