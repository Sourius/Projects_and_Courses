import java.util.*;
/**
 * Write a description of TitleLastAndMagnitudeComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
    @Override
    public int compare(QuakeEntry q1, QuakeEntry q2){
        /*
        String[] aux = q1.getInfo().split(" ");
        String t1 = aux[aux.length-1];
        aux = q1.getInfo().split(" ");
        String t2 = aux[aux.length-1];
        */
        String t1 = q1.getInfo();
        //String lastWordt1 = new StringBuilder(t1).reverse().toString();
        String lastWordt1 = t1.substring(t1.lastIndexOf(" ")+1);
        String t2 = q2.getInfo();
        //String lastWordt2 = new StringBuilder(t2).reverse().toString();
        String lastWordt2 = t2.substring(t2.lastIndexOf(" ")+1);
        
        int cmp = lastWordt1.compareTo(lastWordt2);
        if(cmp != 0){
            return cmp;
        }
        return Double.compare(q1.getMagnitude(), q2.getMagnitude());
    }
}
