package com.sagr.marketing.system.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sasha on 31.05.14.
 */
public class TreeNode<T, D> {
    private TreeNode<T, D> parent;
    private List<TreeNode<T, D>> children = new ArrayList<TreeNode<T, D>>();
    private T data;
    private D editionData;

    public TreeNode(T data, D editionData) {
        this.data = data;
        this.editionData = editionData;
    }

    public TreeNode<T, D> getParent() {
        return parent;
    }

    public void setParent(TreeNode<T, D> parent) {
        this.parent = parent;
        parent.addChild(this);
    }

    public List<TreeNode<T, D>> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode<T, D>> children) {
        this.children = children;
    }

    public void addChild(TreeNode<T, D> child) {
        if (!children.contains(child)) {
            children.add(child);
            child.setParent(this);
        }
    }

    public void removeChild(TreeNode<T, D> child) {
        if (children.contains(child)) {
            children.remove(child);
            child.setParent(null);
        }
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public D getEditionData() {
        return editionData;
    }

    public void setEditionData(D editionData) {
        this.editionData = editionData;
    }

    @Override
    public String toString() {
        return (data == null ? super.toString() : data.toString()) + (editionData == null ? "" : " : " +editionData.toString());
    }
}
