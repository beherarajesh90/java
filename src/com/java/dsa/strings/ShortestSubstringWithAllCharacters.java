package com.java.dsa.strings;

import java.util.HashMap;
import java.util.HashSet;

public class ShortestSubstringWithAllCharacters {


    public static String shortestSubstring(String s) {
        // Write your code here.
        HashMap<Character, Integer> hm = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            hs.add(s.charAt(i));
        }
        int distCount = hs.size();
        int count = 0;
        int start = 0, end = 0;
        String res = "";
        int resLen = Integer.MAX_VALUE;
        while (end < s.length()) {
//             expand window if window size less than distinct count
//                 System.out.println(hm);
//                 System.out.println("start "+start+" end "+end+" count "+count);
            if (count < distCount) {
                if (hm.get(s.charAt(end)) == null || hm.get(s.charAt(end)) == 0) {
                    hm.put(s.charAt(end), 1);
                    count++;
                } else {
                    hm.put(s.charAt(end), hm.get(s.charAt(end)) + 1);
                }
//                 increase window size
                end++;
            } else if (count == distCount) {
//     shrink window if count==distinct count , update result
                if (resLen > s.substring(start, end).length()) {
                    res = s.substring(start, end);
                    resLen = res.length();
                }

                if (hm.get(s.charAt(start)) == 1) {
                    count--;
                }
                hm.put(s.charAt(start), hm.get(s.charAt(start)) - 1);

//                 decrease window size
                start++;
            }
        }
        while (count == distCount) {
//     shrink window if count==distinct count , update result
            if (resLen > s.substring(start, end).length()) {
                res = s.substring(start, end);
                resLen = res.length();
            }

            if (hm.get(s.charAt(start)) == 1) {
                count--;
            }
            hm.put(s.charAt(start), hm.get(s.charAt(start)) - 1);

//                 decrease window size
            start++;
        }
        return res;
    }
}

