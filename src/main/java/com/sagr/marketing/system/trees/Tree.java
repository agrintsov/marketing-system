package com.sagr.marketing.system.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sasha on 31.05.14.
 */
public class Tree<T, D> {
    private List<TreeNode<T, D>> nodes = new ArrayList<TreeNode<T, D>>();
    private TreeNode<T, D> root;

    public List<TreeNode<T, D>> getNodes() {
        return nodes;
    }

    public void setNodes(List<TreeNode<T, D>> nodes) {
        this.nodes = nodes;
    }

    public TreeNode<T, D> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T, D> root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return toString("", root);
    }

    private String toString(String v, TreeNode<T, D> node) {
        if (node.getChildren() == null) {
            return node.toString() + "\n";
        }
        String s = "";
        String newV = v + "    ";
        for (TreeNode<T, D> child : node.getChildren()) {
            s += toString(newV, child);
        }
        return v + node.toString() + '\n' + s;
    }
}
