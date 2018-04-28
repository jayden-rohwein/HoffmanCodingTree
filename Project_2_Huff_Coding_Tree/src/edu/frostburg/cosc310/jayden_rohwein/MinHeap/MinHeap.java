
package edu.frostburg.cosc310.jayden_rohwein.MinHeap;

/**
 *
 * @author Jayden
 */
public class MinHeap{
    
    private final int[] Heap; // array of frequencies 
    private final int   size; //size of array
    private       int   n;    //number of elements
    
    /*
    creates a minHeap
        @param h - array of elements 
        @param num - size of heap
        @param max - maximum elements to be help in array
    */
    public MinHeap(int[] h, int num, int max) {
        
        Heap = h;
        n = num;
        size = max;
        
        buildheap();
    }
    
    public MinHeap(int max){
        size = max;
        n = 0;
        Heap = new int[max];
    }
    
    //-------------------------------------------------------------[ Accessors ]
    
    /*
    @return size of heap
    */
    public int heapsize() {
        
        return n;
    }
    
    public int view(int index){
        assert (index > n) || (index < 0):"out of bounds";
        
        return Heap[index];
    }
    
    /*
    @param position of node to test
    @return true - is leaf
            false - not leaf
    */
    public boolean isLeaf(int pos) {
        
        return (pos >= n/2)&& (pos < n);
    }
    
    /*
    @param position of node to test  
    */
    public int leftchild(int pos) {
        
        assert pos < n/2: "position has no left child";
        
        return 2 * pos + 1;
    }
    
    /*
    @param position of node to test  
    */
    public int rightchild(int pos) {
        
        assert pos < (n/2) +1: "position has no right child";
        
        return 2 * pos + 2;
    }
    
     /*
    @param position of node to test  
    */
    public int parent(int pos) { 
        assert pos > 0: "Position has no parent";
        
        return(pos -1)/2;
    }
 //--------------------------------------------------------------[ Mutators ]
    
    /*
    arranges nodes to correct spot in array
    */
    public void buildheap() {
        
        for(int i = n/2 -1; i >= 0; i--) {
            
            siftdown(i);
        }
    }
    
    /*
    inserts a node with the element into the array
    @param val - element to be placed in node
    */
    public void insert(int val) {
        
        //checks if heap is too big
        assert n < size : "Heap is full";
        
        //keeps track of array size
        int curr = n++;
        
        //moves element into right place in array
        Heap[curr] = val;
        while ((curr != 0) && (Heap[curr] < Heap[parent(curr)])){
            
            swap(Heap, curr, parent(curr));
            curr = parent(curr);
        }
    }

    /*
    remvoes the minimum node from heap
        @return element from minimum node
    */
    public int removemin() {
        
        assert n > 0: " Removing from empty heap";
        
        swap(Heap, 0, --n); // Swap minimum with last value
        
        if(n != 0) // Not on last element
        {
            siftdown(0); // put new heap root val in correct place
        }
        
        return Heap[n];
    }
    
    /*
    removes node from position
        @param pos - position of node to be removed from heap
        @ return - element of node to be removed
    */
    public int remove(int pos) {
        
        //if position is out of arrays bounds
        assert(pos >= 0) && (pos < n) : " Illegal heap position";
        
        if(pos ==(n-1)) {
            n--; // last element, no work to be done
    
        }else{
            swap(Heap, pos, --n); // swap with last value
            
            while((pos > 0) && (Heap[pos] < Heap[parent(pos)])){ //if we swapped in a small value, push it up
                
                swap(Heap, pos, parent(pos));
                pos = parent(pos);
            }
            
            if(n != 0) {
                
                siftdown(pos);
            }
        }
        
        return Heap[n];
    }
    
    //-------------------------------------------------------[ private methods ]
    
    /*
    
    */
    private void siftdown(int pos) {
        
        assert (pos >= 0) && (pos < n): "Illegal heap position";
        
        //while node is not a leaf
        while(!isLeaf(pos)){
            
            int j = leftchild(pos);
            if((j < (n -1)) && (Heap[j] > (Heap[j +1]))){
                
                j++; // j.is now index of child with greater value
            }
            
            if(Heap[pos] <= (Heap[j])) {
                return;
            }
            
            swap(Heap, pos, j);
            pos = j; // move down
        }
        
    }
    /*
    //swaps two elements in array
    */
    private void swap(int[] Heap, int n1, int n2){
        int temp = Heap[1];
        Heap[n1]= Heap[n2];
        Heap[2] = temp;        
    }
   
    
    
    
}

