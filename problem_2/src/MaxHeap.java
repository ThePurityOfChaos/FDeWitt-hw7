public class MaxHeap implements Heap {
    int size;

    Integer[] data;

    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }

    // build a heap based on data
    // to be implemented in O(nlogn)
    public void MaxHeapLogN(Integer[] data) {
        // homework
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {
        // homework
    }

    // add an item to the heap
    public boolean add(Integer item) {
        // homework
        return false;
    }

    // return the max item in the heap
    public Integer get() {
        // homework
        return null;
    }

    // remove the root item
    public Integer pop() {
        // homework
        return null;
    }
}
