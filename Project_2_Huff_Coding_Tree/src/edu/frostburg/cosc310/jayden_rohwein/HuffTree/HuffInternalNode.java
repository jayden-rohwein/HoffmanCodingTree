
package edu.frostburg.cosc310.jayden_rohwein.HuffTree;

/**
 *
 * @author Jayden
 */
public class HuffInternalNode<E> implements HuffBaseNode {
    
    private int weight;             // weight of node
    private HuffBaseNode<E> left;   //refecerence to left child
    private HuffBaseNode<E> right;  // reference to right child
    
    /*
    creates interanl node 
    */
    public HuffInternalNode(HuffBaseNode<E> l, HuffBaseNode<E> r) {
        
        left = l;
        right =r;
        weight = l.weight() + r.weight();
    }

    /*
    @return - reference to left child
    */
    public HuffBaseNode<E> left() { return left;}
    
    
    /*
    @return - reference to right child
    */
    public HuffBaseNode<E> right() {return right;}
    
    /*
    @return - false:not a leaf node
    */
    public boolean isLeaf() {return false;}
    
    /*
    @return - weight of node
    */
    public int weight(){return weight;}
    
    public void setLeft(HuffBaseNode node){
        left =node;
    }
    public void setRight(HuffBaseNode node){
        right =node;
    }


}


