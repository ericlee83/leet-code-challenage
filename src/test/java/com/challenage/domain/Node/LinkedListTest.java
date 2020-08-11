package com.challenage.domain.Node;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {


    @Test
    void insert() {
        LinkedList list = new LinkedList<Integer>();
        list.insert(1);
        list.insert(3);
        list.insert(9);
        assertEquals(9,list.getRoot().getData());
        assertEquals(3,list.getSize());
    }

    @Test
    void remove() {
        LinkedList list = new LinkedList<Integer>();
        list.insert(1);
        list.insert(3);
        list.insert(9);
        list.remove(3);
        assertEquals(2,list.size());
    }

    @Test
    void traverseList() {
        LinkedList list = new LinkedList<Integer>();
        list.insert(1);
        list.insert(3);
        list.insert(9);
        assertEquals("9->3->1",list.traverseList());
    }
}