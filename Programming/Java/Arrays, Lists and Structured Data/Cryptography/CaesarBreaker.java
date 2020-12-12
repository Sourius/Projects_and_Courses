import edu.duke.*;
import java.io.*;

public class CaesarBreaker {
    // countLetters
    private int[] countLetters(String s){
        int size = 26;
        int[] counts = new int [26];
        
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            int pos = Character.toLowerCase(c) - 'a';
            if(pos >= 0) counts[pos]++;
        }
        
        return counts;
    }
    
    public void testCountLetters(){
        String s = "ABCDEFabcdefabcda";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int [] counts = countLetters(s);
        for(int i = 0; i < 26; i++){
            System.out.println(counts[i]+" of "+alphabet.charAt(i));
        }
        int mostCommon = maxIndex(counts);
        System.out.println("Most repeated letter "+alphabet.charAt(mostCommon));
    }
    
    // maxIndex
    private int maxIndex(int[] values){
        int max = 0;
        int pos = -1;
        for(int i = 0; i < values.length; i++){
            if(values[i] > max){
                max = values[i];
                pos = i;
            }
        }
        return pos;
    }
    
    // decrypt
    private String decrypt(String encrypted){
        Caesar cc = new Caesar();
        int [] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int key = maxDex - 4;
        if(maxDex < 4){
            key = 26 - (4 - maxDex);
        }
        int dKey = 26-key;
        System.out.println("Encryption key: "+key);
        System.out.println("Decryption key: "+ dKey);
        String message = cc.encrypt(encrypted, dKey);
        return message;
    }
    
    public void testDecrypt(){
        FileResource fr = new FileResource(
                new File("../ProgrammingBreakingCaesarData/wordsLotsOfEs.txt"));
        String s = fr.asString();
        System.out.println("Encrypted message: "+s);
        System.out.println("Message: "+decrypt(s));
    }
    
    // half of string
    private String halfOfString(String s, int start){
        StringBuilder half = new StringBuilder();
        for(int i=start; i < s.length(); i = i+2){
            half.append(s.charAt(i));
        }
        return half.toString();
    }
    
    public void testHalfOfString(){
        String s = "Qbkm Zgis";
        int start = 0;
        String half = halfOfString(s,start);
        System.out.println("Half of "+s+" from "+start+" is: "+half);
        
        start = 1;
        half = halfOfString(s,start);
        System.out.println("Half of "+s+" from "+start+" is: "+half);
    }
    
    // getkey
    private int getKey(String s){
        int len = s.length();
        int frec[] = countLetters(s);
        return maxIndex(frec);
    }
    
    // decrypt two keys
    private String decryptTwoKeys(String s){
        String even = halfOfString(s,0);
        String odd = halfOfString(s,1);
        
        String decrypted1 = decrypt(even);
        String decrypted2 = decrypt(odd);
        StringBuilder sb = new StringBuilder();
        
        int oddCounter = 0;
        int evenCounter = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(i % 2 == 0){
                sb.append(decrypted1.charAt(evenCounter));
                evenCounter++;
            } 
            else{
                sb.append(decrypted2.charAt(oddCounter));
                oddCounter++;
            }
        }
        return sb.toString();
    }
    
    public void testDecryptTwoKeys(){
        FileResource fr = new FileResource(
                new File("../ProgrammingBreakingCaesarData/wordsLotsOfEsEncrypted.txt"));
        String s = fr.asString();
        System.out.println("Encrypted message: "+s);
        System.out.println("Message: "+decryptTwoKeys(s));
        
        s = "Top ncmy qkff vi vguv vbg ycpx";
        System.out.println("Encrypted message: "+s);
        System.out.println("Message: "+decryptTwoKeys(s));
        
        s = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
        System.out.println("Encrypted message: "+s);
        System.out.println("Message: "+decryptTwoKeys(s));
        
        fr = new FileResource(
                new File("../PracticeBreakingCaesarData/mysteryTwoKeysPractice.txt"));
        s = fr.asString();
        System.out.println("Encrypted message: "+s);
        System.out.println("Message: "+decryptTwoKeys(s));
    }
    
    public void testDecryptTwoKeysQuiz(){
        FileResource fr = new FileResource(
                new File("../QuizCryptographyData/mysteryTwoKeysQuiz.txt"));
        String s = fr.asString();
        System.out.println("Encrypted message: "+s);
        System.out.println("Message: "+decryptTwoKeys(s));
    }
}
