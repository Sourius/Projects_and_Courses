/**
 * Write a description of EfficientMarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class EfficientMarkovModel extends AbstractMarkovModel{
    private Map<String, ArrayList<String>> map;
    
    public EfficientMarkovModel(int order){
        myOrder = order;
        map = new HashMap<>();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
        buildMap();
    }
    
    @Override 
    public String getRandomText(int length){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-myOrder);
        String key = myText.substring(index, index+myOrder);
        sb.append(key);
        
        for(int k=0; k < length-myOrder; k++){
            ArrayList<String> follows = getFollows(key);
            if(follows.size() == 0) break;
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1)+next;
        }
        return sb.toString();
    }
    
    @Override
    protected ArrayList<String> getFollows(String key){
        ArrayList<String> follows = new ArrayList<>();
        if(map.containsKey(key)) follows = map.get(key);
        return follows;
    }
    
    private ArrayList<String> getValuesFor(String key){
        ArrayList<String> values = new ArrayList<>();
        int pos = 0;
        int len = key.length();
        while(pos < myText.length()){
            int start = myText.indexOf(key, pos);
            if(start==-1){
                break;
            }
            if(start + len > myText.length()-1){
                break;
            }
            String next = myText.substring(start+len, start+len+1);
            values.add(next);
            pos = start+1;
        }

        return values;
    }
    
    private void buildMap(){
        HashSet<String> keys = new HashSet<>();
        for(int i = 0; i < myText.length()-myOrder+1; i++){
            String key = myText.substring(i, i+myOrder);
            if(!keys.contains(key)) keys.add(key);
        }
        for(String key: keys){
            map.put(key, getValuesFor(key));
        }
    }
    
    public void printHashMapInfo(){
        Set<String> keys = map.keySet();
        int max = 0;
        
        for(String key: keys){
            List<String> values = map.get(key);
            if(values.size() > max){
                max = values.size();
            }
            
            if(map.size() < 50){
                System.out.println(key+": {");
                for(String value: values){
                    System.out.print(value+", ");
                }
                System.out.println("}");
            }
        }
        
        System.out.println("Number of keys: "+keys.size());
        System.out.println("Maximum number of values within a key: "+max);
        System.out.println("Keys with maximum size values:");
        for(String key: keys){
            List<String> values = map.get(key);
            if(values.size() == max){
                System.out.println(key);
            }
        }
    }
    
    @Override
    public String toString(){
        return "Efficient Markov Model of order "+myOrder;
    }
}
