import edu.duke.*;
import java.util.*;

public class VigenereBreakerTester {
    public void testVBSliceString(){
        VigenereBreaker vb = new VigenereBreaker();
        System.out.println(vb.sliceString("abcdefghijklm",0,3));
        System.out.println(vb.sliceString("abcdefghijklm",1,3));
        System.out.println(vb.sliceString("abcdefghijklm",2,3));
        System.out.println(vb.sliceString("abcdefghijklm",0,4));
        System.out.println(vb.sliceString("abcdefghijklm",1,4));
        System.out.println(vb.sliceString("abcdefghijklm",2,4));
        System.out.println(vb.sliceString("abcdefghijklm",0,5));
        System.out.println(vb.sliceString("abcdefghijklm",1,5));
        System.out.println(vb.sliceString("abcdefghijklm",2,5));
        System.out.println(vb.sliceString("abcdefghijklm",3,5));
        System.out.println(vb.sliceString("abcdefghijklm",4,5));
    }
    
    private void printKey(int[] key){
        System.out.print("[");
        for(int i = 0; i < key.length; i++){
            if(i > 0) System.out.print(", "+key[i]);
            else System.out.print(key[i]);
        }
        System.out.println("]");
    }
    
    public void testTryKeyLength(){
        FileResource fr = new FileResource("messages/secretmessage1.txt");
        String encrypted = fr.asString();
        VigenereBreaker vb = new VigenereBreaker();
        int klength = 4;
        char mostCommon = 'e';
        int[] result = vb.tryKeyLength(encrypted, klength, mostCommon);
        printKey(result);
    }
    
    public void testMostCommonLetter(){
        FileResource fr = new FileResource("dictionaries/English");
        VigenereBreaker vb = new VigenereBreaker();        
        HashSet<String> dictionary = vb.readDictionary(fr);
        System.out.println("Most common letter in English is "+vb.mostCommonCharIn(dictionary));
    }
    
    public void testBreakVigenere(){
        FileResource fr = new FileResource("messages/secretmessage1.txt");
        VigenereBreaker vb = new VigenereBreaker();
        int klength = 4;
        char mostCommon = 'e';
        vb.breakVigenere(fr, klength, mostCommon);
    }
    
    public void testBreakVigenere2(){
        FileResource fr = new FileResource("TestData/athens_keyflute.txt");
        VigenereBreaker vb = new VigenereBreaker();
        vb.breakVigenereEng(fr);
    }
}
