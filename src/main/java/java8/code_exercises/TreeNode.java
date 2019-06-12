package java8.code_exercises;

import java.util.Optional;

public class TreeNode {
    private TreeNode leftTreeNode;
    private TreeNode rightTreeNode;

    public TreeNode() {
    }

    public Optional<TreeNode> getLeftTreeNode() {
        return Optional.ofNullable(leftTreeNode);
    }

    public void setLeftTreeNode(TreeNode leftTreeNode) {
        this.leftTreeNode = leftTreeNode;
    }

    public Optional<TreeNode> getRightTreeNode() {
        return Optional.ofNullable(rightTreeNode);
    }

    public void setRightTreeNode(TreeNode rightTreeNode) {
        this.rightTreeNode = rightTreeNode;
    }
}
