package Nikita.csvParser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Parser {
    public static void main(String[] args) {
        Set<String> ngrs = new HashSet<>();
        Set<String> ngrsSecond = new HashSet<>();
        String inputFileName = "C:\\Users\\User\\IdeaProjects\\untitled\\src\\csvParser\\doc_meta_all_time_rus_and_actual_etc.csv";

        try(BufferedReader reader = new BufferedReader(new FileReader(inputFileName))){
            String line;
            while ((line = reader.readLine()) != null){
                ngrs.add(line);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        String inputFileNameSecond = "C:\\Users\\User\\IdeaProjects\\untitled\\src\\csvParser\\doc_meta_all_time_rus_and_actual_internet.csv";
        try(BufferedReader readerSecond = new BufferedReader(new FileReader(inputFileNameSecond))){
            String lineSecond;
            while ((lineSecond = readerSecond.readLine()) != null){
                ngrsSecond.add(lineSecond);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("doc_meta_all_time_rus_and_actual_etc.csv");
        for(String z : ngrs) {
            boolean a = ngrsSecond.contains(z);
            if (!a) {
                System.out.println(z);
            }
        }
        System.out.println("//////////////////////////////////////////////////");
        System.out.println("doc_meta_all_time_rus_and_actual_internet.csv");
        for(String c : ngrsSecond){
            boolean b = ngrs.contains(c);
            if (!b) {
                System.out.println(c);
            }
        }
    }
}
