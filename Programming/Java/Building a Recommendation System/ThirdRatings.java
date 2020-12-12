/**
 * Write a description of ThirdRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class ThirdRatings {
    private ArrayList<Rater> myRaters;

    public ThirdRatings() {
        // default constructor
        this("ratings.csv");
    }

    public ThirdRatings(String ratingsfile){
        FirstRatings fr = new FirstRatings();
        myRaters = fr.loadRaters(ratingsfile);
    }

    public int getRaterSize(){
        return myRaters.size();
    }

    private double getAverageByID(String id, int minimalRaters){
        double sum = 0;
        int numRaters = 0;
        for(Rater r: myRaters){
            double rating = r.getRating(id);
            if(rating != -1){
                numRaters++;
                sum += rating;
            }
        }
        double avg = (numRaters < minimalRaters)? 0 : (sum/numRaters);
        return avg;
    }
    
    public ArrayList<Rating> getAverageRatings(int minimalRaters){
        ArrayList<Rating> avgRatings = new ArrayList<>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        for(String id: movies){
            double avg = getAverageByID(id, minimalRaters);
            if(avg != 0){
                Rating r = new Rating(id, avg);
                avgRatings.add(r);
            }
        }
        return avgRatings;
    }
    
    public double getAverageRating(String id){
        return getAverageByID(id,1);
    }
    
    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRatings, Filter filterCriteria){
        ArrayList<Rating> ratings = new ArrayList<>();
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        for(String id : movies){
            double avg = getAverageByID(id, minimalRatings);
            if(avg != 0){
                Rating r = new Rating(id, avg);
                ratings.add(r);
            }   
        }
        return ratings;
    }
}
