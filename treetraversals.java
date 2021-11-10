package com.company;

class treeNode {
    int val;
    treeNode left;
    treeNode right;

    treeNode(int val) {
        this.val = val;
    }
}

public class treetraversals {
    treeNode root;

    public void inorder() {
        if (root != null) {
            inorder(root);
        }
    }

    private void inorder(treeNode t) {
        if (root != null) {
            inorder(t.left);
            System.out.println(t.val);
            inorder(t.right);
        }
    }

    public void preorder() {
        if (root != null) {
            preorder(root);
        }
    }

    private void preorder(treeNode t) {
        if (root != null) {
            preorder(t.left);
            System.out.println(t.val);
            preorder(t.right);
        }
    }

    public void postorder() {
        if (root != null) {
            postorder(root);
        }
    }

    private void postorder(treeNode t) {
        if (root != null) {
            postorder(t.left);
            System.out.println(t.val);
            postorder(t.right);
        }
    }
}
