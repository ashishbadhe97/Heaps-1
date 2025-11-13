// 23. Merge k Sorted Lists
// https://leetcode.com/problems/merge-k-sorted-lists/description/

/**
 * Time Complexity: O(k log n) where n is number of lists and k are total nodes
 * Space Complexity: O(n) n = no. of lists. since we use heap of n size
 */


/**
 * Approach: 
 * We add heads of all the lists to min heap. So that we can get min element from all lists
 * We iterate over the heap and in every iteration we remove min element and add to result list
 * Once min element is removed, we add it next non-null element to heap
 * Again, we check for min element and so on till the heap is empty
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(ListNode list: lists){ 
            if(list != null){
                pq.add(list);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();

            curr.next = min;
            curr = curr.next;

            if(min.next != null){
                pq.add(min.next);
            }
        }

        return dummy.next;
    }
}

/**
 * Time Complexity: O(n * k^2) since for every list, the previous list is 2 twice in length
 * Space Complexity:   O(1) since we dont use any auxillary linear space. We just modify the next pointer 
 */

/**
 * Approach: We start by merging 2 lists, 
 * then that merged list is merged with 3rd list and so on till we merge all lists.
 * And while merging we check for the smaller element and add to our result list
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode mergedList = dummy;
        for(ListNode list: lists){
            mergedList = merge(mergedList, list);
        }

        return mergedList.next;
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;

        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                curr.next = l2;
                l2 = l2.next;
            }else{
                curr.next = l1;
                l1 = l1.next;
            }

            curr = curr.next;
        }

        if(l1 != null){
            curr.next = l1;
        }

        if(l2 != null){
            curr.next = l2;
        }

        return dummy.next;
    }
}