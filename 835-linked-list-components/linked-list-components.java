class Solution {
    public int numComponents(ListNode head, int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int count = 0;
        ListNode curr = head;

        while (curr != null) {

            if (set.contains(curr.val)) {

                if (curr == head || !set.contains(getPreviousValue(head, curr))) {
                    count++;
                }
            }

            curr = curr.next;
        }

        return count;
    }

    private int getPreviousValue(ListNode head, ListNode target) {
        ListNode curr = head;

        while (curr.next != target) {
            curr = curr.next;
        }

        return curr.val;
    }
}