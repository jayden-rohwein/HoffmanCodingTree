package edu.frostburg.cosc310.jayden_rohwein.Huffman_Encoding_Tree;

import edu.frostburg.cosc310.jayden_rohwein.Dictionary.*;
import edu.frostburg.cosc310.jayden_rohwein.MinHeap.*;
import edu.frostburg.cosc310.jayden_rohwein.HuffTree.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Jayden
 */
public class Huffman_Encoding_Tree {
    

    private Pair myPair;        //holds pair
    private BST dictionary;     //BST to hold Letters to binary
    private MinHeap myHeap;     //Heap to help make Huffman tree
    private HuffTree myHuff;    //huffman tree
    
    
   private String fileName;
    private String output;      //holds the coverted string
    
    public Huffman_Encoding_Tree(String fileName) throws IOException{

        buildPair(fileName);
        buildHeap();
        buildHuff();
    }
    
    public Huffman_Encoding_Tree() {

        myPair = null;
        myHeap = null;
        myHuff = null;
        dictionary = null;
    }
    
    public void setFile(String fileName)throws IOException{
        
        buildPair(fileName);
        buildHeap();
        buildHuff();
    }
    
    public String getCode() throws IOException{
        
        File myFile = new File(fileName);
        Scanner inputFile = new Scanner(myFile);
        
        //counts frequency of letter in file
        while(inputFile.hasNext())
            output.concat(dictionary.find(inputFile.next()).toString());
 
        return output;
        
    }
    /*
    reads file and counts frequency of letters
    */
    private void buildPair(String fileName) throws IOException{
        this.fileName = fileName;
        File myFile = new File(fileName);
        Scanner inputFile = new Scanner(myFile);
        
        myPair = new Pair();
        
        //counts frequency of letter in file
        while(inputFile.hasNext())
            myPair.addCount(inputFile.next());
 
      
    }
    
    
    /*
    builds a min heap from frequencies of letters
    */
    private void buildHeap(){
        
        myHeap = new MinHeap(dictionary.size());
        
        for(int count = 0; count < dictionary.size(); count++){
                myHeap.insert(myPair.freq(count));
            
        }
    }
    
    /*
    build the huffman tree from the heap and pair
    */
    private void buildHuff(){        
        
        myHuff = new HuffTree(myHeap.view(0),
                myPair.key(myPair.getIndex(myHeap.removemin())));

        
        while(myHeap.view(0) != 0){
            myHuff.addTrees(new HuffTree(myHeap.view(0),
                             myPair.key(myPair.getIndex(myHeap.removemin()))));
            
        }
    }
    
    /*
    creates sorted BST from pair
    */
    private void buildDictionary(){
        
        //perf
        dictionary = new BST();
        
        for(int count = 0;count < 27; count++){
            dictionary.insert(bdHelp(count),  myPair.key(count));
        }
        
        
        
    }
    
    /*
    returns the binary code for the letter on the tree
    */
    private String bdHelp(int i){
        
        HuffBaseNode rt =myHuff.root();
        
        while(rt.left() != null){
            rt = rt.left();
            
        }
      
        for(int count = i; count >1; count--){
            
            if( rt.isLeft())
                rt = rt.parent().right();
            
            else
                rt = rt.parent().parent().right();
            
        }
    }

}
