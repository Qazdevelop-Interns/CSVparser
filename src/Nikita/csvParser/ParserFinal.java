package Nikita.csvParser;
import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class ParserFinal {
    String inputFileNameFirst;
    String inputFileNamesSecond;
    Set<String> containerWay = new HashSet<>();
    Set<String> firstDocument = new HashSet<>();
    Set<String> secondDocument = new HashSet<>();

    void setFileWay(){
        //Specify paths to files.
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("Path to the first document : ");
            inputFileNameFirst = scanner.nextLine();
            System.out.println("Path to the second document : ");
            inputFileNamesSecond = scanner.nextLine();
            System.out.println(inputFileNameFirst + "\n" + inputFileNamesSecond);
            containerWay.add(inputFileNameFirst);
            containerWay.add(inputFileNamesSecond);
        }
    }
    void getInformationFromFiles(){
        for (String a : containerWay){
            try(BufferedReader reader = new BufferedReader(new FileReader(a))){
                String line;
                while ((line = reader.readLine()) != null){
                    if(a.equals(inputFileNameFirst)){
                        firstDocument.add(line);
                    }
                    else {
                        secondDocument.add(line);
                    }
                }
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }
        }
        System.out.println("Information received");
    }
    void comparingTwoFiles(){
        //Finding unique elements by removing all duplicate elements.
        Set<String> resultFirstDocument = new HashSet<>(firstDocument);
        Set<String> resultSecondDocument = new HashSet<>(secondDocument);
        resultFirstDocument.removeAll(secondDocument);
        resultSecondDocument.removeAll(firstDocument);
        System.out.println("First document : " + resultFirstDocument + "\n Number of Unique elements : " + resultFirstDocument.size() +
                "\n" + "Second document : " + resultSecondDocument + "\n Number of Unique elements : " + resultSecondDocument.size());
    }
}
class ParserMain{
    public static void main(String[] args) {
        ParserFinal object = new ParserFinal();
        object.setFileWay();
        object.getInformationFromFiles();
        object.comparingTwoFiles();
    }
}
