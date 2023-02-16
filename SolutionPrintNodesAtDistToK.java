package BinaryTree;

class SolutionPrintNodesAtDistToK {
    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        //Your code goes here
        print(root,node,k);


    }

    private static int print(BinaryTreeNode<Integer> root, int node, int k)
    {
        //If tree is empty return -1
        if (root==null)
            return -1;

        int rootData=root.data;
        if (rootData==node)
        {
            printNodesAtDistanceK(root, k);
            return 0;
        }

        int leftSubTreeDist=0,rightSubTreeDist=0;

        leftSubTreeDist=print(root.left,node,k);
        if (leftSubTreeDist!=-1)
        {
            if(leftSubTreeDist+1==k)
            {
                System.out.println(rootData);
            }
            else
            {
                rightSubTreeDist=k-(leftSubTreeDist+1)-1;
                printNodesAtDistanceK(root.right, rightSubTreeDist);
            }
            return leftSubTreeDist+1;
        }

        rightSubTreeDist=print(root.right,node,k);
        if (rightSubTreeDist!=-1)
        {
            if(rightSubTreeDist+1==k)
            {
                System.out.println(rootData);
            }
            else
            {
                leftSubTreeDist=k-(rightSubTreeDist+1)-1;
                printNodesAtDistanceK(root.left, leftSubTreeDist);
            }
            return rightSubTreeDist+1;
        }
        return -1;
    }

    private static void printNodesAtDistanceK(BinaryTreeNode<Integer> root, int k)
    {
        if (root==null || k<0)
            return;

        if (k == 0)
        {
            System.out.println(root.data);
            return;
        }

        printNodesAtDistanceK(root.left,k-1);
        printNodesAtDistanceK(root.right,k-1);
    }
//    private static void printNodesAtDistK(BinaryTreeNode<Integer> root, int k) {
//        if (root == null) {
//            return;
//        }
//        if (k == 0) {
//            System.out.println(root.data);
//            return;
//        }
//        printNodesAtDistK(root.left, k - 1);
//        printNodesAtDistK(root.right, k - 1);
//    }
//
//    private static int findNode(BinaryTreeNode<Integer> root, int node, int level) {
//        if (root == null) {
//            return 0;
//        }
//        if (root.data == node) {
//            return level;
//        }
//        int leftLevel = findNode(root.left, node, level + 1);
//        if (leftLevel != 0) {
//            return leftLevel;
//        }
//        int rightLevel = findNode(root.right, node, level + 1);
//        return rightLevel;
//    }
//
//    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
//        int nodeLevel = findNode(root, node, 0);
//        if (nodeLevel == 0) {
//            return;
//        }
//        printNodesAtDistK(root, nodeLevel + k);
//        BinaryTreeNode<Integer> parent = root;
//        int distFromParent = nodeLevel;
//        while (parent != null) {
//            if (distFromParent == k) {
//                System.out.println(parent.data);
//                break;
//            } else if (distFromParent > k) {
//                parent = parent.left;
//                distFromParent -= 1;
//            } else {
//                parent = parent.right;
//                k -= distFromParent + 1;
//            }
//        }
//    }
}
