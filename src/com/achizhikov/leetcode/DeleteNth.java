package com.achizhikov.leetcode;

import java.util.ArrayList;

public class DeleteNth {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode node = head;
        list.add(node);
        while (node.next != null) {
            node = node.next;
            list.add(node);
        }
        if (list.size() == 1) return null;
        if (list.size() == n) return head.next;
        list.get(list.size() - 1 - n).next = (n == 1 ? null : list.get(list.size() - n + 1));
        return head;
    }
}
