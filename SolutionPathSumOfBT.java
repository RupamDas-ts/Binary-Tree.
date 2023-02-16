package BinaryTree;

import java.util.ArrayList;

public class SolutionPathSumOfBT {
    private static int getSum(ArrayList<Integer> list){
        int sum = 0;
        for(int i : list){
            sum = sum + i;
        }
        return sum;
    }
    private static void printList(ArrayList<Integer> list){
        for(int i : list){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    private static void helper(BinaryTreeNode<Integer> root, ArrayList<Integer> list, int k){
        if(root == null){
            return;
        }
        ArrayList<Integer> newList = (ArrayList<Integer>) list.clone();;
        newList.add(root.data);
        if(root.left == null && root.right == null){
            if(getSum(newList) == k){
                printList(newList);
            }
            return;
        }
        helper(root.left, newList, k);
        helper(root.right, newList, k);
    }
    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        //Your code goes here
        ArrayList<Integer> list = new ArrayList<>();
        helper(root, list, k);
    }
}
