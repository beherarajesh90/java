package com.java.leetcode.slidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int left = 0;
        int right = 0;
        int wordLength = words[0].length();
        int wordCount = words.length;
        Map<String, Integer> originalWords = new HashMap<>();
        Arrays.stream(words).forEach( word -> originalWords.put(word,1));
        while ((right+(wordCount*wordLength))<=s.length()){
            Map<String, Integer> currentWords = originalWords;
            if (currentWords.getOrDefault(s.substring(right,wordLength), 0)==1){
                currentWords.put(s.substring(right,wordLength),0);
                right+=wordLength;
                wordCount-=1;
                if (wordCount==0){
                    left+=wordLength;
                }
            }else{
                wordCount=words.length;
            }
        }
        return null;
    }
}
