package code_exercises;

import java8.code_exercises.ListNode;
import java8.code_exercises.TreeNode;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java8.code_exercises.Easy.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class EasyTest {

    @Test
    public void sumOfTwoNosTest(){
        assertThat(sumOfTwoNos(3,5), is(8));
    }

    @Test
    public void sumMult35Test() {
        assertThat(sumMult35(3), is(3));
        assertThat(sumMult35(5), is(8));
        assertThat(sumMult35(10), is(33));
    }

    @Test
    public void factTest() {
        assertThat(fact(4), is(24));
    }

    @Test
    public void linearSearchTest() {
        assertThat(linearSearch(4, new int[]{1,3,4,2}), is(2));
        assertThat(linearSearch(4, new int[]{1,3,2}), is(-1));
        assertThat(linearSearch(4, new int[]{1,3,5,8,4,2}), is(4));
    }

    @Test
    public void reverseStringTest() {
        assertThat(reverseString("java interview"), is("weivretni avaj"));
        assertThat(reverseStringIterate("java interview"), is("weivretni avaj"));
        assertThat(reverseStringRecursive("java interview"), is("weivretni avaj"));
    }

    @Test
    public void maxValueTest() {
        assertThat(maxValue(new int[]{3,2,6,8}), is(8));
        assertThat(maxValue(new int[]{3,2,6,4}), is(6));
    }

    @Test
    public void avgValueTest() {
        assertThat(avgValue(new int[]{3,2,6}), is(3));
        assertThat(average(asList(1,2,3)), is(Double.parseDouble("2")));
    }

    @Test
    public void upperCaseTest() {
        assertThat(upperCase(asList("abc", "def", "xy z")), is(asList("ABC","DEF","XY Z")));
    }

    @Test
    public void nthOddTest() {
        assertThat(nthOdd(asList(2,3,8,5,2,4,7,6,9),3), is(7));
        assertThat(nthOdd(asList(2,3,8,5,2,4,7,6,9),4), is(9));
        assertThat(nthOdd(asList(2,3,8,5,2,4,7,6,9),5), is(-1));
    }

    @Test
    public void nosOfNodesTreeTest() {
        assertThat(nosOfNodesTree(createTreeNodes(1)), is(1));
        assertThat(nosOfNodesTree(createTreeNodes(2)), is(2));
        assertThat(nosOfNodesTree(createTreeNodes(3)), is(3));
        assertThat(nosOfNodesTree(createTreeNodes(6)), is(8));
    }

    @Test
    public void nosOfNodesListTest() {
        assertThat(nosOfNodesList(null), is(0));
        assertThat(nosOfNodesList(createListNode(3)), is(3));
        assertThat(nosOfNodesList(createListNode(10)), is(10));
    }

    private ListNode createListNode(int count) {
        ListNode listNode = new ListNode(0);
        ListNode currentNode = listNode;
        for (int i = 1; i < count; i++) {
            ListNode tmp = new ListNode(i);
            currentNode.setNext(tmp);
            currentNode = tmp;
        }
        return listNode;
    }

    private TreeNode createTreeNodes(int count) {
        return createTreeNode(true, true, count);
    }

    private TreeNode createTreeNode(boolean left, boolean right, int count) {
        TreeNode treeNode = new TreeNode();
        count--;
        if (left && count > 0) {
            treeNode.setLeftTreeNode(createTreeNode(left, right, --count));
        }
        if (right && count > 0) {
            treeNode.setRightTreeNode(createTreeNode(left, right, --count));
        }
        return treeNode;
    }
    
    
}
