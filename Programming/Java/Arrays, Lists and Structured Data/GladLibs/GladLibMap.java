import edu.duke.*;
import java.util.*;
public class GladLibMap {
    private Map<String, ArrayList<String>> myMap;
    private Set<String> usedWordList;
    private Set<String> usedLabels;
    private Random myRandom;
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    
    public GladLibMap(){
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    
    public GladLibMap(String source){
        initializeFromSource(source);
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source) {
        myMap = new HashMap<>();
        String[] labels = {"country", "noun", "animal", "adjective"
            , "name", "color", "timeframe", "verb", "fruit"};
        
        for(String s: labels){
            ArrayList<String> list = readIt(source+"/"+s+".txt");
            myMap.put(s,list);
        }
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        if(!usedLabels.contains(label)) usedLabels.add(label);
        return randomFrom(myMap.get(label));
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        while(usedWordList.contains(sub)){
           sub = getSubstitute(w.substring(first+1,last));
        }
        usedWordList.add(sub);
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
        
        System.out.println();
        System.out.println("Total words changed: "+usedWordList.size());
        System.out.println();
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    public void makeStory(){
        usedWordList = new HashSet<>();
        usedLabels = new HashSet<>();
        String story = fromTemplate("data/madtemplate2.txt");
        printOut(story, 60);
        System.out.println("total words in map "+totalWordsInMap());
        System.out.println("total words considered in map "+totalWordsConsidered());
    }
    
    int totalWordsInMap(){
        int total = 0;
        for(String label: myMap.keySet()){
            total += myMap.get(label).size();
        }
        return total;
    }
    
    int totalWordsConsidered(){
        int total = 0;
        for(String label: myMap.keySet()){
            if(usedLabels.contains(label)) total += myMap.get(label).size();
        }
        return total;
    }
}
