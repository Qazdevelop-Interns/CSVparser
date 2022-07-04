package Nikita.csvParser;
import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class ParserFinal {
    Set<String> firstDocument = new HashSet<>();
    Set<String> resultFirstDocument = new HashSet<>();
    Set<String> resultSecondDocument = new HashSet<>();
    Set<String> secondDocument = new HashSet<>();
    ParserFinal(String a, String b) {
        //Чтение данных первого документа.
        try(BufferedReader readerFirst = new BufferedReader(new FileReader(a))){
            String lineFirst;
            while ((lineFirst = readerFirst.readLine()) != null){
                firstDocument.add(lineFirst);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        //Чтение данных второго документа.
        try(BufferedReader readerSecond = new BufferedReader(new FileReader(b))){
            String lineSecond;
            while ((lineSecond = readerSecond.readLine()) != null){
                secondDocument.add(lineSecond);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    void comparingTwoFiles() throws FileNotFoundException {
        System.out.println("First document : ");
        for(String z : firstDocument) {
            boolean a = secondDocument.contains(z);
            if (!a) {
                resultFirstDocument.add(z);
                File fileFirst = new File("firstDocument.txt");
                PrintWriter pwFirst = new PrintWriter(fileFirst);
                pwFirst.println(resultFirstDocument);
                pwFirst.close();
                System.out.println(z);
            }
        }
        System.out.println();
        System.out.println("Second document : ");
        for(String z : secondDocument) {
            boolean a = firstDocument.contains(z);
            if (!a) {
                resultSecondDocument.add(z);
                File fileSecond = new File("SecondDocument.txt");
                PrintWriter pwSecond = new PrintWriter(fileSecond);
                pwSecond.println(resultSecondDocument);
                pwSecond.close();
                System.out.println(z);
            }
        }
    }
}
class ParserMain{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Path for first file : ");
        String inputFileNameFirst = scanner.nextLine();
        System.out.println("Path for second file : ");
        String inputFileNameSecond = scanner.nextLine();
        ParserFinal fileNames = new ParserFinal(inputFileNameFirst, inputFileNameSecond);
        fileNames.comparingTwoFiles();
    }
}
