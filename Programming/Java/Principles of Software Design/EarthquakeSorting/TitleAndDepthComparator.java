import java.util.*;

/**
 * sorts QuakeEntry by title and depth:
 *      sorts by title 
 *      and by depth if the titles match
 *
 *@author sourius 
 * @version 1.0
 */
public class TitleAndDepthComparator implements Comparator<QuakeEntry> {
    @Override
    public int compare(QuakeEntry q1 , QuakeEntry q2){
        int cmp = q1.getInfo().compareTo(q2.getInfo());
        if(cmp == 0){
            return Double.compare(q1.getDepth(), q2.getDepth());
        }
        return cmp;
    }
}
