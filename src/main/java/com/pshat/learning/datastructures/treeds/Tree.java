package com.pshat.learning.datastructures.treeds;

/**
 * Created by Prashant on 08-05-2019.
 */
public class Tree {
    /*
    It is the initializing point of a tree.
     */
    private TreeNode root;

    /*
    While adding element,we will firstly check if the initializing point i.e root is empty or not
    if the root is empty, then we will firstly create the root.
    Once root is created,we can insert the element as left node or right node by calling the insert
    method on root object.
     */
    public void add(int value){
        if(root == null){
            this.root = new TreeNode(value,null,null);
        }else{
            this.root.insert(value);
        }
    }

    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                '}';
    }
}
