package Asanali;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String firstDoc = "src\\Asanali\\kaz_etc.csv";
        String secondDoc = "src\\Asanali\\kaz_int.csv";
        String thirdDoc = "src\\Asanali\\rus_etc.csv";
        String fourthDoc = "src\\Asanali\\rus_int.csv";

        Set<String> set1 = parseDoc(firstDoc);
        Set<String> set2 = parseDoc(secondDoc);
        Set<String> set3 = parseDoc(thirdDoc);
        Set<String> set4 = parseDoc(fourthDoc);

        Set<String> kaz = symmetricSetDifference(set1, set2);
        Set<String> rus = symmetricSetDifference(set3, set4);
        kaz.addAll(rus);
        System.out.println("Final Result: " + kaz);
        System.out.println("Number of occurrences: " + kaz.size());
    }

    static Set<String> symmetricSetDifference(Set<String> set1, Set<String> set2) {
        Set<String> newSet = new HashSet<String>(set1);
        newSet.removeAll(set2);
        System.out.println("Unique elements from first set: " + newSet);
        set2.removeAll(set1);
        System.out.println("Unique elements from second set: " + set2);
        newSet.addAll(set2);
        System.out.println("Unique elements from both sets: ");
        System.out.println(newSet);
        System.out.println("Number of elements from both sets: " + newSet.size());

        return newSet;
    }
    static Set<String> parseDoc(String filePath) {
        Set<String> records = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                records.add(line);
            }
            //records_first.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return records;
    }
}