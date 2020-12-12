import edu.duke.*;
import java.util.*;
/**
 * Write a description of LargestQuakes here.
 * 
 * @author (sourius) 
 * @version (05-11-2020)
 */
public class LargestQuakes {
    public void findLargestQuakes(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        /*for(int k=0; k < list.size(); k++){
            QuakeEntry entry = list.get(k);
            System.out.println(entry);
        }*/
        System.out.println("Total number of earthquakes " + list.size());
        /*int largest = indexOfLargest(list);
        System.out.print("Largest earthquake is at location "+largest);
        QuakeEntry largestQuake = list.get(largest);
        System.out.println(" and has magnitude "+largestQuake.getMagnitude());
        */
       ArrayList<QuakeEntry> largestQuakes;
       largestQuakes = getLargest(list, 20);
       for(QuakeEntry quake: largestQuakes){
           System.out.println(quake);
       }
       
       System.out.println();
       largestQuakes = getLargest(list, 50);
       for(QuakeEntry quake: largestQuakes){
           System.out.println(quake);
       }
    }
    
    public int indexOfLargest(ArrayList<QuakeEntry> quakes){
        double currentMagnitude = 0;
        int largest = 0;
        
        for(int k = 0; k < quakes.size(); k++) {
            QuakeEntry quake = quakes.get(k);
            if(quake.getMagnitude() > currentMagnitude){
                currentMagnitude = quake.getMagnitude();
                largest = k;
            }
        }
        return largest;
    }
    
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
        ArrayList<QuakeEntry> quakes = new ArrayList<>();
        ArrayList<QuakeEntry> copy = new ArrayList<>();
        
        Iterator<QuakeEntry> it = quakeData.iterator();
        while (it.hasNext()) {
            QuakeEntry q = it.next();
            copy.add(new QuakeEntry(q));
        }
        
        for(int i = 0; i < howMany; i++){
            int largest = indexOfLargest(copy);
            quakes.add(copy.get(largest));
            copy.remove(largest);
        }
        return quakes;
    }
}
