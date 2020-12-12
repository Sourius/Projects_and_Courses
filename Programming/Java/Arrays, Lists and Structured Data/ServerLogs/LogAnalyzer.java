import edu.duke.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;
    
    public LogAnalyzer(){
        records = new ArrayList<>();
    }
    
    public void readFile(String filename){
        FileResource fr = new FileResource(new File(filename));
        for(String line: fr.lines()){
            records.add(WebLogParser.parseEntry(line));
        }
    }
    
    public int countUniqueIPs(){
        ArrayList<String> uniqueIPs = new ArrayList<>();
        for(LogEntry log: records){
            String ipAddr = log.getIpAddress();
            if(!uniqueIPs.contains(ipAddr)){
                uniqueIPs.add(ipAddr);
            }
        }
        return uniqueIPs.size();
    }
    
    private String getDateFromLog(String log){
        return log.substring(4,10).trim();
    }
    
    private String getMonthsFromLog(String log){
        return log.substring(4,7).trim();
    }
    
    private int getDaysFromLog(String log){
        return Integer.parseInt(log.substring(8,10));
    }
    
    private boolean compareDayAndMonth(String log, String month, int day){
        String month1 = getMonthsFromLog(log);
        int day1 = getDaysFromLog(log);
        if(month1.equals(month.trim())){
            return day1 == day;
        }
        return false;
    }

    public ArrayList<String> uniqueIPVisitsOnDay(String date){
        ArrayList<String> uniqueVisits = new ArrayList<>();
        String month = date.substring(0,4);
        int day = Integer.parseInt(date.substring(4));
        for(LogEntry log: records){
            String ipAddr = log.getIpAddress();
            String logDate = log.getAccessTime().toString();
            // check date
            if(compareDayAndMonth(logDate.toString(), month, day)){
                if(!uniqueVisits.contains(ipAddr)){
                    uniqueVisits.add(ipAddr);
                }
            }
        }
        return uniqueVisits;
    }
    
    public int countUniqueIPsInRange(int low, int high){
        ArrayList<String> uniqueIPs = new ArrayList<>();
        for(LogEntry log: records){
            String ipAddr = log.getIpAddress();            
            int status = log.getStatusCode();
            if(status >= low && status <= high){
                if(!uniqueIPs.contains(ipAddr)){
                    uniqueIPs.add(ipAddr);
                }
            }
        }
        return uniqueIPs.size();
    }
    
    public void printAll(){
        for(LogEntry record: records){
            System.out.println(record);
        }
    }
    
    public void printAllHigherThan(int num){
        for(LogEntry record: records){
            if(record.getStatusCode() > num)
                System.out.println(record);
        }
    }
    
    public HashMap<String, Integer> countVisitsPerIP(){
        HashMap<String, Integer> visitsMap = new HashMap<>();
        for(LogEntry log: records){
            String ipAddr = log.getIpAddress();
            int visits = 1;
            if(visitsMap.keySet().contains(ipAddr)){
                visits += visitsMap.get(ipAddr);
            }
            visitsMap.put(ipAddr, visits);
        }
        return visitsMap;
    }
    
    public int mostNumberVisitsByIP(HashMap<String, Integer> visitsMap){
        int max = 0;
        for(Integer i : visitsMap.values()){
            if(i > max) max = i;
        }
        return max;
    }
    
    public ArrayList<String> iPsMostVisits(HashMap<String,Integer> visitsMap){
        ArrayList<String> mostVisits = new ArrayList<>();
        int max = mostNumberVisitsByIP(visitsMap);
        for(String ip: visitsMap.keySet()){
            if(visitsMap.get(ip) == max && !mostVisits.contains(ip)) {
                mostVisits.add(ip);
            }
        }
        return mostVisits;
    }
    
    public HashMap<String, ArrayList<String>> iPsForDays(){
        HashMap<String, ArrayList<String>> visitsByDays = new HashMap<>();
        for(LogEntry le: records){
            String date = getDateFromLog(le.getAccessTime().toString()); 
            ArrayList<String> ips;
            if(visitsByDays.keySet().contains(date)){
                ips = visitsByDays.get(date);
            }
            else{
                ips =new ArrayList<>();
            }
            ips.add(le.getIpAddress());
            visitsByDays.put(date, ips);
        }
        return visitsByDays;
    }
    
    public String daysWithMostIPVisits(HashMap<String, ArrayList<String>> visitsByDays){
        String mostVisitedDay = null;
        int mostVisits = 0;
        for(String day: visitsByDays.keySet()){
            int visits = visitsByDays.get(day).size();
            if(visits > mostVisits){
                mostVisits = visits;
                mostVisitedDay = day;
            }
        }
        return mostVisitedDay;
    }
    
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> visitsByDays, String date){
        HashMap <String, Integer> visitsOfDay = new HashMap<>();
        for(String ip: visitsByDays.get(date)){
            int visits = 1;
            if(visitsOfDay.keySet().contains(ip)){
                visits += visitsOfDay.get(ip);
            }
            visitsOfDay.put(ip, visits);
        }
        return iPsMostVisits(visitsOfDay);
    }
}
