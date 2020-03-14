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
    for(int i=0; i<data.length; i++) //n
        this.add(data[i]); //logn
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {

    }

    // add an item to the heap, this is log(n) time
    //had some help from GFG, but changed it up a bit
    public boolean add(Integer item) {
        if(size>=data.length-1){
            return false;
        }
        size++;
        data[size]=item;
        heapifyToRoot(size);
        return true;
    }
    private void heapifyToRoot(int i){
        int curr=i;
        while(data[curr]>data[curr/2]){
            swap(curr, curr/2);
            curr = curr/2;
        }
    }
    private void heapifyAll(int i){
        if(isLeaf(i)) return;
        if(data[i]<data[i*2+1] || data[i]<data[i*2+2])
            if(data[i*2+1]> data[i*2+2]){
            swap(i, i*2+1);
            heapifyAll(i*2+1);
        }
        else{
            swap(i,i*2+2);
            heapifyAll(i*2+2);
            }
    }

    private void swap(int curr, int par){
        Integer temp = data[curr];
        data[curr] = data[par];
        data[par]=temp;
    }
    private boolean isLeaf(int i){
        return i >= size / 2 && i <= size;
    }
    // return the max item in the heap
    public Integer get() {
        if(data!=null){
            return data[0];
        }
        return null;
    }

    // remove the root item
    public Integer pop() {
        if(data!=null){
            Integer result = data[0];
            data[0]=null;
            if(data.length>=2)
            if(data[1]>data[2])
                heapifyAll(1);
            else heapifyAll(2);
            return result;
        }
        return null;
    }
}
