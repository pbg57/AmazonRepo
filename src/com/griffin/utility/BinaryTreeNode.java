package com.griffin.utility;

public class BinaryTreeNode {

    private int key;
    private BinaryTreeNode leftChild = null;
    private BinaryTreeNode rightChild = null;

    public BinaryTreeNode(int key) {
        this.key = key;
    }

    public BinaryTreeNode(int key, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
        this.key = key;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public void setLeftChild(BinaryTreeNode child) {
        this.leftChild = child;
    }

    public void setRightChild(BinaryTreeNode child) {
        this.rightChild = child;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public int getKey() {
        return key;
    }
}
