import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVParser {
    public static void main(String[] args) {
        CSVParser parser = new CSVParser();
        Set<String> records_first = parser.parseFirstDoc();
        Set<String> records_second = parser.parseSecondDoc();
        Set<String> uniq1 = new HashSet<>();
        Set<String> uniq2 = new HashSet<>();
        for(String r:records_first){
            if(!records_second.contains(r)){
                uniq1.add(r);
            }
        }
        for (String r:records_second){
            if (!records_first.contains(r)){
                uniq2.add(r);
            }
        }
        System.out.println("First document unique ids:\n"+uniq1);
        System.out.println("Second document unique ids:\n"+uniq2);
        System.out.println(uniq2.size()+" "+uniq1.size());
    }
    Set<String> parseFirstDoc(){
        Set<String> records_first = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\77021\\OneDrive\\Рабочий стол\\Java\\CSVparsing\\src\\doc1.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String s : line.split(",")){
                    records_first.add(s);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return records_first;
    }
    Set<String> parseSecondDoc(){
        Set<String> records_second = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\77021\\OneDrive\\Рабочий стол\\Java\\CSVparsing\\src\\doc2.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String s : line.split(",")){
                    records_second.add(s);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return records_second;
    }
}
