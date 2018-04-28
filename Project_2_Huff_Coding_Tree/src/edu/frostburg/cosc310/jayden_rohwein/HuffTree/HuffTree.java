
package edu.frostburg.cosc310.jayden_rohwein.HuffTree;

/**
 *
 * @author Jayden
 */
public class HuffTree<E> implements Comparable<HuffTree<E>>  {
    
    
    private HuffBaseNode<E> root; // root of the tree
    
    /*
    creates an empty tree
    */
    public HuffTree(){
        
        root = null;
    }
    
    /*
    creates a new tree with one node
    */
    public HuffTree(int k,E e){
        root = new HuffLeafNode(e, k); 
    }

    /*
    creates a huffman tree
        @param left - node to be left child
        @param right - node of right child
    
    */
    public HuffTree(HuffBaseNode<E> left, HuffBaseNode<E> right){
        
        root = new HuffInternalNode<>(left,right);
    }
    
    
    
    /*
    @return reference to the root of tree
    */
    public HuffBaseNode<E> root(){
        
        return root;
    }


    /*
    @return - weight of root
    */
    public int weight() {
        return root.weight();
    }
    
    /*
    compares two tree's by their weight
        @param that - tree being compared to our current tree
        @return -1 that.weight is greater
        @return 0  trees are equal
        @return 1 current tree is bigger
    */
    public int compareTo(HuffTree<E> that) {
        
        if(root.weight() < that.weight())
            return -1;
        
        else if(root.weight() == that.weight())
            
            return 0;
        
        else return 1;
    }
    
    /*
    adds  a hufftree to this one
    @param ht - tree that will be added to this one
    */
    public void addTrees(HuffTree ht){
        
        if(ht.weight() > this.weight()){
            root = new HuffInternalNode(this.root(),ht.root());
        }
        else
            root = new HuffInternalNode(this.root(),ht.root());
            
    }
    
    
    
    

}




