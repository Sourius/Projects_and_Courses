import java.util.*;
import edu.duke.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }
    
    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe);
            } 
        } 

        return answer;
    }
    
    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedatasmall.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        /*Filter f = new MinMagFilter(4.0); 
        ArrayList<QuakeEntry> m7  = filter(list, f); 
        for (QuakeEntry qe: m7) { 
        System.out.println(qe);
        }*/
        /*
        MagnitudeFilter mf = new MagnitudeFilter(4.0, 5.0);
        DepthFilter df = new DepthFilter(-35000.0, -12000.0);
         */
        Location denvar = new Location(39.7392, -104.9903);
        DistanceFilter df = new DistanceFilter(denvar, 1000000 , "Distance");
        PhraseFilter pf = new PhraseFilter("end","a", "Phrase");
        
        boolean satisfies;
        int howMany = 0;
        for(QuakeEntry quake: list){
            //satisfies = mf.satisfies(quake) && df.satisfies(quake);
            satisfies = df.satisfies(quake) && pf.satisfies(quake);
            if(satisfies){
                //System.out.println(quake);
                howMany++;
            }
        }
        System.out.println("Found "+howMany+" earthquakes that match the criteria");
        
        MagnitudeFilter mf = new MagnitudeFilter(3.5, 4.5, "Magnitude");
        DepthFilter df2 = new DepthFilter(-55000.0, -20000.0,"Depth");
        howMany = 0;
        for(QuakeEntry quake: list){
            //satisfies = mf.satisfies(quake) && df.satisfies(quake);
            satisfies = mf.satisfies(quake) && df2.satisfies(quake);
            if(satisfies){
                //System.out.println(quake);
                howMany++;
            }
        }
        System.out.println("Found "+howMany+" earthquakes that match the criteria");
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
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
    
    public void testMatchAllFilter(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        
        ArrayList<QuakeEntry> list  = parser.read(source);
        //dumpCSV(list);
        System.out.println("# Total number of earthquakes: "+list.size());
        
        MatchAllFilters maf = new MatchAllFilters();
        maf.addFilter(new MagnitudeFilter(1.0, 4.0, "Magnitude"));
        maf.addFilter(new DepthFilter(-180000.0 , -30000.0 , "Depth"));
        maf.addFilter(new PhraseFilter("any","o", "Phrase"));
        
        ArrayList<QuakeEntry> quakes = filter(list,maf);
        /*for(QuakeEntry quake: quakes){
            System.out.println(quake);
        }*/
        System.out.println("# Number of earthquakes that match: "+quakes.size());    
        System.out.println("Used filters: "+maf.getName());
    }
    
    public void testMatchAllFilter2(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        
        ArrayList<QuakeEntry> list  = parser.read(source);
        //dumpCSV(list);
        System.out.println("# Total number of earthquakes: "+list.size());
        
        MatchAllFilters maf = new MatchAllFilters();
        maf.addFilter(new MagnitudeFilter(0.0, 5.0, "Magnitude"));
        Location billund = new Location(55.7308, 9.1153);
        maf.addFilter(new DistanceFilter(billund, 3000000, "Distance"));
        maf.addFilter(new PhraseFilter("any","e", "Phrase"));
        
        ArrayList<QuakeEntry> quakes = filter(list,maf);
        /*for(QuakeEntry quake: quakes){
            System.out.println(quake);
        }*/
        System.out.println("# Number of earthquakes that match: "+quakes.size());    
        System.out.println("Used filters: "+maf.getName());
    }
}