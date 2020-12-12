import edu.duke.*;
import org.apache.commons.csv.*;
public class WhichCountryExports {
    public StorageResource listExporters(CSVParser parser, String interest){
        String export;
        StorageResource sr = new StorageResource();
        for(CSVRecord record: parser){
            export = record.get("Exports");
            if(export.contains(interest)){
                sr.add(record.get("Country"));
            }
        }
        return sr;
    }
    
    public void countryInfo(CSVParser parser, String countryName){
        String country, exports, value;
        for(CSVRecord record: parser){
            country = record.get("Country");
            if(country.equals(countryName)){
                exports = record.get("Exports");
                value = record.get("Value (dollars)");
                System.out.println(countryName+": "+exports+": "+value);
            }
        }
    }
    
    public void listExportersTwoProducts(CSVParser parser, String item1, String item2){
        String country, exports;
        for(CSVRecord record: parser){
            country = record.get("Country");
            exports = record.get("Exports");
            
            if(exports.contains(item1) && exports.contains(item2)){
                System.out.println(country);
            }
        }
    }
    
    public void whoExportsCoffee(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        String interest = "coffee";
        
        StorageResource sr = listExporters(parser,interest);
        
        for(String s: sr.data()){
            System.out.println(s);
        }
    }
    
    public int numberOfExporters(CSVParser parser, String item){
        StorageResource sr = listExporters(parser,item);
        return sr.size();
    }
    
    public void bigExporters(CSVParser parser, String minValue){
        String country, value;
        
        for(CSVRecord record: parser){
            country = record.get("Country");
            value = record.get("Value (dollars)");
            
            if(value.length() > minValue.length()){
                System.out.println(country+" "+value);
            }
        }
    }
    
    public void test(){
        FileResource fr = new FileResource();
        CSVParser parser;
        
        parser = fr.getCSVParser();
        String item = "coffee";
        listExporters(parser,item);
        
        String countryName = "Nauru";
        parser = fr.getCSVParser();
        countryInfo(parser,countryName);
        
        String item1 = "gold";
        String item2 = "diamonds";
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, item1, item2);
        
        parser = fr.getCSVParser();
        int numItemExporters = numberOfExporters(parser,"gold");
        System.out.println("Number of exporters of gold: "+numItemExporters);
        
        parser = fr.getCSVParser();
        bigExporters(parser,"$999,999,999,999");
        
    }
    
    /*quiz*/
    public void cottonAndFlowerExporters(){
        FileResource fr = new FileResource();
        CSVParser parser;
        
        parser = fr.getCSVParser();
        String item1 = "cotton";
        String item2 = "flowers";
        listExportersTwoProducts(parser, item1, item2);
    }
    
    public void cocoaExporters(){
        FileResource fr = new FileResource();
        CSVParser parser;
        
        parser = fr.getCSVParser();
        String item = "cocoa";
        int numItemExporters = numberOfExporters(parser,item);
        System.out.println("Number of exporters of cocoa: "+numItemExporters);
    }
    
    public void mostValued(){
        FileResource fr = new FileResource();
        CSVParser parser;
        
        parser = fr.getCSVParser();
        bigExporters(parser,"$999,999,999,999");
    }
}
