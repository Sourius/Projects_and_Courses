/**
 * Write a description of GenreFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GenreFilter implements Filter{
    private String genre;
    
    public GenreFilter(String genre){
        this.genre = genre;
    }
    
    public boolean satisfies(String id){
        String movieGenres = MovieDatabase.getGenres(id);
        return movieGenres.contains(genre);
    }
}