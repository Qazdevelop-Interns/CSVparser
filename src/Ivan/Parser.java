package Ivan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

class Parser {
    static Set<String> parseFile(String file){
        Set<String> records = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src\\Ivan\\"+file))) {
            String line;
            while ((line = br.readLine()) != null) {
                records.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return records;
    }
}
