/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyBirths {
    public void totalBirths(FileResource fr){
        int totalBirth = 0;
        int totalBoysName = 0;
        int totalGirlsName = 0;
        for(CSVRecord record:  fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(record.get(2));
            totalBirth += numBorn;
            if(record.get(1).equals("M")){
                totalBoysName++;
            }
            else{
                totalGirlsName++;
            }
        }
        System.out.println("total births = "+ totalBirth);
        System.out.println("total boys name is:  " + totalBoysName);
        System.out.println("total girls name is " + totalGirlsName);
    }

    public int getRank(int year, String name, String gender){
        FileResource fr = new FileResource("../data/yob"+year+".csv");
        int rank = 0;
        for(CSVRecord record: fr.getCSVParser(false)){
            String thisName = record.get(0);
            String thisGender = record.get(1);
            if(!thisGender.equals(gender)){
                continue;
            }
            else{
                rank++;
                if(thisName.equals(name)){
                    return rank;
                }
                else{
                    continue;
                }
            }
        }
        return -1;
    }

    public int getRank2(int year, String name, String gender, File f){
        FileResource fr = new FileResource(f);
        int rank = 0;
        for(CSVRecord record: fr.getCSVParser(false)){
            String thisName = record.get(0);
            String thisGender = record.get(1);
            if(!thisGender.equals(gender)){
                continue;
            }
            else{
                rank++;
                if(thisName.equals(name)){
                    return rank;
                }
                else{
                    continue;
                }
            }
        }
        return -1;
    }

    public String getName(int year, int rank, String gender){
        FileResource fr = new FileResource("../data/yob"+year+".csv");
        int thisRank = 0;
        for(CSVRecord record : fr.getCSVParser(false)){
            String thisGender = record.get(1);
            if(!thisGender.equals(gender)){
                continue;
            }
            else{
                thisRank++;
                if(thisRank == rank){
                    return record.get(0);
                }
                else{
                    continue;
                }
            }
        }
        return "NO NAME";
    }

    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        int rank = getRank(year, name, gender);
        if(rank == -1){
            System.out.println("not such name exist!");
        }
        String newName = getName(newYear, rank, gender);
        System.out.println(name + " born in " + year + " would be "+ newName + " if she was born in " + newYear + ".");

    }

    public int yearOfHighestRank(String name, String gender){
        int highestRank = 0;
        int yearWithHighestRank = 0;
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
            String filename = f.getName();
            //System.out.println("the file we select is: "+ filename);
            int year = Integer.parseInt(filename.substring(3,7));
            int rank = getRank2(year, name, gender,f);
            //System.out.println("the rank of year "+ year + " is "+ rank);
            if(rank == -1){
                continue;
            }
            if(highestRank == 0){
                highestRank = rank;
                yearWithHighestRank = year;
            }
            else{
                if(rank < highestRank){
                    highestRank = rank;
                    yearWithHighestRank = year;
                }
                else{
                    continue;
                }
            }
        }

        if(highestRank == 0){
            return -1;
        }
        else{
            return yearWithHighestRank;
        }
    }

    public double getAverageRank(String name, String gender){
        int totalRank = 0;
        int count = 0;
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
            String filename = f.getName();
            //System.out.println("the file we select is: "+ filename);
            int year = Integer.parseInt(filename.substring(3,7));
            int rank = getRank2(year, name, gender,f);
            //System.out.println("the rank of year "+ year + " is "+ rank);
            if(rank == -1){
                continue;
            }
            else {
                totalRank += rank;
                count++;
            }
        }
        if(count == 0){
            return -1;
        }
        else{
            return (double)totalRank/count;
        }
    }

    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        int theRank = getRank(year,name,gender);
        int qualifyTotalBirth = 0;
        FileResource fr = new FileResource("../data/yob"+year+".csv");
        for(CSVRecord record: fr.getCSVParser()){
            String thisName = record.get(0);
            String thisGender = record.get(1);
            int totalbirthOfName = Integer.parseInt(record.get(2));
            if(!thisGender.equals(gender)){
                continue;
            }
            else {
                if(!thisName.equals(name)) {
                    qualifyTotalBirth += totalbirthOfName;
                }
                else{
                    return qualifyTotalBirth;
                }
            }
        }
        return -1;
    }

    public void testTotalBirths(){
        FileResource fr ;
        
        System.out.println("1900:");
        fr = new FileResource(new File("../data/yob1900.csv"));
        totalBirths(fr);
        
        System.out.println("1905:");
        fr = new FileResource(new File("../data/yob1905.csv"));
        totalBirths(fr);
        
        System.out.println("Emily 1960 rank: "+getRank(1960, "Emily", "F"));
        System.out.println("Frank 1971 rank: "+getRank(1971, "Frank", "M"));
        
        System.out.println("Girls name of rank 350 in 1980: "+getName(1980, 350, "F"));
        System.out.println("Boys name of rank 450 in 1982: "+getName(1982, 450, "M"));
        
        whatIsNameInYear("Susan", 1972, 2014, "F");
        whatIsNameInYear("Owen", 1974, 2014, "M");
        
        System.out.println(yearOfHighestRank("Genevieve", "F"));
        System.out.println(yearOfHighestRank("Mich", "M"));
        
        System.out.println(getAverageRank("Susan","F"));
        System.out.println(getAverageRank("Robert","M"));
        
        System.out.println(getTotalBirthsRankedHigher(1990, "Emily", "F"));
        System.out.println(getTotalBirthsRankedHigher(1990, "Drew", "M"));
    }
    
    public void testYearOgHR(){
        System.out.println(yearOfHighestRank("Genevieve", "F"));
        System.out.println(yearOfHighestRank("Mich", "M"));
    }
    
    public void testAvgRank(){
        System.out.println(getAverageRank("Susan","F"));
        System.out.println(getAverageRank("Robert","M"));
    }
    
    public void testTotalBirthsRH(){
        System.out.println(getTotalBirthsRankedHigher(1990, "Emily", "F"));
        System.out.println(getTotalBirthsRankedHigher(1990, "Drew", "M"));
    }
}
