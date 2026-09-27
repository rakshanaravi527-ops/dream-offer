import java.util.*;

class LFUCache {

    class Node {
        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {

        Node head;
        Node tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        void addFirst(Node node) {

            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        void remove(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        Node removeLast() {

            if (size == 0) {
                return null;
            }

            Node node = tail.prev;
            remove(node);

            return node;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    private int capacity;
    private int minFreq;

    private HashMap<Integer, Node> keyMap;

    private HashMap<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {

        this.capacity = capacity;
        this.minFreq = 0;

        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {

        if (!keyMap.containsKey(key)) {
            return -1;
        }

        Node node = keyMap.get(key);

        // Increase frequency
        increaseFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        if (keyMap.containsKey(key)) {

            Node node = keyMap.get(key);

            node.value = value;

            increaseFrequency(node);

            return;
        }

        if (keyMap.size() == capacity) {

            DoublyLinkedList list = freqMap.get(minFreq);

            Node lru = list.removeLast();

            keyMap.remove(lru.key);
        }

        Node newNode = new Node(key, value);

        keyMap.put(key, newNode);

        minFreq = 1;

        DoublyLinkedList list =
                freqMap.computeIfAbsent(
                        1,
                        k -> new DoublyLinkedList()
                );

        list.addFirst(newNode);
    }

    private void increaseFrequency(Node node) {

        int oldFreq = node.freq;

        DoublyLinkedList oldList = freqMap.get(oldFreq);

        oldList.remove(node);

        if (oldFreq == minFreq && oldList.isEmpty()) {
            minFreq++;
        }

        node.freq++;

        DoublyLinkedList newList =
                freqMap.computeIfAbsent(
                        node.freq,
                        k -> new DoublyLinkedList()
                );

        newList.addFirst(node);
    }
}