/**
 * Write a description of FourthRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class FourthRatings {
    private double getAverageByID(String id, int minimalRaters){
        double sum = 0;
        int numRaters = 0;
        for(Rater r: RaterDatabase.getRaters()){
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
    
    private double dotProduct(Rater me, Rater r){
        double dotProduct = 0;
        for(String item: me.getItemsRated()){
            if(r.hasRating(item)){
                double rating = r.getRating(item) - 5;
                double myRating = me.getRating(item) - 5;
                dotProduct += myRating * rating;
            }
        }
        return dotProduct;
    }
    
    //returns similiar ratersID
    private ArrayList<Rating> getSimilarities(String id){
        ArrayList<Rating> raters = new ArrayList<>();
        Rater rater = RaterDatabase.getRater(id);
        for(Rater r: RaterDatabase.getRaters()){
            if(!r.getID().equals(id)){
                Double dotProduct = dotProduct(rater, r);
                if(dotProduct > 0){
                    raters.add(new Rating(r.getID(), dotProduct));
                }
            }
        }
        Collections.sort(raters, Collections.reverseOrder());
        return raters;
    }
    
    public ArrayList<Rating> getSimilarRatings(String id, int numSimilarRaters, int minimalRaters){
        return getSimilarRatingsByFilter(id, numSimilarRaters, minimalRaters, new TrueFilter());
    }
    
    public ArrayList<Rating> getSimilarRatingsByFilter(String id, int numSimilarRaters, int minimalRaters, Filter filterCriteria){
        ArrayList<Rating> similarRatings = new ArrayList<>();
        ArrayList<Rating> similarRaters = getSimilarities(id);
        
        //set with names of movies
        Set<String> ratedMovies = new HashSet<>();

        for(int i = 0; i < numSimilarRaters; i++){
            String raterID = similarRaters.get(i).getItem();
            Rater rater = RaterDatabase.getRater(raterID);
            for(String movieID: rater.getItemsRated()){
                if(filterCriteria.satisfies(movieID)){
                    ratedMovies.add(movieID);
                }
            }
        }
        
        for(String movieID: ratedMovies){
            double avg = 0;
            double sum = 0;
            int howMany = 0;
            
            for(int i = 0; i < numSimilarRaters; i++){
                String raterID = similarRaters.get(i).getItem();
                Rater rater = RaterDatabase.getRater(raterID);
                
                if(rater.hasRating(movieID)){
                    double weight = similarRaters.get(i).getValue();
                    double movieRating = rater.getRating(movieID);
                    sum += weight * movieRating;
                    howMany++;
                }
            }
            if(howMany >= minimalRaters){
                avg = (Math.round((sum / howMany)*100.00))/100.00;
                if(avg > 0){
                    similarRatings.add(new Rating(movieID, avg));
                }
            }
        }
        
        Collections.sort(similarRatings, Collections.reverseOrder());
        return similarRatings;
    }
}