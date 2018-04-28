/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.frostburg.cosc310.jayden_rohwein.HuffTree;

/**
 *
 * @author Jayden
 */
public interface HuffBaseNode<E> {
    
    public boolean isLeaf();
    public int weight();
}
