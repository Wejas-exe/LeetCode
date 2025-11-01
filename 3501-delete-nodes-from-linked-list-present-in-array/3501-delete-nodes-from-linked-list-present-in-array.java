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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode temp = head;
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        ListNode node = null;
        ListNode prev = null;
        while(temp != null){
            if(set.contains(temp.val)){
                temp = temp.next;
                continue;
            }
            ListNode newNode = new ListNode(temp.val);
            if(node == null){
                node = newNode;
            }else{
                prev.next = newNode;
            }
            prev = newNode;
            temp = temp.next;
        }
        return node;
    }
}