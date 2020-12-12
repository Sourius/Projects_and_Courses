/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.URLResource;
public class Part4 {
    private String url = "https://www.dukelearntoprogram.com//course2/data/manylinks.html";
    
    public String getLink(String line){
        String youtubeLink = null;
        String lowerCaseLine = line.toLowerCase();
        int index, linkStart, linkEnd;
        // find index of youtube.com
        index = lowerCaseLine.indexOf("http://www.youtube.com/");
        
        if(index != -1){
            // find index of \" before and after youtube.com
            linkStart = index;
            linkEnd = lowerCaseLine.indexOf("\"", index);
            // return link
            youtubeLink = line.substring(linkStart, linkEnd);
        }
        return youtubeLink;
    }
    
    public void printYoutubeLinks(){
        URLResource ur= new URLResource(url);
        String youtubeLink = null;
        for (String s : ur.lines()) {
            // print or process s
            youtubeLink = null;
            youtubeLink = getLink(s);
            if(youtubeLink != null)
                System.out.println(youtubeLink);
        }
    }
}