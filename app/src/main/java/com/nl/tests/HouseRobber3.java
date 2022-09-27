package com.nl.tests;

public class HouseRobber3 {

    public static void main(String[] args) {

        int[] arr = new int[]{};
        //System.out.println("Decode ways = " + numDecodings(s));
    }

    public static int rob(TreeNode root) {

        Pair valPair = dfs(root);
        int maxVal = Math.max(valPair.first, valPair.second);

        return maxVal;
    }

    public static Pair dfs(TreeNode node) {

        int value = node.val;

        TreeNode left = node.left;
        TreeNode right = node.right;

        Pair leftPair = new Pair(0, 0);
        if(left != null) {
            leftPair = dfs(left);
        }

        Pair rightPair = new Pair(0, 0);
        if(right != null) {
            rightPair = dfs(right);
        }

        int leftVal = leftPair.second + rightPair.second;
        int maxRightVal = leftPair.max() + rightPair.max();

        return new Pair(value + leftVal, maxRightVal);
    }

    public static class Pair {

        public int first;
        public int second;

        public Pair() {

        }

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int max() {
            return Math.max(this.first, this.second);
        }
    }

    public static class TreeNode {

        int val;

        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}