import edu.duke.*;

public class TestCaesarCipher {
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
    
    public void simpleTests(){
        FileResource fr = new FileResource();
        String s = fr.asString();
        int key = 18;
        CaesarCipher cc = new CaesarCipher(key);
        String encrypted = cc.encrypt(s);
        System.out.println("Encrypted message: "+encrypted);
        System.out.println("Decoded message: "+cc.decrypt(encrypted));
        System.out.println("Original message: "+s);
        System.out.print("Breaking Caesar Cipher: ");
        breakCaesarCipher(encrypted);
    }

    private int getKey(String s){
        int len = s.length();
        int freqs[] = countLetters(s);
        int maxIndex = maxIndex(freqs);
        int key = maxIndex - 4;
        
        if(maxIndex < 4){
            key = 26 - (4 - maxIndex);
        }
        
        return key;
    }    
    
    private void breakCaesarCipher(String input){
        int key = getKey(input);
        CaesarCipher cc = new CaesarCipher(key);
        
        String message = cc.decrypt(input);
        System.out.println("\nMessage: "+message+"\nKey: "+key);
    }
    
    public void testForQuiz(){
        String s = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        CaesarCipher cc = new CaesarCipher(15);
        String encrypted = cc.encrypt(s);
        System.out.println(encrypted);
    }
}
