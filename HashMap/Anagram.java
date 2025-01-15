package HashMap;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
        public  static boolean isAnagram(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();

        for(char ch : s.toCharArray()){
            count.put(ch, count.getOrDefault(ch,0)+1);
        }

        for(char ch: t.toCharArray()){
            count.put(ch, count.getOrDefault(ch,0)-1);
        }

        for(int val : count.values()){
            if(val !=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "race";
        String t = "cre";
        
        Boolean ans = isAnagram(s,t);
        if(ans){
            System.out.println(ans);
        }else{
            System.out.println(ans);
        }
    }
}
