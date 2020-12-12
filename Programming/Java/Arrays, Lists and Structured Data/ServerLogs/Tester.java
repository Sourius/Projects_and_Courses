import edu.duke.*;
import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer analyzer = new LogAnalyzer();
        analyzer.readFile("weblog2_log.txt");
        analyzer.printAll();
    }
    
    public void testUniqueIP(){
        LogAnalyzer analyzer = new LogAnalyzer();
        analyzer.readFile("weblog2_log.txt");
        int uniqueIPs = analyzer.countUniqueIPs();
        System.out.println("There are "+uniqueIPs+" IP addresses");
    }
    
    public void testUniqueIPsInRange(){
        LogAnalyzer analyzer = new LogAnalyzer();
        analyzer.readFile("weblog2_log.txt");
        int low = 400;
        int high = 499;
        int uniqueIPs = analyzer.countUniqueIPsInRange(low,high);
        System.out.println("There are "+uniqueIPs+" IPs in range "+low+" "+high);
    }
    
    public void testPrintAllHigherThan(){
        int num = 400;
        LogAnalyzer analyzer = new LogAnalyzer();
        analyzer.readFile("weblog1_log.txt");
        analyzer.printAllHigherThan(num);
    }
    
    public void testUniqueVisitsOn(){
        LogAnalyzer analyzer = new LogAnalyzer();
        analyzer.readFile("weblog2_log.txt");
        String date = "Sep 27";
        System.out.println(date+" "+analyzer.uniqueIPVisitsOnDay(date).size());
    }
    
    public void testCountVisitsPerIP(){
        LogAnalyzer analyzer = new LogAnalyzer();
        analyzer.readFile("short-test_log.txt");
        HashMap<String, Integer> visits = analyzer.countVisitsPerIP();
        for(String ip: visits.keySet()){
            System.out.println(ip+" has "+visits.get(ip)+" visits.");
        }
    }
    
    public void testMostNumberVisitsByIP(){
        LogAnalyzer analyzer = new LogAnalyzer();
        analyzer.readFile("weblog2_log.txt");
        HashMap<String, Integer> visits = analyzer.countVisitsPerIP();
        int mostVisits = analyzer.mostNumberVisitsByIP(visits);
        System.out.println("Most Number Visits by IP is "+mostVisits);
    }
    
    public void testIPsMostVisits(){
        LogAnalyzer analyzer = new LogAnalyzer();
        analyzer.readFile("weblog2_log.txt");
        HashMap<String, Integer> visitsMap = analyzer.countVisitsPerIP();
        ArrayList<String> ipMostVisits = analyzer.iPsMostVisits(visitsMap);
        System.out.println("IPs with most visits:");
        for(String ip: ipMostVisits){
            System.out.println(ip);
        }
    }
    
    public void testIPsForDays(){
        LogAnalyzer analyzer = new LogAnalyzer();
        analyzer.readFile("weblog3-short_log.txt");
        HashMap<String, ArrayList<String>> visitsByDays = analyzer.iPsForDays();
        StringBuilder sb = null;
        
        for(String day: visitsByDays.keySet()){
            sb = new StringBuilder();
            sb.append(day).append(":");
            for(String ip: visitsByDays.get(day)){
                sb.append(" ").append(ip);
            }
            System.out.println(sb.toString());
        }
    }
    
    public void testDayWithMostIPVisits(){
        LogAnalyzer analyzer = new LogAnalyzer();
        analyzer.readFile("weblog2_log.txt");
        HashMap<String, ArrayList<String>> visitsByDays = analyzer.iPsForDays();
        String mostVisitedDay = analyzer.daysWithMostIPVisits(visitsByDays);
        System.out.println("Most visited day is: "+mostVisitedDay);
    }
    
    public void testIPsWithMostVisitsOnDay(){
        LogAnalyzer analyzer = new LogAnalyzer();
        analyzer.readFile("weblog2_log.txt");
        HashMap<String, ArrayList<String>> visitsByDays = analyzer.iPsForDays();
        String date = "Sep 30";
        ArrayList<String> ips = analyzer.iPsWithMostVisitsOnDay(visitsByDays, date);
        System.out.println("Most visited ips on "+date+":");
        for(String ip: ips){
            System.out.println(ip);
        }
    }
    
    public void testQuiz(){
        testMostNumberVisitsByIP();
        testIPsMostVisits();
        testDayWithMostIPVisits();
        testIPsWithMostVisitsOnDay();
    }
    
    public void testQuiz2(){
        testUniqueIP();
        testUniqueVisitsOn();
        testUniqueIPsInRange();
        testMostNumberVisitsByIP();
        testIPsMostVisits();
        testDayWithMostIPVisits();
        testIPsWithMostVisitsOnDay();
    }
}
