package com.java.dsa.trie;

public class Trie {
    static class TrieNode{
        private TrieNode[] children = new TrieNode[26];
        private boolean isEnd;
        TrieNode(){
            isEnd = false;
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }

    static TrieNode root;

    static void insert(String key){
        TrieNode cur=root;
        int index;
        for(int i=0;i<key.length();i++){
            index=key.charAt(i)-'a';
            if(cur.children[index]==null){
                cur.children[index] = new TrieNode();
            }
            cur=cur.children[index];
        }
        cur.isEnd=true;
    }

    static boolean search(String key){
        int index;
        TrieNode cur = root;
        for(int i=0;i< key.length();i++){
            index = key.charAt(i)-'a';
            if(cur.children[index]==null){
                return false;
            }
            cur = cur.children[index];
        }
        return (cur!=null && cur.isEnd);
    }

    static TrieNode remove(TrieNode root, String key, int i){
        if(root==null){
            return null;
        }
        if(i==key.length()){
            if(root.isEnd) root.isEnd = false;
            if(isEmpty(root))  root = null;
            return root;
        }
        int index=key.charAt(i)-'a';
        root.children[index] = remove(root.children[index],key,i+1);
        if(isEmpty(root) && root.isEnd==false) root = null;
        return root;
    }

    static boolean isEmpty(TrieNode root){
        for(int i=0;i<26;i++){
            if(root.children[i]!=null) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String keys[] = {"hello","bag","laptop","book"};
        root = new TrieNode();
        for(String key:keys){
            insert(key);
        }
        root = remove(root,"books",0);
        System.out.println(search("book"));
    }
}
