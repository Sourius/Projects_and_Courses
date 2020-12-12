/**
 * Write a description of MovieRunnerWithFilters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MovieRunnerWithFilters {
    public void printAverageRatings(Filter filter){
        String moviefile = "ratedmovies_short.csv";
        String ratingsfile = "data/ratings_short.csv";
        
        ThirdRatings tr = new ThirdRatings(ratingsfile);
        System.out.println("Raters: "+tr.getRaterSize());
        MovieDatabase.initialize(moviefile);
        System.out.println("Movies: "+MovieDatabase.size());
        
        int minimalRaters = 1;
        ArrayList<Rating> avgRatings =  tr.getAverageRatingsByFilter(minimalRaters, filter);
        System.out.println("AvgRated movies: "+avgRatings.size());
        Collections.sort(avgRatings);
        
        StringBuilder sb = new StringBuilder();
        for(Rating r: avgRatings) {
            sb.append(r.getValue()).append(" ");
            sb.append(MovieDatabase.getTitle(r.getItem()));
            sb.append("\n\tGenres:");
            sb.append(MovieDatabase.getGenres(r.getItem()));
            sb.append("\n\tDirectors: ");
            sb.append(MovieDatabase.getDirector(r.getItem()));
            sb.append("\n\tYear:");
            sb.append(MovieDatabase.getYear(r.getItem()));
            sb.append("\n\tTime: ");
            sb.append(MovieDatabase.getMinutes(r.getItem()));
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    public void printAverageRatings(){
        printAverageRatings(new TrueFilter());
    }
    
    public void printAverageRatingsByYear(){
        int year = 2000;
        Filter filter = new YearAfterFilter(year);
        printAverageRatings(filter);
    }
    
    public void printAverageRatingsByGenre(){
        String genre = "Crime";
        Filter filter = new GenreFilter(genre);
        printAverageRatings(filter);
    }
    
    public void printAverageRatingsByMinutes(){
        int min = 110;
        int max = 170;
        Filter filter = new MinutesFilter(min, max);
        printAverageRatings(filter);
    }
    
    public void printAverageRatingsByDirectors(){
        String directors = "Charles Chaplin,Michael Mann,Spike Jonze";
        Filter filter = new DirectorsFilter(directors);
        printAverageRatings(filter);
    }
    
    public void printAverageRatingsByYearAfterAndGenre(){
        AllFilters filter = new AllFilters();
        filter.addFilter(new YearAfterFilter(1980));
        filter.addFilter(new GenreFilter("Romance"));
        printAverageRatings(filter);
    }
    
    public void printAverageRatingsByDirectorsAndMinutes(){
        AllFilters filter = new AllFilters();
        filter.addFilter(new MinutesFilter(30,170));
        filter.addFilter(new DirectorsFilter("Spike Jonze,Michael Mann,Charles Chaplin,Francis Ford Coppola"));
        printAverageRatings(filter);
    }
}
