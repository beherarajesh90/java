package com.java.leetcode.hashmap;

import java.util.*;

public class GroupAnagrams {

//    public static List<List<String>> groupAnagrams(String[] strs) {
//        Map<String,List<String>> map = new HashMap<>();
//        for (String s: strs){
//            char[] charArr = s.toCharArray();
//            Arrays.sort(charArr);
//            if (map.containsKey(Arrays.toString(charArr))){
//                map.get(Arrays.toString(charArr)).add(s);
//            }else{
//                List<String> ll = new ArrayList<>();
//                ll.add(s);
//                map.put(Arrays.toString(charArr),ll);
//            }
//        }
//        List<List<String>> res = new ArrayList<>();
//        for (String cArr: map.keySet()){
//            res.add(map.get(cArr));
//        }
//        return res;
//    }

    private static List<List<String>> groupAnagrams(String[] s){
        return new AbstractList<List<String>>() {

            private List<List<String>> ans;
            @Override
            public List<String> get(int index) {
                if (ans == null) init();
                return ans.get(index);
            }

            @Override
            public int size() {
                if (ans == null) init();
                return ans.size();
            }

            private void init(){
                Map<String,List<String>> group = new HashMap<>();
                for (String str:s){
                    int[] count = new int[26];
                    StringBuilder sb = new StringBuilder();
                    for (char ch: str.toCharArray()){
                        count[ch-'a']++;
                    }
                    for (int i=0; i<26; i++){
                        if (count[i]!=0){
                            sb.append('a'+i);
                            sb.append(count[i]);
                        }
                    }
                    String key = sb.toString();
                    group.computeIfAbsent(key,val->new ArrayList<>()).add(str);
                }
                ans = new ArrayList<>(group.values());
            }
        };
    }

    public static void main(String[] args) {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = groupAnagrams(arr);
        for (List<String> list: res){
            System.out.println(list);
        }
    }
}
