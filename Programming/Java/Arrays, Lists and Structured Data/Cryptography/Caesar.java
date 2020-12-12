import edu.duke.*;

public class Caesar {
    
    private Character encryptChar(char ch, int key){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
        int pos = alphabet.indexOf(Character.toUpperCase(ch));
        boolean isLower = Character.isLowerCase(ch);
        Character newChar = null;
        
        if(pos != -1){
            if(isLower)
                newChar = Character.toLowerCase(shiftedAlphabet.charAt(pos));
            else
                newChar = Character.toUpperCase(shiftedAlphabet.charAt(pos));
        }
        
        return newChar;
    }
    
    
    public String encrypt(String input, int key){
         StringBuilder encrypted = new StringBuilder(input);
         for(int i = 0; i < encrypted.length(); i++){
             char c = encrypted.charAt(i);
             Character newChar = encryptChar(c,key);
             if(newChar != null) encrypted.setCharAt(i, newChar);
         }
         return encrypted.toString();
    }
    
     private String encryptTwo(String input, int key1, int key2){
         StringBuilder encrypted = new StringBuilder(input);
         for(int i = 0; i < encrypted.length(); i++){
             char c = encrypted.charAt(i);
             int key;
             if(i % 2 == 0) key = key1;
             else key = key2;
             Character newChar = encryptChar(c,key);
             if(newChar != null) encrypted.setCharAt(i, newChar);
         }
         return encrypted.toString();
     }
    
    public void testCesar(){
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
    }
    
    public void testEncrypt(){
        String text = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        int key = 15;
        String encrypted = encrypt(text, key);
        System.out.println("key is " + key + "\n" + encrypted);
    }
    
    public void test2(){
        String text = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        int key = 8;
        int key2 = 21;
        String encrypted = encryptTwo(text, key, key2);
        System.out.println("key are " + key +" and "+ key2 + "\n" + encrypted);
        
    }
}