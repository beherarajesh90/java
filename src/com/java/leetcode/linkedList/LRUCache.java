package com.java.leetcode.linkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class CacheNode{
        private int key, value;
        private CacheNode next, prev;

        public CacheNode(){
        }

        public CacheNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, CacheNode> refMap;
    private int capacity;
    private CacheNode head;
    private CacheNode tail;
    public LRUCache(int capacity){
        this.capacity = capacity;
        refMap = new HashMap<>(capacity);
        head = new CacheNode(0,0);
        tail = new CacheNode(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value){
        CacheNode cacheNode = refMap.get(key);
        if(cacheNode == null){
            if (refMap.size() >= capacity){
                //remove least recently used node
                refMap.remove(tail.prev.key);
                remove(tail.prev);
            }
            //add cacheNode and make it head
            CacheNode newCacheNode = new CacheNode(key, value);
            refMap.put(key, newCacheNode);
            addHead(newCacheNode);
        }else {
            //change the value of cacheNode and make it head
            cacheNode.value = value;
            remove(cacheNode);
            addHead(cacheNode);
        }
    }

    private void remove(CacheNode cacheNode) {
        CacheNode prev = cacheNode.prev;
        CacheNode next = cacheNode.next;
        prev.next = next;
        next.prev = prev;
    }
    private void addHead(CacheNode newCacheNode) {
        newCacheNode.next = head.next;
        head.next.prev = newCacheNode;
        head.next = newCacheNode;
        newCacheNode.prev = head;
    }

    public int get(int key){
        CacheNode cacheNode = refMap.get(key);
        if (cacheNode!=null){
            remove(cacheNode);
            addHead(cacheNode);
            return cacheNode.value;
        }
        return -1;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.put(4,4);
        lruCache.get(1);
        lruCache.put(5,5);

        System.out.println(lruCache.refMap);
    }

}

//class LRUCache {
//    class Node{
//        int key;
//        int value;
//
//        Node prev;
//        Node next;
//
//        Node(int key, int value){
//            this.key= key;
//            this.value= value;
//        }
//    }
//
//    public Node[] map;
//    public int count, capacity;
//    public Node head, tail;
//
//    public LRUCache(int capacity) {
//
//        this.capacity= capacity;
//        count= 0;
//
//        map= new Node[10_000+1];
//
//        head= new Node(0,0);
//        tail= new Node(0,0);
//
//        head.next= tail;
//        tail.prev= head;
//
//        head.prev= null;
//        tail.next= null;
//    }
//
//    public void deleteNode(Node node){
//        node.prev.next= node.next;
//        node.next.prev= node.prev;
//
//        return;
//    }
//
//    public void addToHead(Node node){
//        node.next= head.next;
//        node.next.prev= node;
//        node.prev= head;
//
//        head.next= node;
//
//        return;
//    }
//
//    public int get(int key) {
//
//        if( map[key] != null ){
//
//            Node node= map[key];
//
//            int nodeVal= node.value;
//
//            deleteNode(node);
//
//            addToHead(node);
//
//            return nodeVal;
//        }
//        else
//            return -1;
//    }
//
//    public void put(int key, int value) {
//
//        if(map[key] != null){
//
//            Node node= map[key];
//
//            node.value= value;
//
//            deleteNode(node);
//
//            addToHead(node);
//
//        } else {
//
//            Node node= new Node(key,value);
//
//            map[key]= node;
//
//            if(count < capacity){
//                count++;
//                addToHead(node);
//            }
//            else {
//
//                map[tail.prev.key]= null;
//                deleteNode(tail.prev);
//
//                addToHead(node);
//            }
//        }
//
//        return;
//    }
//
//}