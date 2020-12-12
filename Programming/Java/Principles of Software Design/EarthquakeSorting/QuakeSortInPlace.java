/**
 * Write a description of class QuakeSortInPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class QuakeSortInPlace {
    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub
    }
   
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
       for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
    }

    public int getLargestDepth(ArrayList<QuakeEntry> quakeData, int from){
        int max = from;
        for (int i=from+1; i < quakeData.size(); i++) {
            if (quakeData.get(i).getDepth() > quakeData.get(max).getDepth()){
                max = i;
            }
        }
        return max;
    }
    
    public void sortByLargestDepth(ArrayList<QuakeEntry> in) {
       int max;
       int pases = 0;
       for (int i = 0; i< in.size(); i++) {
            if(checkInSortedOrder(in) || pases == 70){
                break;
            }
            max = getLargestDepth(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmax = in.get(max);
            in.set(i,qmax);
            in.set(max,qi);
            pases++;
        }
        System.out.println("Pases used "+pases);
    }
    
    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedatasmall.atom";
        //String source = "data/nov20quakedata.atom";
        //String source = "data/earthquakeDataSampleSix1.atom";
        String source = "data/earthQuakeDataWeekDec6sample1.atom";
        //String source = "data/earthQuakeDataWeekDec6sample1.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");    
        //sortByMagnitude(list);
        //sortByLargestDepth(list);
        //sortByMagnitudeWithBubbleSort(list);
        //sortByMagnitudeWithBubbleSortWithCheck(list);
        //sortByMagnitudeWithCheck(list);
        /*
        source = "data/earthquakeDataSampleSix2.atom";
        sortByMagnitudeWithCheck(list);
         */
        /*
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        }
         */
         
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                              qe.getLocation().getLatitude(),
                              qe.getLocation().getLongitude(),
                              qe.getMagnitude(),
                              qe.getInfo());
        }
        
    }
    
    public void onePassBubbleSort(ArrayList<QuakeEntry> quakeData, int numSorted){
        int remaining = quakeData.size()-numSorted;
        for(int i = 0; i < remaining-1; i++){
            QuakeEntry a = quakeData.get(i);
            QuakeEntry b = quakeData.get(i+1);
            if(a.getMagnitude() > b.getMagnitude()){
                quakeData.set(i,b);
                quakeData.set(i+1,a);
            }
        }
    }
    
    public void sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> in){
        int i = 0;
        while(i < in.size()-1){
            onePassBubbleSort(in, i);
            i++;
        }
    }
    
    public boolean checkInSortedOrder(ArrayList<QuakeEntry> quakes){
        for(int i = 0; i < quakes.size()-1; i++){
            QuakeEntry a = quakes.get(i);
            QuakeEntry b = quakes.get(i+1);
            if(a.getMagnitude() > b.getMagnitude()){
                return false;
            }
        }
        return true;
    }
    
    public void sortByMagnitudeWithBubbleSortWithCheck(ArrayList<QuakeEntry> in){
        int i = 0;
        int pases = 0;
        
        while(i < in.size()-1){
            if(checkInSortedOrder(in)){
                break;
            }
            onePassBubbleSort(in, i);
            i++;
            pases++;
        }
        
        System.out.println("Pases needed "+pases);
    }
    
    public void sortByMagnitudeWithCheck(ArrayList<QuakeEntry> in){
        int pases = 0;
        
        for (int i=0; i< in.size(); i++) {
            if(checkInSortedOrder(in)){
               break; 
            }
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
            pases++;
        }

        System.out.println("Pases needed "+pases);
    }
}