package il.co.ilrd.InterviewQuestions;

import java.util.HashMap;
import java.util.Map;

public class FirstNonDuplicate {

    private List list = new List(null,null);
    private Map<Long, Node> map = new HashMap<>();

    private class List{
        private Node head;
        private Node tail;

        public List(Node head, Node tail){
            this.head = head;
            this.tail = tail;
        }

        public Node getHead(){
            return head;
        }
        public Node getTail(){
            return tail;
        }
        public boolean isEmpty(){
            return (head == null && tail == null);
        }
        public void add(Long val){
            Node newNode = new Node(val,tail.prev,tail);

            tail.prev.next = newNode;
            tail.prev = newNode;
        }

        public void remove(Node nodeToRemove){
            Node temp = head;
            while(temp != null){
                if(temp.equals(nodeToRemove)){
                    temp.next.prev = temp.prev;
                    temp.prev.next = temp.next;
                    temp.prev = null;
                    temp.next = null;
                    break;
                }
                temp = temp.next;
            }
        }

        public Long get(int index){

            Node temp = head;
            for(int i = 0; i < index; ++i){
                temp= temp.next;
            }
            return temp.data;
        }
    }
    private class Node{
        private Long data;
        private Node next;
        private Node prev;
        public Node(Long data, Node prev, Node next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        public Long getData(){
            return data;
        }
        public Node getNext(){
            return next;
        }
        public Node getPrev(){
            return next;
        }
    }
    public void input(long num) {

        if(! map.containsKey(num)){
            list.add(num);
        }
        else {
            Node temp = map.get(num);
            if(temp != null){
                list.remove(temp);
                map.replace(num, null);
            }
        }
        System.out.println(output());
    }
    public long output() {
        if(list.isEmpty()){
            return 0;
        }
        else {
            return list.get(0);
        }
    }


    public static void main(String[] args){
        FirstNonDuplicate fnd = new FirstNonDuplicate();

        fnd.input(1);
        fnd.input(2);
        fnd.input(2);
        fnd.input(3);
        fnd.input(3);
        fnd.input(4);
        fnd.input(1);
        fnd.input(1);
        fnd.input(1);
        fnd.input(4);
        fnd.input(5);


    }
}
