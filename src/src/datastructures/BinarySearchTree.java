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
    
    private boolean isLeaf(BinaryNode<K, V> node)
    {
        return node.leftChild == null && node.rightChild == null;
    }
    
    public void insert(K key) throws Exception
    {
        BinaryNode<K, V> temp = new BinaryNode<>(key, null);
        
        if(root == null){
            root = temp;
            return;
        }
        
        BinaryNode<K, V> current = root;
        while(!isLeaf(current)){
            if(comparator.compare(current._key, key) > 0 && current.hasLeftChild()){
                current = current.leftChild;
            }else if(comparator.compare(current._key, key) < 0 && current.hasRightChild()){
                current = current.rightChild;
            }else if(comparator.compare(current._key, key) == 0){
                throw new Exception("Cannot insert duplicate key!");
            }else{
                break;
            }
        }
        
        if(comparator.compare(current._key, key) > 0){
            current.leftChild = temp;
        }else if(comparator.compare(current._key, key) < 0){
            current.rightChild = temp;
        }else{
            throw new Exception("Cannot insert duplicate key! (this shouldn't be thrown...)");            
        }
    }
}
