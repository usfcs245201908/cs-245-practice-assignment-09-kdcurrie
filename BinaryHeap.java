import java.util.*;
/************************************
 * Minimum Priority Queue Implementation
 ***********************************/
public class BinaryHeap {

    int[] data;
    int size;

    public BinaryHeap() {
        data = new int[10];
        size = 0;
    }

    public void add(int item) {
        if(size == data.length) {
            growArray();
        }
        data[size++] = item; //data[size++] will set data[0] = item and then increment size
        int child = size-1;
        int parent = (child-1)/2;

        while(parent >= 0 && (data[parent] > data[child])) {
            swap(parent, child);
            child = parent;
            parent = (child-1)/2;
        }
    }

    public int remove() {
        if(size <= 0) {
            throw new IndexOutOfBoundsException();
        }
        int trash = data[0];
        data[0] = data[--size];
        siftdown(0);
        return trash;
    }

    private void siftdown(int index) {
        int child = (2*index)+1;
        if(child < size) {
            if(child+1 < size && data[child] > data[child+1]) {
                child++;
            }
            if(data[index] > data[child]) {
                swap(index, child);
                siftdown(child);
            }
        }
    }

    private void swap(int x, int y) {
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }

    private void growArray() {
        int[] array = new int[(data.length)*2];
        for(int i = 0; i < data.length; i++) {
            array[i] = data[i];
        }
        data = array;
    }
}
