import java.util.*;

class AllOne {

    class Bucket {
        int count;
        HashSet<String> keys;
        Bucket prev;
        Bucket next;

        Bucket(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    HashMap<String, Bucket> map;

    Bucket head;
    Bucket tail;

    public AllOne() {
        map = new HashMap<>();

        head = new Bucket(0);
        tail = new Bucket(0);

        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {

        if (!map.containsKey(key)) {

            Bucket first = head.next;

            if (first == tail || first.count != 1) {
                Bucket newBucket = new Bucket(1);
                insertAfter(head, newBucket);
                first = newBucket;
            }

            first.keys.add(key);
            map.put(key, first);

        } else {

            Bucket current = map.get(key);
            int newCount = current.count + 1;

            Bucket nextBucket = current.next;

            if (nextBucket == tail || nextBucket.count != newCount) {
                Bucket newBucket = new Bucket(newCount);
                insertAfter(current, newBucket);
                nextBucket = newBucket;
            }

            nextBucket.keys.add(key);
            map.put(key, nextBucket);

            current.keys.remove(key);

            if (current.keys.isEmpty()) {
                removeBucket(current);
            }
        }
    }

    public void dec(String key) {

        Bucket current = map.get(key);

        if (current.count == 1) {

            map.remove(key);
            current.keys.remove(key);

            if (current.keys.isEmpty()) {
                removeBucket(current);
            }

        } else {

            int newCount = current.count - 1;
            Bucket prevBucket = current.prev;

            if (prevBucket == head || prevBucket.count != newCount) {
                Bucket newBucket = new Bucket(newCount);
                insertAfter(prevBucket, newBucket);
                prevBucket = newBucket;
            }

            prevBucket.keys.add(key);
            map.put(key, prevBucket);

            current.keys.remove(key);

            if (current.keys.isEmpty()) {
                removeBucket(current);
            }
        }
    }

    public String getMaxKey() {

        if (tail.prev == head) {
            return "";
        }

        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {

        if (head.next == tail) {
            return "";
        }

        return head.next.keys.iterator().next();
    }

    private void insertAfter(Bucket prev, Bucket newBucket) {

        newBucket.next = prev.next;
        newBucket.prev = prev;

        prev.next.prev = newBucket;
        prev.next = newBucket;
    }

    private void removeBucket(Bucket bucket) {

        bucket.prev.next = bucket.next;
        bucket.next.prev = bucket.prev;
    }
}