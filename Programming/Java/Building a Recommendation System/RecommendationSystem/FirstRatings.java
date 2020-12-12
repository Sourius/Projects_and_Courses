/**
 * Write a description of FirstRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
import java.io.File;
import org.apache.commons.csv.*;
public class FirstRatings {
    private CSVParser getCSVParser(String filename){
        FileResource fr = new FileResource(new File(filename));
        return fr.getCSVParser();
    }
    
    private Movie getMovie(CSVRecord r){
        return new Movie(
            r.get("id"), r.get("title"), r.get("year"),
            r.get("genre"), r.get("director"), r.get("country"),
            r.get("poster"), Integer.parseInt(r.get("minutes"))
        );
    }
    
    public ArrayList<Movie> loadMovies(String filename){
        ArrayList<Movie> movies = new ArrayList<>();
        CSVParser parser = getCSVParser(filename);
        for(CSVRecord record: parser){
            movies.add(getMovie(record));
        }
        return movies;
    }
    
    public void testLoadMovies(){
        //String filename = "data/ratedmovies_short.csv";
        String filename = "data/ratedmoviesfull.csv";
        ArrayList<Movie> movieList = loadMovies(filename);
        int numMovies = movieList.size(); // total number of movies in the file
        Map<String, Integer> map = new HashMap<>(); //number of movies by directors
        
        int comedy = 0; // number of comedy movies
        int longMovies = 0; // number of long movies with minutes higher than 150
        boolean fewMovies = numMovies < 10;
        int mostDirected = 0; // maximum number of movies directed by a diector
        
        for(Movie m: movieList){
            if(fewMovies) System.out.println(m);
            if(m.getGenres().contains("Comedy")) comedy++;
            if(m.getMinutes() > 150) longMovies++;
            String [] directors = m.getDirector().split(",");
            System.out.println(Arrays.toString(directors));
            for(String d: directors){
                d = d.trim();
                //int howMany = map.containsKey(d)? map.get(d) : 0;
                //howMany++;
                int howMany = map.getOrDefault(d, 0) + 1;
                map.put(d, howMany);
                if(mostDirected < howMany) mostDirected = howMany;
            }
        }
        System.out.println("There are "+numMovies+" movies");
        System.out.println("There are "+comedy+" comedy movies");
        System.out.println("There are "+longMovies+" movies with more than 150 minutes");
        System.out.println("Maximum number of movies directed by one person: "+mostDirected);
        System.out.println("Directors with most movies: ");
        for(String d: map.keySet()){
            if(map.get(d) == mostDirected){
                System.out.print(d+", ");
            }
        }
        System.out.println();
    }
    
    public ArrayList<Rater> loadRaters(String filename){
        ArrayList<Rater> raters = new ArrayList<>();
        CSVParser parser = getCSVParser(filename);
        // for each record
        for(CSVRecord r: parser){
            String id = r.get("rater_id").trim();
            Rater rater= new EfficientRater(id);
            // get rater
            int index = raters.indexOf(rater);
            if(index != -1) rater = raters.get(index);
            // add rating
            rater.addRating(r.get("movie_id"), Double.parseDouble(r.get("rating")));
            // add rater
            if(index == -1)raters.add(rater);
        }
        return raters;
    }
    
    public void testLoadRaters(){
        //String filename = "data/ratings_short.csv";
        String filename = "data/ratings.csv";
        ArrayList<Rater> raters = loadRaters(filename);
        
        String movie = "1798709";
        Set<String> movieRaters = new HashSet<>();
        Set<String> diffMovies = new HashSet<>();
        
        int maxRatings = 0;
        for(Rater rater: raters){
            if(raters.size() < 20) System.out.println("Rater: "+rater.getID()+" Ratings: "+rater.numRatings());

            if(rater.numRatings() > maxRatings){
                maxRatings = rater.numRatings(); 
            }
            
            List<String> items = rater.getItemsRated(); 
            for(String item: items){ 
                if(raters.size() < 20){ 
                    Double rating = rater.getRating(item);
                    System.out.println(item+" "+rating);
                }
                if(item.equals(movie)) {
                    movieRaters.add(rater.getID());
                }
                diffMovies.add(item);
            }
        }
        
        System.out.println("Number of raters: "+raters.size());
        System.out.println("Max rating by a user: "+maxRatings);
        System.out.println("Raters with max ratings: ");
        for(Rater rater: raters){
            if(rater.numRatings() == maxRatings){
                System.out.println(rater);
            }
        }
        
        String id = "193";
        int index = raters.indexOf(new EfficientRater(id));
        if(index == -1) System.out.println("Rater "+id+" has 0 ratings");
        else {
            Rater r = raters.get(index);
            System.out.println("Rater "+id+" has "+r.numRatings()+" ratings");
        }
        
        System.out.println("Movie "+movie+" has "+movieRaters.size()+" ratings");
        System.out.println("Unique movies with ratings: "+diffMovies.size());
    }
    
}
