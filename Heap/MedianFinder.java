import java.util.*;

public class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        // Max-Heap (Left half)
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // Min-Heap (Right half)
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        
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

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        
        System.out.println("Data Stream Shuru...");
        
        medianFinder.addNum(1);
        System.out.println("Added 1 -> Current Median: " + medianFinder.findMedian());
        
        medianFinder.addNum(2);
        System.out.println("Added 2 -> Current Median: " + medianFinder.findMedian());
        
        medianFinder.addNum(3);
        System.out.println("Added 3 -> Current Median: " + medianFinder.findMedian());
    }
}