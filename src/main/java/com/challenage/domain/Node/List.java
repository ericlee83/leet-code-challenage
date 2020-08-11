package com.challenage.domain.Node;

public interface List<T> {
    void insert(T data);
    void remove(T data);
    String traverseList();
    int size();
}
