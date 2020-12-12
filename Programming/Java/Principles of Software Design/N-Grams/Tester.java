/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class Tester {
    public void testGetFollows(){
        MarkovOne mv = new MarkovOne();
        String trainingText = "this is a test yes this is a test.";
        mv.setTraining(trainingText);
        String aux = ".";
        
        for(String s: mv.getFollows(aux)){
            System.out.println(s);
        }
        
        aux = "t.";
        for(String s: mv.getFollows(aux)){
            System.out.println(s);
        }
        
        aux = "t";
        for(String s: mv.getFollows(aux)){
            System.out.println(s);
        }
    }
    
    public void getFollowsWithFile() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovOne mv = new MarkovOne();
        //markov.setRandom(42);
        //markov.setRandom(88);
        mv.setTraining(st);
        String aux = "he";
        ArrayList<String> list = mv.getFollows(aux);
        System.out.println(list.size());
    }

   private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }
}
