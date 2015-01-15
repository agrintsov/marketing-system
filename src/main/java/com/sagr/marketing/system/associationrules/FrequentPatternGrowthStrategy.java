package com.sagr.marketing.system.associationrules;

import com.sagr.marketing.system.trees.Tree;
import com.sagr.marketing.system.trees.TreeNode;

import java.util.*;

/**
 * Created by Sasha on 31.05.14.
 */
public class FrequentPatternGrowthStrategy<T> {
    private int support;

    private Map<T, Integer> objectFrequency = new HashMap<T, Integer>();
    List<List<FrequencyWrapper<T>>> orderedTransactions = new ArrayList<List<FrequencyWrapper<T>>>();

    public static void main(String[] args) {
        FrequentPatternGrowthStrategy<String> fpgs = new FrequentPatternGrowthStrategy<String>(3);
        List<List<String>> transactions = new ArrayList<List<String>>();
        transactions.add(new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e")));
        transactions.add(new ArrayList<String>(Arrays.asList("a", "b", "c")));
        transactions.add(new ArrayList<String>(Arrays.asList("a", "c", "d", "e")));
        transactions.add(new ArrayList<String>(Arrays.asList("b", "c", "d", "e")));
        transactions.add(new ArrayList<String>(Arrays.asList("b", "c")));
        transactions.add(new ArrayList<String>(Arrays.asList("b", "d", "e")));
        transactions.add(new ArrayList<String>(Arrays.asList("c", "d", "e")));
        fpgs.run(transactions);
    }

    public FrequentPatternGrowthStrategy(int support) {
        this.support = support;
    }

    public void run(List<List<T>> transactions) {
        countObjectFrequency(transactions);
        List<List<T>> sorted = sortTransactions(transactions);
        Tree<T, Integer> tree = buildTree(sorted);
        System.out.println(tree);
    }

    private void countObjectFrequency(List<List<T>> transactions) {
        for (List<T> transaction : transactions) {
            for (T o : transaction) {
                incrementObjectFrequency(o);
            }
        }
    }

    private List<List<T>> sortTransactions(List<List<T>> transactions) {
        List<List<T>> l = new ArrayList<List<T>>();
        for (List<T> transaction : transactions) {
            filterTransaction(transaction);
            if (transaction.size() == 0) {
                continue;
            }
            List<T> sortedTransaction = sortTransaction(transaction);
            l.add(sortedTransaction);
        }
        Collections.sort(l, new Comparator<List<T>>() {
            @Override
            public int compare(List<T> o1, List<T> o2) {
                Integer frequency1 = objectFrequency.get(o1.get(0));
                Integer frequency2 = objectFrequency.get(o2.get(0));
                return Double.compare(frequency1, frequency2) * -1;
            }
        });
        return l;
    }

    void filterTransaction(List<T> transaction) {
        for (int i = 0; i < transaction.size();) {
            T o = transaction.get(i);
            Integer frequency = objectFrequency.get(o);
            if (frequency == null || frequency < support) {
                transaction.remove(o);
            } else {
                i++;
            }
        }
    }

    private List<T> sortTransaction(List<T> transaction) {
        for (int j = 1; j < transaction.size(); j++) {
            T key = transaction.get(j);
            Integer keyValue = objectFrequency.get(key);
            int i = j - 1;
            while (i >= 0 && keyValue > objectFrequency.get(transaction.get(i))) {
                transaction.set(i + 1, transaction.get(i));
                i--;
            }
            transaction.set(i + 1, key);
        }
        return transaction;
    }

    private void incrementObjectFrequency(T o) {
        Integer frequency = 0;
        if (objectFrequency.containsKey(o)) {
            frequency = objectFrequency.get(o);
        }
        frequency++;
        objectFrequency.put(o, frequency);
    }

    private Tree<T, Integer> buildTree(List<List<T>> transactions){
        Tree<T, Integer> tree = new Tree<T, Integer>();
        List<TreeNode<T, Integer>> nodes = new ArrayList<TreeNode<T, Integer>>();
        TreeNode<T, Integer> root = new TreeNode<T, Integer>(null, null);
        tree.setRoot(root);
        nodes.add(root);
        tree.setNodes(nodes);
        for (List<T> transaction : transactions) {
            TreeNode<T, Integer> parent = root;
            for (T o : transaction) {
                List<TreeNode<T, Integer>> children = parent.getChildren();
                TreeNode<T, Integer> currentNode = getNodeByObject(children, o);
                if (currentNode == null){
                    currentNode = new TreeNode<T, Integer>(o, 1);
                    parent.addChild(currentNode);
                    nodes.add(currentNode);
                } else {
                    currentNode.setEditionData(currentNode.getEditionData() + 1);
                }
                parent = currentNode;
            }
        }
        return tree;
    }

    private TreeNode<T, Integer> getNodeByObject(List<TreeNode<T, Integer>> children, T o) {
        for (TreeNode<T, Integer> child : children) {
            if (child.getData().equals(o))
                return child;
        }
        return null;
    }
}
