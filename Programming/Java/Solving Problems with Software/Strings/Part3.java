
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb){
        int index;
        index = stringb.indexOf(stringa);
        if(index != -1){
            index = stringb.indexOf(stringa, index+3);
            return (index != -1);
        }
        return false;
    }
    public String lastPart(String stringa, String stringb){
        int index = stringb.indexOf(stringa);
        if(index != -1){
            int start = index+stringa.length();
            if(start < stringb.length()-1) 
                return stringb.substring(start).trim();
            else return "";
        }
        else return stringb;
    }
    public void testing(){
        System.out.println("Testing twoOccurrences");
        String pair1a, pair1b;
        pair1a = "atg";
        pair1b = "ctgtatgta";
        System.out.println("Pair1: a= "+pair1a+" ,b= "+pair1b);
        System.out.println("Does b have 2 occurrences of a? "+twoOccurrences(pair1a,pair1b));
        
        String pair2a, pair2b;
        pair2a = "by";
        pair2b = "A story by Abby Long";
        System.out.println("Pair2: a= "+pair2a+" ,b= "+pair2b);
        System.out.println("Does b have 2 occurrences of a? "+twoOccurrences(pair2a,pair2b));
        
        System.out.println();
        
        System.out.println("Testing lastPart");
        pair1a = "an";
        pair1b = "banana";
        System.out.println("Pair1: a= "+pair1a+" ,b= "+pair1b);
        System.out.println("Last part of b: "+lastPart(pair1a,pair1b));        
        pair2a = "zoo";
        pair2b = "forest";
        System.out.println("Pair2: a= "+pair2a+" ,b= "+pair2b);
        System.out.println("Last part of b: "+lastPart(pair2a,pair2b));
    }
}
