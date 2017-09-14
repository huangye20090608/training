package com.huangye.training.demo.tree;

/**
 * Created by huangye on 2017/8/27.
 */
public class BinaryTreeNode {

    private TreeNode root;

    public BinaryTreeNode(TreeNode root) {
        this.root = root;
    }

    public BinaryTreeNode() {
        this.root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    class TreeNode implements Comparable<TreeNode> {

        private int data;
        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode(int data, TreeNode leftChild, TreeNode rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }

        public int compareTo(TreeNode o) {
            return (this.data > o.getData()) ? 1 : (this.data < o.getData() ? -1 : 0);
        }
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    public void preSort(TreeNode root) {
        if (null != root) {
            visitTreeNode(root);
            preSort(root.getLeftChild());
            preSort(root.getRightChild());
        }
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public void postSort(TreeNode root) {
        if (null != root) {
            postSort(root.getLeftChild());
            postSort(root.getRightChild());
            visitTreeNode(root);
        }
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void inSort(TreeNode root) {
        if (null != root) {
            inSort(root.getLeftChild());
            visitTreeNode(root);
            inSort(root.getRightChild());
        }
    }

    public void visitTreeNode(TreeNode root) {
        System.out.println(root.getData());
    }

    public int height(TreeNode node) {
        if (null == node) {
            return 0;
        } else {
            int i = height(node.getLeftChild());
            int j = height(node.getRightChild());
            return i < j ? j + 1 : i + 1;
        }
    }

    public int size(TreeNode node) {
        if (null == node) {
            return 0;
        } else {
            return 1 + size(node.getLeftChild()) + size(node.getRightChild());
        }

    }

    public void clear(TreeNode node) {
        if (node != null) {
            clear(node.getLeftChild());
            clear(node.getRightChild());
            node = null;
        }
    }

    public boolean isEmpty(TreeNode root) {
        return root == null;
    }

    public void insertNode(TreeNode node, int data) {
        if (root == null) {
            root = new TreeNode(data, null, null);
        } else {
            if (node.getData() < data) {
                //右子树
                if (node.getRightChild() == null) {
                    //node.setRightChild(new TreeNode(data, null, null));
                    node.rightChild = new TreeNode(data, null, null);
                } else {
                    insertNode(node.getRightChild(), data);
                }
            } else if (node.getData() > data) {
                //左子树
                if (node.getLeftChild() == null) {
                    //node.setLeftChild(new TreeNode(data, null, null));
                    node.leftChild = new TreeNode(data, null, null);
                } else {
                    insertNode(node.getLeftChild(), data);
                }
            } else {
                System.out.println("插入报错!!!!");
            }
        }
    }

    public static void main(String args[]) {
        int data[] = {5, 2, 3, 4, 1, 6, 7, 8, 9};
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode();
        for (int i = 0; i < data.length; i++) {
            binaryTreeNode.insertNode(binaryTreeNode.root, data[i]);
        }
        System.out.println("前序遍历：");
        binaryTreeNode.preSort(binaryTreeNode.root);
        System.out.println("中序遍历：");
        binaryTreeNode.inSort(binaryTreeNode.root);
        System.out.println("后序遍历：");
        binaryTreeNode.postSort(binaryTreeNode.root);
        System.out.println("高度：" + binaryTreeNode.height(binaryTreeNode.root));
        System.out.println("大小：" + binaryTreeNode.size(binaryTreeNode.root));
    }
}
