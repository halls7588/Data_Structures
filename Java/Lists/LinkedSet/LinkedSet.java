/*******************************************************
 *  Linkedset.java
 *  Created by Stephen Hall on 11/09/17.
 *  Copyright (c) 2017 Stephen Hall. All rights reserved.
 *  Linked Set implementation in Java
 ********************************************************/
package Lists.LinkedSet;

/**
 * Linked set class
 * @param <T> Generic type
 */
public class LinkedSet<T extends Comparable<T>> {
    /**
     * Node class for singly linked set
     */
    public class Node{
        /**
         * Public Members
         */
        private T data;
        private Node next;

        /**
         * Node Class Constructor
         * @param data Data to be held in the Node
         */
        public Node(T data){
            this.data = data;
            next = null;
        }
    }

    /**
     * Private Members
     */
    private Node head;
    private Node tail;
    private int count;

    /**
     * Linked Set Constructor
     */
    public LinkedSet(){
        head = tail = null;
        count = 0;
    }

    /**
     * Adds a new node into the list with the given data
     * @param data Data to add into the list<
     * @return Node added into the list
     */
    public Node add(T data){
        // No data to insert into list
        if (data == null || (find(data) != null))
            return null;

        Node node = new Node(data);
        // The Linked list is empty
        if (head == null) {
            head = node;
            tail = head;
            count++;
        } else {
            // Add to the end of the list
            tail.next = node;
            tail = node;
            count++;
        }
        return node;
    }

    /**
     * Removes the first node in the list matching the data
     * @param data Data to remove from the list
     * @return Node removed from the list
     */
    public Node remove(T data){
        // List is empty or no data to remove
        if (head == null || data == null)
            return null;

        Node tmp = head;
        // The data to remove what found in the first Node in the list
        if(equalTo(tmp.data, data)) {
            head = head.next;
            count--;
            return tmp;
        }
        // Try to find the node in the list
        while (tmp.next != null) {
            // Node was found, Remove it from the list
            if (equalTo(tmp.next.data, data)){
                Node node = tmp.next;
                tmp.next = tmp.next.next;
                count--;
                return node;
            }
            tmp = tmp.next;
        }
        // The data was not found in the list
        return null;
    }

    /**
     * Gets the first node that has the given data
     * @param data Data to find in the list
     * @return Node First node with matching data or null if no node was found
     */
    public Node find(T data){
        // No list or data to find
        if (head == null || data == null)
            return null;

        Node tmp = head;
        // Try to find the data in the list
        while(tmp != null) {
            // Data was found
            if (equalTo(tmp.data, data))
                return tmp;
            tmp = tmp.next;
        }
        // Data was not found in the list
        return null;
    }

    /**
     * Gets the node at the given index
     * @param index Index of the Node to get
     * @return Node at passed in index
     */
    public Node indexAt(int index){
        //Index was negative or larger then the amount of Nodes in the list
        if (index < 0 || index > size())
            return null;

        Node tmp = head;
        // Move to index
        for (int i = 0; i < index; i++)
            tmp = tmp.next;
        // return the node at the index position
        return tmp;
    }

    /**
     * Gets the current count of the array
     * @return Number of items in the array
     */
    public int size(){
        return count;
    }

    /**
     * Determines if a is equal to b
     * @param a: generic type to test
     * @param b: generic type to test
     * @return boolean: true|false
     */
    private boolean equalTo(T a, T b) {
        return a.compareTo(b) == 0;
    }
}
