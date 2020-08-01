package com.challenage.medium;

import com.challenage.domain.ListNode;

public class AddTwoNumbers {
    public ListNode solution(ListNode l1, ListNode l2) {
        int total=0;
        int count = 1;
        ListNode firstNode = null;
        ListNode currentNode = null;
        while(null != l1 || null != l2){
            total += ((null!=l1?l1.val:0) + (null!=l2?l2.val:0)) * count;
            l1 = (null!=l1?l1.next:null);
            l2 = (null!=l2?l2.next:null);
            count = count*10;
        }
        String totalStr = ""+total;
        for(int i = totalStr.length(); i>0;i--){
            if(firstNode == null){
                firstNode = new ListNode(Character.getNumericValue(totalStr.charAt(i-1)));
                currentNode = firstNode;
            }else{
                currentNode.next = new ListNode(Character.getNumericValue(totalStr.charAt(i-1)));
                currentNode = currentNode.next;
            }
        }
        return firstNode;
    }
}
