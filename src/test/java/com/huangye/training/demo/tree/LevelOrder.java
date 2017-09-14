package com.huangye.training.demo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by huangye on 2017/9/13.
 */
public class LevelOrder {

    public static void main(String args[]){
        int data[] = {5, 2, 3, 4, 1, 6, 7, 8, 9};
        LevelOrder binaryTreeNode = new LevelOrder();
        for (int i = 0; i < data.length; i++) {
            binaryTreeNode.insertNode(binaryTreeNode.root, data[i]);
        }
        //System.out.println("前序遍历：");
        //binaryTreeNode.preSort(binaryTreeNode.root);
        System.out.println("层次遍历：");
        levelIterator(binaryTreeNode.root);
        System.out.println("层次分组遍历：");
        List<TreeNode> finalQueue = new ArrayList<TreeNode>();
        levelListIterator(binaryTreeNode.root,finalQueue);

        for(TreeNode treeNode : finalQueue){
            System.out.println(treeNode.getData() + ":" + treeNode.getLevel());
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

    public void visitTreeNode(TreeNode root) {
        System.out.println(root.getData());
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

    private TreeNode root;

    public LevelOrder(TreeNode root) {
        this.root = root;
    }

    public LevelOrder() {
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
        private int level;

        public TreeNode(int data, TreeNode leftChild, TreeNode rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public int getData() {
            return data;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
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

    public static void levelIterator(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode current = null;
        queue.offer(root);//将根节点入队
        while (!queue.isEmpty()) {
            current = queue.poll();//出队队头元素并访问
            System.out.print(current.getData() + "-->");
            if (current.getLeftChild() != null)//如果当前节点的左节点不为空入队
            {
                queue.offer(current.getLeftChild());
            }
            if (current.getRightChild() != null)//如果当前节点的右节点不为空，把右节点入队
            {
                queue.offer(current.getRightChild());
            }
        }

    }

    public static void levelListIterator(TreeNode root,List<TreeNode> finalQueue) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode current = null;
        int levelIndex = 1;
        queue.offer(root);//将根节点入队

        while (!queue.isEmpty()) {
            current = queue.poll();//出队队头元素并访问
            current.setLevel(levelIndex);
            finalQueue.add(current);


            if (current.getLeftChild() != null)//如果当前节点的左节点不为空入队
            {
                queue.offer(current.getLeftChild());

                current.getLeftChild().setLevel(++levelIndex);
                finalQueue.add(current.getLeftChild());
            }
            if (current.getRightChild() != null)//如果当前节点的右节点不为空，把右节点入队
            {
                queue.offer(current.getRightChild());
                if(current.getLeftChild() != null){
                    current.getRightChild().setLevel(levelIndex);
                }else{
                    current.getRightChild().setLevel(++levelIndex);
                }
                finalQueue.add(current.getRightChild());
            }
        }
    }
}
