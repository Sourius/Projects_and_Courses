/**
 * Write a description of DirectorsFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DirectorsFilter implements Filter{
    private String[] directors;
    
    public DirectorsFilter(String directors){
        this.directors = directors.split(",");
    }
    
    public boolean satisfies(String id){
        String movieDirectors = MovieDatabase.getDirector(id);
        for(String director: directors) {
            if(movieDirectors.contains(director)) return true;
        }
        return false;
    }
}
