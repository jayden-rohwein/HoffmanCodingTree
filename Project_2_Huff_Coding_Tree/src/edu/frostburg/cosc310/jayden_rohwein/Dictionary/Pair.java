
package edu.frostburg.cosc310.jayden_rohwein.Dictionary;

import java.util.ArrayList;

/**
 *
 * @author Jayden
 */
public class Pair {
 
    //holds the frequencies
    int[] element;
    
    //holds the letters
    ArrayList<String> key;

    /*
    creates array element, and arraylist key
    -alphabet and space is added to key
    -all 27 positions of element are set to 0
    */
    public Pair(){
        
        //creates arrays 
        element = new int[27];
        key = new ArrayList();
        
        //adds each letter and space to array
        key.add("a"); key.add("b"); key.add("c");
        key.add("d"); key.add("e"); key.add("f");
        key.add("g"); key.add("h"); key.add("i");
        key.add("j"); key.add("k"); key.add("l");
        key.add("m"); key.add("n"); key.add("o");
        key.add("p"); key.add("q"); key.add("r");
        key.add("s"); key.add("t"); key.add("u");
        key.add("v"); key.add("w"); key.add("x");
        key.add("y"); key.add("z"); key.add(" ");
        
        //sets all values to 0
        for(int count = 0; count <= 26; count++)
            element[count] = 0;
    }

    /*
    adds one to the count
    @param str - letter to search for in list
    */
    public void addCount(String str){
        
        int count = 0;
        while(count < key.size()){
            
            if(key.get(count).equalsIgnoreCase(str)){
                element[count] = element[count]+ 1;
                break;
            }
            count++;
        }
    }
    
    /*
    returns frequencie at array position 
    @param i - position of frequency
    */
    public int freq(int i){
        return element[i];
    }
    
    /*
    reeturns the letter at array position
    @param i - possition of letter
    */
    public String key(int i){
        return key.get(i);
    }
    
    //used frequency to get index
    public int getIndex(int i){
        for(int count = 0;count <= 26; count++){

            if(i == element[count])
                return count;
        }
        
        return 0;
    }
    
    /*
    @number of characters in array
    */
    public int size(){
        return 27;
    }
    
    
    
}



