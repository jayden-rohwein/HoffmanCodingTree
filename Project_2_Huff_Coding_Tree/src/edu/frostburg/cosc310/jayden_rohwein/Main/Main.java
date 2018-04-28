package edu.frostburg.cosc310.jayden_rohwein.Main;

import edu.frostburg.cosc310.jayden_rohwein.Huffman_Encoding_Tree.*; 
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Jayden
 */
public class Main {
    
    public static void main(String[] args)throws IOException{
        
        String fileName = getFileName();
        Huffman_Encoding_Tree tree = new Huffman_Encoding_Tree(fileName);
        System.out.println();
        
    }
    
    /*
    ask user for file name in terminal
    @returs file name
    */
    private static String getFileName(){
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Enter file name");
        return keyboard.nextLine();
    
    }
    
    
}
