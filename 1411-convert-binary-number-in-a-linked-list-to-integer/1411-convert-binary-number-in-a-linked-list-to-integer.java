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
    public int getDecimalValue(ListNode head) {
        int ans = 0 ;
        ListNode temp = head;
        int count = 0 ;
        while(temp != null){
            count ++;
            temp = temp.next;
        }
        temp = head ;
        count = count -1 ;
        while(temp != null){

            ans += temp.val*Math.pow(2,count);
            count--;
            temp = temp.next;
        }
        return ans;
    }
}