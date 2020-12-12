import edu.duke.*;

public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    
    public CaesarCipherTwo(int key1, int key2){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = shiftAlphabet(key1);
        shiftedAlphabet2 = shiftAlphabet(key2);
    }
    
    private String shiftAlphabet(int key){
        StringBuilder shift = new StringBuilder(alphabet);
        for(int i = 0; i < shift.length(); i++){
             char c = shift.charAt(i);
             int pos = (i + key) % 26;
             Character newChar = alphabet.charAt(pos);
             if(newChar != null) shift.setCharAt(i, newChar);
        }
        return shift.toString();
    }

    private String encryptDecrypt(String input, int option){
        StringBuilder encrypted = new StringBuilder(input);
        String from, to;
        String shiftedAlphabet="";
        
        for(int i = 0; i < encrypted.length(); i++){
            char c = encrypted.charAt(i);
            
            if(i % 2 == 0) shiftedAlphabet = shiftedAlphabet1;
            else shiftedAlphabet = shiftedAlphabet2;
            
            //encode
            if(option == 1) {
                from = alphabet;
                to = shiftedAlphabet;
            }
            //decode
            else{
                to = alphabet;
                from = shiftedAlphabet;
            }
            
            int pos = from.indexOf(Character.toUpperCase(c));
            
            if(pos != -1){
                char newChar = to.charAt(pos);
                if(Character.isUpperCase(c))
                    newChar = Character.toUpperCase(newChar);
                else 
                    newChar = Character.toLowerCase(newChar);
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }
    
    public String encrypt(String input){
        return encryptDecrypt(input, 1);
    }

    public String decrypt(String input){
        return encryptDecrypt(input, 2);
    }
}
