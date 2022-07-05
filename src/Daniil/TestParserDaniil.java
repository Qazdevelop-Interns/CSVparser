package Daniil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TestParserDaniil {
    public static void main(String[] args) {

        Set<String> firstKazFile = new HashSet<>();
        Set<String> secondKazFile = new HashSet<>();
        Set<String> firstRusFile = new HashSet<>();
        Set<String> secondRusFile = new HashSet<>();
        Set<String> processedFileOne = new HashSet<>();
        Set<String> processedFileTwo = new HashSet<>();
        Set<String> processedFileOneRus = new HashSet<>();
        Set<String> processedFileTwoRus = new HashSet<>();

        try {
            Scanner sc1kaz = new Scanner(new File("src\\Daniil\\doc1(kaz).csv"));
            while (sc1kaz.hasNext()) {
                firstKazFile.add(sc1kaz.next());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Scanner sc2kaz = new Scanner(new File("src\\Daniil\\doc2(kaz).csv"));
            while (sc2kaz.hasNext()) {
                secondKazFile.add(sc2kaz.next());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Scanner sc1rus = new Scanner(new File("src\\Daniil\\doc1(rus).csv"));
            while (sc1rus.hasNext()) {
                firstRusFile.add(sc1rus.next());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Scanner sc2rus = new Scanner(new File("src\\Daniil\\doc2(rus).csv"));
            while (sc2rus.hasNext()) {
                secondRusFile.add(sc2rus.next());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (String s : firstKazFile) {
            if (!secondKazFile.contains(s)) {
                processedFileOne.add(s);
            }


        }
        System.out.println("Unique elements of first kaz file are: \n " + processedFileOne);
        for (String s: secondKazFile) {
            if (!firstKazFile.contains(s)) {
                processedFileTwo.add(s);
            }
        }
        System.out.println("Unique elements of second kaz file are: \n" + processedFileTwo);
        for (String s: firstRusFile) {
            if (!secondRusFile.contains(s)) {
                processedFileOneRus.add(s);
            }
        }
        System.out.println("Unique elements of first rus file are: \n" + processedFileOneRus);
        for (String s: secondRusFile) {
            if (!firstRusFile.contains(s)) {
                processedFileTwoRus.add(s);
            }
        }
        System.out.println("Unique elements of second rus file are: \n " + processedFileTwoRus);
    }
}
