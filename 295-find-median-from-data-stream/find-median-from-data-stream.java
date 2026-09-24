import java.util.*;

class MedianFinder {

    PriorityQueue<Integer> maxHeap;

    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        maxHeap.offer(num);

       
        if (!maxHeap.isEmpty() && !minHeap.isEmpty()
                && maxHeap.peek() > minHeap.peek()) {

            int value = maxHeap.poll();
            minHeap.offer(value);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}