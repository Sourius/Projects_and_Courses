import edu.duke.*;
import java.util.*;
public class CodonMap {
    private Map<String, Integer> codonMap;
    
    void buildCodonMap(int start, String dna){
        codonMap = new HashMap();
        int next = start+3;
        String aux[] = dna.substring(start).split("(?<=\\G.{3})");
        for(String s: aux){
            s = s.trim();
            if(s.length() == 3){
                int occurrences = 1;
                if(codonMap.keySet().contains(s)){
                    occurrences += codonMap.get(s);
                }
                codonMap.put(s,occurrences);
            }
        }
    }
    
    String getMostCommonCodon(){
        String mostCommon = null;
        int max = 0;
        for(String codon: codonMap.keySet()){
            int occurrences = codonMap.get(codon);
            if( occurrences > max){
                max = occurrences;
                mostCommon = codon;
            }
        }
        return mostCommon;
    }
    
    void printCodonCounts(int start, int end){
        for(String codon: codonMap.keySet()){
            int occurrences = codonMap.get(codon);
            if(occurrences >= start && occurrences <= end){
                System.out.println(occurrences+" --> "+codon);
            }
        }
    }
    
    public void test(){
        FileResource fr = new FileResource();
        String s = null;
        
        s = fr.asString().toUpperCase();
        System.out.println(s+"\nFrom 0");
        buildCodonMap(0, s);
        printCodonCounts(1,5);
        
        System.out.println("\nFrom 1");
        buildCodonMap(1, s);
        printCodonCounts(1,5);
        
        System.out.println("\nFrom 2");
        buildCodonMap(2, s);
        printCodonCounts(1,5);
    }
    
    private void printCodons(){
        for(String codon: codonMap.keySet()){
            int occurrences = codonMap.get(codon);
            System.out.println(occurrences+" --> "+codon);
        }
    }
    
    private void printCodonsSize(){
        System.out.println(codonMap.keySet().size());
    }
    
     public void testQuiz(){
        FileResource fr = new FileResource();
        String s = null;
        
        s = fr.asString().toUpperCase();
        System.out.println(s+"\nFrom 0");
        buildCodonMap(0, s);
        printCodonsSize();
        System.out.println("Most common codon is "+getMostCommonCodon());
        printCodonCounts(7,7);
        
        System.out.println("\nFrom 1");
        buildCodonMap(1, s);
        printCodonsSize();
        System.out.println("Most common codon is "+getMostCommonCodon());
        
        System.out.println("\nFrom 2");
        buildCodonMap(2, s);
        printCodonsSize();
        String mostCommon = getMostCommonCodon();
        System.out.println("Most common codon is "+mostCommon);
        printCodons();
        
        System.out.println("codons that appear 4 times: ");
        printCodonCounts(4,4);
        
    }
}
