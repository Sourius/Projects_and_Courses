import edu.duke.*;
import java.util.ArrayList;

public class WordFrequencies {
    private ArrayList<String> wordList;
    private ArrayList<Integer> freqList;
    
    public WordFrequencies(){
        wordList = new ArrayList<String>();
        freqList = new ArrayList<Integer>();
    }
    
    public void findUnique(){
        wordList = new ArrayList<String>();
        freqList = new ArrayList<Integer>();
        FileResource resource = new FileResource();
        
        for(String s: resource.words()){
            s = s.toLowerCase();
            int index = wordList.indexOf(s);
            if(index == -1){
                wordList.add(s);
                freqList.add(1);
            }
            else{
                int value = freqList.get(index);
                freqList.set(index,value+1);
            }
        }
    }
    
    public int numberOfUniqueWords(){
        return wordList.size();
    }
    
    public boolean contains(String [] list, String word, int number){
        for(int k = 0; k < number; k++){
            if(list[k].equals(word)){
                return true;
            }
        }
        return false;
    }
    
    public void tester(){
        findUnique();
        System.out.println("# unique words: "+wordList.size());
        /*for(int k = 0; k < wordList.size(); k++){
            System.out.println(freqList.get(k)+"\t"+wordList.get(k));
        }*/
    }
    
    private int findIndexOfMax(){
        int max = 0;
        int pos = -1;
        
        for(int i = 0; i < freqList.size(); i++){
            int value = freqList.get(i);
            if(value > max){
                max = value;
                pos = i;
            }
        }
        
        return pos;
    }
    
    public String mostFrequentWord(){
        int mFIndex = findIndexOfMax();
        if(mFIndex != -1){
            return wordList.get(mFIndex);
        }
        return null;
    }
    
    public void testMostFrequentWord(){
        findUnique();
        System.out.println("# unique words: "+wordList.size());
        int index = findIndexOfMax();
        if(index != -1){
            System.out.println("Most frequent word "+wordList.get(index)+" at "+index+" with "+freqList.get(index));
        }
        else{
            System.out.println("There are no words");
        }
    }
    
    
}
