
package edu.frostburg.cosc310.jayden_rohwein.Dictionary;

/**
 *
 * @author Jayden
 */

public class BST< Key extends Comparable<? super Key>, E> {
    
    private BST_Node< Key, E> root;     //root of the bst
    private int nodeCount;              //number of nodes in tree
    
    //----------------------------------------------------------[ Constructors ]
    
    /*
    creates an empty Binary Search Tree
        root set to null
        nodeCount set to 0
    */
    public BST() {
        
        root = null;
        nodeCount = 0;
    }
    
    
    //--------------------------------------------------------------[ Mutators ]
    /*
    Makes BST Empty
        root set to null
        nodeCount set to 0
    */
    public void clear(){
        root = null;
        nodeCount = 0;
    }
    
    /*
    inserts a node into BST
        @param k- key of node to be inserted
        @param e- element to be stored in BST
    */
    public void insert( Key k, E e){
        
        // calls recursive method to help
        root = insertHelp(root,k,e);
        
        //updates nodecount
        nodeCount += nodeCount;
    }
    
    /*
    searches for a node and removes it, if it exist
        @param k- key of node to be removed
        @return E- returns element of node which is removed, null if node doesn't
        exist
    */
    public E remove(Key k){
        
        // finds the node to remove
        E temp = findHelp(root, k);
        
         //removes node and updates nodeCount
        if(temp != null){
            root = removeHelp(root,k);
            nodeCount--;
        }
       return temp;         
    }
    
    /*
    Removes any Node
        @return E - element of node removed
        null if tree is empty
    */
    public E removeAny() {
        
        //handles empty tree
        if(root == null)
            return null;
        
        //uses recursive method to help remove node
        E temp = root.element();
        root = removeHelp(root,root.key());
        
        //updates node countand returns element of node being deleted
        nodeCount--;
        return temp;
    }
    
    
    //-------------------------------------------------------------[ Accessors ]
    /*
    returns the element of the node with the corresponding key
        @param k - key to search for
        @return E - element to be returned to user
        null if no node with key k exist in tree
    */
    public E find(Key k){
        
        //uses recursive method to help find node
        return findHelp(root,k);
    }
    
    /*
    returns the size of the tree
        @return number of nodes in tree
    */
    public int size(){
        return nodeCount;
    }
    
    /*
    Returns The authors name
        @return my name "jay..."
    */
    public String myName(){
        return "Jayden Rohwein";
    }
    
    /*
    prints the in order transversal of the tree
    */
    public void printTreeInOrder(){
        
        //uses recursive method to help print tree
        printHelp(root);
    }
    
    //-------------------------------------------------------[ Private Methods ]
    
    /*
    helper method to find a node
        @param rt - root of the subtree being searched
        @param k - key which is being searched for
        @return element of node which is being searched for, null if k is not part
        of the tree
    */
    private E findHelp(BST_Node<Key,E> rt, Key k){
        
        //handles empty subtee
        if(rt == null)
            return null;
        
        //recursive case: when k belongs to subtee of the left child
        if(rt.key().compareTo(k) > 0){
            return findHelp(rt.left(),k);
        
        //base case: when element if found 
        }else if(rt.key().compareTo(k) == 0){
            return rt.element();
        
        }else {
            //recursive case: when k belongs to subtee of the right child
            return findHelp(rt.right(),k);
        }
    }
    
    /*
    helper method used to insert a node
        @param rt - root of subtree to gain the new node
        @param k - k of new node being inserted
        @param e - element of new node being inserted
    */
    private BST_Node<Key,E> insertHelp(BST_Node<Key, E> rt, Key k, E e){
        
        //Base case: inserts new node
        if(rt == null){
            return new BST_Node<>(k,e);
        }
        //recursive case: when k is to be placed in subtee of the left child
        if(rt.key().compareTo(k) > 0){
            rt.setLeft(insertHelp(rt.left(), k,e));
        } else {
            
            //recursive case: when k is to be placed in subtee of the left child
            rt.setRight(insertHelp(rt.right(),k,e));
        }
        
        //returns reference to node which was just inserted
        return rt;
    }
    
    /*
    helper method used to remove a node
        @param rt - subtree containing node to be removed
        @param k - k contained by node to be removed
        @return - node which was removed from tree
    */
    private BST_Node<Key, E> removeHelp(BST_Node<Key, E> rt, Key k){
        
        //handles empty subtee
        if(rt == null)
            return null;
        
        
        //recursive case: when k belongs to subtee of the left child
        if(rt.key().compareTo(k) > 0) {
            rt.setLeft(removeHelp(rt.left(), k));
        
            
        //recursive case: when k belongs to subtee of the right child
        } else if (rt.key().compareTo(k) < 0){
            rt.setRight(removeHelp(rt.right(), k));
        
        }else  {
            
            //if theirs no left child
            if(rt.left() == null)
                return rt.right();
            
            //if their no right child
            else if(rt.right() == null)
                return rt.left();
            
            //if node has no children 
            else {
                
                // deletes node and updates node references
                BST_Node<Key, E> temp = getMin(rt.right());
                rt.setElement(temp.element());
                rt.setKey(temp.key());
                rt.setRight(deleteMin(rt.right()));
            }
        }
        return rt;
    }
    
    /*
    deletes the node with the minimum key
        @param rt - root of subtree containing min
        @return - node which is removed
    */
    private BST_Node<Key, E> deleteMin(BST_Node<Key, E> rt){

        if(rt.left() == null)
            return rt.right();

        rt.setLeft(deleteMin(rt.left()));
        return rt;
    }
    
    /*
     returns the node with the smallest key
        @param rt - root of subtree containing smallest key
        @return - reference to node containing smallest key
    */
    private BST_Node<Key, E> getMin(BST_Node<Key, E> rt){
        
        if(rt.left() == null)
            return rt;
        return getMin(rt.left());
    }
    
    /*
    helper method used for printing BST
    @param rt - root of subtree currently being printed
    */
    private void printHelp(BST_Node<Key, E> rt){
        if(rt == null)
            return;
        
        printHelp(rt.left());
        printVist(rt.element());
        printHelp(rt.right());
    }
    /*
    prints the element from a node to the screen
        @param value - is printed to the screen
    */
    public void printVist(E value) {
        System.out.println(value);
    }
    
    

    private class BST_Node<Key, E> {

        private Key key; // key for this node
        private E element; // elemend
        private BST_Node<Key,E> left;// left child
        private BST_Node<Key,E> right;// right child

        //-------------------------------------------------------------constructors
        /*
        sets everything to null
        */
        public BST_Node() {
            left = right = null;
        }

        /*
        sets children to null
            @param k - key for this node
            @param val - element that is stored
        */
        public BST_Node(Key k, E val) {
            left = right = null;
            key = k;
            element = val;
        }

        /*
        sets children to null
            @param k - key for this node
        */
        public BST_Node(Key k) {
            left = right = null;
            key = k;
        }



        //------------------------------------------------------get and set the key
        /*
        sets the key
            @param key - key for the node
        */
        public void setKey(Key key){
            this.key = key;
        }
        /*returns key of the node
            @return -key of the node
        */
        public Key key(){
            return key;
        }

        //--------------------------------------------------get and set the element

        /*
        returns element of the node
            @param element - element of the node
        */
        public E element(){
            return element;
        }

        /*
        sets element of the node
            @param-element for the node
        */
        public void setElement(E element){
            this.element = element;
        }

        //----------------------------------------------------get and set left Node
        /*
        @return - the left node
        */
        public BST_Node<Key, E> left(){
            return left;
        }
        /*
        @param right - will be the pointer to the left node
        */
        public void setLeft(BST_Node<Key, E> left){
            this.left = left;
        }


        //---------------------------------------------------get and set right Node
        /*
        @return - the right node
        */
        public BST_Node<Key, E> right(){
            return right;
        }
        /*
        @param right - will be the pointer to the right node
        */
        public void setRight(BST_Node<Key, E> right){
            this.right = right;
        }

        //---------------------------------------------------------- is node a leaf
        /*
        @return - true if leaf, false if not leaf 
        */
          public boolean isLeaf() {
            return(left == null) && (right == null);
        }



    }

}




