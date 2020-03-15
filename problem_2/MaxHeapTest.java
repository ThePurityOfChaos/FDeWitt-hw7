import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MaxHeapTest {
    Integer[][] datasets = {{},{0},{0,1,2},{0,1,2,3,4,5,7,23,55,96,1000,-12},{5,5,5,5,16,4}};
    @Test
    public void MaxHeapLogN(){ //this also tests add due to how I set up MaxHeapLogN();
        Integer[][] expected = {{},{0},{2,0,1},{1000,96,5,7,55,1,4,0,3,2,23,-12},{16,5,5,5,5,4}};
        MaxHeap[] actual = new MaxHeap[datasets.length];

        for(int i=0; i<datasets.length; i++) {
            actual[i] = new MaxHeap(datasets[i].length);
            actual[i].MaxHeapLogN(datasets[i]);

        }
        for(int i=0; i<datasets.length; i++) {
            System.out.println(i);
            assertEquals(expected[i], actual[i].toArray());
        }
    }

    @Test
    public void get(){
        Integer[] expected = {null,0,2,1000,16};
        MaxHeap[] actual = new MaxHeap[datasets.length];
        for(int i=0; i<datasets.length; i++){
            actual[i] = new MaxHeap(datasets[i].length);
            actual[i].MaxHeapLogN(datasets[i]);
            assertEquals(expected[i],actual[i].get());
        }
    }
    @Test
    public void pop(){
        Integer[] expected = {null,0,2,1000,16};
        MaxHeap[] actual = new MaxHeap[datasets.length];
        for(int i=0; i<datasets.length; i++){
            actual[i] = new MaxHeap(datasets[i].length);
            actual[i].MaxHeapLogN(datasets[i]);
            assertEquals(expected[i],actual[i].pop());
            if(actual[i].size!=0)
            assertTrue(actual[i].size<datasets[i].length);
        }
    }
    @Test
            public void MaxHeapN(){
    Integer[][] expected = {{},{0},{2,1,0},{1000,96,7,55,4,5,2,23,3,1,0,-12},{16,5,5,5,5,4}};
    MaxHeap[] actual = new MaxHeap[datasets.length];
        for(int i=0; i<datasets.length; i++) {
        actual[i] = new MaxHeap(datasets[i].length);
        System.out.println(i);
        actual[i].MaxHeapN(datasets[i]);
    }
        for(int i=0; i<datasets.length; i++) {
            System.out.println(i);
            assertEquals(expected[i], actual[i].toArray());
        }
    }
    @Test
    public void PerfMaxHeapLogN() {
        int interval =10000;
        int quantity = 100;
        Integer[][] data = new Integer[quantity][];
        for(int i=0; i<data.length; i++){
            data[i] = new Integer[i*interval];
            for(int j=0; j<data[i].length; j++)
                data[i][j]=j;
        }
        long[] timeData = new long[data.length];
        for(int i=0; i<data.length; i++) {
            long start = System.nanoTime();
            MaxHeap time = new MaxHeap(data.length);
            time.MaxHeapLogN(data[i]);
            long end = System.nanoTime();
            timeData[i]=(end - start);
        }
        for(int i=0; i<quantity; i++)
            System.out.println(timeData[i]);
    }
    @Test
    public void PerfMaxHeapN() { // this is a great test :D
        int interval =10000;
        int quantity = 100;
        Integer[][] data = new Integer[quantity][];
        for(int i=0; i<data.length; i++){
            data[i] = new Integer[i*interval];
            for(int j=0; j<data[i].length; j++)
            data[i][j]=j;
        }
        long[] timeData = new long[data.length];
        for(int i=0; i<data.length; i++) {
            long start = System.nanoTime();
            MaxHeap time = new MaxHeap(data.length);
            time.MaxHeapN(data[i]);
            long end = System.nanoTime();
            timeData[i]=(end - start);
        }
        for(int i=0; i<quantity; i++)
        System.out.println(timeData[i]);
    }
}