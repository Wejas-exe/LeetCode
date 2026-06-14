/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        int size =0;
        int sum =0;
        int maxSum =0;
        ListNode tail = head ;
        while(tail!=null){
            size++;
            tail= tail.next;
        }
        int[] arr = new int[size];
        ListNode temp = head;
        int i=0;
        while(temp!=null){
            arr[i] = temp.val;
            temp=temp.next;
            i++;
        }
        for(int j =0;j<size;j++){
            sum = arr[j] +arr[size-j-1];
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }
}