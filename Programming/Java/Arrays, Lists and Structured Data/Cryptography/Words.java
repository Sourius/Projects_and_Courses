import edu.duke.*;
import java.io.*;

public class Words {
    private void countWordsLength(FileResource fr, int[] counts){
        for(String word: fr.words()){
            int len = word.length();
            char first = word.charAt(0);
            char last = word.charAt(len-1);
           
            if(!Character.isLetter(first)) len--;
            if(!Character.isLetter(last)) len--;
            
            if(len > counts.length){
                len = counts.length-1;
            }
            if(len == -1) len = 0; 
            counts[len]++;
        }
    }
    
    private int indexOfMax(int[] values){
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
    
    public void testWordsLengthCounter(){
        FileResource fr = new FileResource(
                new File("../QuizCryptographyData/errors.txt"));
        String s = fr.asString();
        int size = 31;
        int[] counts = new int [size];
        countWordsLength(fr, counts);
        
        /*
        for(int i = 0; i < counts.length; i++){
            if(counts[i] != 0) System.out.println(counts[i]+" words of length "+i);
        }
        */
        System.out.println("Most common word length: "+indexOfMax(counts));
        
        fr = new FileResource(
                new File("../QuizCryptographyData/manywords.txt"));
        s = fr.asString();
        counts = new int [size];
        countWordsLength(fr, counts);
        System.out.println("Most common word length: "+indexOfMax(counts));
    }
}