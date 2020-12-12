
/**
 * Write a description of DepthFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DepthFilter implements Filter{
    private double min;
    private double max;
    private String name;
    
    public DepthFilter(double min, double max, String name){
        this.min = min;
        this.max = max;
        this.name = name;
    }
    
    public  boolean satisfies(QuakeEntry qe){
        double depth = qe.getDepth();
        return min <= depth && depth <= max;
    }
    
    public String getName(){
        return name;
    }
}
