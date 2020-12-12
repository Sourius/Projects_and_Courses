/**
 * Write a description of class MarkovWordOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MarkovWordOne implements IMarkovModel {
    private String[] myText;
    private Random myRandom;

    public MarkovWordOne() {
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
        int index = myRandom.nextInt(myText.length-1);  // random word to start with
        String key = myText[index];
        sb.append(key).append(" ");
        for(int k=0; k < numWords-1; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next).append(" ");
            key = next;
        }
        return sb.toString().trim();
    }

    private ArrayList<String> getFollows(String key) {
        ArrayList<String> follows = new ArrayList<String>();
        int index = indexOf(myText, key, 0);
        while(index != -1){
            String word = myText[index+1];
            follows.add(word);
            index = indexOf(myText, key, index+1);
        }
        return follows;
    }
    
    private int indexOf(String words[], String target, int start){
        for(int i = start; i < words.length; i++){
            String currentWord = words[i];
            if(currentWord.equalsIgnoreCase(target)){
                return i;
            }
        }
        return -1;
    }
    
    public void testIndexOf(){
        ArrayList<String> follows;
        setTraining("this is just a test yes this is a simple test");
        String key = "this";
        int start = 0;
        int pos;
        
        int index = indexOf(myText, key, start);
        if(index != -1) {
            pos = index+1;
            System.out.println(key+" is followed by "+myText[pos]+" from "+start);
        }
        
        key = "this";
        start = 3;
        index = indexOf(myText, key, start);
        if(index != -1) {
            pos = index+1;
            System.out.println(key+" is followed by "+myText[pos]+" from "+start);
        }
        
        key = "frog";
        start = 0;
        index = indexOf(myText, key, start);
        if(index != -1) {
            pos = index+1;
            System.out.println(key+" is followed by "+myText[pos]+" from "+start);
        }
        
        key = "frog";
        start = 5;
        index = indexOf(myText, key, start);
        if(index != -1) {
            pos = index+1;
            System.out.println(key+" is followed by "+myText[pos]+" from "+start);
        }
        
        key = "simple";
        start = 2;
        index = indexOf(myText, key, start);
        if(index != -1) {
            pos = index+1;
            System.out.println(key+" is followed by "+myText[pos]+" from "+start);
        }
        
        key = "test";
        start = 5;
        index = indexOf(myText, key, start);
        if(index != -1) {
            pos = index+1;
            System.out.println(key+" is followed by "+myText[pos]+" from "+start);
        }
    }
}