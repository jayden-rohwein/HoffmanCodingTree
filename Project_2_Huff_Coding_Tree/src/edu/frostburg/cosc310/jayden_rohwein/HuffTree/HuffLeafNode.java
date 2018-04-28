
package edu.frostburg.cosc310.jayden_rohwein.HuffTree;

/**
 *
 * @author Jayden
 */
public class HuffLeafNode<E> implements HuffBaseNode {
    
    private E element;//element of node
    private int weight;//weight of node
    
    /*
    creates a leaf node
        @param el - element to be stored in node
        @param wt - weight of node
    */
    public HuffLeafNode(E el, int wt){
        
        element = el;
        weight = wt;
    }
    
    /*
    @return - element of node
    */
    public E element() {
        return element;
    }
    
    /*
    @return - weight of node
    */
    public int weight() {
        
        return weight;
    }
    
    /*
    @return - true - is a leaf node
    */
    public boolean isLeaf() {
        
        return true;
    }
    
}


