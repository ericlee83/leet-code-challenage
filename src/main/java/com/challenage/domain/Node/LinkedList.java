package com.challenage.domain.Node;

public class LinkedList<T extends Comparable<T>> implements List<T>{

    private Node<T> root;
    private int size;

    @Override
    public void insert(T data) {
        this.size++;
        if(this.root == null){
          this.root = new Node<T>(data);
        }else{
            insertNewNodeAtBeginning(data);
        }
    }

    private void insertNewNodeAtBeginning(T data) {
        Node<T> nextNode = new Node<T>(data);
        nextNode.setNextNode(this.root);
        this.root = nextNode;
    }

    private void insertNewNodeAtEnd(T data,Node<T> node){
        if(node.getNextNode() != null){
            insertNewNodeAtEnd(data,node.getNextNode());
        }else{
            node.setNextNode(new Node<T>(data));
        }
    }

    @Override
    public void remove(T data) {
        if(this.root == null) return;

        if(this.root.getData().compareTo(data) == 0){
            this.root = this.root.getNextNode();
            this.size--;
        }else{
            remove(data,this.root,this.root.getNextNode());
        }

    }

    private void remove(T data, Node<T> previousNode, Node<T> currentNode) {
        if(currentNode == null) return;
        if(currentNode.getData().compareTo(data) == 0){
            previousNode.setNextNode(currentNode.getNextNode());
            this.size --;
        }else{
            remove(data,currentNode,currentNode.getNextNode());
        }
    }

    @Override
    public String traverseList() {
        String result = "";
        if(this.root ==null) return result;
        result = printNode(this.root.getNextNode(),this.root.getData().toString());
        return result;
    }

    private String printNode(Node<T> nextNode, String result) {
        if(nextNode == null){
            return result;
        }else{
            return printNode(nextNode.getNextNode(),result+"->"+nextNode.getData().toString());
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    public Node<T> getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }
}
