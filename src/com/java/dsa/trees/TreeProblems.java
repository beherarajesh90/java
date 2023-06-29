package com.java.dsa.trees;

import java.util.*;

class Node{
    int data;
    Node left,right;
    public Node(int data){
        this.data = data;
        left=right=null;
    }
}
class BinaryTree{
    Node root;
    static HashMap<Integer,Integer> map = new HashMap<>();
    static int preOrderIndex = 0;
    BinaryTree(){
        root = null;
    }

    public void preOrderTraversal(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data+" ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void inOrderTraversal(Node node){
        if(node == null){
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data+" ");
        inOrderTraversal(node.right);
    }

    public void postOrderTraversal(Node node){
        if(node == null){
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data+" ");
    }

    void printInOrder(){
        System.out.println("\nInorder traversal");
        inOrderTraversal(root);
    }

    void printPreOrder(){
        System.out.println("\nPreorder traversal");
        preOrderTraversal(root);
    }

    void printPostOrder(){
        System.out.println("\nPostorder traversal");
        postOrderTraversal(root);
    }

    int getHeight(Node node){
        if(node == null){
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        if(leftHeight > rightHeight){
            return leftHeight+1;
        }
        return rightHeight+1;
    }

    void printNodesAtKDistance(Node node,int k){
        if( k<0 || (node == null)){
            return;
        }
        if(k == 0){
            System.out.print(node.data+" ");
        }
        printNodesAtKDistance(node.left,k-1);
        printNodesAtKDistance(node.right,k-1);

    }

    void levelOrderTraversal(Node node){
        Queue<Node> q = new LinkedList<>();
        if(node == null){
            return;
        }
        q.add(node);
        while (!q.isEmpty()){
            System.out.print(q.peek().data+" ");
            Node temp = q.remove();
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
    }

    int sizeOfBinaryTree(Node node){
        if (node == null){
            return 0;
        }
        int leftSize = sizeOfBinaryTree(node.left);
        int rightSize = sizeOfBinaryTree(node.right);
        return 1+leftSize+rightSize;
    }

    int maxInBinaryTree(Node node){
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int max = node.data;
        int leftMax = maxInBinaryTree(node.left);
        int rightMax = maxInBinaryTree(node.right);
        if(leftMax>max){
            max = leftMax;
        }
        if(rightMax>max){
            max = rightMax;
        }
        return max;
    }

    void printLeftView(Node node){
        if (node == null){
            return;
        }
        printLeftView(node.left);
        System.out.println(node.data);
    }

    void printRightView(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.data);
        printRightView(node.right);
    }

    void printTopView(Node node){
        if(node == null){
            return;
        }
        printLeftView(node.left);
        System.out.println(node.data);
        printRightView(node.right);
    }
    void printBottomView(Node node){
        if (node == null){
            return;
        }
        if(node.left == null && node.right == null){
            System.out.print(node.data+" ");
        }
        printBottomView(node.left);
        printBottomView(node.right);
    }

    int isBalanced(Node node){
        if(node == null){
            return 0;
        }
        int lh = isBalanced(node.left);
        if(lh == -1){
            return -1;
        }
        int rh = isBalanced(node.right);
        if (rh == -1){
            return -1;
        }
        if(Math.abs(lh-rh)>1){
            return -1;
        }
        return Math.max(lh,rh)+1;
    }

    int maxWidthOfBinaryTree(Node node){
        int height = getHeight(node);
        int maxWidth = 0;
        for (int i=1; i<=height; i++){
            int tempWidth = getWidth(node,i);
            if (tempWidth > maxWidth){
                maxWidth = tempWidth;
            }
        }
        return maxWidth;
    }
    
    int getWidth(Node node, int level){
        if(node == null){
            return 0;
        }
        if(level == 1){
            return 1;
        } else if (level>1) {
            return getWidth(node.left,level-1)+getWidth(node.right,level-1);
        }
        return 0;
    }

    Node buildTreeFromInOrderAndPreOrder(int preOrder[], int[] inOrder){
        for(int i=0;i<inOrder.length;i++){
            map.put(inOrder[i], i);
        }
        return buildTree(preOrder,inOrder,0,preOrder.length-1);
    }

    Node buildTree(int[] preOrder, int[] inOrder, int start, int end){

        if(start>end){
            return null;
        }
        int curNode = preOrder[preOrderIndex++];
        Node node = new Node(curNode);
        if(start == end){
            return node;
        }
        int inorderIndex = map.get(curNode);
        node.left = buildTree(preOrder,inOrder,start,inorderIndex-1);
        node.right = buildTree(preOrder,inOrder, inorderIndex+1,end);
        return node;
    }

    void printSpiralForm(Node node){
        Deque<Node> dq = new ArrayDeque<>();
        dq.offerFirst(node);
        boolean reverse = false;
        while (!dq.isEmpty()){
            int n = dq.size();
            if(reverse){
                for(int i=0; i<n; i++){
                    if(dq.peekFirst().left!=null){
                        dq.offerLast(dq.peekFirst().left);
                    }
                    if(dq.peekFirst().right!=null){
                        dq.offerLast(dq.peekFirst().right);
                    }
                    System.out.print(dq.pollFirst().data+" ");
                }
            }else{
                while (n-- > 0){
                    if(dq.peekLast().right!=null){
                        dq.offerFirst(dq.peekLast().right);
                    }
                    if(dq.peekLast().left!=null){
                        dq.offerFirst(dq.peekLast().left);
                    }
                    System.out.print(dq.pollLast().data+" ");
                }
            }
            reverse = !reverse;
        }
    }

    int getDiameter(Node node ){
        if (node == null){
            return 0;
        }
        int leftDiameter = getDiameter(node.left);
        int rightDiameter = getDiameter(node.right);

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return Math.max(Math.max(leftDiameter,rightDiameter),1+leftHeight+rightHeight);
    }

    Node findLCA(Node node, int n1, int n2){

        if(node == null){
            return null;
        }
        if(node.data == n1 || node.data == n2){
            return node;
        }
        Node leftLca = findLCA(node.left, n1, n2);
        Node rightLca = findLCA(node.right, n1, n2);

        if(leftLca!=null && rightLca!=null){
            return node;
        }

        return leftLca!=null ? leftLca : rightLca;
    }

    void preOrderIterative(Node node){
        if(node==null){
            return;
        }
        Stack<Node> st = new Stack<>();
        Node curNode = node;
        while (curNode!=null || !st.isEmpty()){
            while (curNode!=null){
                System.out.print(curNode.data+" ");
                if(curNode.right!=null){
                    st.push(curNode.right);
                }
                curNode = curNode.left;
            }
            if(!st.isEmpty()){
                curNode = st.pop();
            }
        }
    }

}
public class TreeProblems {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node8.left = node9;
        node4.left = node8;
        node2.right = node5;
        node3.left = node6;
        node6.left = node10;
        node3.right = node7;
        BinaryTree bt = new BinaryTree();
        bt.root = node1;
//                                      1
//                              2               3
//                           4      5         6       7
//                        8                10
//                     9
//        bt.printPreOrder();
//        bt.printInOrder();
//        bt.printPostOrder();
//        System.out.println("Height of binary tree "+bt.getHeight(bt.root));
//        bt.printNodesAtKDistance(node1,3);
//        bt.levelOrderTraversal(bt.root);
//        System.out.println("Size of the binary tree is "+bt.sizeOfBinaryTree(bt.root));
//        System.out.println("Max element in the tree is "+bt.maxInBinaryTree(bt.root));
//        bt.printTopView(bt.root);
//        System.out.println(bt.isBalanced(bt.root));
//        System.out.println(bt.maxWidthOfBinaryTree(bt.root));
//        int inOrder[] = { 9, 8, 4, 2, 5, 1, 6, 3, 7 };
//        int preOrder[] = { 1, 2, 4, 8, 9, 5, 3, 6 ,7 };
//        Node root = bt.buildTreeFromInOrderAndPreOrder(preOrder, inOrder);
//        bt.inOrderTraversal(root);
//        bt.printSpiralForm(node1);
//        System.out.println(bt.getDiameter(node1));
//        System.out.println(bt.findLCA(node1, 9, 5).data);
//        bt.preOrderIterative(node1);
        bt.preOrderIterative(node1);
    }
}
