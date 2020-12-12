
/**
 * Write a description of MovieRunnerAverage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MovieRunnerAverage { 
    public void printAverageRatings(){
        String moviefile = "data/ratedmovies_short.csv";
        String ratingsfile = "data/ratings_short.csv";
        SecondRatings sr = new SecondRatings(moviefile, ratingsfile);
        //SecondRatings sr = new SecondRatings();
        System.out.println("Movies: "+sr.getMovieSize());
        System.out.println("Raters: "+sr.getRaterSize());
        int minimalRaters = 3;
        ArrayList<Rating> avgRatings =  sr.getAverageRatings(minimalRaters);
        Collections.sort(avgRatings);
        for(Rating r: avgRatings){
            System.out.println(r.getValue()+" "+sr.getTitle(r.getItem()));
        }
    }
    
    public void getAverageRatingOneMovie(){
        String moviefile = "data/ratedmovies_short.csv";
        String ratingsfile = "data/ratings_short.csv";
        SecondRatings sr = new SecondRatings(moviefile, ratingsfile);
        //SecondRatings sr = new SecondRatings();
        System.out.println("Movies: "+sr.getMovieSize());
        System.out.println("Raters: "+sr.getRaterSize());
        String title = "The Godfather";
        String id = sr.getID(title);
        if(!id.equals("NO SUCH TITLE"))
            System.out.println(title+" "+sr.getAverageRating(id));
    }
}