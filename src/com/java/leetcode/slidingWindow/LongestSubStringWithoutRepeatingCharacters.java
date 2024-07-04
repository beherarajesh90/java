package com.java.leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left=0; int right=0;
        while (right<s.length()){
            char cur = s.charAt(right);
            map.put(cur,map.getOrDefault(cur,0)+1);
            while (map.get(cur)>1){
                char leftChar = s.charAt(left);
                map.put(leftChar,map.get(leftChar)-1);
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "dvdf";
        System.out.println(LongestSubStringWithoutRepeatingCharacters.lengthOfLongestSubstring(str));
    }
}
