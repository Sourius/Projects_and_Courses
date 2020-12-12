
/**
 * Write a description of DistanceFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DistanceFilter implements Filter{
    private Location location;
    private float max;
    private String name;
    
    public DistanceFilter(Location loc, float max, String name){
        location = loc;
        this.max = max;
        this.name = name;
    }
    
    public boolean satisfies(QuakeEntry qe){
        Location loc = qe.getLocation();
        float distance = location.distanceTo(loc);
        return  distance < max;
    }
    
    public String getName(){
        return name;
    }
}
