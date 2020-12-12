import edu.duke.*;

public class TestCaesarCipherTwo {
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
        int key1 = 17;
        int key2 = 3;
        CaesarCipherTwo cc = new CaesarCipherTwo(key1, key2);
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
    
    // half of string
    private String halfOfString(String s, int start){
        StringBuilder half = new StringBuilder();
        for(int i=start; i < s.length(); i = i+2){
            half.append(s.charAt(i));
        }
        return half.toString();
    }
    
    private void breakCaesarCipher(String input){
        String even = halfOfString(input,0);
        String odd = halfOfString(input,1);
        
        int key1 = getKey(even);
        int key2 = getKey(odd);
        
        CaesarCipherTwo cc = new CaesarCipherTwo(key1,key2);
        String decrypted = cc.decrypt(input);
        
        System.out.println("Broken caesar message: "+decrypted);
    }
    
    public void testForQuiz(){
        String s = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        CaesarCipherTwo cc = new CaesarCipherTwo(21,8);
        String encrypted = cc.encrypt(s);
        System.out.println(s+"\n"+encrypted);
        
        s = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
        cc = new CaesarCipherTwo(14,24);
        System.out.println(s+"\n"+cc.decrypt(s));
        
        System.out.println(s);
        breakCaesarCipher("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!");
    }
}
