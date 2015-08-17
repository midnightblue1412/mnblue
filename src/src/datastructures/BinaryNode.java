/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.datastructures;

/**
 *
 * @author De la Cruz Family
 * @param <K>   Key
 * @param <V>   Value
 */
public class BinaryNode<K, V> {
    protected K _key;
    protected V _value;
    
    protected BinaryNode<K, V> parent;
    protected BinaryNode<K, V> leftChild;
    protected BinaryNode<K, V> rightChild;
    
    public BinaryNode(K key, V value)
    {
        _key = key;
        _value = value;
    }
    
    public K key()
    {
        return _key;
    }
    
    public V value()
    {
        return _value;
    }
    
    public void setValue(V value)
    {
        _value = value;
    }
    
    public boolean hasLeftChild()
    {
        return leftChild != null;
    }
    
    public boolean hasRightChild()
    {
        return rightChild != null;
    }
}
