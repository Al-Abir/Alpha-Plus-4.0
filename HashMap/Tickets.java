package HashMap;

import java.util.HashMap;
import java.util.Map;

public class Tickets {

    public static String getStart(Map<String,String> tickets){
        Map<String,String> revtickets = new HashMap<>();

        for(String key : tickets.keySet()){
            revtickets.put(tickets.get(key), key);
        }
        for(String key : tickets.keySet()){
           if(!revtickets.containsKey(key)){
             return key; // starting point
           }
        }
        return null;
    }
    public static void main(String[] args){
     Map<String,String> tickets = new HashMap<>();

     tickets.put("Chennai", "Bengaluru");
     tickets.put("Mumbai", "Delhi");
     tickets.put("Goa", "Chennai");
     tickets.put("Delhi", "Goa");

     String start = getStart(tickets);

     System.out.print(start);

     while (tickets.containsKey(start)) {
        System.out.print(" -> " + tickets.get(start));
        start = tickets.get(start);
     }
     System.out.println();

     }
     

    }
