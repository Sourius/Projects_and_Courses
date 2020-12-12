import java.util.*;
import edu.duke.*;
import java.io.File;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        char[] aux = message.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = whichSlice ; i < message.length(); i+=totalSlices){
            sb.append(aux[i]);
        }
        return sb.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cc = new CaesarCracker(mostCommon);
        int current = 0;
        for(int i = 0; i < klength; i++){
            if(current > 0) current = current % klength;
            String aux = sliceString(encrypted,current,klength);
            key[i] = cc.getKey(aux);
            current++;
        }
        return key;
    }

    public void breakVigenere (FileResource fr, int klength, char mostCommon) {
        //WRITE YOUR CODE HERE
        String encrypted = fr.asString();
        int[] key = tryKeyLength(encrypted, klength, mostCommon);
        VigenereCipher vc = new VigenereCipher(key);
        
        FileResource frEng = new FileResource("dictionaries/English");
        HashSet<String> dictionary = readDictionary(frEng);
        
        String decrypted = vc.decrypt(encrypted);
        System.out.println("Encrypted message:\n"+encrypted.substring(0,200));
        //System.out.println("Decrypted message:\n"+vc.decrypt(encrypted));
        System.out.println("Decrypted message:\n"+decrypted.substring(0,200));
    
        System.out.println("Words decrypted: "+countWords(decrypted, dictionary));
    }
    
    public void breakVigenereEng(FileResource fr){
        String encrypted = fr.asString();
        FileResource frEng = new FileResource("dictionaries/English");
        HashSet<String> dictionary = readDictionary(frEng); 
        String decrypted = breakForLanguage(encrypted, dictionary);
        System.out.println(decrypted.substring(0,200));
    }
    
    public void breakVigenere(FileResource fr){
        DirectoryResource dr = new DirectoryResource();
        HashMap<String, HashSet<String>> dictionaryMap = new HashMap<>();
        String encrypted = fr.asString();
        for(File f: dr.selectedFiles()){
            String language = f.getName();
            FileResource frLang = new FileResource("dictionaries/"+language);
            HashSet<String> dictionary = readDictionary(frLang);
            dictionaryMap.put(language, dictionary);
        }
        breakForAllLanguages(encrypted, dictionaryMap);
    }
    
    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> words = new HashSet<>();
        for(String word: fr.words()){
            String lowerCaseWord = word.toLowerCase();
            if(!words.contains(lowerCaseWord)){
                words.add(lowerCaseWord);
            }
        }
        return words;
    }
    
    /*
    public int countWords(String message, HashSet<String> dictionary){
        int wordsCounter = 0;
        for(String aux: message.split("\\W+")){
            aux = aux.trim();
            if(aux != "" && dictionary.contains(aux)) wordsCounter++;
        }
        return wordsCounter;
    }
    */
    
   public int countWords(String message, HashSet<String> dictionary){
        String[] messageSplit = message.split("\\W+");
        int commonWords = 0;
        for(int i=0; i < messageSplit.length; i++){
            String word = messageSplit[i].toLowerCase();
            if (dictionary.contains(word)){
                commonWords++;
            }
        }
        return commonWords;
    }
   
    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        String decryptionMessage = "";
        int[] bestKey = null;
        int mostWords = 0;
        char mostCommon = 'e';
        for(int i = 1; i <= 100; i++){
            int[] key = tryKeyLength(encrypted, i, mostCommon);
            VigenereCipher vc = new VigenereCipher(key);
            String current = vc.decrypt(encrypted);
            int words = countWords(current, dictionary);
            
            if(words > mostWords){
                mostWords = words;
                bestKey = key;
                decryptionMessage = current;
            }
        }
        System.out.println("Decryption with key "+Arrays.toString(bestKey));
        System.out.println("KeyLength: "+bestKey.length);
        System.out.println("Decrypted  words :"+mostWords);
        return decryptionMessage;
    }
    
    public char mostCommonCharIn(HashSet<String> dictionary){
        Character mostCommon = null;
        HashMap<Character,Integer> frequency = new HashMap<>();
        for(String word: dictionary){
            for(Character c: word.toCharArray()){
                int rep = 1;
                c = Character.toLowerCase(c);
                if(frequency.keySet().contains(c)){
                    rep += frequency.get(c);
                }
                frequency.put(c,rep);
            }
        }
        
        int max = 0;
        for(Character c: frequency.keySet()){
            int rep = frequency.get(c);
            if(rep > max){
                max = rep;
                mostCommon = c;
            }
        }
        
        return mostCommon;
    }
    
    public void breakForAllLanguages(String encrypted, HashMap<String, HashSet<String>> dictionaryMap){
        String decryptionMessage = "";
        String bestLanguage = "";
        int mostWords = 0;    
        int[] bestKey = null;
        
        for(String lang: dictionaryMap.keySet()){
            HashSet<String> dictionary = dictionaryMap.get(lang);
            char mostCommon = mostCommonCharIn(dictionary);
            for(int i = 1; i <= 100; i++){
                int[] key = tryKeyLength(encrypted, i, mostCommon);
                VigenereCipher vc = new VigenereCipher(key);
                String current = vc.decrypt(encrypted);
                int words = countWords(current, dictionary);
                
                if(words > mostWords){
                    mostWords = words;
                    bestKey = key;
                    decryptionMessage = current;
                    bestLanguage = lang;
                }
            }
        }
        System.out.println("Language: "+bestLanguage);
        System.out.println("Decryption with key "+Arrays.toString(bestKey));
        System.out.println("KeyLength: "+bestKey.length);
        System.out.println("Decrypted  words :"+mostWords);
        System.out.println("Description message:\n"+decryptionMessage.substring(0,200).trim());
    }
}