// 215. Kth Largest Element in an Array
// https://leetcode.com/problems/kth-largest-element-in-an-array/description/

/**
 * Time Complexity: O(n * log k) where n is nums length
 * Space Complexity: O(k) since we maintain minheap of k size
 */

/**
 * Approach: We iterate over array and while maintain a min heap of k size.
 * If our heap size is greater than k, we are very sure that the 1st element is not the kth largest because its minimum
 * So, we remove first element and move forward.
 * At last we have min heap with k elements, and kth largest element on top.
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();

        for(int num: nums){
            pq.add(num);

            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.poll();
    }
}