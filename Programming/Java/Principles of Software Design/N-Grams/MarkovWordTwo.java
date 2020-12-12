/**
 * Write a description of MarkovWordTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class MarkovWordTwo implements IMarkovModel{
    private String[] myText;
    private Random myRandom;
    
    public MarkovWordTwo(){
        myRandom = new Random();
    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setTraining(String text){
        myText = text.split("\\s+");
    }

    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        
        // random words to start with
        int index = myRandom.nextInt(myText.length-2);  
        String key = myText[index];
        String key2 = myText[index+1];
        sb.append(key).append(" ");
        sb.append(key2).append(" ");

        for(int k=0; k < numWords-1; k++){
            ArrayList<String> follows = getFollows(key, key2);
            if (follows.size() == 0) {
                break;
            }
            
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next).append(" ");
            key = key2;
            key2 = next;
        }

        return sb.toString().trim();
    }

    private ArrayList<String> getFollows(String key1, String key2) {
        ArrayList<String> follows = new ArrayList<String>();
        int index = indexOf(myText, key1, key2, 0);
        while(index != -1){
            String word = myText[index+2];
            follows.add(word);
            index = indexOf(myText, key1, key2, index+1);
        }
        return follows;
    }
    
    private int indexOf(String words[], String target1, String target2, int start){
        for(int i = start; i < words.length-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            if(word1.equalsIgnoreCase(target1) && word2.equalsIgnoreCase(target2)){
                return i;
            }
        }
        return -1;
    }
}
