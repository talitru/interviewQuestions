package il.co.ilrd.InterviewQuestions;

import java.util.Hashtable;

public class LRUCache {

    class Node {
        int key;
        int value;
        Node pre;
        Node next;
    }
    private Hashtable<Integer, Node> cacheMap = new Hashtable<Integer, Node>();
    private int count;
    private int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new Node();
        head.pre = null;

        tail = new Node();
        tail.next = null;

        head.next = tail;
        tail.pre = head;
    }

    //Add the new node right after head
    private void addNodeAfterHead(Node node) {
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }

    //Remove an existing node from the linked list
    private void removeNode(Node node){
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;
    }

    //Move node in between to the head
    private void moveToHead(Node node){
        this.removeNode(node);
        this.addNodeAfterHead(node);
    }

    //Pop the current tail
    private Node popTail(){
        Node res = tail.pre;
        this.removeNode(res);
        return res;
    }


    public int get(int key) {
        Node node = cacheMap.get(key);

        if(node == null){
            return -1;
        }

        this.moveToHead(node);
        return node.value;
    }


    public void put(int key, int value) {
        Node node = cacheMap.get(key);

        if(node == null){
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            this.cacheMap.put(key, newNode);
            this.addNodeAfterHead(newNode);

            ++count;

            if(count > capacity){
                // pop the tail
                Node tail = this.popTail();
                this.cacheMap.remove(tail.key);
                --count;
            }
        }
        else {
            // update the value.
            node.value = value;
            this.moveToHead(node);
        }
    }
}