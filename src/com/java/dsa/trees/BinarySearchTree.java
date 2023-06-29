package com.java.dsa.trees;


public class BinarySearchTree{

    Node root;

    BinarySearchTree(){
        this.root = null;
    }

    public void insert(int data){
        root = insertRecord(root,data);
    }

    public Node insertRecord(Node root, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }
        if (data > root.data){
            root.right = insertRecord(root.right,data);
        }
        else {
            root.left = insertRecord(root.left, data);
        }
        return root;
    }

    public Node search(Node root, int key){
       if (root == null || root.data == key){
           return root;
       }
       if(root.data > key){
           return search(root.left,key);
       }
       return search(root.right,key);
    }

    public void printInOrder(){
        Node cur = root;
        inOrder(cur);
    }

    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public Node delete(int data){
        return deleteNode(root,data);
    }

    public Node deleteNode(Node root, int data){
        if(root == null){
            return null;
        }
        if(data < root.data){
            root.left = deleteNode(root.left,data);
        } else if (data > root.data){
            root.right = deleteNode(root.right, data);
        } else {
            if(root.left==null){
                return root.right;
            }
            else if (root.right==null) {
                return root.left;
            }
            root.data = getInOrderSuccessor(root.right);
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    public int getInOrderSuccessor(Node root){
//        if (root == null){
//            return getInOrderPredecessor(root);
//        }
        while (root.left!=null){
            root = root.left;
        }
        return root.data;
    }

    public void inOrderPredecessor(){

    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(8);
        bst.insert(3);
        bst.insert(10);
        bst.insert(1);
        bst.insert(6);
        bst.insert(14);
        bst.insert(4);
        bst.insert(7);
        bst.insert(13);
//                                                8
//                                    3                        10
//                              1            6                       14
//                                       4       7               13


        bst.delete(8);
        bst.printInOrder();
//        bst.search(bst.root,103);
    }
}
