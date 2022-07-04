package Ivan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Parser {
    Set<String> parseKazEtc(){
        Set<String> recordsKazEtc = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src\\Ivan\\kaz_etc.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                recordsKazEtc.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return recordsKazEtc;
    }
    Set<String> parseKazInternet(){
        Set<String> recordsKazInternet = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src\\Ivan\\kaz_internet.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                recordsKazInternet.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return recordsKazInternet;
    }
    Set<String> parseRusEtc(){
        Set<String> recordsRusEtc = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src\\Ivan\\rus_etc.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                recordsRusEtc.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return recordsRusEtc;
    }

    Set<String> parseRusInternet(){
        Set<String> recordsRusInternet = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src\\Ivan\\rus_internet.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                recordsRusInternet.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return recordsRusInternet;
    }
}
