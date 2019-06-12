package java8.code_exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Easy {

    public static int sumOfTwoNos(int i, int j) {
        return i + j;
    }

    public static int sumMult35(int n) {
        // Range 1 to n incl
        // filter mod 3 & 5
        // sum
        return IntStream.rangeClosed(1,n).filter(i -> (i%3==0) || (i%5==0)).sum();
    }

    //    factorial(4) = 4x3x2x1 = 24.
    public static int fact(int n) {
        // Term 1 return 1
        // rec n * fact(n-1)
        if (n == 1) {
            return 1;
        }
        return n * fact(n-1);
    }

    public static int linearSearch(int n, int[] arr) {
        // create Int stream till length
        // find match
        // return index
        OptionalInt first = IntStream.range(0, arr.length).filter(i -> n == arr[i]).findFirst();
        return first.orElse(-1);
    }


    public static String reverseString(String text) {
        return new StringBuffer(text).reverse().toString();
    }

    public static String reverseStringRecursive(String text) {
        // Terminator len/2
        // return char[], param i & char[]
        // swap
        // Rec forward
        char[] revChar = recurseRev(text.toCharArray(), 0);
        return new String(revChar);
    }

    private static char[] recurseRev(char[] arr, int i) {
        if (i >= arr.length/2) {
            return arr;
        }
        swap(arr, i);
        return recurseRev(arr, ++i);
    }

    private static void swap(char[] arr, int i) {
        char tmp = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = arr[i];
        arr[i] = tmp;
    }

    public static String reverseStringIterate(String text) {
        // In iterate
        // Iterate 0 to l/2
        // swap last 2 elements
        int len = text.length();
        char[] chars = text.toCharArray();
        IntStream.range(0, len/2).forEachOrdered(i-> {
            // swap
            swap(chars, i);
        });
        return new String(chars);
    }

    public static int maxValue(int[] nos) {
        return Arrays.stream(nos).max().orElse(0);
    }

    public static int avgValue(int[] nos) {
        return (int) Arrays.stream(nos).average().orElse(0);
    }

    public static Double average(List<Integer> list) {
        return list.stream().mapToInt(Integer::valueOf).average().orElse(0);
    }

    public static List<String> upperCase(List<String> lowerCaseList) {
        return lowerCaseList.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    /**
     * Nth Odd Element
     * Write a method that returns th nth element of a list. If the index of the element exceeds the list size, then return -1.
     */
    public static int nthOdd(List<Integer> nos, int nth) {
        // filter odd
        // skip n-1
        // or else -1
        return nos.stream().filter(i -> i%2!=0).skip(nth-1).findFirst().orElse(-1);
    }

    /**
     * Number Of Tree Nodes
     * Write a method that returns the number of nodes in a binary tree.
     * TreeNode API methods: treeNode.left() and treeNode.right().
     */
    public static int nosOfNodesTree(TreeNode treeNode) {
        // term if not left & right
        // count current
        // rec count left
        // rec count right
        // param count
        return countNode(treeNode);
    }

    private static int countNode(TreeNode treeNode) {
        int nodeCount = 1; // count current treeNode
        if (!treeNode.getLeftTreeNode().isPresent() && !treeNode.getRightTreeNode().isPresent()) {
            return nodeCount;
        }

        nodeCount += treeNode.getLeftTreeNode().map(Easy::countNode).orElse(0);
        nodeCount += treeNode.getRightTreeNode().map(Easy::countNode).orElse(0);
        return nodeCount;
    }

    public static int nosOfNodesList(ListNode listNode) {
        // if null ret 0
        // make current node & create count
        // while current node present add 1
        // reinitialize currrent node with next node
        if (listNode == null) {
            return 0;
        }
        int count = 0;
        Optional<ListNode> currentNode = Optional.of(listNode);
        while (currentNode.isPresent()) {
            count++;
            currentNode = currentNode.get().getNext();
        }

        return count;
    }
}
