/**
 * Write a description of EfficientMarkovWord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class EfficientMarkovWord implements IMarkovModel{
    private String[] myText;
    private Random myRandom;
    private int myOrder;
    Map<WordGram, ArrayList<String>> map;

    public EfficientMarkovWord(int order) {
        myRandom = new Random();
        myOrder = order;
        map = new HashMap<>();
    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setTraining(String text){
        myText = text.split("\\s+");
        buildMap();
    }

    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-myOrder);  // random word to start with
        WordGram key = new WordGram(myText, index, myOrder);
        sb.append(key.toString()).append(" ");
        for(int k=0; k < numWords - myOrder; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next).append(" ");
            key = key.shiftAdd(next);
        }
        return sb.toString().trim();
    }

    protected ArrayList<String> getFollows(WordGram key){
        ArrayList<String> follows = new ArrayList<>();
        if(map.containsKey(key)) follows = map.get(key);
        return follows;
    }

    private ArrayList<String> getValuesFor(WordGram key) {
        ArrayList<String> follows = new ArrayList<String>();
        int start = indexOf(myText, key, 0);
        while(start != -1){
            String word = myText[start+myOrder];
            follows.add(word);
            start = indexOf(myText, key, start+1);
        }
        return follows;
    }

    private int indexOf(String words[], WordGram target, int start){
        for(int i = start; i < words.length - myOrder; i++){
            WordGram wg = new WordGram(words, i, myOrder);
            if(wg.equals(target)){
                return i;
            }
        }
        return -1;
    }

    private void buildMap(){
        for (int i=0; i<myText.length-myOrder;i++) {
            WordGram key = new WordGram(myText,i,myOrder);
            String word = myText[i+myOrder];
            if (map.containsKey(key)) {
                map.get(key).add(word);
            }
            else {
                ArrayList<String> value = new ArrayList<>();
                value.add(word);
                map.put(key, value);
            }
        }
    }

    public void printHashMapInfo(){
        Set<WordGram> keys = map.keySet();
        int max = 0;

        for(WordGram key: keys){
            List<String> values = map.get(key);
            if(values.size() > max){
                max = values.size();
            }
        }

        System.out.println("Number of keys: "+keys.size());
        System.out.println("Maximum number of values within a key: "+max);
        System.out.println("Keys with maximum size values:");
        for(WordGram key: keys){
            List<String> values = map.get(key);
            if(values.size() == max){
                System.out.println(key);
            }
        }
    }
}
