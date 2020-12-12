import edu.duke.*;
import java.util.*;
import java.io.File;

public class WordsInFile {
    private Map<String, ArrayList<String>> wordsMap;
    
    public WordsInFile(){
        wordsMap = new HashMap<>();
    }
    
    private void addWordsFromFile(File f){
        FileResource fr = new FileResource(f);
        for(String word: fr.words()){
            String filename = f.getName();
            ArrayList<String> files;
            if(!wordsMap.keySet().contains(word)){
                files = new ArrayList<>();
                files.add(filename);
                wordsMap.put(word, files);
            }
            else{
                files = wordsMap.get(word);
                if(!files.contains(filename)){
                    files.add(filename);
                }
            }
        }
    }
    
    void buildWordFileMap(){
        wordsMap.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    
    int maxNumber(){
        int max = 0;
        for(String word: wordsMap.keySet()){
            int numFiles = wordsMap.get(word).size();
            if(numFiles > max){
                max = numFiles;
            }
        }
        return max;
    }
    
    ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> list = new ArrayList<>();
        for(String word: wordsMap.keySet()){
            int numFiles = wordsMap.get(word).size();
            if(numFiles == number){
                list.add(word);
            }
        }
        return list;
    }
    
    void printFilesIn(String word){
        for(String s: wordsMap.keySet()){
            if(word.equals(s)){
                ArrayList<String> files = wordsMap.get(s);
                StringBuilder result = new StringBuilder(); 
                result.append(s+": ");
                for(String filename: files){
                    result.append(filename+" ");
                }
                System.out.println(result.toString());
            }
        }
    }
    
    public void test(){
       buildWordFileMap();
       // determine maximum number of files any word is in
       int max = maxNumber();
       System.out.println("Maximum number of files any word is in: "+max);
       // determine the words that are in maximum number of files for each word
       System.out.println("Words in maximum number of files");
       for(String word: wordsInNumFiles(max)){
           System.out.println(word);
       }
    }
    
    private void doesNotAppearIn(String word){
        ArrayList<String> files = wordsMap.get(word);
        System.out.println("The word "+word+" appears in: ");
        for(String file: wordsMap.get(word)){
            System.out.print(file+" ");
        }
        System.out.println();
    }
    
    public void testQuiz(){
        buildWordFileMap();
        /* quiz 1
        System.out.print("Words that appear in 5 files: ");
        System.out.println(wordsInNumFiles(5).size());
        System.out.print("Words that appear in 4 files: ");
        System.out.println(wordsInNumFiles(4).size());
        doesNotAppearIn("sad");
        doesNotAppearIn("red");
        */
        /*review quiz*/
        System.out.print("Words that appear in 7 files: ");
        System.out.println(wordsInNumFiles(7).size());
        System.out.print("Words that appear in 4 files: ");
        System.out.println(wordsInNumFiles(4).size());
        doesNotAppearIn("sea");
        doesNotAppearIn("laid");
        doesNotAppearIn("tree");
    }
}
