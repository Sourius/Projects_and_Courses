
/**
 * Write a description of MinutesFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinutesFilter implements Filter{
    int minMinutes;
    int maxMinutes;
    
    public MinutesFilter(int min, int max){
        minMinutes = min;
        maxMinutes = max;
    }
    
    public boolean satisfies(String id){
        int movieMinutes = MovieDatabase.getMinutes(id);
        return movieMinutes >= minMinutes && movieMinutes <= maxMinutes;
    }
}
