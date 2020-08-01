package com.challenage.domain;

public class ListNodeBuilder {

    private ListNodeBuilder() {
    }

    public static ListNode createListNodeAndGetFirstNode(int[] nums) {
        ListNode firstNode =null,currentNode=null;
        for (int num : nums) {
            if(firstNode == null){
                firstNode = new ListNode(num);
                currentNode = firstNode;
            }else{
                currentNode.next = new ListNode(num);
                currentNode = currentNode.next;
            }
        }
        return firstNode;
    }

    public static String toString(final ListNode firstNode){
        StringBuilder result = new StringBuilder();
        ListNode currentNode = firstNode;
        if(currentNode != null){
            result.append(currentNode.val+"");
            while (currentNode.next != null){
                result.append("->"+currentNode.next.val);
                currentNode = currentNode.next;
            }
        }
        return result.toString();
    }
}
