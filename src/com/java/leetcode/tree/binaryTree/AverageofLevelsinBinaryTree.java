package com.java.leetcode.tree.binaryTree;

import com.java.leetcode.tree.TreeNode;

import java.util.*;

public class AverageofLevelsinBinaryTree {
    public static List<Double> averageOfLevels(TreeNode root) {
        return new AbstractList<Double>() {

            List<Double> result = new ArrayList<>();
            List<TreeNode> level = new ArrayList<>();
            @Override
            public Double get(int index) {
                init();
                return result.get(index);
            }

            @Override
            public int size() {
                init();
                return result.size();
            }

            private void init(){
                if (result.isEmpty()){
                    level.add(root);
                    while (!level.isEmpty()){
                        levelOrderTraversal(root);
                    }
                }
            }

            private void levelOrderTraversal(TreeNode root){
                double sum = 0.0;
                int levelCount = level.size();
                for (int i=0; i<levelCount; i++){
                    TreeNode node = level.get(0);
                    sum+=node.val;
                    if(node.left!=null) level.add(node.left);
                    if(node.right!=null) level.add(node.right);
                    level.remove(0);
                }
                result.add(sum/levelCount);
            }
        };
    }

    public List<Double> averageOfLevels2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> avg = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            double sum = 0.0;
            for(int i=0; i<level; i++){
                TreeNode temp = queue.poll();
                sum+=temp.val;
                if(temp.left!=null) queue.offer(temp.left);
                if(temp.right!=null) queue.offer(temp.right);
            }
            avg.add(sum/level);
            sum=0.0;
        }
        return avg;
    }
}
