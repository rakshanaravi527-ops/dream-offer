class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {

        int n = 0;
        ListNode curr = head;

        while (curr != null) {
            n++;
            curr = curr.next;
        }

        ListNode[] result = new ListNode[k];

        int partSize = n / k;

        int extra = n % k;

        curr = head;

        for (int i = 0; i < k; i++) {

            result[i] = curr;

            int size = partSize;

            if (i < extra) {
                size++;
            }

            for (int j = 1; j < size && curr != null; j++) {
                curr = curr.next;
            }

            if (curr != null) {
                ListNode nextPart = curr.next;
                curr.next = null;
                curr = nextPart;
            }
        }

        return result;
    }
}