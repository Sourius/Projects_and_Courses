/**
 * Write a description of MovieRunnerSimilarRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MovieRunnerSimilarRatings {
    private void initializeDatabase(){
        String moviefile = "ratedmovies_short.csv";
        String ratingsfile = "ratings_short.csv";
        RaterDatabase.initialize(ratingsfile);
        MovieDatabase.initialize(moviefile);
    }
    
    private void initializeDatabase2(){
        String moviefile = "ratedmoviesfull.csv";
        String ratingsfile = "ratings.csv";
        RaterDatabase.initialize(ratingsfile);
        MovieDatabase.initialize(moviefile);
    }
    
    private void printMoviesInfo(ArrayList<Rating> ratings){
        StringBuilder sb = new StringBuilder();
        for(Rating r: ratings) {
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
    
    private void printAverageRatings(Filter filter){
        initializeDatabase();
        FourthRatings fr = new FourthRatings();
        System.out.println("Raters: "+RaterDatabase.size());
        System.out.println("Movies: "+MovieDatabase.size());
        int minimalRaters = 1;
        
        ArrayList<Rating> avgRatings =  fr.getAverageRatingsByFilter(minimalRaters, filter);
        System.out.println("AvgRated movies: "+avgRatings.size());
        Collections.sort(avgRatings);
        printMoviesInfo(avgRatings);
    }
    
    public void printAverageRatings(){
        printAverageRatings(new TrueFilter());        
    }

    public void printAverageRatingsByYearAfterAndGenre(){
        AllFilters filter = new AllFilters();
        filter.addFilter(new YearAfterFilter(1980));
        filter.addFilter(new GenreFilter("Romance"));
        printAverageRatings(filter);
    }
    
    public void printSimilarRatings(){
        Filter filter = new TrueFilter();
        printSimilarRatingsByFilter(filter);
    }
    
    private void printSimilarRatingsByFilter(Filter filter){
        FourthRatings fr = new FourthRatings();
        initializeDatabase2();
        String raterID = "65";
        int numSimilarRaters = 20;
        int minimalRaters = 5;
        ArrayList<Rating> ratings = fr.getSimilarRatingsByFilter(raterID, numSimilarRaters, minimalRaters, filter);
        System.out.println("Recommended movies:");
        printMoviesInfo(ratings);
    }
    
    private void printSimilarRatings(Filter filter, String raterID, int numSimilarRaters, int minimalRaters){
        FourthRatings fr = new FourthRatings();
        initializeDatabase2();
        ArrayList<Rating> ratings = fr.getSimilarRatingsByFilter(raterID, numSimilarRaters, minimalRaters, filter);
        System.out.println("Recommended movies:");
        printMoviesInfo(ratings);
    }
    
    public void printSimilarRatingsByGenre(){
        Filter filter = new GenreFilter("Action");
        String raterID = "65";
        int numSimilarRaters = 20;
        int minimalRaters = 5;
        printSimilarRatings(filter, raterID, numSimilarRaters, minimalRaters);
    }
    
    public void printSimilarRatingsByDirector(){
        Filter filter = new DirectorsFilter("Clint Eastwood,Sydney Pollack,David Cronenberg,Oliver Stone");
        String raterID = "1034";
        int numSimilarRaters = 10;
        int minimalRaters = 3; 
        printSimilarRatings(filter, raterID, numSimilarRaters, minimalRaters);
    }
    
    public void printSimilarRatingsByGenreAndMinutes(){
        AllFilters filter = new AllFilters();
        filter.addFilter(new GenreFilter("Adventure"));
        filter.addFilter(new MinutesFilter(100,200));
        String raterID = "65";
        int numSimilarRaters = 10;
        int minimalRaters = 5;
        printSimilarRatings(filter, raterID, numSimilarRaters, minimalRaters);
    }
    
    public void printSimilarRatingsByYearAndMinutes(){
        AllFilters filter = new AllFilters();
        filter.addFilter(new YearAfterFilter(2000));
        filter.addFilter(new MinutesFilter(80,100));
        String raterID = "65";
        int numSimilarRaters = 10;
        int minimalRaters = 5;
        printSimilarRatings(filter, raterID, numSimilarRaters, minimalRaters);
    }
}