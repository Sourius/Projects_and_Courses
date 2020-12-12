import java.util.*;
/**
 * Write a description of MatchAllFilters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MatchAllFilters implements Filter{
    private ArrayList<Filter> filters;
    
    public MatchAllFilters(){
        filters = new ArrayList<>();
    }
    
    public boolean satisfies(QuakeEntry qe){
        int n = 0;
        for(Filter f: filters){
            if(f.satisfies(qe)) n++;
        }
        return n == filters.size();
    }
    
    public void addFilter(Filter f){
        filters.add(f);
    }
    
    public String getName(){
        StringBuilder sb = new StringBuilder();
        for(Filter f: filters){
            sb.append(f.getName()).append(" ");
        }
        return sb.toString();
    }
}
