package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubSringWithAllWords {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        int len = L[0].length();
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<String, Integer> hash = new HashMap<>();
        for(int i = 0; i < L.length; i++){
            if(hash.containsKey(L[i])){
                int n = hash.get(L[i]);
                hash.put(L[i], n + 1);
            }else {
                hash.put(L[i], 1);
            }
        }
        for(int i = 0; i < len; i++){
            int start = i;
            HashMap<String, Integer> matchMap = new HashMap<>();
            for(int j = i; j <= S.length() - len; j += len){
                String sub = S.substring(j, j + len);
                if(!hash.containsKey(sub) || (matchMap.containsKey(sub) && matchMap.get(sub) >= hash.get(sub))){
                    j = start;
                    start = j + len;
                    matchMap = new HashMap<>();
                }else if(!matchMap.containsKey(sub)){
                    matchMap.put(sub, 1);
                    if(j - start == len * (L.length - 1)){
                        res.add(start);
                        j = start;
                        start = j + len;
                        matchMap = new HashMap<>();

                    }
                }else {
                    int n = matchMap.get(sub);
                    matchMap.put(sub, n + 1);
                    if(j - start == len * (L.length - 1)){
                        res.add(start);
                        j = start;
                        start = j + len;
                        matchMap = new HashMap<>();

                    }
                }
            }
        }
        return res;

    }


    public static void main(String[] args){
        SubSringWithAllWords subSringWithAllWords = new SubSringWithAllWords();
        String[] L = new String[]{"foo","bar"};
        String S = "barfoothefoobarman";
        List<Integer> res = subSringWithAllWords.findSubstring(S, L);
        for(Integer i:res){
            System.out.println(i);
        }
    }
}
