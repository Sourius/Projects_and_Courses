import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;

public class Weather {
    public CSVRecord hottestHourInFile(CSVParser parser){
        CSVRecord largestSoFar = null;
            
        for(CSVRecord currentRow: parser){
            largestSoFar= maxTemp(currentRow,largestSoFar);
        }
        
        return largestSoFar;
    }
    
    private CSVRecord maxTemp(CSVRecord current, CSVRecord largest){
        if(largest == null){
            return current;
        }
        /*ignore bugs*/
        double currentTemp = Double.parseDouble(current.get("TemperatureF"));
        if(currentTemp == -9999) return largest;
        double largestTemp = Double.parseDouble(largest.get("TemperatureF"));
        if(largestTemp == -9999) return current;
        /*return maximum*/
        if(currentTemp > largestTemp){
            return current;
        }
        return largest;
    }
    
    public CSVRecord hottestInManyDays(){
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord current = hottestHourInFile(fr.getCSVParser());
            largestSoFar= maxTemp(current,largestSoFar);
        }
        return largestSoFar;
    }
    
    public void testHottestInDay(){
        FileResource fr = new FileResource();
        CSVRecord largest = hottestHourInFile(fr.getCSVParser());
        System.out.print("hottest temperature was "+largest.get("TemperatureF"));
        System.out.println(" at "+largest.get("TimeEST"));
    }
    
    public void testHottestInManyDays(){
        CSVRecord largest = hottestInManyDays();
        System.out.print("hottest temperature was: "+largest.get("TemperatureF"));
        System.out.println(" at "+largest.get("DateUTC"));
    }
    
    private CSVRecord minTemp(CSVRecord current, CSVRecord coldest){
        if(coldest == null){
            return current;
        }
        /*ignore bugs*/
        double currentTemp = Double.parseDouble(current.get("TemperatureF"));
        if(currentTemp == -9999) return coldest;
        double coldestTemp = Double.parseDouble(coldest.get("TemperatureF"));
        if(coldestTemp == -9999) return current;
        /*return minimum*/
        if(currentTemp < coldestTemp){
            return current;
        }
        return coldest;
    }
    
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldest = null;
        for(CSVRecord current: parser){
            coldest= minTemp(current,coldest);
        }
        return coldest;
    }
    
    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.print("coldest temperature was "+coldest.get("TemperatureF"));
        try{
            System.out.println(" at "+coldest.get("TimeEST"));
        } catch(Exception e){
            System.out.println(" at "+coldest.get("TimeEDT"));
        }
    }
    
    public String fileWithColdestTemp(){
        CSVRecord coldest = null;
        File fileWithColdestTemp = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord current = coldestHourInFile(fr.getCSVParser());
            coldest= minTemp(current,coldest);
            if(coldest == current) fileWithColdestTemp = f;
        }
        return fileWithColdestTemp.getName();
    }
    
    public void testFileWithColdestTemp(){
        String coldestTempFile = fileWithColdestTemp();
        FileResource fr = new FileResource("../nc_weather/2013/"+coldestTempFile);
        
        CSVParser parser = fr.getCSVParser();
        CSVRecord coldest = coldestHourInFile(parser);
        
        System.out.println("coldest day was in file "+coldestTempFile);
        System.out.println("coldest temperature was: "+coldest.get("TemperatureF"));
        System.out.println("All the temperatures on the coldest day were:");
        
        parser = fr.getCSVParser();
        for(CSVRecord currentTemp: parser){
            System.out.print(currentTemp.get("DateUTC"));
            System.out.println(" "+currentTemp.get("TemperatureF"));
        }
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowest = null;
        for(CSVRecord current: parser){
            lowest = minHumidity(current,lowest);
        }
        return lowest;
    }
    
    private CSVRecord minHumidity(CSVRecord current, CSVRecord lowest){
        if(lowest == null){
            return current;
        }
        /*ignore bugs*/
        String currHumString = current.get("Humidity");
        if(currHumString.equals("N/A")) return lowest;
        String lowHumString = lowest.get("Humidity");
        if(lowHumString.equals("N/A")) return current;
        /*return minimum*/
        int currHumidity = Integer.parseInt(currHumString);
        int lowHumidity = Integer.parseInt(lowHumString);
        if(currHumidity < lowHumidity){
            return current;
        }
        return lowest;
    }
    
    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.print("lowest humidity was "+csv.get("Humidity"));
        System.out.println(" at "+csv.get("DateUTC"));
    }
    
    public CSVRecord lowestHumidityInManyFiles(){
        CSVRecord lowest = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord current = lowestHumidityInFile(fr.getCSVParser());
            lowest = minHumidity(current,lowest);
        }
        return lowest;
    }
    
    public void testLowestHumidityInManyFiles(){
        CSVRecord lowest = lowestHumidityInManyFiles();
        System.out.print("lowest humidity was "+lowest.get("Humidity"));
        System.out.println(" at "+lowest.get("DateUTC"));
    }
    
    public double averageTempInFile(CSVParser parser){
        double avgTemp = 0;
        double sumTemp = 0;
        double temp = 0;
        double total = 0;
        for(CSVRecord current: parser){
            temp = Double.parseDouble(current.get("TemperatureF"));
            if(temp != -9999){
                sumTemp += temp;
                total++;
            }
        }
        avgTemp = sumTemp / total;
        return avgTemp;
    }
    
    public void testAverageTempInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        Double avg = averageTempInFile(parser);
        System.out.println("Average temperature in file is "+avg);
    }
    
    public double avgTempWithHumidityInFile(CSVParser parser, int value){
        double avgTemp = 0;
        double sumTemp = 0;
        double temp = 0;
        double total = 0;
        for(CSVRecord current: parser){
            temp = Double.parseDouble(current.get("TemperatureF"));
            
            String currHumString = current.get("Humidity");
            if(currHumString.equals("N/A")) continue;
            int currHumidity = Integer.parseInt(currHumString);
            
            if(temp != -9999 && currHumidity >= value){
                sumTemp += temp;
                total++;
            }
        }
        avgTemp = sumTemp/total;
        return avgTemp;
    }
    
    public void testAvgTempWithHumidity(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        int value = 80;
        double avg = avgTempWithHumidityInFile(parser,value);
        if(avg > 0) System.out.println("Average temp when high humidity is "+avg);
        else System.out.println("No temperatures with that humidity");
    }
}