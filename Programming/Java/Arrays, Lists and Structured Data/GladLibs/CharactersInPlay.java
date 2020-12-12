import edu.duke.*;
import java.util.ArrayList;

public class CharactersInPlay {
    private ArrayList<String> names;
    private ArrayList<Integer> dialogs;
    
    public CharactersInPlay(){
        names = new ArrayList<>();
        dialogs = new ArrayList<>();
    }
    
    public void update(String character){
        character = character.trim();
        int index = names.indexOf(character);
        if(index == -1){
            names.add(character);
            dialogs.add(1);
        }
        else{
            int rep = dialogs.get(index);
            dialogs.set(index, rep+1);
        }
    }
    
    public void findAllCharacters(){
        FileResource fr = new FileResource();
        names = new ArrayList<>();
        dialogs = new ArrayList<>();
        
        for(String s: fr.lines()){
            s = s.trim();
            int index = s.indexOf(".");
            if(index != -1 && s.length() > index+1) {
                String name = s.substring(0,index);
                update(name);
            }
        }
    }
    
    private int getAvg(){
        int avg = 0;
        for(Integer i: dialogs){
            avg += i;
        }
        avg = avg / dialogs.size();
        return avg;
    }
    
    public void tester(){
        findAllCharacters();
        
        int avg = getAvg();
        for(int i = 0; i < names.size(); i++){
           String name = names.get(i);
           int dialog = dialogs.get(i);
           if(dialog > avg){
               System.out.println(name+" has "+dialog+" speaking parts.");
           }
        }
        
        charactersWithNumParts(10,15);
    }
    
    public void charactersWithNumParts(int num1, int num2){
        if(num1 > num2) throw new RuntimeException("Error in number values");
        System.out.println("Characters with "+num1+" to "+num2+" speaking parts");
        for(int i=0; i<dialogs.size();i++){
            int dialog = dialogs.get(i);
            if(dialog >= num1 && dialog <= num2){
                System.out.println(names.get(i)+" with "+dialog+" parts");
            }
        }
    }
    
    public void testQuiz(){
        findAllCharacters();
        charactersWithNumParts(70,100);
    }
}

