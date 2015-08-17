/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.datastructures;

import java.util.Comparator;

/**
 *
 * @author De la Cruz Family
 * @param <K> key
 * @param <V> value
 */
public class BinarySearchTree<K, V> {
    protected BinaryNode<K, V> root;
    protected Comparator<K> comparator;
    
    public BinarySearchTree(Comparator<K> comparator)
    {
        this.comparator = comparator;
    }
    
    public void insert(K key)
    {
        if(root == null){
            root = new BinaryNode<>(key, null);
        }else if(comparator.compare(root._key, key) < 0){
            
        }
    }
}
