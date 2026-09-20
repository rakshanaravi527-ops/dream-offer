class Solution {
        public ListNode insertionSortList(ListNode head) {

                // Dummy node before the sorted list
                        ListNode dummy = new ListNode(0);

                                ListNode current = head;

                                        while (current != null) {

                                                    // Save the next node before changing links
                                                                ListNode next = current.next;

                                                                            // Find the correct position
                                                                                        ListNode prev = dummy;

                                                                                                    while (prev.next != null && prev.next.val < current.val) {
                                                                                                                    prev = prev.next;
                                                                                                                                }

                                                                                                                                            // Insert current node
                                                                                                                                                        current.next = prev.next;
                                                                                                                                                                    prev.next = current;

                                                                                                                                                                                // Move to next unsorted node
                                                                                                                                                                                            current = next;
                                                                                                                                                                                                    }

                                                                                                                                                                                                            return dummy.next;
                                                                                                                                                                                                                }
                                                                                                                                                                                                                }
