package com.pshat.learning.datastructures.treeds;

/**
 * Created by Prashant on 08-05-2019.
 */
public class TreeNode {
    private int data;
    private TreeNode leftNode;
    private TreeNode rightNode;

    public TreeNode(int data, TreeNode leftNode, TreeNode rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    /*
    No-args,just for plain object creation
     */
    public TreeNode() {
    }

    /**
    *@param value  value to be inserted.
    *@return if inserted true,else false;

    * This method will firstly be called from root instance, if the data of this node is equal to the
       value passed,it will return false, as it doesn't support duplicates.
    * if the value is greater than the data , means it will go to the right node,if right node
       is empty then  value(as a node) will be placed here else we will call again insert() on the
       instance of rightNode & same procedure will be followed till it finds the right place for insertion.
    * if the value is smaller than the data , means it will go to the left node,if left node is empty
       then value(as a node) will be placed here else we will call again insert() on the instance of
       leftNode & same procedure will be followed till it finds the right place for insertion.

     */
    public boolean insert(int value){
        boolean isInserted = false;
        if(value == data){
            return isInserted;
        }else if(value > data){
            if(this.rightNode == null){
                TreeNode right = new TreeNode(value,null,null);
                this.rightNode = right;
            }else{
                this.rightNode.insert(value);
            }
        }else if(value < data){
            if(this.leftNode == null) {
                TreeNode left = new TreeNode(value, null, null);
                this.leftNode = left;
            }else{
                this.leftNode.insert(value);
            }
        }
        return isInserted;
    }

    public void levelTraversal(){
        TreeNode root = this;
        System.out.println(root.data);
        while(root != null){

        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }
}
