import edu.duke.*;

public class WordPlay {
    private char vowels[] = {'a','e','i','o','u'};
    
    private boolean isVowel(char ch){
        for(int i = 0; i < 5; i++){
            if(vowels[i] == Character.toLowerCase(ch)) return true;
        }
        return false;
    };
    
    public void testIsVowel(){
        for(int i = 0; i < 5; i++){
            if(!isVowel(vowels[i])){
                System.out.println("Error in method isVowel");
            }
        }
    }
    
    private String replaceVowels(String phrase, char ch){
        StringBuilder sb = new StringBuilder(phrase);
        
        for(int i = 0; i < sb.length(); i++){
            char oldChar = sb.charAt(i);
            char newChar;
            if(isVowel(oldChar)){
                if(Character.isLowerCase(oldChar)){
                    newChar = Character.toLowerCase(ch);
                }
                else{
                    newChar = Character.toUpperCase(ch);
                }
                sb.setCharAt(i, newChar);
            }
        }
        return sb.toString();
    }
    
    private boolean isEven(int num){
        return num % 2 == 0;
    }
    
    public void testReplaceVowels(){
        String phrase = "Hello World";
        char ch = '*';
        System.out.println(replaceVowels(phrase, ch));
    }
    
    private  String emphasize(String phrase, char ch){
        StringBuilder sb = new StringBuilder(phrase);
        
        for(int i = 0; i < sb.length(); i++){
            char oldChar = sb.charAt(i);
            char newChar;
            if(oldChar == Character.toLowerCase(ch)){
                if(isEven(i+1))newChar = '+';
                else newChar = '*';
                sb.setCharAt(i, newChar);
            }
        }
        return sb.toString();
    }
    
    public void testEmphasize(){
        String phrase;
        char ch;
        
        phrase = "dna ctgaaactga";
        ch = 'a';
        System.out.println(emphasize(phrase, ch));
        
        phrase = "Mary Bella Abracadabra";
        System.out.println(emphasize(phrase, ch));
    }
}
