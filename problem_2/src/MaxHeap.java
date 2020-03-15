public class MaxHeap implements Heap {
    int size;
    Integer[] data;

    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }

    // build a heap based on data
    // to be implemented in O(nlogn)
    //all me, no assistance
    public void MaxHeapLogN(Integer[] data) {
        for (int i = 0; i < data.length; i++) //n
            this.add(data[i]);//logn
    }

    // build a heap based on data
    // to be implemented in O(n)
    //O(n) is harder, I needed some help
    public void MaxHeapN(Integer[] data) {
    this.data= new Integer[data.length];
    this.data= data;
    this.size=data.length;
    int lastParent = (size-2)/2;
    for(int i=lastParent; i>=0; i--)
    heapifyAll(i);
    }

    // add an item to the heap, this is log(n) time
    //had some help from GFG, but changed it up a bit
    public boolean add(Integer item) {
        if (size >= data.length){
            return false;
        }

        data[size] = item;
        heapifyOne(size);
        size++;
        return true;
    }

    private void heapifyOne(int i) {
        int curr = i;
        if(data[curr]!=null) {
            while (data[curr] > data[(curr-1)/ 2]) {
                System.out.println(data[curr] + " " + data[curr / 2]);
                    swap(curr, (curr - 1) / 2);
                    curr = (curr - 1) / 2;
                }
            }
        }


    private void heapifyAll(int i) {
        if (isLeaf(i)) return;
        if(i*2+1>=data.length-1) return;
        if (data[i] < data[(i * 2)+1] || data[i] < data[(i * 2) + 2])
            if (data[(i * 2)+1] > data[(i * 2) + 2]) {
                swap(i, (i * 2)+1);
                heapifyAll((i * 2)+1);
            } else {
                swap(i, (i * 2)+2);
                heapifyAll((i * 2)+2);
            }
    }

    private void swap(int curr, int par) {
        Integer temp = data[curr];
        data[curr] = data[par];
        data[par] = temp;
    }

    private boolean isLeaf(int i) {
        return i >= (size / 2)+1&&i<=size;
    }

    // return the max item in the heap
    public Integer get() {
        if (size != 0) {
            return data[0];
        }
        return null;
    }

    // remove the root item
    public Integer pop() {
        if (size!=0) {
            Integer result = data[0];
            data[0] = null;
            size--;
            if (data.length >= 2)
                if (data[1] > data[2])
                    heapifyAll(1);
                else heapifyAll(2);
            return result;
        }
        return null;
    }

    public Integer[] toArray() {
        Integer[] result = new Integer[data.length];
        System.arraycopy(data, 0, result, 0, data.length);
        return result;
    }
}
