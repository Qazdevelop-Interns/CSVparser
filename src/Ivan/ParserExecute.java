package Ivan;

import java.util.*;

class ParserExecute {
    static Set<String> all_unique_ids = new HashSet<>();
    public static void main(String[] args) {

        Set<String> recordsKazEtc = Parser.parseFile("kaz_etc.csv");
        Set<String> recordsKazInternet = Parser.parseFile("kaz_internet.csv");
        Set<String> recordsRusEtc = Parser.parseFile("rus_etc");
        Set<String> recordsRusInternet = Parser.parseFile("rus_internet");


        Set<String> uniqueKazEtc = new HashSet<>();
        Set<String> uniqueKazInternet = new HashSet<>();
        Set<String> uniqueRusEtc = new HashSet<>();
        Set<String> uniqueRusInternet = new HashSet<>();


        uniqueChecker(recordsKazEtc, recordsKazInternet, uniqueKazEtc);
        uniqueChecker(recordsKazInternet, recordsKazEtc, uniqueKazInternet);

        System.out.println("etc unique ids:\n"+uniqueKazEtc);
        System.out.println("internet unique ids:\n"+uniqueKazInternet);
        System.out.println("^ Kaz entries "+" "+ (uniqueKazInternet.size() + uniqueKazEtc.size())+"\n\n");

        uniqueChecker(recordsRusEtc, recordsRusInternet, uniqueRusEtc);
        uniqueChecker(recordsRusInternet, recordsRusEtc, uniqueRusInternet);

        System.out.println("etc unique ids:\n"+uniqueRusEtc);
        System.out.println("internet unique ids:\n"+uniqueRusInternet);
        System.out.println("^ Rus entries "+" "+ (uniqueRusEtc.size() + uniqueRusInternet.size())+"\n\n");
        System.out.println("All unique ids:\n"+all_unique_ids+"\n"+all_unique_ids.size());
    }

    static void uniqueChecker(Set<String> first, Set<String> second, Set<String> parsed){
        for(String r : first){
            if (!second.contains(r)){
                parsed.add(r);
                all_unique_ids.add(r);
            }
        }
    }
}
