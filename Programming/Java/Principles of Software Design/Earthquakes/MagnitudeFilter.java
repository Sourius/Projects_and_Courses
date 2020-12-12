
/**
 * Write a description of MagnitudeFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagnitudeFilter implements Filter{
    private double min;
    private double max;
    private String name;
    
    public MagnitudeFilter(double min, double max, String name){
        this.min = min;
        this.max = max;
        this.name = name;
    }
    
    public  boolean satisfies(QuakeEntry qe){
        double magnitude = qe.getMagnitude();
        return magnitude >= min && magnitude <= max;
    }
    
    public String getName(){
        return name;
    }
}
