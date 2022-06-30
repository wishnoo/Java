package DataStructures.LinkedList.SinglyLinkedList;

public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public SinglyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public SinglyLinkedList(int value){
        this.head = new Node(value);
        this.tail = this.head;
        this.length = 1;
    }

    public void prepend (int value){
        Node currentNode = new Node(value, this.head);
        this.head = currentNode;
        length++;
    }

    public void append (int value){
        Node currentNode = new Node (value);
        this.tail.setNext(currentNode);
        this.tail = currentNode;
        length++;
    }

    // wrap index
    // This method makes sure the index value is within boundaries.
    // If index is greater than the length it is set as length - 1
    // If index is less than 0 it is set as 0 
    public int wrapIndex(int index){
        return Math.max(Math.min(index, length - 1), 0);
    }
    // insert
    public void insert(int index, int value) {
        index = wrapIndex(index);

        if(index == 0){
            prepend(value);
            return;
        }

        if(index == length - 1){
            append(value);
            return;
        }

        Node leader = traverseToIndex(index);
        Node follower = leader.getNext();
        Node newNode = new Node(value, follower);
        leader.setNext(newNode);
        this.length++;
    }

    // The method traverseToIndex returns the node at index - 1
    public Node traverseToIndex(int index){
        Node currentNode = this.head;

        for(int i = 0; i < index; i++){
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }

    // remove
    public void remove(int index) {
        index = wrapIndex(index);

        if(index == 0){
            this.head = this.head.getNext();
            length--;
            return;
        }

        Node leader = traverseToIndex(index);
        Node nodeToRemove = leader.getNext();
        leader.setNext(nodeToRemove.getNext());
        length--;
    }

    // reverse
    public void reverse(){
        Node first = this.head;
        Node second = first.getNext();
        
        while(second != null){
            Node temp = second.getNext();
            
        }
    }

    // printList
    public void printList() {
        
    }

    // getlength
    public int getLength() {
        return this.length;
    }

}
