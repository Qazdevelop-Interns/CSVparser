package Ivan;

import java.util.*;

public class ParserExecute {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Set<String> recordsKazEtc = parser.parseKazEtc();
        Set<String> recordsKazInternet = parser.parseKazInternet();
        Set<String> recordsRusEtc = parser.parseRusEtc();
        Set<String> recordsRusInternet = parser.parseRusInternet();
        Set<String> uniq1 = new HashSet<>();
        Set<String> uniq2 = new HashSet<>();
        Set<String> uniq3 = new HashSet<>();
        Set<String> uniq4 = new HashSet<>();
        for(String r:recordsKazEtc){
            if(!recordsKazInternet.contains(r)){
                uniq1.add(r);
            }
        }
        for (String r:recordsKazInternet){
            if (!recordsKazEtc.contains(r)){
                uniq2.add(r);
            }
        }
        System.out.println("etc unique ids:\n"+uniq1);
        System.out.println("internet unique ids:\n"+uniq2);
        System.out.println("^ Kaz entries "+" "+ (uniq2.size() + uniq1.size())+"\n\n");

        for (String r:recordsRusEtc){
            if (!recordsRusInternet.contains(r)){
                uniq3.add(r);
            }
        }

        for(String r:recordsRusInternet){
            if(!recordsRusEtc.contains(r)){
                uniq4.add(r);
            }
        }
        System.out.println("etc unique ids:\n"+uniq3);
        System.out.println("internet unique ids:\n"+uniq4);
        System.out.println("^ Rus entries "+" "+ (uniq3.size() + uniq4.size())+"\n\n");

    }

}
