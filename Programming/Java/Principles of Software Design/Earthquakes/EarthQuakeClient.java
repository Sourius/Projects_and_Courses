import java.util.*;
import edu.duke.*;

public class EarthQuakeClient {
    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData, double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        //TODO
        for (QuakeEntry qe : quakeData) {
            if (qe.getMagnitude() > magMin) {
                answer.add(qe);
            }
        }
        return answer;              
    }
    
    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData, double distMax, Location from) {      
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for (QuakeEntry qe : quakeData) {
            if (qe.getLocation().distanceTo(from) < distMax) {
                answer.add(qe);
            }
        }
        return answer;
    }
            
    public void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                              qe.getLocation().getLatitude(),
                              qe.getLocation().getLongitude(),
                              qe.getMagnitude(),
                              qe.getInfo());
        }
        
    }
    
    public void bigQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for " + list.size() + " quakes");
        /*
        for (QuakeEntry qe : list) {
            if (qe.getMagnitude() > 5.0) {
                System.out.println(qe);
            }
        }
        */
        ArrayList<QuakeEntry> listBig = filterByMagnitude(list, 5.0);
        for (QuakeEntry qe : listBig) {
           System.out.println(qe); 
        }
    }
    
    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void closeToMe() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("# quakes read: " + list.size());
        
        //Durham, NC
        //Location city = new Location(35.988, -78.907);
        //Bridgeport, CA
        Location city = new Location(38.17, -118.82);
        ArrayList<QuakeEntry> close = filterByDistanceFrom(list, 1000*1000, city);
        for (int k=0; k< close.size(); k++) {
            QuakeEntry entry = close.get(k);
            double distanceInMeters = city.distanceTo(entry.getLocation());
            System.out.println(distanceInMeters/1000 + " " + entry.getInfo());
        }
        System.out.println("Found "+close.size()+" quakes that match that criteria.");
    }
    
    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData, double minDepth, double maxDepth){
        ArrayList<QuakeEntry> result = new ArrayList<>();
        for(QuakeEntry qe: quakeData){
            double depth = qe.getDepth();
            if(depth > minDepth &&  depth < maxDepth){
                result.add(qe);
            }
        }
        return result;
    }
    
    private void printQuakesInfo(ArrayList<QuakeEntry> quakeData){
        for(QuakeEntry entry: quakeData){
            StringBuilder sb = new StringBuilder();
            Location loc = entry.getLocation();
            sb.append("(").append(loc.getLatitude()).append(", ");
            sb.append(loc.getLongitude()).append(")");
            sb.append(", mag = ").append(entry.getMagnitude());
            sb.append(", depth = ").append(entry.getDepth());
            sb.append(", title = ").append(entry.getInfo());
            System.out.println(sb.toString());
        }
    }
    
    public void quakesOfDepth(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedatasmall.atom";
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> quakeData = parser.read(source);
        //dumpCSV(quakeData);
        System.out.println("# quakes read: " + quakeData.size());
        
        double minDepth = -12000.0;
        double maxDepth = -10000.0;
        ArrayList<QuakeEntry> filteredList = filterByDepth(quakeData, minDepth, maxDepth);
        System.out.println("Find quakes with depth between "+minDepth+" and "+maxDepth);
        //printQuakesInfo(filteredList);
        System.out.println("Found "+filteredList.size()+" quakes that match that criteria.");
    
        minDepth = -4000.0;
        maxDepth = -2000.0;
        filteredList = filterByDepth(quakeData, minDepth, maxDepth);
        System.out.println("Find quakes with depth between "+minDepth+" and "+maxDepth);
        //printQuakesInfo(filteredList);
        System.out.println("Found "+filteredList.size()+" quakes that match that criteria.");
    }
    
    public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData, String where, String phrase){
        ArrayList<QuakeEntry> filteredQuakes = new ArrayList<>();
        boolean shouldAdd;
        
        for(QuakeEntry quake: quakeData){
            shouldAdd = false;
            String title = quake.getInfo();
            if(where.equals("start")){
                shouldAdd = title.startsWith(phrase);
            }
            else if(where.equals("end")){
                shouldAdd = title.endsWith(phrase);
            }
            else {
                shouldAdd = title.contains(phrase);
            }
            if(shouldAdd){
                filteredQuakes.add(quake);
            }
        }
        return filteredQuakes;
    }
    
    public void quakesByPhrase(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedatasmall.atom";
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> quakeData = parser.read(source);
        //dumpCSV(quakeData);
        System.out.println("#read data for: " + quakeData.size());
        
        ArrayList<QuakeEntry> filteredQuakes;
        
        String where;
        String phrase;
        
        where = "any";
        phrase = "Can";
        filteredQuakes = filterByPhrase(quakeData, where, phrase);
        /*for(QuakeEntry quake: filteredQuakes){
            System.out.println(quake);
        }*/
        System.out.println("Found "+filteredQuakes.size()+" quakes that match "+phrase+" at "+where);
        
        System.out.println();
        where = "end";
        phrase = "Alaska";
        filteredQuakes = filterByPhrase(quakeData, where, phrase);
        /*for(QuakeEntry quake: filteredQuakes){
            System.out.println(quake);
        }*/
        System.out.println("Found "+filteredQuakes.size()+" quakes that match "+phrase+" at "+where);
        
        System.out.println();
        where = "start";
        phrase = "Quarry Blast";
        filteredQuakes = filterByPhrase(quakeData, where, phrase);
        /*for(QuakeEntry quake: filteredQuakes){
            System.out.println(quake);
        }*/
        System.out.println("Found "+filteredQuakes.size()+" quakes that match "+phrase+" at "+where);
        
    }
}