
/**
 * Write a description of PhraseFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhraseFilter implements Filter{
    private String where;
    private String phrase;
    private String name;
    
    public PhraseFilter(String where, String phrase, String name){
        this.where = where;
        this.phrase = phrase;
        this.name = name;
    }
    
    public boolean satisfies(QuakeEntry qe){
        String title = qe.getInfo();
        boolean satisfies;
        if(where.equals("start")){
            satisfies = title.startsWith(phrase);
        }
        else if(where.equals("end")){
            satisfies = title.endsWith(phrase);
        }
        else {
            satisfies = title.contains(phrase);
        }
        return satisfies;
    }
    
    public String getName(){
        return name;
    }
}
